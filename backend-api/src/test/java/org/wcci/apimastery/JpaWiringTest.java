package org.wcci.apimastery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.resources.*;
import org.wcci.apimastery.storage.*;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private AlbumsRepository albumsRepo;
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private SongsRepository songsRepo;
    @Autowired
    private TestEntityManager entityManager;
    private void flushAndClear(){
        entityManager.flush();
        entityManager.clear();
    }
    @Test
    public void AlbumsRepoShouldSaveAndRetrieveAlbumsObjects(){

        Album testAlbum1 = new Album("Back in Black", "img","Back in Black","lila",5);
        albumsRepo.save(testAlbum1);
        flushAndClear();
        Album retrievedAlbums = albumsRepo.findById(testAlbum1.getId()).get();
        assertThat(retrievedAlbums).isEqualTo(testAlbum1);
    }
    @Test
    public void songsHaveManyComments() {
        Album testAlbum1 = new Album("Back in Black", "img","Back in Black","lila",5);
        albumsRepo.save(testAlbum1);
        Song testSong = new Song("eagle", "link", 5,testAlbum1);
        songsRepo.save(testSong);
        Comment testComment1 = new Comment("this is a test",testSong);
        commentRepo.save(testComment1);
        Comment testComment2 = new Comment("salam",testSong );
        commentRepo.save(testComment2);
        flushAndClear();
        Song retrievedSong = songsRepo.findById(testSong.getId()).get();
        assertThat(retrievedSong.getComments()).contains(testComment1, testComment2);

        assertThat(retrievedSong).isEqualTo(testSong);
    }
    @Test
    public void AlbumsShouldHaveSongs(){
        Album testAlbum1 = new Album("Back in Black", "img","Back in Black","lila",5);
        albumsRepo.save(testAlbum1);
        Song testSong = new Song("eagle","link",5,testAlbum1);
        songsRepo.save(testSong);
        flushAndClear();
        Album retrievedAlbums = albumsRepo.findById(testAlbum1.getId()).get();
        assertThat(retrievedAlbums.getSongs()).contains(testSong);
    }
}

