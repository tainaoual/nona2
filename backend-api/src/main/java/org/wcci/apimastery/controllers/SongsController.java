package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.resources.Albums;
import org.wcci.apimastery.resources.Songs;
import org.wcci.apimastery.storage.AlbumsStorage;
import org.wcci.apimastery.storage.SongStorage;

@RestController
public class SongsController {

    private SongStorage songStorage;

    public SongsController(SongStorage songStorage){
        this.songStorage = songStorage;
    }

    @GetMapping("/api/songs")
    public Iterable<Songs> retrieveAllSongs(){
        return songStorage.retrieveAllSongs();
    }
    @GetMapping("/api/songs/{id}")
    public Songs retrieveSongsById(@PathVariable Long id){
        return songStorage.RetrieveSongsById(id);
    }
    @PostMapping("/api/songs")
    public Iterable<Songs> addSongs(@RequestBody Songs songsToAdd){
        songStorage.saveSongs(songsToAdd);
        return songStorage.retrieveAllSongs();
    }
    @PutMapping("/api/songs")
    public Iterable<Songs> editSongs(@RequestBody Songs songsToEdit){
        if (songsToEdit.getId() != null){
            songStorage.saveSongs(songsToEdit);
        }
        return songStorage.retrieveAllSongs();
    }
    @PatchMapping("/api/songs/{id}/title")
    public Songs changeSongsTitle(@RequestBody String newTitle,@PathVariable Long id){
        Songs songToChangeTitle = songStorage.RetrieveSongsById(id);
        songToChangeTitle.changeTitle(newTitle);
        songStorage.saveSongs(songToChangeTitle);
        return songToChangeTitle;
    }
    @DeleteMapping("/api/songs/{id}")
    public Iterable<Songs> deleteSongsById(@PathVariable Long id){
        songStorage.deleteASongById(id);
        return songStorage.retrieveAllSongs();
    }
}
