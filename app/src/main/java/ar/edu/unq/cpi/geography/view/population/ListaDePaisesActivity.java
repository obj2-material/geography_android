package ar.edu.unq.cpi.geography.view.population;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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

        CountryDataProvider.api().fetchCountryList((data) -> {
            this.listAdapter = new ListaDePaisesAdapter(this, data);
            this.listView.setAdapter(this.listAdapter);
        });

        // clase anonima: se crea al voleo una clase que
        // implementa la interface AdapterView.OnItemClickListener,
        // y se le hace new a esa clase.
        // la clase no tiene nombre, de ahí lo de "anonima"
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // obtengo el objeto a partir de la posicion, OJO hay que pedirselo al listAdapter
                // ListaDePaisesActivity.this es el "this de afuera"
                CountryData selectedData = ListaDePaisesActivity.this.listAdapter.getItem(position);

                // salto a otra Activity
                Intent intent = new Intent(ListaDePaisesActivity.this, DetalleDePaisActivity.class);
                intent.putExtra("countryName", selectedData.getSpanishName());
                intent.putExtra("countryCode", selectedData.getCode());
                startActivity(intent);
            }
        });

        // forma "larga" de hacer lo mismo que con la clase anonima:
        // se crea una clase que implementa la interfaz, y se le hace new
//        listView.setOnItemClickListener(new ClaseQueImplementaOnItemClickListener(this));
    }

    public ListaDePaisesAdapter listAdapter() {
         return this.listAdapter;
    }
}
