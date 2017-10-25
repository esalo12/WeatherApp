package no.nord.weatherapp;

import java.util.ArrayList;

import no.nord.weatherapp.Model.NesnaData;
import no.nord.weatherapp.Model.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface YrService {
    @GET
    Call<WeatherData> getWeatherData(@Url String url);
    @GET("/sok?")
    Call<ArrayList<NesnaData>> getNesnaData(@Query("sok") String sok);
    @GET("/location?")
    Call<NesnaData> getGPS(@Query("lat") double lat, @Query("lng") double lng);
}
