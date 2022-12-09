package com.cantor.interfaces;

import java.math.BigDecimal;
import java.net.URL;

public interface UrlBuilder {

    URL buildUrlFetchAll(String currencyFrom , String currencyTo);
    URL buildUrlCurrencies();
}
