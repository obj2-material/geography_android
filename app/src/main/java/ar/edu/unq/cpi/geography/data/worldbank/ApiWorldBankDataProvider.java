package ar.edu.unq.cpi.geography.data.worldbank;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import ar.edu.unq.cpi.geography.tools.ApplicationToolset;

/**
 * Created by Carlos on 15/11/2017.
 */

public class ApiWorldBankDataProvider extends WorldBankDataProvider {
    public void fetchIndicatorData2000to2010(String countryCode, String indicator, WBCountryDataConsumer theFunction) {
        String url =  "http://api.worldbank.org/v2/countries/" + countryCode
                + "/indicators/" + indicator + "?date=2000:2010"
                + "&format=json";
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        WBDataAnalyzer analyzer = new WBDataAnalyzer(response);
                        theFunction.accept(analyzer.getIndicatorCountryYearRangeValues());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        throw new RuntimeException("Error en el request REST", error);
                    }
                });
        ApplicationToolset.toolset().addToRequestQueue(jsArrayRequest);
    }

}
