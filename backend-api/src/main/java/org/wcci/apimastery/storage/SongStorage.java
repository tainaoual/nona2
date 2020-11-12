package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.resources.Song;

@Service
public class SongStorage {

    private SongsRepository songsRepo;

    public SongStorage(SongsRepository songsRepo) {
        this.songsRepo = songsRepo;
    }

    public Song retrieveSongsById(Long id) {
        return songsRepo.findById(id).get();
    }

    public Iterable<Song> retrieveAllSongs() {
        return songsRepo.findAll();
    }
    public void saveSongs(Song songToSave) {
        songsRepo.save(songToSave);
    }

    public void deleteASongById(Long id) {
        songsRepo.deleteById(id);
    }


}






