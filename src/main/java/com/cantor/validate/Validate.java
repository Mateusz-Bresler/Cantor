package com.cantor.validate;

import com.cantor.exceptions.AmountMustBeMoreThanZeroException;
import com.cantor.exceptions.CurrencyDoesNotExistException;

import java.math.BigDecimal;
import java.util.List;

public class Validate {

    public static void validateCurrency (String currency, List<String> currencyList){
        if (!currencyList.contains(currency)){
            throw new CurrencyDoesNotExistException(currency);
        }
    }

    public static void validateAmount (BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new AmountMustBeMoreThanZeroException(amount.toString());
        }
    }
}
