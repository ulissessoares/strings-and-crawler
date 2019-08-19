package idwall.desafio.idwallcrawlerbot.controller.bot.parser;

import idwall.desafio.idwallcrawlerbot.exception.InvalidSlashCommand;

import java.util.List;

public interface ISlashCommandParser {
    public List<String> parse(String command) throws InvalidSlashCommand;
}
