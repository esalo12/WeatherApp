package no.nord.weatherapp.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Forecast {
    @ElementList
    List<Time> tabular;

    public List<Time> getTabular() {
        return tabular;
    }

    public void setTabular(List<Time> tabular) {
        this.tabular = tabular;
    }
}