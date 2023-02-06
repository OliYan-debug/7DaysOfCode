package imbd.top250.Util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class CallApi {
    static OkHttpClient client = new OkHttpClient();

    public static String run (String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }
}
