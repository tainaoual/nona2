package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.resources.*;
import org.wcci.apimastery.storage.*;

@Component
public class Populator implements CommandLineRunner {

    private AlbumsStorage albumsStorage;
    private SongsRepository songsRepo;
    private ArtistRepository artistRepo;
    private CommentRepository commentRepos;
    private GenreRepository genreRepo;
    private RatingRepository ratingRepo;

    public Populator(AlbumsStorage albumsStorage, SongsRepository songsRepo, ArtistRepository artistRepo, CommentRepository commentRepo, GenreRepository genreRepo,RatingRepository ratingRepo){
        this.albumsStorage = albumsStorage;
        this.songsRepo = songsRepo;
        this.artistRepo = artistRepo;
        this.commentRepos = commentRepo;
        this.genreRepo = genreRepo;
        this.ratingRepo = ratingRepo;
    }
    @Override
    public void run(String... args) throws Exception {
    //this is the artist
        Artist artist1 = new Artist("john","img");
        artistRepo.save(artist1);
    //this is the comment
        Comment comment1 = new Comment("this is a test");
        commentRepos.save(comment1);

    //this is the Albums
        Album eagles = new Album("Eagles", "img","eagles",artist1);
        albumsStorage.saveAlbums(eagles);
        Album ACDC = new Album("Back in Black", "img","Back in Black",artist1);
        albumsStorage.saveAlbums(ACDC);
    //this it the rating
         Rating rating1 = new Rating(eagles,5);
         ratingRepo.save(rating1);
     //this is the Genre
        Genre genre1 = new Genre("Rock");
        genreRepo.save(genre1);
     // this is the Songs
        Song takeItEasy = new Song(eagles,"eagle","https","2 min");
        songsRepo.save(takeItEasy);
        Song backInBlack = new Song(ACDC,"Back In Black","https","long");
        songsRepo.save(backInBlack);
    }
}
