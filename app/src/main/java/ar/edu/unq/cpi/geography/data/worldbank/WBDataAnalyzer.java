package ar.edu.unq.cpi.geography.data.worldbank;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Carlos on 17/11/2017.
 */

class WBDataAnalyzer {
    private JSONArray rawData;
    public WBDataAnalyzer(JSONArray response) {
        super();
        this.rawData = response;
    }

    public WBCountryData getIndicatorCountryYearRangeValues() {
        try {
            WBCountryData result = new WBCountryData();
            JSONArray properData = this.rawData.getJSONArray(1);
            for (int i = 0; i < properData.length() ; i++) {
                JSONObject yearData = properData.getJSONObject(i);
                if (result.getCountryCode() == null) {
                    String countryCode = yearData.getString("countryiso3code").toLowerCase();
                    String indicatorCode = yearData.getJSONObject("indicator").getString("id");
                    result.setCountryCode(countryCode);
                    result.setIndicatorCode(indicatorCode);
                }
                long year = Long.valueOf(yearData.getString("date"));
                double value = yearData.getDouble("value");
                result.setValue(year, value);
            }
            return result;
        } catch (JSONException e) {
            throw new RuntimeException("Error en el procesamiento del JSON obtenido", e);
        }
    }
}
















