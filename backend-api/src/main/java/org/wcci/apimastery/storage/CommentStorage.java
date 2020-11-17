package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.resources.Comment;

@Service
public class CommentStorage {

    private CommentRepository commentRepo;

    public CommentStorage(CommentRepository commentRepo){
        this.commentRepo = commentRepo;
    }
    public Comment retrieveCommentById(Long id){
        return commentRepo.findById(id).get();
    }
    public Iterable<Comment> retrieveAllComments(){
        return commentRepo.findAll();
    }
    public void saveComments(Comment commentToSave){
        commentRepo.save(commentToSave);
    }
    public void deleteCommentById(Long id){
        commentRepo.deleteById(id);
    }
}
