package org.wcci.apimastery.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Albums {

    private String title;
    private String image;
    private String recordLabel;
    private String comments;
    private String ratings;
    @Id
    @GeneratedValue
    private  Long id;
    @OneToMany(mappedBy = "albums")
    private List<Song> songs;
    protected Albums(){
    }

    public Albums(String title, String image,String recordLabel, String comments,String ratings){
        this.title = title;
        this.image = image;
        this.recordLabel = recordLabel;
        this.comments = comments;
        this.ratings = ratings;
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

    public String getComments() {
        return comments;
    }

    public String getRatings() {
        return ratings;
    }

    public Long getId() {
        return id;
    }

    public void changeTitle(String newTitle) {
        title = newTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Albums albums = (Albums) o;
        return Objects.equals(title, albums.title) &&
                Objects.equals(image, albums.image) &&
                Objects.equals(songs, albums.songs) &&
                Objects.equals(recordLabel, albums.recordLabel) &&
                Objects.equals(comments, albums.comments) &&
                Objects.equals(ratings, albums.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, image, songs, recordLabel, comments, ratings);
    }

    public List<Song> getSongs(){
        return songs;
    }
}
