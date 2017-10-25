package no.nord.weatherapp;


import java.util.Date;

public class Linje {
    int periode;
    Date fra;
    Date til;
    String grader;
    String bilde;
    String varnavn;
    String vindretn;
    String vindstrk;

    public Linje(int periode, Date fra, Date til, String grader, String vindretn,String vindstrk, String bilde, String varnavn) {
        this.periode = periode;
        this.fra = fra;
        this.til = til;
        this.grader = grader;
        this.vindretn = vindretn;
        this.vindstrk = vindstrk;
        this.bilde = bilde;
        this.varnavn = varnavn;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public String getGrader() {
        return grader;
    }

    public void setGrader(String grader) {
        this.grader = grader;
    }

    public String getBilde() {
        return bilde;
    }

    public void setBilde(String bilde) {
        this.bilde = bilde;
    }

    public String getVindstrk() {
        return vindstrk;
    }

    public void setVindstrk(String vindstrk) {
        this.vindstrk = vindstrk;
    }

    public String getVindretn() {
        return vindretn;
    }

    public void setVindretn(String vendretn) {
        this.vindretn = vendretn;
    }

    public String getVarnavn() {
        return varnavn;
    }

    public void setVarnavn(String varnavn) {
        this.varnavn = varnavn;
    }
}
