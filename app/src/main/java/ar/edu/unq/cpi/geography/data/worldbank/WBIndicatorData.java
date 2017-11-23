package ar.edu.unq.cpi.geography.data.worldbank;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Carlos on 15/11/2017.
 */

public class WBIndicatorData {
    private String code;
    private String description;

    public WBIndicatorData() { super(); }

    public WBIndicatorData(String _code, String _description) {
        this();
        this.code = _code;
        this.description = _description;
    }

    public String getCode() { return this.code; }
    public void setCode(String theCode) { this.code = theCode; }
    public String getDescription() { return this.description; }
    public void setDescription(String desc) { this.description = desc; }
}



















