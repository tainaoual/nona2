package org.wcci.apimastery.storages;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.resources.Songs;

public interface SongsRepository extends CrudRepository<Songs , Long > {
}
