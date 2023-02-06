package imbd.top250;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import imbd.top250.Model.Movie;
import static imbd.top250.Util.CallApi.run;
import imbd.top250.env.Credentials;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        String url = "https://imdb-api.com/en/API/Top250Movies/" + Credentials.getApiKey();
        String jsonString = run(url);
//        String jsonString = getResource("movies.json");
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.readTree(jsonString);
        String arrayJson = jsonNode.get("items").toString();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Movie> movies = mapper.readValue(arrayJson, new TypeReference<List<Movie>>() {});
        movies.forEach(System.out::println);

    }

}
