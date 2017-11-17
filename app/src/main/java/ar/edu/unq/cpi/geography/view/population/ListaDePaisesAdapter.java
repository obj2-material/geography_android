package ar.edu.unq.cpi.geography.view.population;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ar.edu.unq.cpi.geography.data.expanded.CountryData;

/**
 * Created by Carlos on 10/11/2017.
 */

public class ListaDePaisesAdapter extends ArrayAdapter<CountryData> {

    private LayoutInflater inflater;

    public ListaDePaisesAdapter(@NonNull Context context, List<CountryData> objects) {
        super(context, 0, objects);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView whereTextMustBeSet = (TextView) convertView;
        CountryData item = this.getItem(position);
        whereTextMustBeSet.setText(item.getSpanishName());
        return convertView;
    }
}
