package port.filmes.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

abstract public class ApiClient {
    protected final String url;
    protected String apiKey;
    protected HttpClient client;
    protected Builder request;

    public ApiClient(String url, String apiKey) {
        this.client = HttpClient.newHttpClient();
        this.request = HttpRequest.newBuilder();
        this.url = url;
        this.apiKey = apiKey;
    }

    public String get(String uri) throws IOException, InterruptedException {
        String fullUrl = this.url + uri;

        this.request.uri(URI.create(fullUrl)).GET();
        return this.send();
    }

    private String send() throws IOException, InterruptedException {
        return this.client.send(this.request.build(), HttpResponse.BodyHandlers.ofString()).body();
    }
}
