package port.filmes.parser;

import org.json.JSONArray;
import org.json.JSONObject;
import port.filmes.Content;
import port.filmes.Movie;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MarvelSeriesJsonParser extends JsonParser {
    public MarvelSeriesJsonParser(String json) {
        super.json = json;
    }

    public List<Content> parse() {
        JSONObject json = new JSONObject(super.json);
        JSONArray seriesList = json.getJSONObject("data")
                .getJSONArray("results");

        seriesList.forEach(series -> {
            String title = Objects.requireNonNull(Json.getString(series, "title")).trim();
            JSONObject thumbnail = ((JSONObject) series).getJSONObject("thumbnail");
            String urlImage = Json.getString(thumbnail, "path") + "." + Json.getString(thumbnail, "extension");
            String rating = Json.getString(series, "rating");
            Integer year = Json.getInteger(series, "startYear");

            super.list.add(new Movie(title, urlImage, rating, year));
        });

        return Collections.unmodifiableList(super.list);
    }
}
