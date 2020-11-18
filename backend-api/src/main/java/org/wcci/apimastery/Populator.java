package org.wcci.apimastery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.resources.*;
import org.wcci.apimastery.storage.*;
@Component
public class Populator implements CommandLineRunner {
    private AlbumsStorage albumsStorage;
    private SongStorage songStorage;
    private CommentRepository commentRepos;

public Populator(AlbumsStorage albumsStorage, SongStorage songStorage, CommentRepository commentRepo){
        this.albumsStorage = albumsStorage;
        this.songStorage = songStorage;
        this.commentRepos = commentRepo;

    }
    @Override
    public void run(String... args) throws Exception {
        Album backInBlack = new Album("Back in Black", "img","Back in Black","AC/DC", 5);
        albumsStorage.saveAlbums(backInBlack);
        Song hellsBells = new Song("Hells bells","link",5,backInBlack);
        songStorage.saveSongs(hellsBells);
        Song shootToThrill = new Song("Shoot to Thrill","link",5,backInBlack);
        songStorage.saveSongs(shootToThrill);
        Song whatDoYouDoForMoneyHoney = new Song("What Do You Do For Money Honey","link",5,backInBlack);
        songStorage.saveSongs(whatDoYouDoForMoneyHoney);
        Song letMePutMyLoveIntoYou = new Song("Let Me Put My Love Into You","link",4,backInBlack);
        songStorage.saveSongs(letMePutMyLoveIntoYou);
        Song haveADrinkOnMe = new Song("Have a Drink On Me","link",4,backInBlack);
        songStorage.saveSongs(haveADrinkOnMe);
        Comment comment2 = new Comment("pretty iconic song !",hellsBells);
        commentRepos.save(comment2);

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^first album^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        Album Eagles = new Album("Greatest Hits", "img","Eagles","Eagles",12);
        albumsStorage.saveAlbums(Eagles);
        Song takeItEasy = new Song("Take it Easy","link",3,Eagles);
        songStorage.saveSongs(takeItEasy);
        Comment comment1 = new Comment("this is a test", takeItEasy);
        commentRepos.save(comment1);
        Comment comment3 = new Comment("this is a test 3", takeItEasy);
        commentRepos.save(comment3);

    }
}