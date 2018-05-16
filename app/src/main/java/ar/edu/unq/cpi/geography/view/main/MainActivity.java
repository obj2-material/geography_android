package ar.edu.unq.cpi.geography.view.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ar.edu.unq.cpi.geography.R;
import ar.edu.unq.cpi.geography.databinding.MainActivityBinding;
import ar.edu.unq.cpi.geography.tools.ApplicationToolset;

/**
 * Ventana inicial de la aplicacion.
 * Se propone armar una variante que obtenga la informacion usando
 * WBCountryData y WorldBankDataProvider, package ar.edu.unq.cpi.geography.data.worldbank.
 * OJO para usar WorldBankDataProvider desde una Activity hay que pasar el applicationContext.
 * P.ej. WorldBankDataProvider.fixed(this.getApplicationContext()).
 */
public class MainActivity extends AppCompatActivity {

    MainActivityControlller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        controller = new MainActivityControlller(getString(R.string.saludoInicial));
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.setController(controller);

        ApplicationToolset.setContext(this);
    }

}
