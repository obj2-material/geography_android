package ar.edu.unq.cpi.geography.data.expanded;

import java.util.List;

/**
 * Created by Carlos on 10/11/2017.
 */

public interface CountryListConsumer {
    public void accept(List<CountryData> data);
}
