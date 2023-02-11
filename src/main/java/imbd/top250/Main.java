package imbd.top250;

import imbd.top250.Model.Movie;
import imbd.top250.Util.HtmlGenerator;
import imbd.top250.Imdb.ImdbJsonParser;
import imbd.top250.env.Credentials;
import imbd.top250.Imdb.ImdbApiClient;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        String url = "https://imdb-api.com/en/API/Top250Movies/";
        String apiKey = Credentials.getApiKey();
        String jsonString = new ImdbApiClient(apiKey).getBody(url);
//        String jsonString = getResource("movies.json");
        List<Movie> movies = new ImdbJsonParser(jsonString).generateMovies();
//        movies.forEach(System.out::println);
        PrintWriter printWriter = new PrintWriter("src/main/resources/index.html", StandardCharsets.UTF_8);
        new HtmlGenerator(printWriter).generate(movies);
        printWriter.close();
    }

}
