package no.nord.weatherapp.Model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by E on 07.04.2016.
 */
@Root(strict = false)
public class Temperature {
    @Attribute
    String value;

    @Attribute
    String unit;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
