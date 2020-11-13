package org.wcci.apimastery.resources;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String commentContent;
    @ManyToOne
    private Song song;
    @OneToMany
    private List<Comment> comments;
    protected Comment() {
    }
    public Comment(String commentContent, Song song) {
        this.commentContent = commentContent;
        this.song = song;
    }
    public String getCommentContent() {
        return commentContent;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public Long getId() {
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        if (!id.equals(comment.id)) return false;
        return commentContent.equals(comment.commentContent);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + commentContent.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentContent='" + commentContent + '\'' +
                ", comments=" + comments +
                '}';
    }
    public Comment getComment() {
        return new Comment();
    }
}