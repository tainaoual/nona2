package org.wcci.apimastery.storage;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.resources.Rating;

public interface RatingRepository extends CrudRepository<Rating,Long > {
}
