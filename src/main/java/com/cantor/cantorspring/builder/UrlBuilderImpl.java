package com.cantor.cantorspring.builder;

import com.cantor.cantorspring.exceptions.CanNotCreateUrlException;
import com.cantor.cantorspring.interfaces.UrlBuilder;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

import static com.cantor.cantorspring.constants.Constants.CURRENCIES_ENDPOINT;
import static com.cantor.cantorspring.constants.Constants.FETCH_ALL_ENDPOINT;
import static com.cantor.cantorspring.constants.Constants.FREE_API_KEY;
import static com.cantor.cantorspring.constants.Constants.WEBSITE;
@Component
public class UrlBuilderImpl implements UrlBuilder {


    @Override
    public URL buildUrlFetchAll(String currencyFrom, String currencyTo) {
        try {
            return new URL(WEBSITE + String.format(FETCH_ALL_ENDPOINT, currencyFrom) + FREE_API_KEY);
        } catch (MalformedURLException e) {
            throw new CanNotCreateUrlException();
        }
    }

    @Override
    public URL buildUrlCurrencies() {
        try {
            return new URL(WEBSITE + CURRENCIES_ENDPOINT + FREE_API_KEY);
        } catch (MalformedURLException e) {
            throw new CanNotCreateUrlException();
        }
    }
}

