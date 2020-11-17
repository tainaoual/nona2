package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.resources.Rating;

@Service
public class RatingStorage {
    private RatingRepository ratingRepo;

    public RatingStorage(RatingRepository ratingRepo){
        this.ratingRepo = ratingRepo;
    }
    public Rating retrieveRatingById(Long id){
        return ratingRepo.findById(id).get();
    }
    public Iterable<Rating> retrieveAllRatings(){
        return ratingRepo.findAll();
    }
    public void saveRating(Rating ratingToSave){
        ratingRepo.save(ratingToSave);
    }
    public void deleteRatingById(Long id){
        ratingRepo.deleteById(id);
    }
}
