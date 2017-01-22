package com.vivion.naruto;

import com.hkfs.fundamental.api.data.ResultEx;
import com.jspider.*;
import com.jspider.pipeline.Pipeline;
import com.jspider.processor.PageProcessor;
import com.jspider.scheduler.QueueScheduler;
import com.vivion.naruto.bean.NovelJsxs;
import com.vivion.naruto.dao.NovelJsxsDao;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by GuoXinJie on 2017-01-13.
 */
@Service
public class NovelServiceImpl implements NovelService {

    private static Logger logger = LoggerFactory.getLogger(NovelServiceImpl.class);

    @Resource
    private NovelJsxsDao novelJsxsDao;


    @Override
    public ResultEx getNovel(String date) {
        ResultEx resultEx =new ResultEx();
        try {
            SpiderConfig spiderConfig = SpiderConfig.create("note", 5);
            SiteConfig siteConfig = SiteConfig.create().putCharset("aoyuge", "gbk");

            Spider spider = Spider.create(spiderConfig, siteConfig, new NotePageProcessor())
                    .setScheduler(new NoteScheduler())
                    .setPipeline(new NotePipeline());
            spider.addStartRequests("http://www.aoyuge.com/0/89/");
            spider.run();
            resultEx.setRetCode(1);
        } catch (Exception e) {
            logger.info(e.toString());
            e.printStackTrace();
            resultEx.setRetCode(0);
        }
        return resultEx;
    }

    private static class NotePipeline implements Pipeline {
        @Resource
        private NovelJsxsDao novelJsxsDao;
        @Override
        public void persist(Request request, Result result) {
            NovelJsxs novelJsxs =new NovelJsxs();
            for (String name: result.keySet()) {
                if (name.equals("title")){
                    String text = result.get(name).toString().replaceAll("正文 ","").replaceAll("免费章节","").replaceAll("收费章节 ","");
                    novelJsxs.setTitle(text);
                }
                if (name.equals("content")){
                    String text = result.get(name).toString().replaceAll("&nbsp;&nbsp;&nbsp;&nbsp;", "").replaceAll("<br />\\n", "").replaceAll("    ", "")
                            .replaceAll("<br />", "").replaceAll("<div id=\"BookText\">", "").replaceAll("</div>", "").replaceAll("【★不要忘记点击本吧右上角的“签到”★】","")
                            .replaceAll("【欢迎大家到3g为犀利增加点击量，投推荐票。】","").replaceAll("——","").replaceAll("《绝世邪神》最近100章连载贴","")
                            .replaceAll("《绝世邪神》全部章节连载贴","").replaceAll("〖傲宇阁小说网∷更新快∷无弹窗∷纯文字∷ ..〗","");
                    novelJsxs.setContent(text);
                }
                novelJsxs.setIsValid(1);
                novelJsxs.setCreateTime(new Date());
            }
            novelJsxsDao.add(novelJsxs);
            //System.out.println(result);
        }
    }

    private static class NoteScheduler extends QueueScheduler {
    }

    private static class NotePageProcessor implements PageProcessor {

        @Override
        public Result process(Request request, Page page) {
            Result result = new Result();
            Elements elements = page.document().select("div#main dl.chapterlist a");
            for (Element element : elements) {
                String url = element.absUrl("href");
                System.out.println(url);
                page.addTargetRequest(url);
            }

/*            List<String> links = page.html().links().regex("http://www.aoyuge.com/0/89/(.*)").all();

            if (links != null) {
                page.addTargetRequests(links);
            }*/


            Element element = page.document().select("div#BookCon h1").first();
            if (element != null) {
                String title = element.text();

                result.put("title", title);
            }

            element = page.document().select("div#BookText").first();
            if (element != null) {
                String content = element.text();

                result.put("content", content);
            }

            return result;
        }
    }
}
