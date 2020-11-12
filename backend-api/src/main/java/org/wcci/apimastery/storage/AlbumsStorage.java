package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.resources.Album;

@Service
public class AlbumsStorage {

    private AlbumsRepository albumsRepo;

    public AlbumsStorage(AlbumsRepository albumsRepo) {
        this.albumsRepo = albumsRepo;
    }

    public Album RetrieveAlbumsById(Long id) {
        return albumsRepo.findById(id).get();
    }

    public Iterable<Album> retrieveAllAlbums() {
        return albumsRepo.findAll();
    }

    public void saveAlbums(Album albumToSave) {
        albumsRepo.save(albumToSave);
    }

    public void deleteAlbumsById(Long id) {
        albumsRepo.deleteById(id);
    }


}
