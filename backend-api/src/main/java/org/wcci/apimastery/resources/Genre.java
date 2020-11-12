package org.wcci.apimastery.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.List;

@Entity
public class Genre {

    @Id
    @GeneratedValue
    private Long id;
    private String genreName;
    @ManyToMany(mappedBy="genres")
    @JsonIgnore
    private List<Artist> artists;

    protected Genre() {}

    public Genre(String genreName) {
        this.genreName = genreName;
    }

    public Long getId() {
        return id;
    }
    public String getGenreName() {
        return genreName;
    }
    public List<Artist> getArtists() {
        return artists;
    }

    public void changeGenreName(String newGenreName) {
        genreName =  newGenreName;
    }
}
