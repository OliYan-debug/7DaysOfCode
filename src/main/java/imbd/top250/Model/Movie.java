package imbd.top250.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;


public record Movie(
        String title,
        @JsonProperty("image")
        String imageUrl,
        String year,
        @JsonProperty("imDbRating")
        String rating)
        implements Content,  Comparable<Movie>{

        @Override
        public int compareTo(@NotNull Movie outro) {
                return this.title().compareTo(outro.title());
        }

        @Override
        public String type() {
                return "Movie";
        }
}
