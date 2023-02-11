package imbd.top250;

import imbd.top250.Marvel.MarvelApiClient;
import imbd.top250.Marvel.MarvelSeriesParser;
import imbd.top250.Model.Series;
import imbd.top250.Util.HtmlGenerator;
import imbd.top250.env.Credentials;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
//        String jsonString = new ImdbApiClient(imdbApiKey).getBody();
//        String jsonString = getResource("movies.json");
//        List<Movie> movies = new ImdbMovieParser(jsonString).parse();
//        movies.forEach(System.out::println);
//        PrintWriter printWriter = new PrintWriter("src/main/resources/index.html", StandardCharsets.UTF_8);
//        new HtmlGenerator(printWriter).generate(movies);
//        printWriter.close();
//        String jsonString = new MarvelApiClient().getBody("series");
        String jsonString = new MarvelApiClient("series",
                new Credentials().getPublicMarvelApiKey(),
                new Credentials().getPrivateMarvelApiKey()
                ).getBody();
        List<Series> series = new MarvelSeriesParser(jsonString).parse();
          PrintWriter printWriter = new PrintWriter("src/main/resources/index.html", StandardCharsets.UTF_8);
          new HtmlGenerator(printWriter).generate(series);
          printWriter.close();
    }

}
