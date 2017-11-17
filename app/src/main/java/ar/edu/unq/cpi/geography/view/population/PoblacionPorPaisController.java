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

public class PoblacionPorPaisController {

    // RestrictedCountryData es el DataObject
    private RestrictedCountryData currentCountryData = RestrictedCountryData.noData();

    public void setCountryName(String nombreDePais) {
        // FixedRestrictedCountryDataProvider es el DataProvider
        this.currentCountryData = new FixedRestrictedCountryDataProvider()
                .getCountryData(nombreDePais);
    }

    public boolean hasData() { return this.currentCountryData.hasData(); }
    public String getCountryName() {
        return this.hasData() ? this.currentCountryData.getApiName() : "";
    }
    public String getPopulation() {
        return this.hasData() ? String.valueOf(this.currentCountryData.getPopulation()) : "";
    }

    public void setCountryData(RestrictedCountryData countryData) {
        this.currentCountryData = countryData;
    }
}
