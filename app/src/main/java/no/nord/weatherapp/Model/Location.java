package no.nord.weatherapp.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(strict = false)
public class Location {
    @Element
    String name;

    @Element
    String type;

    @Element
    String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
