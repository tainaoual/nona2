package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.resources.Artist;
import org.wcci.apimastery.storage.ArtistStorage;

@RestController
public class ArtistController {
    private ArtistStorage artistStorage;

    public ArtistController(ArtistStorage artistStorage){
        this.artistStorage = artistStorage;
    }
    @GetMapping("/api/artist")
    public Iterable<Artist> retrieveAllArtists(){
        return artistStorage.retrieveAllArtists();
    }
    @GetMapping("/api/artist/{id}")
    public Artist retrieveArtistsById(@PathVariable Long id){
        return artistStorage.retrieveArtistById(id);
    }
    @PostMapping("/api/artist")
    public Iterable<Artist> addArtist(@RequestBody Artist artistToAdd){
        artistStorage.saveArtists(artistToAdd);
        return artistStorage.retrieveAllArtists();
    }
    @PutMapping("/api/artist")
    public Iterable<Artist> editArtist(@RequestBody Artist artistToEdit){
        if(artistToEdit.getId()!=null){
            artistStorage.saveArtists(artistToEdit);
        }
        return artistStorage.retrieveAllArtists();
    }
    @PatchMapping("/api/artist/{id}/artistName")
    public Artist changeArtistName(@RequestBody String newArtistName, @PathVariable Long id){
        Artist artistToChangeArtistName = artistStorage.retrieveArtistById(id);
        artistToChangeArtistName.changeArtistName(newArtistName);
        artistStorage.saveArtists(artistToChangeArtistName);
        return artistToChangeArtistName;
    }
    @DeleteMapping("/api/artist/{id}")
    public Iterable<Artist> deleteArtistById(@PathVariable Long id){
        artistStorage.deleteAArtistById(id);
        return artistStorage.retrieveAllArtists();
    }
}
