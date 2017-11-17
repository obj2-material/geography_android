package ar.edu.unq.cpi.geography.data.worldbank;

import org.json.JSONArray;
import org.json.JSONException;

import ar.edu.unq.cpi.geography.R;


/**
 * Created by Carlos on 17/11/2017.
 */

public class FixedWorldBankDataProvider extends WorldBankDataProvider {
    @Override
    public void fetchIndicatorData2000to2008(String countryCode, String indicator, WBCountryDataConsumer theFunction) {
        theFunction.accept(this.getIndicatorData2000to2008(countryCode, indicator));
    }

    public WBCountryData getIndicatorData2000to2008(String countryCode, String indicator) {
        boolean hasData = false;
        int indicatorId = 0;
        if (countryCode.equals(WorldBankDataProvider.ARGENTINA)
                && indicator.equals(WorldBankDataProvider.ACCESS_TO_ELECTRICITY)) {
            indicatorId = R.string.worldBankFixedData_arg_electricityAccess;
            hasData = true;
        }
        if (!hasData) {
            return new WBCountryData(indicator, countryCode);
        }
        String source = this.getSource(indicatorId);
        JSONArray rawData = null;
        try {
            rawData = new JSONArray(source);
        } catch (JSONException e) {
            throw new RuntimeException("Error al crear el juego de datos de prueba", e);
        }
        return new WBDataAnalyzer(rawData).getIndicatorCountryYearRangeValues();
    }

    private String getSource(int indicatorId) {
        return this.getContext().getString(indicatorId).replace("XX", "\"");
    }
}





















































