package ua.kruart.tdd.finances;

import java.math.BigDecimal;

/**
 * Created by Arthur on 11.12.2016.
 */
public class TaxRate {


    private BigDecimal rate;

    public TaxRate(double rateAsPercentage) {
        this.rate = new BigDecimal(rateAsPercentage).divide(new BigDecimal(100));
    }

    public int taxFor(int amount) {
//        return (int)(amount * rate);
        return 0;
    }
}
