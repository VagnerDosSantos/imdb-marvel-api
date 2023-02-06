package port.filmes.parser;

import org.json.JSONArray;
import org.json.JSONObject;
import port.filmes.Content;
import port.filmes.Movie;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ImdbMovieJsonParser extends JsonParser {
    public ImdbMovieJsonParser(String json) {
        this.json = json;
    }

    public List<Content> parse() {
        JSONObject json = new JSONObject(this.json);
        JSONArray movies = json.getJSONArray("items");

        movies.forEach(movie -> {
            String title = Objects.requireNonNull(Json.getString(movie, "title")).trim();
            String urlImage = Json.getString(movie, "image");
            String rating = Json.getString(movie, "imDbRating");
            Integer year = Integer.parseInt(((JSONObject) movie).getString("releaseState").split(",")[1].trim());

            super.list.add(new Movie(title, urlImage, rating, year));
        });

        return Collections.unmodifiableList(this.list);
    }
}
