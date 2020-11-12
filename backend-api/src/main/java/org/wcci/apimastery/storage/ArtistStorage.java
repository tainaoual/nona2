package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.resources.Artist;

@Service
public class ArtistStorage {

    private ArtistRepository artistRepo;

    public ArtistStorage(ArtistRepository artistRepo){
        this.artistRepo = artistRepo;
    }
    public Artist retrieveArtistById(Long id){
        return artistRepo.findById(id).get();
    }
    public Iterable<Artist> retrieveAllArtists(){
        return artistRepo.findAll();
    }
    public void saveArtists(Artist artistToSave){
        artistRepo.save(artistToSave);
    }
    public void deleteAArtistById(Long id){
        artistRepo.deleteById(id);
    }
}
