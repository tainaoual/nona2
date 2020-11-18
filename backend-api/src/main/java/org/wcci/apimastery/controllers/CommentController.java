package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.resources.Comment;
import org.wcci.apimastery.storage.CommentStorage;

@RestController
public class CommentController {

    private CommentStorage commentStorage;

    public CommentController(CommentStorage commentStorage) {
        this.commentStorage = commentStorage;
    }

    @GetMapping("/api/comment")
    public Iterable<Comment> retrieveAllRating() {
        return commentStorage.retrieveAllComments();
    }

    @GetMapping("/api/comment/{id}")
    public Comment retrieveCommentsById(@PathVariable Long id) {
        return commentStorage.retrieveCommentById(id);
    }

    @PostMapping("/api/comment")
    public Iterable<Comment> addComment(@RequestBody Comment commentToAdd) {
        commentStorage.saveComments(commentToAdd);
        return commentStorage.retrieveAllComments();
    }

    @PutMapping("/api/comment")
    public Iterable<Comment> editComment(@RequestBody Comment commentToEdit) {
        if (commentToEdit.getId() != null) {
            commentStorage.saveComments(commentToEdit);
        }
        return commentStorage.retrieveAllComments();
    }

    @DeleteMapping("/api/comment/{id}")
    public Iterable<Comment> deleteCommentById(@PathVariable Long id) {
        commentStorage.deleteCommentById(id);
        return commentStorage.retrieveAllComments();
    }
}
