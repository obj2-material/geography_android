package ar.edu.unq.cpi.geography.view.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import ar.edu.unq.cpi.geography.BR;
import ar.edu.unq.cpi.geography.R;

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
}
