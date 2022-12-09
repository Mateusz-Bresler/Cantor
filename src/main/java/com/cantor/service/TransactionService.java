package com.cantor.service;

import com.cantor.exceptions.CanNotProcessResponseToRateException;
import com.cantor.exceptions.CanNotProcessResponseToSymbolsException;
import com.cantor.exceptions.CanNotReturnStringFromUrlException;
import com.cantor.interfaces.ConvertCurrencyInterface;
import com.cantor.interfaces.ForexApi;
import com.cantor.interfaces.UrlBuilder;
import com.cantor.model.Transaction;
import com.cantor.repository.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.cantor.validate.Validate.validateAmount;
import static com.cantor.validate.Validate.validateCurrency;

@RequiredArgsConstructor
@Service
public class TransactionService implements ConvertCurrencyInterface, ForexApi {
    private final TransactionRepository transactionRepository;
    private final UrlBuilder urlBuilder;

    private final ObjectMapper objectMapper;

    @Override
    public Transaction exchangeMoney(String currencyFrom, String currencyTo, BigDecimal amount) {
        validateAmount(amount);

        List<String> symbols = currencies();
        validateCurrency(currencyFrom, symbols);
        validateCurrency(currencyTo, symbols);
        BigDecimal rate = getRate(currencyFrom, currencyTo);
        BigDecimal result = amount.multiply(rate);
        result.setScale(2, RoundingMode.CEILING);
        return Transaction.builder()
                .currencyFrom(currencyFrom)
                .currencyTo(currencyTo)
                .rate(rate)
                .amount(amount)
                .afterConversion(result)
                .date(LocalDate.now())
                .build();

    }


    @Override
    public BigDecimal getRate(String currencyFrom, String currencyTo) {
        String response = getRequestFromUrl(urlBuilder.buildUrlFetchAll(currencyFrom, currencyTo));
        JsonNode jsonNode1;
        try {
            jsonNode1 = objectMapper.readTree(response);
        } catch (JsonProcessingException e) {
            throw new CanNotProcessResponseToRateException();
        }
        return jsonNode1.get("results").get(currencyTo).decimalValue();
    }

    @Override
    public List<String> currencies() {
        String response = getRequestFromUrl(urlBuilder.buildUrlCurrencies());
        List<String> currencies = new ArrayList<>();
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(response).get("currencies");
        } catch (IOException e) {
            throw new CanNotProcessResponseToSymbolsException();
        }
        Iterator<String> iterator = jsonNode.fieldNames();
        iterator.forEachRemaining(currencies::add);
        return currencies;
    }

    private String getRequestFromUrl(URL url) {
        try {
            return objectMapper.readTree(url).toPrettyString();
        } catch (IOException e) {
            throw new CanNotReturnStringFromUrlException(url.toString());
        }
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }


}
