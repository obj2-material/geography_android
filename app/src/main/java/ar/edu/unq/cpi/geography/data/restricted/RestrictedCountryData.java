package ar.edu.unq.cpi.geography.data.restricted;

/**
 * Created by Carlos on 09/11/2017.
 */

public class RestrictedCountryData {
    private String apiName;
    private long population;

    // este es el Null Object de la clase RestrictedCountryData
    public static RestrictedCountryData noData() {
        return new RestrictedCountryData(null, 0);
    }

    public RestrictedCountryData(String name, long population) {
        super();
        this.setApiName(name);
        this.setPopulation(population);
    }

    public boolean hasData() { return this.apiName != null; }

    public String getApiName() { return this.apiName; }

    public void setApiName(String name) { this.apiName = name; }

    public long getPopulation() { return this.population; }

    public void setPopulation(long howMany) { this.population = howMany; }

}
