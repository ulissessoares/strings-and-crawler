package idwall.desafio.idwallcrawlerbot.model.service.crawler;

public class SubredditVO {

    private final String html;
    private final String subredditName;

    public SubredditVO(String html, String subredditName) {
        this.html = html;
        this.subredditName = subredditName;
    }

    public String getHtml() {
        return html;
    }

    public String getSubredditName() {
        return subredditName;
    }
}
