package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.resources.Album;
import org.wcci.apimastery.resources.Song;
import org.wcci.apimastery.storage.AlbumsStorage;
import org.wcci.apimastery.storage.SongsRepository;

@RestController
public class AlbumsController {

    private AlbumsStorage albumsStorage;
    private SongsRepository songsRepo;

    public AlbumsController(AlbumsStorage albumsStorage,SongsRepository songsRepo) {
        this.albumsStorage = albumsStorage;
        this.songsRepo = songsRepo;
    }

    @GetMapping("/api/albums")
    public Iterable<Album> retrieveAllAlbums() {
        return albumsStorage.retrieveAllAlbums();
    }

    @GetMapping("/api/albums/{id}")
    public Album retrieveAlbumsById(@PathVariable Long id) {
        return albumsStorage.RetrieveAlbumsById(id);
    }

    @PostMapping("/api/albums")
    public Iterable<Album> addAlbums(@RequestBody Album albumToAdd) {
        albumsStorage.saveAlbums(albumToAdd);
        return albumsStorage.retrieveAllAlbums();
    }

    @PutMapping("/api/albums")
    public Iterable<Album> editAlbums(@RequestBody Album albumToEdit) {
        if (albumToEdit.getId() != null) {
            albumsStorage.saveAlbums(albumToEdit);
        }
        return albumsStorage.retrieveAllAlbums();
    }

    @PatchMapping("/api/albums/{id}/title")
    public Album changeAlbumsTitle(@RequestBody String newTitle, @PathVariable Long id) {
        Album albumToChangeTitle = albumsStorage.RetrieveAlbumsById(id);
        albumToChangeTitle.changeTitle(newTitle);
        albumsStorage.saveAlbums(albumToChangeTitle);
        return albumToChangeTitle;
    }
    @PatchMapping("/api/albums/{albumsId}/songs")
    public Album addSongToAlbum(@RequestBody Song songToAdd,@PathVariable long albumsId){
        Album album = albumsStorage.RetrieveAlbumsById(albumsId);
        Song song = new Song(songToAdd.getTitle(),songToAdd.getLink(),songToAdd.getDuration(),album);
        songsRepo.save(song);
        return albumsStorage.RetrieveAlbumsById(albumsId);
    }

    @DeleteMapping("/api/albums/{id}")
    public Iterable<Album> deleteAlbumsById(@PathVariable Long id) {
        albumsStorage.deleteAlbumsById(id);
        return albumsStorage.retrieveAllAlbums();
    }
}
