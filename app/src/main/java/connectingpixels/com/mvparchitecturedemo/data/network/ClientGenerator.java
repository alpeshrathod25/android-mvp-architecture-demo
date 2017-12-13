package connectingpixels.com.mvparchitecturedemo.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alpesh on 29/10/17.
 */

public class ClientGenerator {

    private static final String API_BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static ClientGenerator retrofitClient;
    private Retrofit.Builder builder;
    private OkHttpClient.Builder httpClient;


    private ClientGenerator() {

    }

    public static ClientGenerator getInstance() {
        if (retrofitClient == null)
            retrofitClient = new ClientGenerator();
        return retrofitClient;
    }

    public <S> S createService(Class<S> cls) {
        OkHttpClient.Builder oKHttpClient = getOKHttpClient();
        this.builder = new Retrofit.Builder().client(oKHttpClient.build()).addConverterFactory(GsonConverterFactory.create());
        this.builder.baseUrl(API_BASE_URL);
        return getRetrofit().create(cls);
    }

    public Retrofit getRetrofit() {
        return this.builder.build();
    }

    private OkHttpClient.Builder getOKHttpClient() {
        if (this.httpClient == null) {
            this.httpClient = new OkHttpClient.Builder();
            this.httpClient.connectTimeout(16, TimeUnit.SECONDS);
            this.httpClient.writeTimeout(16, TimeUnit.SECONDS);
            this.httpClient.readTimeout(16, TimeUnit.SECONDS);
        }
        return this.httpClient;
    }

}
