package org.wcci.apimastery.resources;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Album {
    @Lob
    private String title;
    private String artist;
    private int rating;
    private String image;
    private String recordLabel;
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs;

    protected Album(){}
    public Album(String title, String image, String recordLabel, String artist, int rating) {
        this.title = title;
        this.image = image;
        this.recordLabel = recordLabel;
        this.artist = artist;
        this.rating = rating;
    }

    public int getRating() {
        if(rating > 10){
            rating = 10;
        }
        return rating;

    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public String getImage() {
        return image;
    }
    public String getRecordLabel() {
        return recordLabel;
    }

    public Long getId() {
        return id;
    }
    public void changeTitle(String newTitle) {
        title = newTitle;
    }
    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(title, album.title) &&
                Objects.equals(artist, album.artist) &&
                Objects.equals(image, album.image) &&
                Objects.equals(recordLabel, album.recordLabel) &&
                Objects.equals(id, album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, image, recordLabel, id);
    }
}
