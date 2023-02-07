package imbd.top250.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Movie {
    private String rank;
    private String title;
    private String image;
    @JsonProperty("year")
    private String year;
    @JsonProperty("imDbRating")
    private String rating;
    public Movie(){

    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getYear() {
        return year;
    }
    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rank='" + rank + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", year='" + year + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
