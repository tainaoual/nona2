package org.wcci.apimastery.resources;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Integer duration;
    @Lob
    private String link;
    @OneToMany
    @JsonIgnore
    private List<Rating> ratings;
    @ManyToOne
    private Album album;
    @OneToMany(mappedBy = "song")
    @JsonIgnore
    private List<Comment> comments;
    protected Song( ) {
    }
    public Song(String title, String link, Integer duration,Album album) {
        this.album = album;
        this.title = title;
        this.link = link;
        this.duration = duration;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getLink() {
        return link;
    }
    public int getDuration() {
        return duration;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void changeTitle(String newTitle) {
        title = newTitle;
    }
    public List<Rating> getRatings() {
        return ratings;
    }
    public Album getAlbum() {
        return album;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        if (!id.equals(song.id)) return false;
        if (!title.equals(song.title)) return false;
        if (!duration.equals(song.duration)) return false;
        return link.equals(song.link);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + duration.hashCode();
        result = 31 * result + link.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", link='" + link + '\'' +
                ", ratings=" + ratings +
                ", comments=" + comments +
                '}';
    }
}