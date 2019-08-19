package idwall.desafio.idwallcrawlerbot.model.service;

import idwall.desafio.idwallcrawlerbot.model.service.crawler.SubredditHotThreadsCrawler;
import idwall.desafio.idwallcrawlerbot.model.service.crawler.SubredditThreadVO;
import idwall.desafio.idwallcrawlerbot.model.service.crawler.SubredditVO;
import idwall.desafio.idwallcrawlerbot.model.service.rest.RedditRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class SubredditHotThreadsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${idwall.crawler.bot.no-hot-threads-message:This subreddit has no thread with 5000 or more likes!}")
    private String noHotThreadsForSubredditMessage;

    @Autowired
    private SubredditHotThreadsCrawler crawler;

    @Autowired
    private RedditRestClient redditRestClient;

    public void findHotThreads(List<String> subredditList, Consumer<String> responseCallback) {
        List<Mono<SubredditVO>> subredditRequests = subredditList.stream()
                .map(this::getSubredditHtml)
                .collect(Collectors.toList());

        Flux.merge(subredditRequests).subscribe(processSubredditHtmlAndExecuteResponseCallback(responseCallback), (x) -> logger.warn(x.getMessage(), x));
    }

    protected Consumer<SubredditVO> processSubredditHtmlAndExecuteResponseCallback(Consumer<String> responseCallback) {
        return (subredditVO) -> {
            List<SubredditThreadVO> threads = crawler.scrapHotThreads(subredditVO.getHtml());
            String responseText = threads.stream()
                    .map(x -> x.toString())
                    .collect(Collectors.joining("\n"));

            if(!responseText.isEmpty())
                responseCallback.accept(subredditVO.getSubredditName() + "\n\n" + responseText);
            else
                responseCallback.accept(subredditVO.getSubredditName() + "\n\n" + noHotThreadsForSubredditMessage);

        };
    }

    protected Mono<SubredditVO> getSubredditHtml(String subredditName) {
        Mono<String> htmlMono = redditRestClient.getSubreddit(subredditName);
        return htmlMono.map(html -> new SubredditVO(html, subredditName));
    }

}
