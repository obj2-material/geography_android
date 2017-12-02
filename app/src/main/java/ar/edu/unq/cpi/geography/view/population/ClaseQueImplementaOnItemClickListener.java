package ar.edu.unq.cpi.geography.view.population;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import ar.edu.unq.cpi.geography.data.expanded.CountryData;

/**
 * Created by Carlos on 01/12/2017.
 */

public class ClaseQueImplementaOnItemClickListener implements AdapterView.OnItemClickListener {
    ListaDePaisesActivity elActivity;

    public ClaseQueImplementaOnItemClickListener(ListaDePaisesActivity act) {
        super();
        this.elActivity = act;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CountryData selectedData = this.elActivity.listAdapter().getItem(position);
        Intent intent = new Intent(this.elActivity, DetalleDePaisActivity.class);
        intent.putExtra("countryName", selectedData.getSpanishName());
        intent.putExtra("countryCode", selectedData.getCode());
        this.elActivity.startActivity(intent);
    }
}

