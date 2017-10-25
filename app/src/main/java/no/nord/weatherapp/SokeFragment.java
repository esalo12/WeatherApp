package no.nord.weatherapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationParams;
import no.nord.weatherapp.Model.NesnaData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SokeFragment extends Fragment implements View.OnClickListener, ListView.OnItemClickListener {
    private static final String TAG= "her";
    private static final String URL = "http://studit.hinesna.no:3001/";
    final VaerFragment fragment = new VaerFragment();
    final Bundle bundle = new Bundle();
    Button gps;
    Button sokeKnapp;
    EditText sokeText;
    View view;
    public SokeFragment() {}
    ListView listaHer;
    private ArrayList<NesnaData> loggen = new ArrayList<>();
    private ArrayList<NesnaData> linker = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("VærAPP");
        view = inflater.inflate(R.layout.fragment_soke, container, false);
        gps = (Button) view.findViewById(R.id.gps);
        gps.setOnClickListener(this);
        sokeKnapp = (Button) view.findViewById(R.id.sok_knapp);
        sokeKnapp.setOnClickListener(this);
        sokeText = (EditText) view.findViewById(R.id.soke_text);
        listaHer = (ListView) view.findViewById(R.id.soke_liste);
        listaHer.setOnItemClickListener(this);
        if (linker.size()> 0 ){
            Log.d(TAG, ""+loggen.size());
            startAdapter(loggen);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sok_knapp:
                String tilsok = sokeText.getText().toString();
                Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                YrService nesnaService = retrofit.create(YrService.class);
                Call<ArrayList<NesnaData>> call = nesnaService.getNesnaData(tilsok);
                call.enqueue(new Callback<ArrayList<NesnaData>>() {
                    @Override
                    public void onResponse(Call<ArrayList<NesnaData>> call, Response<ArrayList<NesnaData>> response) {
                        linker = new ArrayList<>();
                        linker = response.body();
                        startAdapter(linker);
                    }
                    @Override
                    public void onFailure(Call<ArrayList<NesnaData>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
                break;
            case R.id.gps:

                SmartLocation.with(this.getActivity()).location().oneFix().config(LocationParams.NAVIGATION).start(new OnLocationUpdatedListener() {
                    @Override
                    public void onLocationUpdated(Location location) {
                        Retrofit gpsretro = new Retrofit.Builder().baseUrl(URL)
                                .addConverterFactory(GsonConverterFactory.create()).build();
                        YrService gpsService = gpsretro.create(YrService.class);
                        Call<NesnaData> gpscall = gpsService.getGPS(location.getLatitude(), location.getLongitude());
                        gpscall.enqueue(new Callback<NesnaData>() {
                            @Override
                            public void onResponse(Call<NesnaData> call, Response<NesnaData> response) {
                                String yrURL = response.body().getUrl();
                                bundle.putString("URL", yrURL);
                                fragment.setArguments(bundle);
                                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                                        .addToBackStack("sok").commit();
                            }
                            @Override
                            public void onFailure(Call<NesnaData> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                });
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String yrURL;
        Boolean sjekk=false;
        NesnaData item = (NesnaData) parent.getItemAtPosition(position);
        yrURL= item.getUrl();
        if (linker.size()>0){
            for (NesnaData obj : loggen) {
                if (item.getUrl() == obj.getUrl()) {
                    sjekk=true;
                }
            }
            if ( sjekk == false ){
                loggen.add(item);
            }
        }
        bundle.putString("URL", yrURL);
        fragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .addToBackStack("sok").commit();
    }

    public void startAdapter(ArrayList<NesnaData> listen) {
        SokeAdapter stedet = new SokeAdapter(this.getActivity(), listen);
        ListView stedView = (ListView) view.findViewById(R.id.soke_liste);
        stedView.setAdapter(stedet);
    }
}