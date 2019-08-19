package idwall.desafio.idwallcrawlerbot.controller.bot.parser;

import idwall.desafio.idwallcrawlerbot.exception.InvalidSlashCommand;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IdwallCrawlerBotSlashCommandParserTest {
    private IdwallCrawlerBotSlashCommandParser parser;

    @Before
    public void setup() {
        this.parser = new IdwallCrawlerBotSlashCommandParser();
    }

    @Test
    public void shouldReturnSigleArgListForCorrectOneSubredditCommand() throws InvalidSlashCommand {
        String command = "/NadaParaFazer cats";
        List<String> arguments = parser.parse(command);

        assert(arguments.size() == 1);
    }

    @Test
    public void shouldReturnCorretSubredditForCorrectOneSubredditCommand() throws InvalidSlashCommand {
        String command = "/NadaParaFazer cats";
        List<String> arguments = parser.parse(command);

        assert(arguments.get(0).equals("cats"));
    }

    @Test
    public void shouldReturnMultiplergListForCorrectMultipleSubredditCommand() throws InvalidSlashCommand {
        String command = "/NadaParaFazer cats;dogs";
        List<String> arguments = parser.parse(command);

        assert(arguments.size() == 2);
    }

    @Test
    public void shouldReturnMultipleSubredditsForCorrectMultipleSubredditCommand() throws InvalidSlashCommand {
        String command = "/NadaParaFazer cats;dogs";
        List<String> arguments = parser.parse(command);
        Set<String> argumentsSet = new HashSet<>(arguments);
        Set<String> expectedSet = new HashSet<>(Arrays.asList("cats", "dogs"));

        assert(argumentsSet.containsAll(expectedSet) && expectedSet.containsAll(argumentsSet));
    }

    @Test(expected = InvalidSlashCommand.class)
    public void shouldReturnExceptionWhenParsingUnkownCommand() throws InvalidSlashCommand {
        String command = "/NadaPara cats;dogs";
        List<String> arguments = parser.parse(command);
    }

    @Test
    public void shouldReturnExceptionWithUnkownCommandMessageWhenParsingUnkownCommand() {
        try {
            String command = "/NadaPara cats;dogs";
            List<String> arguments = parser.parse(command);
        } catch (InvalidSlashCommand e) {
            assert ("Not supported command: /NadaPara".equals(e.getMessage()));
        }
    }

    @Test(expected = InvalidSlashCommand.class)
    public void shouldReturnExceptionWhenParsingCommandWithoutSubreddits() throws InvalidSlashCommand {
        String command = "/NadaParaFazer";
        List<String> arguments = parser.parse(command);
    }

    @Test
    public void shouldReturnExceptiWithWrongArgumentNumberMessageWhenParsingCommandWithoutSubreddits() {
        try {
            String command = "/NadaPara";
            List<String> arguments = parser.parse(command);
        } catch (InvalidSlashCommand e) {
            assert ("Wrong argument number".equals(e.getMessage()));
        }
    }

}
