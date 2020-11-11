package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.resources.Albums;
import org.wcci.apimastery.resources.Song;
import org.wcci.apimastery.storage.AlbumsStorage;
import org.wcci.apimastery.storage.SongsRepository;

@Component
public class Populator implements CommandLineRunner {

    private AlbumsStorage albumsStorage;
    private SongsRepository songsRepo;

    public Populator(AlbumsStorage albumsStorage, SongsRepository songsRepo){
        this.albumsStorage = albumsStorage;
        this.songsRepo = songsRepo;
    }
    @Override
    public void run(String... args) throws Exception {
    //this is the Albums
        Albums eagles = new Albums("Eagles","img","some random song","some record label","5");
        albumsStorage.saveAlbums(eagles);
        Albums ACDC = new Albums("Back in Black", "img","Back in Black","whatever","10");
        albumsStorage.saveAlbums(ACDC);
    //this is the Songs
        Song takeItEasy = new Song(eagles,"Take it Easy","some link","some length of song","dont know what this is about","3");
        songsRepo.save(takeItEasy);
        Song backInBlack = new Song(ACDC,"Back In Black","some other link","long","awesome sauce","8");
        songsRepo.save(backInBlack);
    }
}
