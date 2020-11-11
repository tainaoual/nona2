package org.wcci.apimastery.resources;

import java.util.Objects;

public class Songs {
    private Long id;
    private String title;
    private String link;
    private String duration;
    private String comments;
    private String ratings;

    protected Songs() {
    }
    public Songs(String title, String link, String duration, String comments, String ratings) {

        this.title = title;
        this.link = link;
        this.duration = duration;
        this.comments = comments;
        this.ratings = ratings;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getLink() {
        return link;
    }
    public String getDuration() {
        return duration;
    }
    public String getComments() {
        return comments;
    }
    public String getRatings() {
        return ratings;
    }
    public void changeTitle(String newTitle) {
        title = newTitle;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Songs songs = (Songs) o;
        return id == songs.id &&
                Objects.equals(title, songs.title) &&
                Objects.equals(link, songs.link) &&
                Objects.equals(duration, songs.duration) &&
                Objects.equals(comments, songs.comments) &&
                Objects.equals(ratings, songs.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, link, duration, comments, ratings);
    }


}