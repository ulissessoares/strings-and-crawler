package idwall.desafio.idwallcrawlerbot.controller.bot;
import idwall.desafio.idwallcrawlerbot.controller.bot.parser.ISlashCommandParser;
import idwall.desafio.idwallcrawlerbot.exception.InvalidSlashCommand;
import idwall.desafio.idwallcrawlerbot.model.service.SubredditHotThreadsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.function.Consumer;

@Component
public class ReditHotThreadsTelegramBot extends TelegramLongPollingBot {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Value("${idwall.crawler.bot.username}")
    private String username;

    @Value("${idwall.crawler.bot.token}")
    private String token;

    @Value("${idwall.crawler.bot.help-message}")
    private String helpMessage;

    @Autowired
    private ISlashCommandParser commandParser;

    @Autowired
    private SubredditHotThreadsService subredditHotThreadsService;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            try {
                String messageText = update.getMessage().getText();
                List<String> commandArguments = commandParser.parse(messageText);
                subredditHotThreadsService.findHotThreads(commandArguments, sendResponseCallback(update.getMessage().getChatId()));

            } catch (InvalidSlashCommand e) {
                logger.warn(e.getMessage(), e);
                createAndSendResponse(update.getMessage().getChatId(), helpMessage);
            }

        }
    }

    protected void createAndSendResponse(long chatId, String messageText) {
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText(messageText);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            logger.error("Failed to respond telegram: " + e.getMessage(), e);
        }
    }

    Consumer<String> sendResponseCallback(long chatId) {
        return (text) -> {
           createAndSendResponse(chatId, text);
        };
    }

    @Override
    public String getBotUsername() {
        return this.username;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }
}
