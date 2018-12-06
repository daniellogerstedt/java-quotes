public class Quote {
    protected String[] tags;
    protected String author;
    protected String text;
    protected String likes;

    public Quote(String[] tags, String author, String text, String likes) {
        this.tags = tags;
        this.author = author;
        this.text = text;
        this.likes = likes;
    }

    public String toString() {
        return text + " - " + author;
    }
}
