package org.wcci.apimastery.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String commentContent;
    @OneToMany
    private List<Comment> comments;

    protected Comment() {}

    public Comment(String commentContent) {
        this.commentContent = commentContent;
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
        return Objects.equals(id, comment.id) &&
                Objects.equals(commentContent, comment.commentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commentContent);
    }
}
