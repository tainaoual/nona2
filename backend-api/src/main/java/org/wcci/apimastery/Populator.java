package org.wcci.apimastery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.resources.*;
import org.wcci.apimastery.storage.*;
@Component
public class Populator implements CommandLineRunner {
    private AlbumsStorage albumsStorage;
    private SongsRepository songsRepo;
    private CommentRepository commentRepos;
    private RatingRepository ratingRepo;
    public Populator(AlbumsStorage albumsStorage, SongsRepository songsRepo, CommentRepository commentRepo,RatingRepository ratingRepo){
        this.albumsStorage = albumsStorage;
        this.songsRepo = songsRepo;
        this.commentRepos = commentRepo;
        this.ratingRepo = ratingRepo;
    }
    @Override
    public void run(String... args) throws Exception {
        Album album1 = new Album("Back in Black", "img","Back in Black","song");
        albumsStorage.saveAlbums(album1);
        Album album2 = new Album("dodo", "img","dodo","song");
        albumsStorage.saveAlbums(album2);
        Song takeItEasy = new Song("eagle","link",5,album1);
        songsRepo.save(takeItEasy);
        Song backInBlack = new Song("eagle","link",5,album2);
        songsRepo.save(backInBlack);
        Comment comment1 = new Comment("this is a test", takeItEasy);
        commentRepos.save(comment1);
        Comment comment2 = new Comment("salam",backInBlack);
        commentRepos.save(comment2);
        Rating rating1 = new Rating(album1 ,5);
        ratingRepo.save(rating1);
        Rating rating2 = new Rating(album2 ,5);
        ratingRepo.save(rating2);
    }
}