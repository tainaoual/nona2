package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.resources.Albums;
import org.wcci.apimastery.storage.AlbumsStorage;

@RestController
public class AlbumsController {

    private AlbumsStorage albumsStorage;

    public AlbumsController(AlbumsStorage albumsStorage){
        this.albumsStorage = albumsStorage;
    }

    @GetMapping("/api/albums")
    public Iterable<Albums> retrieveAllAlbums(){
        return albumsStorage.retrieveAllAlbums();
    }
    @GetMapping("/api/albums/{id}")
    public Albums retrieveAlbumsById(@PathVariable Long id){
        return albumsStorage.RetrieveAlbumsById(id);
    }
    @PostMapping("/api/albums")
    public Iterable<Albums> addAlbums(@RequestBody Albums albumsToAdd){
        albumsStorage.saveAlbums(albumsToAdd);
        return albumsStorage.retrieveAllAlbums();
    }
    @PutMapping("/api/albums")
    public Iterable<Albums> editAlbums(@RequestBody Albums albumsToEdit){
        if (albumsToEdit.getId() != null){
            albumsStorage.saveAlbums(albumsToEdit);
        }
        return albumsStorage.retrieveAllAlbums();
    }
    @PatchMapping("/api/albums/{id}/title")
    public Albums changeAlbumsTitle(@RequestBody String newTitle,@PathVariable Long id){
        Albums albumToChangeTitle = albumsStorage.RetrieveAlbumsById(id);
        albumToChangeTitle.changeTitle(newTitle);
        albumsStorage.saveAlbums(albumToChangeTitle);
        return albumToChangeTitle;
    }
    @DeleteMapping("/api/albums/{id}")
    public Iterable<Albums> deleteAlbumsById(@PathVariable Long id){
        albumsStorage.deleteAlbumsById(id);
        return albumsStorage.retrieveAllAlbums();
    }
}
