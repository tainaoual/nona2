package org.wcci.apimastery.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Album {
    @Id
    @GeneratedValue
    private  Long id;
    private String title;
    @Lob
    private String image;
    private String recordLabel;

    @OneToMany(mappedBy = "albums")
    private List<Rating> ratings;
    @ManyToOne
    @JsonIgnore
    private Artist artist;
    @OneToMany(mappedBy = "albums")
    private List<Song> songs;
    protected Album(){
    }

    public Album(String title, String image, String recordLabel, Artist artist){
        this.title = title;
        this.image = image;
        this.recordLabel = recordLabel;
        this.artist = artist;
        this.ratings = new ArrayList<Rating>();
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public Long getId() {
        return id;
    }

    public void changeTitle(String newTitle) {
        title = newTitle;
    }

    public List<Song> getSongs(){
        return songs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(title, album.title) &&
                Objects.equals(image, album.image) &&
                Objects.equals(recordLabel, album.recordLabel) &&
                Objects.equals(artist, album.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, image, recordLabel, artist);
    }
}
