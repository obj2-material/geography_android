package ar.edu.unq.cpi.geography.data.expanded;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import ar.edu.unq.cpi.geography.data.expanded.analyzer.ApiCountryDataAnalyzer;
import ar.edu.unq.cpi.geography.data.expanded.analyzer.ApiCountryListAnalyzer;
import ar.edu.unq.cpi.geography.tools.ApplicationToolset;

/**
 * Created by Carlos on 11/11/2017.
 */

public class ApiCountryDataProvider extends CountryDataProvider {

    @Override
    public void fetchCountryList(CountryListConsumer theFunction) {
        String url =  "https://restcountries.eu/rest/v2/region/americas";
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ApiCountryListAnalyzer analyzer = new ApiCountryListAnalyzer(response);
                        theFunction.accept(analyzer.getSouthAmericaCountryList());
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

    @Override
    public void fetchCountryData(String countryCode, CountryDataConsumer theFunction) {
        String url =  "https://restcountries.eu/rest/v2/alpha/" + countryCode;
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ApiCountryDataAnalyzer analyzer = new ApiCountryDataAnalyzer(response);
                        theFunction.accept(analyzer.buildCountryData());
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
