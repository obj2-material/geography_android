package ar.edu.unq.cpi.geography.data.expanded.analyzer;

import org.json.JSONException;
import org.json.JSONObject;

import ar.edu.unq.cpi.geography.data.expanded.CountryData;

/**
 * Created by Carlos on 11/11/2017.
 */

public class ApiCountryDataAnalyzer {
    private JSONObject rawData;

    public ApiCountryDataAnalyzer(JSONObject _rawData) {
        super();
        this.rawData = _rawData;
    }

    public boolean isOnTarget() throws JSONException {
        return this.getString("subregion").equals("South America") &&
                !(this.getString("name").contains("Falkland")
                        || this.getString("name").contains("South Georgia")
                );
    }

    public String getString(String fieldName) throws JSONException {
        return this.rawData.getString(fieldName);
    }

    public CountryData buildCountryData() {
        try {
            String code = this.getString("alpha3Code");  // este tiene que estar
            String spanishName = "";
            try {
                spanishName = this.rawData.getJSONObject("translations").getString("es");
            } catch (JSONException e) {
                // nothing to do
            }
            long population = 0;
            try {
                population = this.rawData.getLong("population");
            } catch (JSONException e) {
                // nothing to do
            }
            long area = 0;
            try {
                area = this.rawData.getLong("area");
            } catch (JSONException e) {
                // nothing to do
            }
            return new CountryData(code, spanishName, population, area);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
