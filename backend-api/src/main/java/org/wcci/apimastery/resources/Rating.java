package org.wcci.apimastery.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Album album;
    private double albumRating;

    protected Rating(){

    }
    public Rating(Album album, double albumRating){

        this.album = album;
        this.albumRating = albumRating;
    }

    public Long getId() {
        return id;
    }

    public Album getAlbums() {
        return album;
    }

    public double getAlbumRating() {
        return albumRating;
    }
}
