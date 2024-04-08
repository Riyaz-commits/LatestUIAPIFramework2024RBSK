package utils.helpers;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    public CurrencyUtil() {
    }

    public String formatCurrency(String Amount) {
        double Currency = Double.parseDouble(Amount.replaceAll(",", ""));
        BigDecimal Dollar = BigDecimal.valueOf(Currency);
        return NumberFormat.getCurrencyInstance(Locale.US).format(Dollar);
    }
}
