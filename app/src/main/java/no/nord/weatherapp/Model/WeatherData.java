package no.nord.weatherapp.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class WeatherData {
    @Element
    Location location;

    @Element
    Forecast forecast;

    public Location getLocation() { return location; }
    public  void setLocation(Location location) {this.location = location;}

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
