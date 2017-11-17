package ar.edu.unq.cpi.geography.data.expanded;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 10/11/2017.
 */

public class FixedCountryDataProvider extends CountryDataProvider {
    private List<CountryData> fixedData;

    protected FixedCountryDataProvider() {
        super();
        this.fillFixedData();
    }

    private void fillFixedData() {
        this.fixedData = new ArrayList<>();
        this.fixedData.add(new CountryData("ARG", "Argentina", 44000000, 2800000));
        this.fixedData.add(new CountryData("BOL", "Bolivia", 11000000, 1100000));
        this.fixedData.add(new CountryData("BRA", "Brasil", 207000000, 8500000));
        this.fixedData.add(new CountryData("COL", "Colombia", 48800000, 1140000));
        this.fixedData.add(new CountryData("CHL", "Chile", 18200000, 750000));
//        this.fixedData.add(new CountryData("ECU", "Ecuador", 16500000, 275000));
//        this.fixedData.add(new CountryData("PRY", "Paraguay", 6800000, 400000));
//        this.fixedData.add(new CountryData("PER", "Perú", 31500000, 1300000));
//        this.fixedData.add(new CountryData("URY", "Uruguay", 3500000, 180000));
//        this.fixedData.add(new CountryData("VEN", "Venezuela",31000000, 915000));
    }

    @Override
    public void fetchCountryList(CountryListConsumer theFunction) {
        theFunction.accept(this.fixedData);
    }

    @Override
    public void fetchCountryData(String countryCode, CountryDataConsumer theFunction) {
        CountryData theCountryData = null;
        for (CountryData someCountry : this.fixedData) {
            if (someCountry.getCode().equals(countryCode)) {
                theCountryData = someCountry;
                break;
            }
        }
        if (theCountryData == null) {
            throw new RuntimeException("No se encontro informacion para el codigo de pais " + countryCode);
        }
        theFunction.accept(theCountryData);
    }
}
