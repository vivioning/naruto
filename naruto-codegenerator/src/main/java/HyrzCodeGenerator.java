import com.hkfs.fundamental.codegenerator.basis.data.Annotation;
import com.hkfs.fundamental.codegenerator.basis.data.Interface;
import com.hkfs.fundamental.codegenerator.basis.data.db.Connection;
import com.hkfs.fundamental.codegenerator.basis.data.db.Mapper;
import com.hkfs.fundamental.codegenerator.basis.data.db.MySql;
import com.hkfs.fundamental.codegenerator.basis.data.db.Table;
import com.hkfs.fundamental.codegenerator.basis.global.Config;
import com.hkfs.fundamental.codegenerator.basis.global.Consts;
import com.hkfs.fundamental.codegenerator.basis.render.NameRender;
import com.hkfs.fundamental.codegenerator.basis.translator.BaseColumnNameTranslator;
import com.hkfs.fundamental.codegenerator.basis.translator.BaseColumnTypeTranslator;
import com.hkfs.fundamental.codegenerator.basis.translator.ColumnToEnumTranslator;
import com.hkfs.fundamental.codegenerator.basis.translator.TableToClassTranslator;
import com.hkfs.fundamental.codegenerator.io.CodeInputer;
import com.hkfs.fundamental.codegenerator.output.MultiCodeOutputer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.vivion on 2017/1/8.
 */
public class HyrzCodeGenerator {
    static {
        Consts.TAB = "    ";
        Config.addFullClass("org.springframework.stereotype.Repository");
    }

    static Connection connection = new Connection("101.200.57.149", 3306, "naruto", "root", "123456");

    private static final String ROOT = ".";

    public static void main(String[] args) throws Exception {
        generate();
    }
    private static void generate() throws Exception {
        String root = ROOT;
        String pojoRoot = root+"/naruto-model/src/main/java";
        String daoRoot = root+"/naruto-dao/src/main/java";
        String mapperRoot = root+"/naruto-dao/src/main/resources/mappers";

        String pojoPackageName = "com.vivion.naruto.bean";
        String daoPackageName = "com.vivion.naruto.dao";
        String pojoEnumDefultPackageName = "com.vivion.naruto.enums";

        ColumnToEnumTranslator columnToEnumTranslator = new ColumnToEnumTranslator(pojoEnumDefultPackageName, NameRender.Constant);

        TableToClassTranslator tableToClassTranslator = new TableToClassTranslator(pojoPackageName,
                new BaseColumnTypeTranslator().setReflection("DECIMAL", "Double"), new BaseColumnNameTranslator());
        tableToClassTranslator.setParentClassName("com.hkfs.fundamental.api.data.PojoDataObjectBase");//基类
        tableToClassTranslator.setIsSerializable(true);
        tableToClassTranslator.setTablePrefix("tb_");
        tableToClassTranslator.setColumnToEnumTranslator(columnToEnumTranslator);//自动生成枚举

        //查询数据库获取table
        Table[] tables = MySql.newInstance(connection)
                .include(
                        "tb_member"
                ).getTables();
        //将table转换成class
        com.hkfs.fundamental.codegenerator.basis.data.Class[] pojoClasses = tableToClassTranslator.translate(tables);

        //pojo输出
        MultiCodeOutputer.newInstance(pojoRoot, pojoPackageName)
                .setClearFolderBeforeOutput(false)
                .setGiveupOutputIfExists(false)
                .output(pojoClasses);
        //枚举输出
        MultiCodeOutputer.newInstance(pojoRoot, pojoEnumDefultPackageName)
                .setClearFolderBeforeOutput(false)
                .setGiveupOutputIfExists(true)
                .outputEnum(pojoClasses);

        //输出mapper.xml
        MultiCodeOutputer mapperOutputer = MultiCodeOutputer.newInstance(mapperRoot, "")
                .setClearFolderBeforeOutput(false)
                .setGiveupOutputIfExists(false);
        Mapper[] mappers = translate(mapperOutputer,
                daoPackageName, tables, tableToClassTranslator);
        mapperOutputer.output(mappers);

        //输出dao
        Interface[] interfaces = translate(mappers);
        MultiCodeOutputer.newInstance(daoRoot, daoPackageName)
                .setClearFolderBeforeOutput(false)
                .setGiveupOutputIfExists(false)
                .output(interfaces);
    }

    //将table转换成扩展mapper
    private static Mapper[] translate(MultiCodeOutputer mapperOutputer, String packageName,
                                      Table[] tables, TableToClassTranslator tableToClassTranslator) {
        List<Mapper> list = new ArrayList<Mapper>();
        for (Table table : tables) {
            Mapper mapper = new Mapper(packageName, table, tableToClassTranslator);
            String mapperPath = mapperOutputer.getOutputablePathBuilder(mapper).build();
            CodeInputer codeInputer = new CodeInputer(mapperPath);
            mapper.setExistingMapper(codeInputer.read());
            mapper.setPrimaryKeyColumnName("id");
            list.add(mapper);
        }
        return list.toArray(new Mapper[tables.length]);
    }

    //将mapper转换成dao的接口
    private static Interface[] translate(Mapper[] mappers) {
        List<Interface> list = new ArrayList<Interface>();
        String parentBaseMapperName = "com.hkfs.fundamental.database.DaoBase<T, Long>";
        for (Mapper mapper : mappers) {
            String parentMapperName = parentBaseMapperName.replace("<T,", "<"+mapper.pojoClass.fullClassName+",");
            Interface it = new Interface(mapper.processNamespace()).setParentInterface(new Interface(parentMapperName));
            it.setAnnotation(new Annotation("@Repository"));
            list.add(it);
        }
        return list.toArray(new Interface[mappers.length]);
    }

    static class MyConnection extends Connection {
        public MyConnection(String ip, int port, String databaseName, String username, String password) {
            super(processDatabaseUrl(ip, port, databaseName), databaseName, username, password);
            driverClassName = "org.postgresql.Driver";
        }
        private static String processDatabaseUrl(String ip, int port, String databaseName) {
            return "jdbc:postgresql://"+ip+":"+port+"/"+databaseName;
        }
    }
}
