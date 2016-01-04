package com.taccardi.android_api_playground.retrofit2;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Single;

/**
 * Created by zak on 12/28/15.
 */
public class OpenWeatherMapApi {
    public static final String BASE_URL = "http://api.openweathermap.org/data/";
    public static final String VERSION = "2.5/";
    //don't store API key as a string in production environment!
    public static final String API_KEY = "a10bbe3602ce78c7dd20777dad40fb94";
    public static final String API_QUERY_PARAMETER_ID = "appid";

    OpenWeatherMapRetrofitService retrofitService;


    protected OpenWeatherMapApi(OpenWeatherMapRetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }


    public static Retrofit createRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                HttpUrl httpUrl = chain.request()
                        .httpUrl()
                        .newBuilder()
                        .addQueryParameter(API_QUERY_PARAMETER_ID, API_KEY)
                        .build();

                Request request = chain.request().newBuilder()
                        .url(httpUrl)
                        .build();

                return chain.proceed(request);
            }
        });


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.interceptors().add(httpLoggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL + VERSION)

                .client(okHttpClient)
                .build();

        retrofit.baseUrl();
        return retrofit;
    }


    interface OpenWeatherMapRetrofitService {
        @GET("weather")
        Single<WeatherJson> getWeatherJson(@Query("q") String location);

        @GET("weather")
        Single<Response<WeatherJson>> getWeatherJsonWithResponse(@Query("q") String location);

    }


}
