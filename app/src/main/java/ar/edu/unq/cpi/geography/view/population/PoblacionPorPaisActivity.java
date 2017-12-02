package ar.edu.unq.cpi.geography.view.population;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ar.edu.unq.cpi.geography.R;
import ar.edu.unq.cpi.geography.data.restricted.FixedRestrictedCountryDataProvider;
import ar.edu.unq.cpi.geography.data.restricted.RestrictedCountryData;
import ar.edu.unq.cpi.geography.data.restricted.RestrictedCountryDataProvider;
import ar.edu.unq.cpi.geography.data.worldbank.WorldBankDataProvider;

public class PoblacionPorPaisActivity extends AppCompatActivity {

    private TextView nombrePais;
    private TextView poblacionPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_poblacion_por_pais);

        this.nombrePais = this.findViewById(R.id.poblacionPorPais_pais);
        this.poblacionPais = this.findViewById(R.id.poblacionPorPais_poblacion);

        Button elegirArgentina = this.findViewById(R.id.poblacionPorPais_argentina);
        elegirArgentina.setOnClickListener((View v) -> {
            this.showDataDePais_fetch("Argentina");
        });
        Button elegirBrasil = this.findViewById(R.id.poblacionPorPais_brasil);
        elegirBrasil.setOnClickListener((View v) -> {
            this.showDataDePais_fetch("Brasil");
        });
        Button elegirParaguay = this.findViewById(R.id.poblacionPorPais_paraguay);
        elegirParaguay.setOnClickListener((View v) -> {
            this.showDataDePais_fetch("Paraguay");
        });
    }

    public void showDataDePais_get(String nombreDePais) {
        RestrictedCountryData data = new FixedRestrictedCountryDataProvider().getCountryData(nombreDePais);
        this.nombrePais.setText(nombreDePais);
        this.poblacionPais.setText(String.valueOf(data.getPopulation()));
    }

    public void showDataDePais_fetch(String nombreDePais) {
        RestrictedCountryDataProvider.api().fetchCountryData(nombreDePais,
                // este es el callback, o continuation,
                // mediante el callback le digo al DataProvider qué quiero que haga
                // cuando obtenga los datos
                // en el parámetro (data) me llegan los datos que obtuvo el DataProvider
                // este es un ejemplo de comunicación *asincrónica*
                // entre la Activity y el DataProvider
                (data) -> {
                    Log.d("PoblacionPorPais", "adentro del bloque");
                    this.nombrePais.setText(nombreDePais);
                    this.poblacionPais.setText(String.valueOf(data.getPopulation()));
                }
        );
        Log.d("PoblacionPorPais", "afuera del bloque");
    }

}
