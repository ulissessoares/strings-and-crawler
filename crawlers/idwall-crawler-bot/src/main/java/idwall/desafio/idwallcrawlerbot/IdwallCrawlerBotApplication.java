package idwall.desafio.idwallcrawlerbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class IdwallCrawlerBotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(IdwallCrawlerBotApplication.class, args);
	}

}
