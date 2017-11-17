package ar.edu.unq.cpi.geography.data.expanded;

/**
 * Created by Carlos on 09/11/2017.
 */

public class CountryData {
    private String code;
    private String spanishName;
    private long population;
    private long area;

    public CountryData(String code, String name, long population, long area) {
        super();
        this.setCode(code);
        this.setSpanishName(name);
        this.setPopulation(population);
        this.setArea(area);
    }

    public String getCode() { return this.code; }
    public void setCode(String theCode) { this.code = theCode; }
    public long getPopulation() { return this.population; }
    public void setPopulation(long howMany) { this.population = howMany; }
    public String getSpanishName() {return this.spanishName; }
    public void setSpanishName(String name) { this.spanishName = name; }
    public long getArea() { return this.area; }
    public void setArea(long howMuch) { this.area = howMuch; }
}
