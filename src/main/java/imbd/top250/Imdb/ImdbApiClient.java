package imbd.top250.Imdb;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ImdbApiClient {
    static OkHttpClient client = new OkHttpClient();
    private final String apiKey;
    public ImdbApiClient(String apiKey){
        this.apiKey = apiKey;
    }
    public String getBody(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url + this.apiKey)
                .build();

        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }

    }

}
