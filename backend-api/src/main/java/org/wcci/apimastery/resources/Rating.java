package org.wcci.apimastery.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Rating {
    private int albumRating;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Album album;

    protected Rating() {
    }

    public Rating(Album album, int albumRating) {
        this.album = album;
        this.albumRating = albumRating;
    }

    public Long getId() {
        return id;
    }

    public Album getAlbums() {
        return album;
    }

    public int getAlbumRating() {
        return albumRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Double.compare(rating.albumRating, albumRating) == 0 &&
                Objects.equals(id, rating.id) &&
                Objects.equals(album, rating.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, album, albumRating);
    }
}