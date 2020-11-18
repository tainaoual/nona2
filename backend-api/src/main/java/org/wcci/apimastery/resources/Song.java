package org.wcci.apimastery.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String title;
    private Integer duration;
    private String link;
    @ManyToOne
    @JsonIgnore
    private Album album;
    @OneToMany(mappedBy = "song", orphanRemoval = true)
    private List<Comment> comments = Collections.EMPTY_LIST;

    protected Song() {
    }

    public Song(String title, String link, Integer duration, Album album) {
        this.album = album;
        this.title = title;
        this.link = link;
        this.duration = duration;
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

    public int getDuration() {
        return duration;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void changeTitle(String newTitle) {
        title = newTitle;
    }

    public Album getAlbum() {
        return album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) &&
                Objects.equals(title, song.title) &&
                Objects.equals(duration, song.duration) &&
                Objects.equals(link, song.link) &&
                Objects.equals(album, song.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, duration, link, album);
    }
}