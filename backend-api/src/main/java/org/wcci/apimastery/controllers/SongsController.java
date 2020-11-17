package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.resources.Song;
import org.wcci.apimastery.storage.SongStorage;

@RestController
public class SongsController {

    private SongStorage songStorage;

    public SongsController(SongStorage songStorage){
        this.songStorage = songStorage;
    }

    @GetMapping("/api/songs")
    public Iterable<Song> retrieveAllSongs(){
        return songStorage.retrieveAllSongs();
    }
    @GetMapping("/api/songs/{id}")
    public Song retrieveSongsById(@PathVariable Long id){
        return songStorage.retrieveSongsById(id);
    }
    @PostMapping("/api/songs")
    public Iterable<Song> addSongs(@RequestBody Song songToAdd){
        songStorage.saveSongs(songToAdd);
        return songStorage.retrieveAllSongs();
    }
    @PutMapping("/api/songs")
    public Iterable<Song> editSongs(@RequestBody Song songToEdit){
        if (songToEdit.getId() != null){
            songStorage.saveSongs(songToEdit);
        }
        return songStorage.retrieveAllSongs();
    }
    @PatchMapping("/api/songs/{id}/title")
    public Song changeSongsTitle(@RequestBody String newTitle, @PathVariable Long id){
        Song songToChangeTitle = songStorage.retrieveSongsById(id);
        songToChangeTitle.changeTitle(newTitle);
        songStorage.saveSongs(songToChangeTitle);
        return songToChangeTitle;
    }
    @DeleteMapping("/api/songs/{id}")
    public Iterable<Song> deleteSongsById(@PathVariable Long id){
        songStorage.deleteASongById(id);
        return songStorage.retrieveAllSongs();
    }
}
