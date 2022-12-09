package com.cantor.interfaces;

import com.cantor.model.Transaction;

import java.math.BigDecimal;

public interface ConvertCurrencyInterface {

    Transaction exchangeMoney(String currencyFrom, String currencyTo, BigDecimal amount);

}
