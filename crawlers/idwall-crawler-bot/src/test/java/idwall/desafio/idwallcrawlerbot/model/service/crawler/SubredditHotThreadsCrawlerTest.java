package idwall.desafio.idwallcrawlerbot.model.service.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class SubredditHotThreadsCrawlerTest {

    @Test
    public void shouldScrapThreadsFromDefaultExample() throws IOException {
        File resource = new ClassPathResource("Default-subreddit-example.html").getFile();
        String html = new String(Files.readAllBytes(resource.toPath()));

        SubredditHotThreadsCrawler crawler = new SubredditHotThreadsCrawler();
        ReflectionTestUtils.setField(crawler, "hotThreadUpvoteThreshold", 5000);

        List<SubredditThreadVO> threads = crawler.scrapHotThreads(html);
        assert(threads.size() == 3);
    }

    @Test
    public void shouldNotScrapThreadsFromEmptySubreddit() throws IOException {
        File resource = new ClassPathResource("Empty-subreddit-example.html").getFile();
        String html = new String(Files.readAllBytes(resource.toPath()));

        SubredditHotThreadsCrawler crawler = new SubredditHotThreadsCrawler();
        ReflectionTestUtils.setField(crawler, "hotThreadUpvoteThreshold", 5000);

        List<SubredditThreadVO> threads = crawler.scrapHotThreads(html);
        assert(threads.size() == 0);
    }

    @Test
    public void shouldNotScrapThreadsFromNotFoundPage() throws IOException {
        File resource = new ClassPathResource("Not-found-subreddit-example.html").getFile();
        String html = new String(Files.readAllBytes(resource.toPath()));

        SubredditHotThreadsCrawler crawler = new SubredditHotThreadsCrawler();
        ReflectionTestUtils.setField(crawler, "hotThreadUpvoteThreshold", 5000);

        List<SubredditThreadVO> threads = crawler.scrapHotThreads(html);
        assert(threads.size() == 0);
    }

    @Test
    public void shouldAssignZeroUpvotesWhenNoUpvoteValueIsFoundByTheScrapper() throws IOException {
        File resource = new ClassPathResource("No-upvotes-div-example.html").getFile();
        String html = new String(Files.readAllBytes(resource.toPath()));

        SubredditHotThreadsCrawler crawler = new SubredditHotThreadsCrawler();

        Element element = Jsoup.parse(html);

        SubredditThreadVO threadVO = crawler.createThreadVOFromElement(element);
        assert(threadVO.getUpvotes() == 0);
    }
}
