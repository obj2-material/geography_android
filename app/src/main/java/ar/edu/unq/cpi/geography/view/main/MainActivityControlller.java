package ar.edu.unq.cpi.geography.view.main;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import ar.edu.unq.cpi.geography.BR;
import ar.edu.unq.cpi.geography.R;
import ar.edu.unq.cpi.geography.view.population.ListaDePaisesActivity;
import ar.edu.unq.cpi.geography.view.population.PoblacionPorPaisActivity;

public class MainActivityControlller extends BaseObservable {
    private String saludo;

    public MainActivityControlller(String saludo) {
        this.saludo = saludo;
    }

    @Bindable
    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
        notifyPropertyChanged(BR.saludo);
    }

    public void cambiarSaludo(View view) {
        this.setSaludo(view.getResources().getString(R.string.saludoFinal));
    }

    /*
    Pantalla que muestra la poblacion de Argentina, Brasil o Paraguay
    Usa RestrictedCountryData, package ar.edu.unq.cpi.geography.data.restricted,
    info de http://api.population.io
    */
    public void irAPoblacionPorPais(View view) {
        abrirActivity(view, PoblacionPorPaisActivity.class);
    }

    /*
     Pantalla que muestra la lista de paises de America del Sud, eligiendo un pais
     se accede a poblacion y superficie del pais.
     Usa RestrictedCountryData, package ar.edu.unq.cpi.geography.data.expanded,
     info de https://restcountries.eu
     */
    public void irAListaDePaises(View view) {
        abrirActivity(view, ListaDePaisesActivity.class);
    }

    private void abrirActivity(View view, Class<?> activityClass) {
        Intent intent = new Intent(view.getContext(), activityClass);
        view.getContext().startActivity(intent);
    }
}
