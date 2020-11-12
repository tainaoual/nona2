package org.wcci.apimastery.storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.resources.Artist;

public interface ArtistRepository extends CrudRepository<Artist,Long> {

}
