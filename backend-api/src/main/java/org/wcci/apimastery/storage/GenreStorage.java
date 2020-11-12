package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.resources.Genre;

@Service
public class GenreStorage {

    private GenreRepository genreRepo;

    public GenreStorage(GenreRepository genreRepo){
        this.genreRepo = genreRepo;
    }
    public Genre retrieveGenreById(Long id){
        return genreRepo.findById(id).get();
    }
    public Iterable<Genre> retrieveAllGenres(){
        return genreRepo.findAll();
    }
    public void saveGenres(Genre genreToSave){
        genreRepo.save(genreToSave);
    }
    public void deleteGenreById(Long id){
        genreRepo.deleteById(id);
    }
}
