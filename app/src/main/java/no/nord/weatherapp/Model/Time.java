package no.nord.weatherapp.Model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Time {

    @Attribute
    int period;

    @Attribute
    String from;

    @Attribute
    String to;

    @Element
    Temperature temperature;

    @Element
    Symbol symbol;

    @Element
    WindDirection windDirection;

    @Element
    WindSpeed windSpeed;


    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Symbol getSymbol(){
        return symbol;
    }
    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }
    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }
    public void setWindSpeed(WindSpeed windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
