package ar.edu.unq.cpi.geography.data.restricted;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carlos on 10/11/2017.
 */

public abstract class RestrictedCountryDataProvider {
    protected Map<String, String> countryNameTranslation;

    private static FixedRestrictedCountryDataProvider fixedInstance = new FixedRestrictedCountryDataProvider();
    private static ApiRestrictedCountryDataProvider apiInstance = new ApiRestrictedCountryDataProvider();

    public static FixedRestrictedCountryDataProvider fixed() { return fixedInstance; }
    public static ApiRestrictedCountryDataProvider api() { return apiInstance; }

    protected RestrictedCountryDataProvider() {
        super();
        this.initTranslation();
    }
    private void initTranslation() {
        this.countryNameTranslation = new HashMap<>();
        this.countryNameTranslation.put("Brasil", "Brazil");
    }

    protected String getApiCountryNameFor(String appCountryName) {
        String result = this.countryNameTranslation.get(appCountryName);
        if (result == null) { result = appCountryName; }
        return result;
    }

    public abstract void fetchCountryData(String appCountryName, RestrictedCountryDataConsumer theFunction);
}
