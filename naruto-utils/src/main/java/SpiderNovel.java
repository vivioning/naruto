/*
import com.jspider.*;
import com.jspider.pipeline.Pipeline;
import com.jspider.processor.PageProcessor;
import com.jspider.scheduler.QueueScheduler;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

*/
/**
 * Created by GuoXinJie on 2017-01-22.
 *//*

public class SpiderNovel {

    private static class NotePipeline implements Pipeline {
        @Override
        public void persist(Request request, Result result) {

            System.out.println(result);
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

*/
/*            List<String> links = page.html().links().regex("http://www.aoyuge.com/0/89/(.*)").all();

            if (links != null) {
                page.addTargetRequests(links);
            }*//*



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

    public static void main(String[] args) {
        SpiderConfig spiderConfig = SpiderConfig.create("note", 3);
        SiteConfig siteConfig = SiteConfig.create().putCharset("aoyuge", "gbk");

        Spider spider = Spider.create(spiderConfig, siteConfig, new NotePageProcessor())
                .setScheduler(new NoteScheduler())
                .setPipeline(new NotePipeline());

        spider.addStartRequests("http://www.aoyuge.com/0/89/");

        spider.run();
    }
}
*/
