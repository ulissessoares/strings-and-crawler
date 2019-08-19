package idwall.desafio.idwallcrawlerbot.model.service.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class RedditRestClient {

    private final String TOP_THREADS_PATH_URI = "/top/";
    private final String SUBREDDIT_PATH_PREFIX = "/r/";

    @Value("${idwall.crawler.bot.reddit-base-url:https://old.reddit.com/}")
    private String baseURL;

    @Autowired
    private WebClient.Builder webClientBuilder;


    public Mono<String> getSubreddit(String subredditName) {
        WebClient webClient = this.webClientBuilder.baseUrl(baseURL).build();

        return webClient
                .get()
                .uri(SUBREDDIT_PATH_PREFIX + subredditName + TOP_THREADS_PATH_URI)
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class, (error) -> Mono.just(error.getResponseBodyAsString()));
    }

}
