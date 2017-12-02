package ar.edu.unq.cpi.geography.view.population;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ar.edu.unq.cpi.geography.R;
import ar.edu.unq.cpi.geography.data.expanded.CountryDataProvider;

public class DetalleDePaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_pais);

        Intent intent = this.getIntent();
        String countryName = intent.getStringExtra("countryName");
        String countryCode = intent.getStringExtra("countryCode");

        TextView title = this.findViewById(R.id.detalleDePais_paisLabel);
        title.setText(countryName);

        TextView population = this.findViewById(R.id.detalleDePais_poblacion);
        TextView superficie = this.findViewById(R.id.detalleDePais_superficie);

        CountryDataProvider.fixed().fetchCountryData(countryCode, (data) -> {
            population.setText(String.valueOf(data.getPopulation()));
            superficie.setText(String.valueOf(data.getArea()));
        });

    }
}
