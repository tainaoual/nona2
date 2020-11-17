package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.resources.Rating;
import org.wcci.apimastery.storage.RatingStorage;

@RestController
public class RatingController {

    private RatingStorage ratingStorage;

    public RatingController(RatingStorage ratingStorage){
        this.ratingStorage = ratingStorage;
    }

    @GetMapping("/api/rating")
    public Iterable<Rating> retrieveAllRating(){
        return ratingStorage.retrieveAllRatings();
    }
    @GetMapping("/api/rating/{id}")
    public Rating retrieveRatingsById(@PathVariable Long id){
        return ratingStorage.retrieveRatingById(id);
    }
    @PostMapping("/api/rating")
    public Iterable<Rating> addRating(@RequestBody Rating ratingToAdd){
        ratingStorage.saveRating(ratingToAdd);
        return ratingStorage.retrieveAllRatings();
    }
    @PutMapping("/api/rating")
    public Iterable<Rating> editRating(@RequestBody Rating ratingToEdit){
        if (ratingToEdit.getId() != null){
            ratingStorage.saveRating(ratingToEdit);
        }
        return ratingStorage.retrieveAllRatings();
    }
    @DeleteMapping("/api/rating/{id}")
    public Iterable<Rating> deleteRatingById(@PathVariable Long id){
        ratingStorage.deleteRatingById(id);
        return ratingStorage.retrieveAllRatings();
    }
}
