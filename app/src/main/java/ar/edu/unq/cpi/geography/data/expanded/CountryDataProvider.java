package ar.edu.unq.cpi.geography.data.expanded;


/**
 * Created by Carlos on 10/11/2017.
 */

public abstract class CountryDataProvider {
    private static FixedCountryDataProvider fixedInstance = new FixedCountryDataProvider();
    private static ApiCountryDataProvider apiInstance = new ApiCountryDataProvider();

    public static FixedCountryDataProvider fixed() { return fixedInstance; }
    public static ApiCountryDataProvider api() { return apiInstance; }

    protected CountryDataProvider() {
        super();
    }
    public abstract void fetchCountryList(CountryListConsumer theFunction);
    public abstract void fetchCountryData(String countryCode, CountryDataConsumer theFunction);
}
