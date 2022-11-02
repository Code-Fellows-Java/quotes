package quotes;

import java.util.ArrayList;

public class Quote {
    private ArrayList <String> tags = new ArrayList<>();
    private String author;
    private String likes;
    private String text;

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }
}
