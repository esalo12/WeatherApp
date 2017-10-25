package no.nord.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

class VaerAdapter extends ArrayAdapter<Linje> {
    ArrayList<Linje> liste;
    VaerAdapter(Context context, ArrayList<Linje> vaer){
        super(context, R.layout.first_item, vaer);
        this.liste=vaer;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String[] dato = {"EEE", "dd.MMM"};
        Linje vaerItem = getItem(position);
        LayoutInflater vaerInflater = LayoutInflater.from(getContext());
        int periode = vaerItem.periode;
        if (position == 0) {
            SimpleDateFormat kl = new SimpleDateFormat("HH");
            View vaerView = vaerInflater.inflate(R.layout.first_item, parent, false);
            TextView dagen = (TextView) vaerView.findViewById(R.id.tiden);
            TextView tempen = (TextView) vaerView.findViewById(R.id.temp1);
            ImageView bildet = (ImageView) vaerView.findViewById(R.id.bilde1);
            TextView vind = (TextView) vaerView.findViewById(R.id.vindretn);
            TextView vindstrk = (TextView) vaerView.findViewById(R.id.vindstrk);
            TextView vartype = (TextView) vaerView.findViewById(R.id.vartype);
            dagen.setText("Kl: " + kl.format(vaerItem.fra) + "-" + kl.format(vaerItem.til) + ".00");
            vind.setText(vaerItem.vindretn + "lig");
            vindstrk.setText(vaerItem.vindstrk);
            tempen.setText(vaerItem.grader + "°C");
            vartype.setText(vaerItem.varnavn);
            bildet.setImageResource(this.getContext().getResources().getIdentifier(vaerItem.bilde, "drawable", "no.nord.weatherapp"));
            return vaerView;
        } else if (periode == 4) {
            SimpleDateFormat dag = new SimpleDateFormat("EEE dd.MMM");
            View vaerView = vaerInflater.inflate(R.layout.dag_tittel, parent, false);
            TextView skille = (TextView) vaerView.findViewById(R.id.dagdato);
            skille.setText(dag.format(vaerItem.fra));
            return vaerView;
        } else {
            SimpleDateFormat kl = new SimpleDateFormat("HH");
            View vaerView = vaerInflater.inflate(R.layout.other_item, parent, false);
            TextView tiden = (TextView) vaerView.findViewById(R.id.tid2);
            TextView tempen = (TextView) vaerView.findViewById(R.id.temp2);
            ImageView bildet = (ImageView) vaerView.findViewById(R.id.bilde2);
            TextView vind = (TextView) vaerView.findViewById(R.id.vindretn2);
            TextView vindstrk = (TextView) vaerView.findViewById(R.id.vindstrk2);
            tiden.setText("Kl: " + kl.format(vaerItem.fra) + "-" + kl.format(vaerItem.til) + ".00");
            vind.setText(vaerItem.vindretn + "lig");
            vindstrk.setText(vaerItem.vindstrk);
            tempen.setText(vaerItem.grader + "°C");
            bildet.setImageResource(this.getContext().getResources().getIdentifier(vaerItem.bilde, "drawable", "no.nord.weatherapp"));
            return vaerView;
        }
    }
}
