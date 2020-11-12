package org.wcci.apimastery.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String duration;
    @Lob
    private String link;
    @ManyToOne
    @JsonIgnore
    private Album album;
    @OneToMany
    private List<Comment> comments;


    protected Song() {
    }
    public Song(Album album, String title, String link, String duration) {
        this.album = album;
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.comments = new ArrayList<Comment>();
    }

    public Album getAlbums() {
        return album;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void changeTitle(String newTitle) {
        title = newTitle;
    }


}