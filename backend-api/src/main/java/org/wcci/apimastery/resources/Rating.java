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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        if (Double.compare(rating.albumRating, albumRating) != 0) return false;
        if (!id.equals(rating.id)) return false;
        return album.equals(rating.album);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + album.hashCode();
        temp = Double.doubleToLongBits(albumRating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", album=" + album +
                ", albumRating=" + albumRating +
                '}';
    }
    public Rating getRatings() {return new Rating();
    }
}