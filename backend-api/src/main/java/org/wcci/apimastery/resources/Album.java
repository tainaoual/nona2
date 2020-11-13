package org.wcci.apimastery.resources;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;
@Entity
public class Album {
    @Lob
    private String title;
    private String artist;
    private String image;
    private String recordLabel;
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    @JsonIgnore
    private List<Rating> ratings;
    @OneToMany(mappedBy = "album")
    @JsonIgnore
    private List<Song> songs;
    protected Album(){}
    public Album(String title, String image, String recordLabel, String artist ) {
        this.title = title;
        this.image = image;
        this.recordLabel = recordLabel;
        this.artist = artist;
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
    public List<Song> getSongs() {
        return songs;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        if (title != null ? !title.equals(album.title) : album.title != null) return false;
        if (artist != null ? !artist.equals(album.artist) : album.artist != null) return false;
        if (image != null ? !image.equals(album.image) : album.image != null) return false;
        if (recordLabel != null ? !recordLabel.equals(album.recordLabel) : album.recordLabel != null) return false;
        return id != null ? id.equals(album.id) : album.id == null;
    }
    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (recordLabel != null ? recordLabel.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Albums{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", image='" + image + '\'' +
                ", recordLabel='" + recordLabel + '\'' +
                ", id=" + id +
                ", ratings=" + ratings +
                ", songs=" + songs +
                '}';
    }
}
