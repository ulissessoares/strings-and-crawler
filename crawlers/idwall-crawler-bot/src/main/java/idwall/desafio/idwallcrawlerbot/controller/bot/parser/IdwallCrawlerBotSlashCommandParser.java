package idwall.desafio.idwallcrawlerbot.controller.bot.parser;

import idwall.desafio.idwallcrawlerbot.exception.InvalidSlashCommand;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class IdwallCrawlerBotSlashCommandParser implements ISlashCommandParser {

    private final String REDDIT_HOT_THREAD_COMMAND = "/NadaParaFazer";

    public List<String> parse(String command) throws InvalidSlashCommand {

        List<String> commandArguments = Arrays.asList(command.split(" "));

        if (commandArguments.size() != 2)
            throw new InvalidSlashCommand("Wrong argument number");

        if (!commandArguments.get(0).equals(REDDIT_HOT_THREAD_COMMAND))
            throw new InvalidSlashCommand("Not supported command: " + commandArguments.get(0));

        List<String> subreddits = Arrays.asList(commandArguments.get(1).split(";"));

        return subreddits;

    }

}
