package com.taccardi.android_api_playground.retrofit2;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zak on 12/28/15.
 */
public class OpenWeatherMapApiTest {
    OpenWeatherMapApi api;

    OpenWeatherMapApi.OpenWeatherMapRetrofitService retrofitService;

    @Before
    public void setUp() throws Exception {
        retrofitService = OpenWeatherMapApi.createRetrofit().create(OpenWeatherMapApi.OpenWeatherMapRetrofitService.class);

    }

    @Test
    public void testApiCall() throws Exception {
        WeatherJson weatherJson = retrofitService.getWeatherJson("London,uk").toBlocking().toFuture().get();

        Assert.assertThat("WeatherJson should not be null", weatherJson, CoreMatchers.notNullValue());
    }
}