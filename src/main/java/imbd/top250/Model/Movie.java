package imbd.top250.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Movie(
        String title,
        @JsonProperty("image")
        String imageUrl,
        String year,
        @JsonProperty("imDbRating")
        String rating)
        implements Content{

}
