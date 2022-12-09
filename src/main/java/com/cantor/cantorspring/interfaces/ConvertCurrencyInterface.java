package com.cantor.cantorspring.interfaces;

import com.cantor.cantorspring.model.Transaction;

import java.math.BigDecimal;

public interface ConvertCurrencyInterface {

    Transaction exchangeMoney(String currencyFrom, String currencyTo, BigDecimal amount);

}
