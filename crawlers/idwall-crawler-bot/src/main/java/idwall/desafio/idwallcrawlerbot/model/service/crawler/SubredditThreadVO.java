package idwall.desafio.idwallcrawlerbot.model.service.crawler;

public class SubredditThreadVO {

    private final String subreddit;
    private final String title;
    private final String link;
    private final Integer upvotes;

    public SubredditThreadVO(String subreddit, String title, String link, Integer upvotes) {
        this.subreddit = subreddit;
        this.title = title;
        this.link = link;
        this.upvotes = upvotes;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return
//                "subreddit=\"" + subreddit + "\"\n" +
                "title=\"" + title + "\"\n" +
                "link=\"" + link + "\"\n" +
                "upvotes=" + upvotes + "\n";
    }
}
