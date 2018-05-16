package ar.edu.unq.cpi.geography.view.main;

public class MainActivityControlller {
    private String saludo;

    public MainActivityControlller(String saludo) {
        this.saludo = saludo;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
}
