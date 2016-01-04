package com.taccardi.android_api_playground.retrofit2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WeatherJson {

    /**
     * (Required)
     */
    @SerializedName("coord")
    @Expose
    public Coord coord;
    /**
     * (Required)
     */
    @SerializedName("weather")
    @Expose
    public List<Weather> weather = new ArrayList<Weather>();
    /**
     * (Required)
     */
    @SerializedName("base")
    @Expose
    public String base;
    /**
     * (Required)
     */
    @SerializedName("main")
    @Expose
    public Main main;
    /**
     * (Required)
     */
    @SerializedName("wind")
    @Expose
    public Wind wind;
    /**
     * (Required)
     */
    @SerializedName("clouds")
    @Expose
    public Clouds clouds;
    /**
     * (Required)
     */
    @SerializedName("dt")
    @Expose
    public int dt;
    /**
     * (Required)
     */
    @SerializedName("sys")
    @Expose
    public Sys sys;
    /**
     * (Required)
     */
    @SerializedName("id")
    @Expose
    public int id;
    /**
     * (Required)
     */
    @SerializedName("name")
    @Expose
    public String name;
    /**
     * (Required)
     */
    @SerializedName("cod")
    @Expose
    public int cod;

    /**
     * No args constructor for use in serialization
     */
    public WeatherJson() {
    }

    /**
     * @param id
     * @param dt
     * @param clouds
     * @param coord
     * @param wind
     * @param cod
     * @param sys
     * @param name
     * @param base
     * @param weather
     * @param main
     */
    public WeatherJson(Coord coord, List<Weather> weather, String base, Main main, Wind wind, Clouds clouds, int dt, Sys sys, int id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public static class Clouds {

        @SerializedName("all")
        @Expose
        public int all;

        /**
         * No args constructor for use in serialization
         */
        public Clouds() {
        }

        /**
         * @param all
         */
        public Clouds(int all) {
            this.all = all;
        }

    }

    public static class Coord {

        /**
         * (Required)
         */
        @SerializedName("lon")
        @Expose
        public float lon;
        /**
         * (Required)
         */
        @SerializedName("lat")
        @Expose
        public float lat;

        /**
         * No args constructor for use in serialization
         */
        public Coord() {
        }

        /**
         * @param lon
         * @param lat
         */
        public Coord(float lon, float lat) {
            this.lon = lon;
            this.lat = lat;
        }

    }

    public static class Main {

        @SerializedName("temp")
        @Expose
        public float temp;
        @SerializedName("pressure")
        @Expose
        public int pressure;
        @SerializedName("humidity")
        @Expose
        public int humidity;
        @SerializedName("temp_min")
        @Expose
        public float tempMin;
        @SerializedName("temp_max")
        @Expose
        public float tempMax;

        /**
         * No args constructor for use in serialization
         */
        public Main() {
        }

        /**
         * @param humidity
         * @param pressure
         * @param tempMax
         * @param temp
         * @param tempMin
         */
        public Main(float temp, int pressure, int humidity, float tempMin, float tempMax) {
            this.temp = temp;
            this.pressure = pressure;
            this.humidity = humidity;
            this.tempMin = tempMin;
            this.tempMax = tempMax;
        }

    }

    public static class Sys {

        @SerializedName("type")
        @Expose
        public int type;
        @SerializedName("id")
        @Expose
        public int id;
        @SerializedName("message")
        @Expose
        public float message;
        @SerializedName("country")
        @Expose
        public String country;
        @SerializedName("sunrise")
        @Expose
        public int sunrise;
        @SerializedName("sunset")
        @Expose
        public int sunset;

        /**
         * No args constructor for use in serialization
         */
        public Sys() {
        }

        /**
         * @param message
         * @param id
         * @param sunset
         * @param sunrise
         * @param type
         * @param country
         */
        public Sys(int type, int id, float message, String country, int sunrise, int sunset) {
            this.type = type;
            this.id = id;
            this.message = message;
            this.country = country;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }

    }

    public static class Weather {

        @SerializedName("id")
        @Expose
        public int id;
        @SerializedName("main")
        @Expose
        public String main;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("icon")
        @Expose
        public String icon;

        /**
         * No args constructor for use in serialization
         */
        public Weather() {
        }

        /**
         * @param id
         * @param icon
         * @param description
         * @param main
         */
        public Weather(int id, String main, String description, String icon) {
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }

    }

    public static class Wind {

        @SerializedName("speed")
        @Expose
        public float speed;
        @SerializedName("deg")
        @Expose
        public int deg;

        /**
         * No args constructor for use in serialization
         */
        public Wind() {
        }

        /**
         * @param speed
         * @param deg
         */
        public Wind(float speed, int deg) {
            this.speed = speed;
            this.deg = deg;
        }

    }
}
