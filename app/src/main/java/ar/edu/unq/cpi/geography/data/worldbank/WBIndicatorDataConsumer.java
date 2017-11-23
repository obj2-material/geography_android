package ar.edu.unq.cpi.geography.data.worldbank;

import java.util.List;

/**
 * Created by Carlos on 22/11/2017.
 */

public interface WBIndicatorDataConsumer {
    public void accept(List<WBIndicatorData> data);
}
