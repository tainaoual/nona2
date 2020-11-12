package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.resources.Genre;
import org.wcci.apimastery.storage.GenreStorage;


@RestController
public class GenreController {

    private GenreStorage genreStorage;

    public GenreController(GenreStorage genreStorage){
        this.genreStorage = genreStorage;
    }

    @GetMapping("/api/genre")
    public Iterable<Genre> retrieveAllGenre(){
        return genreStorage.retrieveAllGenres();
    }
    @GetMapping("/api/genre/{id}")
    public Genre retrieveGenresById(@PathVariable Long id){
        return genreStorage.retrieveGenreById(id);
    }
    @PostMapping("/api/genre")
    public Iterable<Genre> addGenres(@RequestBody Genre genreToAdd){
        genreStorage.saveGenres(genreToAdd);
        return genreStorage.retrieveAllGenres();
    }
    @PutMapping("/api/genre")
    public Iterable<Genre> editGenre(@RequestBody Genre genreToEdit){
        if (genreToEdit.getId() != null){
            genreStorage.saveGenres(genreToEdit);
        }
        return genreStorage.retrieveAllGenres();
    }
    @PatchMapping("/api/genre/{id}/genreName")
    public Genre changeGenreName(@RequestBody String newGenreName, @PathVariable Long id){
        Genre genreToChangeGenreName = genreStorage.retrieveGenreById(id);
        genreToChangeGenreName.changeGenreName(newGenreName);
        genreStorage.saveGenres(genreToChangeGenreName);
        return genreToChangeGenreName;
    }
    @DeleteMapping("/api/genre/{id}")
    public Iterable<Genre> deleteGenreById(@PathVariable Long id){
        genreStorage.deleteGenreById(id);
        return genreStorage.retrieveAllGenres();
    }
}
