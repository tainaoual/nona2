package org.wcci.apimastery.storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.resources.Comment;

public interface CommentRepository extends CrudRepository<Comment,Long> {
}
