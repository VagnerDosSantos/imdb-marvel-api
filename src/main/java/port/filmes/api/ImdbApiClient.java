package port.filmes.api;

import java.io.IOException;

public class ImdbApiClient extends ApiClient {
    public ImdbApiClient(String apiKey) {
        super("https://imdb-api.com/API/", apiKey);
    }

    @Override
    public String get(String uri) throws IOException, InterruptedException {
        uri = uri.replace("{apiKey}", this.apiKey);
        return super.get(uri);
    }
}
