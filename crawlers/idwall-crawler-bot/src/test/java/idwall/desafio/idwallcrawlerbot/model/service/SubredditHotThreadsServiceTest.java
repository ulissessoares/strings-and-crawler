package idwall.desafio.idwallcrawlerbot.model.service;

import idwall.desafio.idwallcrawlerbot.model.service.crawler.SubredditHotThreadsCrawler;
import idwall.desafio.idwallcrawlerbot.model.service.crawler.SubredditThreadVO;
import idwall.desafio.idwallcrawlerbot.model.service.rest.RedditRestClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@RunWith(MockitoJUnitRunner.class)
public class SubredditHotThreadsServiceTest {

    @InjectMocks
    public SubredditHotThreadsService subredditHotThreadsService;

    @Mock
    private SubredditHotThreadsCrawler crawler;

    @Mock
    private RedditRestClient redditRestClient;


    @Test
    public void shouldProcessSubredditAndExecuteCallBack() throws IOException {
        List<String> callbackResults = new ArrayList<>();
        Consumer<String> sout = (text) -> callbackResults.add(text);

        ReflectionTestUtils.setField(subredditHotThreadsService, "noHotThreadsForSubredditMessage", "This subreddit has no thread with 5000 or more likes!");

        File resource = new ClassPathResource("Default-subreddit-example.html").getFile();
        String html = new String(Files.readAllBytes(resource.toPath()));

        Mockito
                .when(redditRestClient.getSubreddit(Mockito.anyString()))
                .thenReturn(Mono.just(html));

        SubredditThreadVO threadVO = new SubredditThreadVO("cats", "title", "https://old.reddit.com/r/cats", 10000);
        Mockito
                .when(crawler.scrapHotThreads(Mockito.anyString()))
                .thenReturn(Arrays.asList(threadVO));


        subredditHotThreadsService.findHotThreads(Arrays.asList("cats"), sout);

        String expected = "cats\n\n" + threadVO.toString();
        assert expected.equals(callbackResults.get(0).toString());
    }

}
