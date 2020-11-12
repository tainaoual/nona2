package org.wcci.apimastery.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

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
}
