package imbd.top250.Marvel;

import imbd.top250.Api.ApiClient;
import imbd.top250.Util.HashGenerator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.Timestamp;

public class MarvelApiClient implements ApiClient {
    private final OkHttpClient client = new OkHttpClient();
    private String endpoint;
    public MarvelApiClient(String content, String publicApiKey, String privateApiKey) {
        String url = "https://gateway.marvel.com/v1/public/" + content;

        String timeStamp = new Timestamp(System.currentTimeMillis()).toString();
        String hash = HashGenerator.getHashMd5(String.format(timeStamp + privateApiKey + publicApiKey));
        this.endpoint = url + "?apikey=" + publicApiKey + "&ts=" + timeStamp + "&hash=" + hash;
    }

    @Override
    public String getBody() throws IOException {

        Request request = new Request.Builder()
                .url(endpoint)
                .build();

        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }
}
