package port.filmes.api;

import port.filmes.hash.MD5;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class MarvelApiClient extends ApiClient {
    private final String authKey;

    public MarvelApiClient(String publicKey, String privateKey) throws NoSuchAlgorithmException {
        super("https://gateway.marvel.com/v1/public/", publicKey);
        long timestamp = System.currentTimeMillis();
        this.authKey = "?ts=" + timestamp + "&apikey=" + publicKey + "&hash=" + MD5.hash(timestamp + privateKey + publicKey);
    }

    public String get(String url) throws IOException, InterruptedException {
        url += this.authKey;
        return super.get(url);
    }
}
