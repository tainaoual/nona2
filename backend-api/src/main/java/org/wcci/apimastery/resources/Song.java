package org.wcci.apimastery.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Song {
    @ManyToOne
    @JsonIgnore
    private Albums albums;
    private String title;
    @Lob
    private String link;
    private String duration;
    private String comments;
    private String ratings;
    @Id
    @GeneratedValue
    private Long id;
    protected Song() {
    }
    public Song(Albums albums, String title, String link, String duration, String comments, String ratings) {
        this.albums = albums;
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.comments = comments;
        this.ratings = ratings;
    }

    public Albums getAlbums() {
        return albums;
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
        Song song = (Song) o;
        return Objects.equals(albums, song.albums) &&
                Objects.equals(title, song.title) &&
                Objects.equals(link, song.link) &&
                Objects.equals(duration, song.duration) &&
                Objects.equals(comments, song.comments) &&
                Objects.equals(ratings, song.ratings) &&
                Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albums, title, link, duration, comments, ratings, id);
    }
}