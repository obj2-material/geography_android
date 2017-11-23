package ar.edu.unq.cpi.geography.data.worldbank;


import android.content.Context;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Carlos on 10/11/2017.
 */

public abstract class WorldBankDataProvider {
    public static final String ARGENTINA = "arg";
    public static final String BRAZIL = "bra";
    public static final String PARAGUAY = "pry";
    public static final String BOLIVIA = "bol";
    public static final String URUGUAY = "ury";
    public static final String CHILE = "chl";
    public static final String PERU = "per";
    public static final String ECUADOR = "ecu";
    public static final String COLOMBIA = "col";
    public static final String VENEZUELA = "ven";
    public static final String ACCESS_TO_ELECTRICITY = "1.1_ACCESS.ELECTRICITY.TOT";
    public static final String COMPLETE_SECONDARY_PERCENTAGE = "BAR.SEC.CMPT.25UP.ZS";
    public static final String PUBLIC_PRIMARY_STUDENT_COUNT = "UIS.E.1.Pu";
    public static final String PRIVATE_PRIMARY_STUDENT_COUNT = "UIS.E.1.PR";
    public static final String UNDER_15_PERCENTAGE = "SP.POP.0014.TO.ZS";
    public static final String UNEMPLOYMENT_PERCENTAGE = "SL.UEM.TOTL.ZS";
    public static final String UNEMPLOYMENT_MALE_PERCENTAGE = "SL.UEM.TOTL.MA.ZS";
    public static final String UNEMPLOYMENT_FEMALE_PERCENTAGE = "SL.UEM.TOTL.FE.ZS";
    public static final String WORKFORCE_COUNT = "SL.TLF.TOTL.IN";
    public static final String FEMALE_WORKFORCE_PERCENTAGE = "SL.TLF.TOTL.FE.ZS";
    public static final String RURAL_POPULATION_PERCENTAGE = "SP.RUR.TOTL.ZS";
    public static final String AGRO_GDP_PERCENTAGE = "NV.AGR.TOTL.ZS";
    public static final String CEREAL_TOTAL_PRODUCTION = "AG.PRD.CREL.MT";

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
    public abstract void fetchIndicatorData2000to2010(String countryCode, String indicator, WBCountryDataConsumer theFunction);

    public void setContext(Context ctx) { this.context = ctx.getApplicationContext(); }
    public Context getContext() { return this.context; }

    public void fetchIndicatorList(WBIndicatorDataConsumer theFunction) {
        theFunction.accept(this.getIndicatorList());
    }

    public List<WBIndicatorData> getIndicatorList() {
        return Arrays.asList(
                new WBIndicatorData(ACCESS_TO_ELECTRICITY, "Porcentaje de población con acceso a la electricidad"),
                new WBIndicatorData(COMPLETE_SECONDARY_PERCENTAGE, "Porcentje de población con secundaria completa"),
                new WBIndicatorData(PUBLIC_PRIMARY_STUDENT_COUNT, "Cantidad de alumnos en primaria pública"),
                new WBIndicatorData(PRIVATE_PRIMARY_STUDENT_COUNT, "Cantidad de alumnos en primaria pública"),
                new WBIndicatorData(UNDER_15_PERCENTAGE, "Porcentaje de población menor a 15 años"),
                new WBIndicatorData(UNEMPLOYMENT_PERCENTAGE, "Tasa de desocupación"),
                new WBIndicatorData(UNEMPLOYMENT_MALE_PERCENTAGE, "Tasa de desocupación en varones"),
                new WBIndicatorData(UNEMPLOYMENT_FEMALE_PERCENTAGE, "Tasa de desocupación en mujeres"),
                new WBIndicatorData(WORKFORCE_COUNT, "Cantidad total de personas en la fuerza laboral"),
                new WBIndicatorData(FEMALE_WORKFORCE_PERCENTAGE, "Porcentaje de mujeres en la fuerza laboral"),
                new WBIndicatorData(RURAL_POPULATION_PERCENTAGE, "Porcentaje de población rural"),
                new WBIndicatorData(AGRO_GDP_PERCENTAGE, "Agricultura como porcentaje del PBI"),
                new WBIndicatorData(CEREAL_TOTAL_PRODUCTION, "Producción total de cereales, en toneladas")
        );
    }

}
