package no.nord.weatherapp.Model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root
public class Symbol {
    @Attribute
    int number;

    @Attribute
    int numberEx;

    @Attribute
    String name;

    @Attribute
    String var;

    public int getNumberEx() {
        return numberEx;
    }

    public void setNumberEx(int numberEx) {
        this.numberEx = numberEx;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
