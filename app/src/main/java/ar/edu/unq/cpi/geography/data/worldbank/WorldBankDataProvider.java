package ar.edu.unq.cpi.geography.data.worldbank;


import android.content.Context;

/**
 * Created by Carlos on 10/11/2017.
 */

public abstract class WorldBankDataProvider {
    public static final String ARGENTINA = "arg";
    public static final String BRAZIL = "bra";
    public static final String PARAGUAY = "pry";
    public static final String ACCESS_TO_ELECTRICITY = "1.1_ACCESS.ELECTRICITY.TOT";

    private static FixedWorldBankDataProvider fixedInstance;
    private static ApiWorldBankDataProvider apiInstance;

    private Context context;

    public static FixedWorldBankDataProvider fixed(Context ctx) {
        if (fixedInstance == null) { fixedInstance = new FixedWorldBankDataProvider(); }
        fixedInstance.setContext(ctx);
        return fixedInstance;
    }
    public static ApiWorldBankDataProvider api(Context ctx) {
        if (apiInstance == null) { apiInstance = new ApiWorldBankDataProvider(); }
        apiInstance.setContext(ctx);
        return apiInstance;
    }

    protected WorldBankDataProvider() {
        super();
    }
    public abstract void fetchIndicatorData2000to2008(String countryCode, String indicator, WBCountryDataConsumer theFunction);

    public void setContext(Context ctx) { this.context = ctx.getApplicationContext(); }
    public Context getContext() { return this.context; }
}
