package imbd.top250;

import imbd.top250.env.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;

public class Main {

    static OkHttpClient client = new OkHttpClient();

    public static String run (String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }

    public static void main(String[] args) throws Exception {
        String url = "https://imdb-api.com/en/API/Top250Movies/" + Credentials.getApiKey();
        String jsonString = run(url);
        System.out.println(jsonString);
    }
}