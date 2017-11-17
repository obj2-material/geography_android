package ar.edu.unq.cpi.geography.data.restricted;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 09/11/2017.
 */

public class FixedRestrictedCountryDataProvider extends RestrictedCountryDataProvider {

    private List<RestrictedCountryData> temporaryData;

    public FixedRestrictedCountryDataProvider() {
        super();
        this.initTemporaryData();
    }
    private void initTemporaryData() {
        this.temporaryData = new ArrayList<>();
        this.temporaryData.add(new RestrictedCountryData("Argentina", 44000000));
        this.temporaryData.add(new RestrictedCountryData("Bolivia", 11000000));
        this.temporaryData.add(new RestrictedCountryData("Brazil", 230000000));
        this.temporaryData.add(new RestrictedCountryData("Colombia", 48800000));
        this.temporaryData.add(new RestrictedCountryData("Chile", 18200000));
        this.temporaryData.add(new RestrictedCountryData("Ecuador", 16500000));
        this.temporaryData.add(new RestrictedCountryData("French Guiana", 250000));
        this.temporaryData.add(new RestrictedCountryData("Guyana", 750000));
        this.temporaryData.add(new RestrictedCountryData("Paraguay", 6800000));
        this.temporaryData.add(new RestrictedCountryData("Peru", 31500000));
        this.temporaryData.add(new RestrictedCountryData("Suriname", 550000));
        this.temporaryData.add(new RestrictedCountryData("Uruguay", 3500000));
        this.temporaryData.add(new RestrictedCountryData("RB-de-Venezuela",31000000));
    }

    public RestrictedCountryData getCountryData(String appCountryName) {
        RestrictedCountryData result = null;
        String apiCountryName = this.getApiCountryNameFor(appCountryName);
        // este es un forEach de antes que existieran los stream
        // si en Android me quiero bancaqr desde 4.4 (API 19)
        // no tengo streams, por eso tengo que hacer el loop de esta form
        for (RestrictedCountryData country : this.temporaryData) {
            if (country.getApiName().equals(apiCountryName)) {
                result = country;
                break;  // para que corte el for
                // en rigor, la combinación del for con el break es análogo a un find
            }
        }
        if (result == null) {
            throw new RuntimeException("No se encontro informacion sobre el pais " + appCountryName);
        }
        return result;
    }

    @Override
    public void fetchCountryData(String appCountryName, RestrictedCountryDataConsumer callback) {
        callback.accept(this.getCountryData(appCountryName));
    }

//    public void fetchCountryNames
}
