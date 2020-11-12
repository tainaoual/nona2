package org.wcci.apimastery.storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.resources.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
