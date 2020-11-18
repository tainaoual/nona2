package org.wcci.apimastery.storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.resources.Song;

public interface SongsRepository extends CrudRepository<Song, Long > {
}
