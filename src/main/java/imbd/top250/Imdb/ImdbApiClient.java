package imbd.top250.Imdb;

import imbd.top250.Api.ApiClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ImdbApiClient implements ApiClient {
    private static OkHttpClient client = new OkHttpClient();
    private String apiUrl = "https://imdb-api.com/en/API/Top250Movies/";
    private final String apiKey;
    public ImdbApiClient(String apiKey){
        this.apiKey = apiKey;
    }
    @Override
    public String getBody() throws IOException {
        Request request = new Request.Builder()
                .url(apiUrl + this.apiKey)
                .build();

        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }

    }

}
