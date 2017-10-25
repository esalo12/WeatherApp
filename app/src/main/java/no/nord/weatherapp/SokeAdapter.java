package no.nord.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import no.nord.weatherapp.Model.NesnaData;


public class SokeAdapter extends ArrayAdapter<NesnaData> {
    private ArrayList<NesnaData> listen;

    SokeAdapter(Context context, ArrayList<NesnaData> liste){
        super(context, R.layout.soke_item, liste);
        this.listen=liste;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if( v == null ){
            LayoutInflater listeInflater = LayoutInflater.from(getContext());
            v = listeInflater.inflate(R.layout.soke_item, parent, false);
        }

        NesnaData sokeItem = listen.get(position);
        if ( sokeItem != null) {
            TextView stedet = (TextView) v.findViewById(R.id.sted_navn);
            TextView info = (TextView) v.findViewById(R.id.sted_info);
            if (stedet != null){
                stedet.setText(sokeItem.getSted());
            }
            if (info != null){
                String kommune = sokeItem.getKommune();
                info.setText(kommune);
            }
        }
        return v;
    }
}
