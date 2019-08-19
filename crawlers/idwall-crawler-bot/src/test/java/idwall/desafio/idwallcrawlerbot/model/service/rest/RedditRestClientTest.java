package idwall.desafio.idwallcrawlerbot.model.service.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

//@RunWith(MockitoJUnitRunner.class)
public class RedditRestClientTest {

//    @InjectMocks
//    private RedditRestClient redditRestClient;
//
//    @Mock
//    private WebClient.Builder webClientBuilder;

//    @Test
//    public void shouldReturnMonoWhenReceiveNotFoundResponse() {
//        WebClient webClientMock = Mockito.mock(WebClient.class);
//        WebClient.Request uriSpecMock = Mockito.mock(WebClient.RequestHeadersUriSpec.class);
//        WebClient.ResponseSpec responseSpecMock = Mockito.mock(WebClient.ResponseSpec.class);
//
//        Mockito.when(webClientMock.get()).thenReturn(uriSpecMock);
//        Mockito.when(uriSpecMock.uri(ArgumentMatchers.<String>notNull())).thenReturn(responseSpecMock);
//        Mockito.when(headersSpecMock.header(notNull(), notNull())).thenReturn(headersSpecMock);
//        Mockito.when(headersSpecMock.headers(notNull())).thenReturn(headersSpecMock);
//        Mockito.when(headersSpecMock.retrieve()).thenReturn(responseSpecMock);
//        Mockito.when(responseSpecMock.bodyToMono(ArgumentMatchers.<Class<String>>notNull()))
//                .thenReturn(Mono.just(resp));
//        ReflectionTestUtils.setField(redditRestClient, "baseURL", "https://old.reddit.com/");
//        Mockito.when(webClientBuilder.baseUrl(Mockito.anyString())).thenCallRealMethod();
//        Mockito.when(webClientBuilder.build()).thenReturn(webClientMock);
//
//
//
//
//            return mock;
//
//        Mockito.when(webClientMock.get()).thenReturn(Mockito.mock());
//        webClient
//                .get()
//                .uri(SUBREDDIT_PATH_PREFIX + subredditName + TOP_THREADS_PATH_URI)
//                .retrieve()
//                .bodyToMono(String.class)
//                .onErrorResume(WebClientResponseException.class, (error) -> Mono.just(error.getResponseBodyAsString()));
//    }
}
