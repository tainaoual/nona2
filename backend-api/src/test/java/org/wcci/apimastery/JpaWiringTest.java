package org.wcci.apimastery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.resources.Album;
import org.wcci.apimastery.resources.Artist;
import org.wcci.apimastery.storage.*;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private AlbumsRepository albumsRepo;
    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private GenreRepository genreRepo;
    @Autowired
    private RatingRepository ratingRepo;
    @Autowired
    private SongsRepository songsRepo;
    @Autowired
    private TestEntityManager entityManager;

    private void flushAndClear(){
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    public void albumsRepoShouldSaveAndRetrieveAlbumObjects(){
//        Artist testArtist = new Artist("testy","test img");
//        artistRepo.save(testArtist);
        Album testAlbum = new Album("test title","test img","test record label",new Artist("testy","test img"));
        albumsRepo.save(testAlbum);
        flushAndClear();
        Album retrievedAlbum = albumsRepo.findById(testAlbum.getId()).get();
        assertThat(retrievedAlbum).isEqualTo(testAlbum);
    }

}
