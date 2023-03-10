package imbd.top250.Imdb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import imbd.top250.Model.Movie;
import imbd.top250.Api.JsonParser;

import java.util.List;

public class ImdbMovieParser implements JsonParser {
    private static final ObjectMapper mapper = new ObjectMapper();
    private String jsonString;

    public ImdbMovieParser(String jsonString){
        this.jsonString = jsonString;
    }
    @Override
    public List<Movie> parse(){
        try {
            JsonNode jsonNode = mapper.readTree(this.jsonString);
            String arrayJson = jsonNode.get("items").toString();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<Movie> movies = mapper.readValue(arrayJson, new TypeReference<List<Movie>>(){});
            return movies;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public String type() {
        return "Movie";
    }
}
