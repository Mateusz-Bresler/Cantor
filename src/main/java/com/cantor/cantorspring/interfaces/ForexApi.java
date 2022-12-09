package com.cantor.cantorspring.interfaces;

import java.math.BigDecimal;
import java.util.List;

public interface ForexApi {

    BigDecimal getRate(String currencyFrom, String currencyTo);
    List<String> currencies();




}
