package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.resources.Album;
import org.wcci.apimastery.storage.AlbumsStorage;

@RestController
public class AlbumsController {

    private AlbumsStorage albumsStorage;

    public AlbumsController(AlbumsStorage albumsStorage){
        this.albumsStorage = albumsStorage;
    }

    @GetMapping("/api/albums")
    public Iterable<Album> retrieveAllAlbums(){
        return albumsStorage.retrieveAllAlbums();
    }
    @GetMapping("/api/albums/{id}")
    public Album retrieveAlbumsById(@PathVariable Long id){
        return albumsStorage.RetrieveAlbumsById(id);
    }
    @PostMapping("/api/albums")
    public Iterable<Album> addAlbums(@RequestBody Album albumToAdd){
        albumsStorage.saveAlbums(albumToAdd);
        return albumsStorage.retrieveAllAlbums();
    }
    @PutMapping("/api/albums")
    public Iterable<Album> editAlbums(@RequestBody Album albumToEdit){
        if (albumToEdit.getId() != null){
            albumsStorage.saveAlbums(albumToEdit);
        }
        return albumsStorage.retrieveAllAlbums();
    }
    @PatchMapping("/api/albums/{id}/title")
    public Album changeAlbumsTitle(@RequestBody String newTitle, @PathVariable Long id){
        Album albumToChangeTitle = albumsStorage.RetrieveAlbumsById(id);
        albumToChangeTitle.changeTitle(newTitle);
        albumsStorage.saveAlbums(albumToChangeTitle);
        return albumToChangeTitle;
    }
    @DeleteMapping("/api/albums/{id}")
    public Iterable<Album> deleteAlbumsById(@PathVariable Long id){
        albumsStorage.deleteAlbumsById(id);
        return albumsStorage.retrieveAllAlbums();
    }
}
