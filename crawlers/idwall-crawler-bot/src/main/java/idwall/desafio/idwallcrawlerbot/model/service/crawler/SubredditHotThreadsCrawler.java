package idwall.desafio.idwallcrawlerbot.model.service.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubredditHotThreadsCrawler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @Value("${idwall.crawler.bot.hot-thread-upvote-threshold:5000}")
    private Integer hotThreadUpvoteThreshold;

    public List<SubredditThreadVO> scrapHotThreads(String html) {

        Document document = Jsoup.parse(html);
        Elements mainContentDivs = document.body().select("div.content > div#siteTable > div[class*=\"thing id-t3\"][data-subreddit-type=\"public\"]" );

        return mainContentDivs.stream()
                .map(this::createThreadVOFromElement)
                .filter(thread -> thread.getUpvotes() >= hotThreadUpvoteThreshold)
                .collect(Collectors.toList());


    }

    protected SubredditThreadVO createThreadVOFromElement(Element element) {
        logger.info("DEBUG Thread Html" + element.text());

        String subreddit = element.attr("data-subreddit");
        String title = element.select("div.entry.unvoted > div.top-matter > p > a.title.may-blank").text();
        String upvotesText = element.select("div.midcol.unvoted > div.score.unvoted").attr("title");
        Integer upvotes = (upvotesText.isEmpty()) ? 0 : Integer.parseInt(upvotesText);

        String link = element.select("ul.flat-list.buttons > li.first > a").attr("href");

        return new SubredditThreadVO(subreddit, title, link, upvotes);
    }
}

