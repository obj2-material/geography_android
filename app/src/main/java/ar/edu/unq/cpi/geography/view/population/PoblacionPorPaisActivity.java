package ar.edu.unq.cpi.geography.view.population;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ar.edu.unq.cpi.geography.R;
import ar.edu.unq.cpi.geography.databinding.ActivityPoblacionPorPaisBinding;

/**
 * Esta es una version de PoblacionPorPaisActivity que incluye un controller.
 * En esta version, el controller habla con el DataProvider.s
 */
public class PoblacionPorPaisActivity extends AppCompatActivity {

    private PoblacionPorPaisController controller = new PoblacionPorPaisController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityPoblacionPorPaisBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_poblacion_por_pais);
        binding.setController(controller);

        Button elegirArgentina = this.findViewById(R.id.argentina);
        elegirArgentina.setOnClickListener((View v) -> {
            this.controller.setCountryName("Argentina");
        });
        Button elegirBrasil = this.findViewById(R.id.brasil);
        elegirBrasil.setOnClickListener((View v) -> {
            this.controller.setCountryName("Brasil");
        });
        Button elegirParaguay = this.findViewById(R.id.paraguay);
        elegirParaguay.setOnClickListener((View v) -> {
            this.controller.setCountryName("Paraguay");
        });
    }

}
