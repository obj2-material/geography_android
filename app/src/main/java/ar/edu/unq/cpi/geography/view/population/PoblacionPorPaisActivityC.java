package ar.edu.unq.cpi.geography.view.population;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ar.edu.unq.cpi.geography.R;
import ar.edu.unq.cpi.geography.data.restricted.FixedRestrictedCountryDataProvider;
import ar.edu.unq.cpi.geography.data.restricted.RestrictedCountryData;
import ar.edu.unq.cpi.geography.data.restricted.RestrictedCountryDataProvider;

/**
 * Esta es una version de PoblacionPorPaisActivity que incluye un controller.
 * En esta version, el controller habla con el DataProvider.s
 */
public class PoblacionPorPaisActivityC extends AppCompatActivity {

    private TextView nombrePais;
    private TextView poblacionPais;
    private PoblacionPorPaisController controller = new PoblacionPorPaisController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_poblacion_por_pais);

        this.nombrePais = this.findViewById(R.id.poblacionPorPais_pais);
        this.poblacionPais = this.findViewById(R.id.poblacionPorPais_poblacion);

        Button elegirArgentina = this.findViewById(R.id.poblacionPorPais_argentina);
        elegirArgentina.setOnClickListener((View v) -> {
            this.showDataDePais("Argentina");
        });
        Button elegirBrasil = this.findViewById(R.id.poblacionPorPais_brasil);
        elegirBrasil.setOnClickListener((View v) -> {
            this.showDataDePais("Brasil");
        });
        Button elegirParaguay = this.findViewById(R.id.poblacionPorPais_paraguay);
        elegirParaguay.setOnClickListener((View v) -> {
            this.showDataDePais("Paraguay");
        });
    }

    public void showDataDePais(String nombreDePais) {
        this.controller.setCountryName(nombreDePais);
        this.nombrePais.setText(this.controller.getCountryName());
        this.poblacionPais.setText(this.controller.getPopulation());
    }

}
