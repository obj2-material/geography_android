package ar.edu.unq.cpi.geography.data.expanded.analyzer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.cpi.geography.data.expanded.CountryData;

/**
 * Created by Carlos on 11/11/2017.
 */

public class ApiCountryListAnalyzer {
    JSONArray rawData;
    List<CountryData> processedData;

    public ApiCountryListAnalyzer(JSONArray _rawData) {
        super();
        this.rawData = _rawData;
    }

    public List<CountryData> getSouthAmericaCountryList() {
        this.checkData();
        return this.processedData;
    }

    private void doProcessData() {
        this.processedData = new ArrayList<>();
        try {
            for (int i = 0; i < this.rawData.length(); i++) {
                JSONObject element = this.rawData.getJSONObject(i);
                ApiCountryDataAnalyzer elementAnalyzer = new ApiCountryDataAnalyzer(element);
                if (elementAnalyzer.isOnTarget()) {
                    CountryData elementAsCountryData = elementAnalyzer.buildCountryData();
                    if (elementAsCountryData != null) {
                        this.processedData.add(elementAsCountryData);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException("Error al procesar la respuesta JSON", e);
        }
    }

    private void checkData() {
        if (this.processedData == null) { this.doProcessData(); }
    }

}
