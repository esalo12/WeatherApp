package no.nord.weatherapp.Model;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class WindDirection {
    @Attribute
    String deg;

    @Attribute
    String code;

    @Attribute
    String name;

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
