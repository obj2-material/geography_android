package ar.edu.unq.cpi.geography.view.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ar.edu.unq.cpi.geography.databinding.ActivityMainBinding;
import ar.edu.unq.cpi.geography.tools.ApplicationToolset;
import ar.edu.unq.cpi.geography.view.population.ListaDePaisesActivity;
import ar.edu.unq.cpi.geography.R;
import ar.edu.unq.cpi.geography.view.population.PoblacionPorPaisActivity;

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
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setController(controller);

        ApplicationToolset.setContext(this);

        Button botonCambiarSaludo = this.findViewById(R.id.cambiarSaludoButton);
        botonCambiarSaludo.setOnClickListener((View v) -> {
            controller.setSaludo(getString(R.string.saludoInicial));
        });

        /*
         Pantalla que muestra la poblacion de Argentina, Brasil o Paraguay
         Usa RestrictedCountryData, package ar.edu.unq.cpi.geography.data.restricted,
         info de http://api.population.io
         */
        Button botonIrAPoblacion = this.findViewById(R.id.irAPoblacionPorPais);
        botonIrAPoblacion.setOnClickListener((View v) -> {
            this.irAPoblacionPorPais();
        });

        /*
         Pantalla que muestra la lista de paises de America del Sud, eligiendo un pais
         se accede a poblacion y superficie del pais.
         Usa RestrictedCountryData, package ar.edu.unq.cpi.geography.data.expanded,
         info de https://restcountries.eu
         */
        Button botonIrAListaDePaises = this.findViewById(R.id.irAListaDePaises);
        botonIrAListaDePaises.setOnClickListener((View v) -> {
            this.irAListaDePaises();
        });
    }

    public void irAPoblacionPorPais() {
        Intent intent = new Intent(this, PoblacionPorPaisActivity.class);
        startActivity(intent);
    }

    public void irAListaDePaises() {
        Intent intent = new Intent(this, ListaDePaisesActivity.class);
        startActivity(intent);
    }
}
