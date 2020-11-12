package org.wcci.apimastery.resources;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private Long id;
    private String artistName;
    @Lob
    private String image;
    @OneToMany
    private List<Album> albums;
    @ManyToMany
    private List<Genre> genres;

    protected Artist(){

    }
    public Artist(String artistName, String image){

        this.artistName = artistName;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getImage() {
        return image;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void changeArtistName(String newArtistName) {
        artistName = newArtistName;
    }
}
