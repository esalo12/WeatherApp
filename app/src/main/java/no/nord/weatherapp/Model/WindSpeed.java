package no.nord.weatherapp.Model;


import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root
public class WindSpeed {
    @Attribute
    String mps;

    @Attribute
    String name;

    public String getMps() {
        return mps;
    }

    public void setMps(String mps) {
        this.mps = mps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
