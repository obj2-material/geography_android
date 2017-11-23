package ar.edu.unq.cpi.geography;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import java.util.List;

import ar.edu.unq.cpi.geography.data.worldbank.WBCountryData;
import ar.edu.unq.cpi.geography.data.worldbank.WBIndicatorData;
import ar.edu.unq.cpi.geography.data.worldbank.WorldBankDataProvider;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WorldBankDataTest {
    @Test
    public void electricityValueTest() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        WBCountryData accessToElectricityData = WorldBankDataProvider.fixed(appContext)
                .getIndicatorData2000to2010(
                        WorldBankDataProvider.ARGENTINA,
                        WorldBankDataProvider.ACCESS_TO_ELECTRICITY
                );
        assertEquals(accessToElectricityData.getValue(2000), 95.1, 0.01);
        assertEquals(accessToElectricityData.getValue(2010), 99.2, 0.01);
    }

    @Test
    public void unemploymentValueTest() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        WBCountryData argData = WorldBankDataProvider.fixed(appContext)
                .getIndicatorData2000to2010(
                        WorldBankDataProvider.ARGENTINA,
                        WorldBankDataProvider.UNEMPLOYMENT_PERCENTAGE
                );
        WBCountryData chlData = WorldBankDataProvider.fixed(appContext)
                .getIndicatorData2000to2010(
                        WorldBankDataProvider.CHILE,
                        WorldBankDataProvider.UNEMPLOYMENT_PERCENTAGE
                );
        WBCountryData colData = WorldBankDataProvider.fixed(appContext)
                .getIndicatorData2000to2010(
                        WorldBankDataProvider.COLOMBIA,
                        WorldBankDataProvider.UNEMPLOYMENT_PERCENTAGE
                );
        assertEquals(argData.getValue(2002), 19.6, 0.01);
        assertEquals(argData.getValue(2009), 8.64, 0.01);
        assertEquals(chlData.getValue(2002), 8.94, 0.01);
        assertEquals(chlData.getValue(2009), 9.69, 0.01);
        assertEquals(colData.getValue(2002), 15.63, 0.01);
        assertEquals(colData.getValue(2009), 12.07, 0.01);
    }

    @Test
    public void indicatorListTest() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        List<WBIndicatorData> indicators = WorldBankDataProvider.fixed(appContext)
                .getIndicatorList();
        WBIndicatorData unemploymentRateIndicator = null;
        for (WBIndicatorData currentData : indicators) {
            if (currentData.getCode().equals(WorldBankDataProvider.UNEMPLOYMENT_PERCENTAGE)) {
                unemploymentRateIndicator = currentData;
                break;
            }
        }
        assertNotNull(unemploymentRateIndicator);
        assertEquals("Tasa de desocupación", unemploymentRateIndicator.getDescription());
    }
}
