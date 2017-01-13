package com.vivion.naruto;

import com.hkfs.fundamental.api.data.ResultEx;
import com.vivion.naruto.bean.MemberNinja;
import com.vivion.naruto.enums.MemberNinjaView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GuoXinJie on 2017-01-13.
 */
@Service
public interface NinjaService {

    /**
     * 获取成员忍者信息
     *
     * @param memberNinjaView
     * @return
     */
    public List<MemberNinja> getNinjaList(MemberNinjaView memberNinjaView);

    /**
     * 新增成员忍者信息
     *
     * @param memberNinjaView
     * @return
     */
    public ResultEx addNinja(MemberNinjaView memberNinjaView);

    /**
     * 修改成员忍者信息
     *
     * @param memberNinjaView
     * @return
     */
    public ResultEx modifyNinja(MemberNinjaView memberNinjaView);

    /**
     * 删除成员忍者信息
     *
     * @param memberNinjaView
     * @return
     */
    public ResultEx deleteNinja(MemberNinjaView memberNinjaView);
}
