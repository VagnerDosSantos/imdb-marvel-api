package port.filmes;

import port.filmes.api.ApiClient;
import port.filmes.api.ImdbApiClient;
import port.filmes.api.MarvelApiClient;
import port.filmes.parser.ImdbMovieJsonParser;
import port.filmes.parser.MarvelSeriesJsonParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, NoSuchAlgorithmException {
        ApiClient imdbClient = new ImdbApiClient("<apiKey>");
        String movies = imdbClient.get("ComingSoon/{apiKey}");
        List<Content> moviesList = new ImdbMovieJsonParser(movies).parse();

        ApiClient marvelClient = new MarvelApiClient("<publicKey>",
                "<privateKey>");
        String series = marvelClient.get("series");
        List<Content> seriesList = new MarvelSeriesJsonParser(series).parse();

        List<Content> contents = new java.util.ArrayList<>(
                Stream.of(moviesList, seriesList)
                        .flatMap(List::stream)
                        .toList());

        contents.sort(Comparator.comparing(Content::year));

        Writer writer = new PrintWriter("index.html");
        HTMLGenerator generator = new HTMLGenerator(writer);
        contents.forEach(generator::generate);

        generator.close();
    }
}