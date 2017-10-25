package no.nord.weatherapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Root;

@Root(strict = false)
public class NesnaData implements Parcelable {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("kommune")
    @Expose
    private String kommune;
    @SerializedName("sted")
    @Expose
    private String sted;
    @SerializedName("loc")
    @Expose
    private List<Double> loc = new ArrayList<Double>();

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKommune() {
        return kommune;
    }

    public void setKommune(String kommune) {
        this.kommune = kommune;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public List<Double> getLoc() {
        return loc;
    }

    public void setLoc(List<Double> loc) {
        this.loc = loc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Id);
        dest.writeString(this.url);
        dest.writeString(this.kommune);
        dest.writeString(this.sted);
        dest.writeList(this.loc);
    }

    public NesnaData() {
    }

    protected NesnaData(Parcel in) {
        this.Id = in.readString();
        this.url = in.readString();
        this.kommune = in.readString();
        this.sted = in.readString();
        this.loc = new ArrayList<Double>();
        in.readList(this.loc, Double.class.getClassLoader());
    }

    public static final Creator<NesnaData> CREATOR = new Creator<NesnaData>() {
        @Override
        public NesnaData createFromParcel(Parcel source) {
            return new NesnaData(source);
        }

        @Override
        public NesnaData[] newArray(int size) {
            return new NesnaData[size];
        }
    };
}