package org.wcci.apimastery.storages;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.resources.Albums;


public interface AlbumsRepository extends CrudRepository<Albums, Long> {
}
