package ar.edu.unq.cpi.geography.data.worldbank;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carlos on 15/11/2017.
 */

public class WBCountryData {
    private String indicatorCode;
    private String counryCode;
    private Map<Long,Double> values = new HashMap<>();

    public WBCountryData() { super(); }

    public WBCountryData(String _indicatorCode, String _countryCode) {
        this();
        this.indicatorCode = _indicatorCode;
        this.counryCode = _countryCode;
    }

    public void setCountryCode(String code) { this.counryCode = code; }
    public void setIndicatorCode(String code) { this.indicatorCode = code; }
    public String getCountryCode() { return this.counryCode; }
    public String getIndicatorCode() { return this.indicatorCode; }
    public double getValue(long year) {
        Double theValue = this.values.get(year);
        if (theValue == null) { theValue = 0.0; }
        return theValue;
    }
    public void setValue(long year, double value) {
        this.values.put(year, value);
    }
}



















