package org.wcci.apimastery.resources;

import java.util.Objects;

public class Albums {
    private  int id ;
    private String title;
    private String image;
    private Songs songs;
    private String recordLabel;
    private String comments;
    private String ratings;

    protected Albums(){

    }

    public Albums(String title, String image, Songs songs,String recordLabel, String comments,String ratings){


        this.title = title;
        this.image = image;
        this.songs = songs;
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

    public Songs getSongs() {
        return songs;
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

    public int getId() {
        return id;
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
}
