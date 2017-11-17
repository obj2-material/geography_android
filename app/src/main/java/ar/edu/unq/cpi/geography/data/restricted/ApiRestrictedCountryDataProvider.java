package ar.edu.unq.cpi.geography.data.restricted;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import ar.edu.unq.cpi.geography.tools.ApplicationToolset;

/**
 * Created by Carlos on 10/11/2017.
 */

public class ApiRestrictedCountryDataProvider extends RestrictedCountryDataProvider {


    @Override
    public void fetchCountryData(String appCountryName, RestrictedCountryDataConsumer theFunction) {
        String apiCountryName = this.getApiCountryNameFor(appCountryName);
        String url = "http://api.population.io/1.0/population/" + apiCountryName + "/today-and-tomorrow/";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        long obtainedPopulation = 0;
                        try {
                            obtainedPopulation = response.getJSONArray("total_population")
                                    .getJSONObject(0)
                                    .getLong("population");
                            theFunction.accept(new RestrictedCountryData(apiCountryName, obtainedPopulation));
                        } catch (JSONException e) {
                            throw new RuntimeException("Error al parsear la respuesta JSON", e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        throw new RuntimeException("Error en el request REST", error);
                    }
                });
        ApplicationToolset.toolset().addToRequestQueue(jsObjRequest);
    }

    public void fetchCountryData_old(String appCountryName, RestrictedCountryDataConsumer theFunction) {
        String apiCountryName = this.getApiCountryNameFor(appCountryName);
        String url = "http://api.population.io/1.0/population/" + apiCountryName + "/today-and-tomorrow/";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        long obtainedPopulation = 0;
                        try {
                            obtainedPopulation = response.getJSONArray("total_population")
                                    .getJSONObject(0)
                                    .getLong("population");
                            theFunction.accept(new RestrictedCountryData(apiCountryName, obtainedPopulation));
                        } catch (JSONException e) {
                            throw new RuntimeException("Error al parsear la respuesta JSON", e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        throw new RuntimeException("Error en el request REST", error);
                    }
                });
        ApplicationToolset.toolset().addToRequestQueue(jsObjRequest);
    }

}
