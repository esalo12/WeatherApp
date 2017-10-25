package no.nord.weatherapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import no.nord.weatherapp.Model.Time;
import no.nord.weatherapp.Model.WeatherData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class VaerFragment extends Fragment {
    private static final String URL = "http://www.yr.no/";
    String STED;

    public VaerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vaer, container, false);
        if (this.getArguments()!=null){
            Bundle bundle = this.getArguments();
            STED = bundle.getString("URL");
            Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(SimpleXmlConverterFactory.create()).build();
            YrService yrService = retrofit.create(YrService.class);
            Call<WeatherData> call = yrService.getWeatherData(STED);
            call.enqueue(new Callback<WeatherData>() {
                @Override
                public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                    ArrayList<Linje> listen = new ArrayList<Linje>();
                    getActivity().setTitle(response.body().getLocation().getName());
                    for (Time time : response.body().getForecast().getTabular()) {
                        int period = time.getPeriod();
                        Date fra = makeDate(time.getFrom());
                        Date til = makeDate(time.getTo());
                        if (period == 0 && listen.size() >=1) {
                            Linje dagLinje = new Linje(4, fra, til, "-", "-", "-", "-", "-");
                            listen.add(dagLinje);
                        }
                        String kode = time.getSymbol().getVar().replaceAll("mf/", "");
                        String[] output = kode.split("\\.");
                        String bilde = output[0];
                        String varnavn = time.getSymbol().getName();
                        String temp = time.getTemperature().getValue();
                        String vindretn = time.getWindDirection().getName();
                        String vindstrk = time.getWindSpeed().getName();
                        Linje linje = new Linje(period, fra, til, temp, vindretn, vindstrk, "y" + bilde, varnavn);
                        listen.add(linje);
                    }
                    startAdapter(listen);
                }
                @Override
                public void onFailure(Call<WeatherData> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
        return view;
    }

    private void startAdapter(ArrayList<Linje> listen) {
        ListAdapter varet = new VaerAdapter(this.getActivity(), listen);
        ListView vaeretView = (ListView) getView().findViewById(R.id.vaerListe);
        vaeretView.setAdapter(varet);
    }

    public Date makeDate(String dato){
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date object = fm.parse(dato);
            return object;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
