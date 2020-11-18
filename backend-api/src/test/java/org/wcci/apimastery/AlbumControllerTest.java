package org.wcci.apimastery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.apimastery.controllers.AlbumsController;
import org.wcci.apimastery.resources.Album;
import org.wcci.apimastery.storage.AlbumsStorage;
import org.wcci.apimastery.storage.SongsRepository;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AlbumControllerTest {

    private AlbumsStorage albumsStorage;
    private AlbumsController underTest;

    @BeforeEach
    void setUp(){
        albumsStorage = mock(AlbumsStorage.class);
        SongsRepository songsRepo = mock(SongsRepository.class);
        underTest = new AlbumsController(albumsStorage,songsRepo);
        when(albumsStorage.retrieveAllAlbums()).thenReturn(Collections.singletonList(new Album("test title","test img","test record label","testy",5)));
    }
    @Test
    public void shouldRetrieveAllAlbums(){
        Iterable<Album> albums = underTest.retrieveAllAlbums();
        assertThat(albums).contains(new Album("test title","test img","test record label","testy",5));
    }
    @Test
    public void retrieveAllAlbumsShouldBeMappedCorrectly() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/api/albums")).andExpect(status().isOk());
    }
}

