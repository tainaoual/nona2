package org.wcci.apimastery.resources;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Artist {
    private String artistName;
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String image;
    @OneToMany(mappedBy = "artist")
    private List<Album> albums;
    @ManyToMany(mappedBy = "genres")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) &&
                Objects.equals(artistName, artist.artistName) &&
                Objects.equals(image, artist.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artistName, image);
    }
}
