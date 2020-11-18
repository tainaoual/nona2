package org.wcci.apimastery.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String commentContent;
    @ManyToOne
    @JsonIgnore
    private Song song;

    protected Comment() {
    }

    public Comment(String commentContent, Song song) {
        this.commentContent = commentContent;
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public Long getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(commentContent, comment.commentContent) &&
                Objects.equals(song, comment.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentContent, song);
    }
}