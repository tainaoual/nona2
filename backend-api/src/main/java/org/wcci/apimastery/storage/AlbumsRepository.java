package org.wcci.apimastery.storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.resources.Albums;


public interface AlbumsRepository extends CrudRepository<Albums, Long> {
}
