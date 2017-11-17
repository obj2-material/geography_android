package ar.edu.unq.cpi.geography.view.population;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ar.edu.unq.cpi.geography.R;
import ar.edu.unq.cpi.geography.data.expanded.CountryData;
import ar.edu.unq.cpi.geography.data.expanded.CountryDataProvider;

public class ListaDePaisesActivity extends AppCompatActivity {

    private ListView listView;
    private ListaDePaisesAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_paises);

        this.listView = this.findViewById(R.id.listaDePaises);
        this.listAdapter = new ListaDePaisesAdapter(this, new ArrayList<>());
        this.listView.setAdapter(this.listAdapter);

        CountryDataProvider.api().fetchCountryList((data) -> {
            this.listAdapter = new ListaDePaisesAdapter(this, data);
            this.listView.setAdapter(this.listAdapter);
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CountryData selectedData = ListaDePaisesActivity.this.listAdapter.getItem(position);
                Intent intent = new Intent(ListaDePaisesActivity.this, DetalleDePaisActivity.class);
                intent.putExtra("countryName", selectedData.getSpanishName());
                intent.putExtra("countryCode", selectedData.getCode());
                startActivity(intent);
            }
        });
    }
}
