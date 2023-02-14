package imbd.top250;

import imbd.top250.Imdb.ImdbMovieParser;
import imbd.top250.Marvel.MarvelApiClient;
import imbd.top250.Marvel.MarvelSeriesParser;
import imbd.top250.Model.Content;
import imbd.top250.Model.Movie;
import imbd.top250.Model.Series;
import imbd.top250.Util.HtmlGenerator;
import imbd.top250.env.Credentials;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static imbd.top250.Util.ReadLocalJson.getResource;


public class Main {

    public static void main(String[] args) throws Exception {
//        String jsonString = new ImdbApiClient(imdbApiKey).getBody();
        String jsonStringImdb = getResource("movies.json");
        List<Movie> movies = new ImdbMovieParser(jsonStringImdb).parse();
        String jsonStringMarvel = new MarvelApiClient("series",
                new Credentials().getPublicMarvelApiKey(),
                new Credentials().getPrivateMarvelApiKey()
                ).getBody();
        List<Series> series = new MarvelSeriesParser(jsonStringMarvel).parse();
        List<? extends Content> mixedList = Stream.of(movies, series)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        Collections.sort(mixedList, Comparator.comparing(Content::title));
        PrintWriter printWriter = new PrintWriter("src/main/resources/index.html", StandardCharsets.UTF_8);
        new HtmlGenerator(printWriter).generate(mixedList);
        printWriter.close();
    }

}
