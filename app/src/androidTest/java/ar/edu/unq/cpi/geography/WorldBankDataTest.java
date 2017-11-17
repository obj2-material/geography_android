package ar.edu.unq.cpi.geography;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import ar.edu.unq.cpi.geography.data.worldbank.WBCountryData;
import ar.edu.unq.cpi.geography.data.worldbank.WorldBankDataProvider;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WorldBankDataTest {
    @Test
    public void indicatorValueTest() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        WBCountryData accessToElectricityData = WorldBankDataProvider.fixed(appContext)
                .getIndicatorData2000to2008(
                        WorldBankDataProvider.ARGENTINA,
                        WorldBankDataProvider.ACCESS_TO_ELECTRICITY
                );
        assertEquals(accessToElectricityData.getValue(2000), 95.1, 0.01);
        System.out.println("After test");
    }
}
