package com.cantor.cantorspring.repository;

import com.cantor.cantorspring.model.Transaction;
import com.cantor.cantorspring.service.TransactionService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DbInit {
    private final TransactionService transactionService;


    public DbInit(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //
    @PostConstruct //adnotacja wywoluje metode po uruchomieniu apki
    public void init() {
        transactionService.save(Transaction.builder()
                .currencyFrom("USD")
                .currencyTo("EUR")
                .rate(new BigDecimal("1.2"))
                .amount(new BigDecimal("123"))
                .date(LocalDate.now())
                .build());

        transactionService.save(Transaction.builder()
                .currencyFrom("USD")
                .currencyTo("EUR")
                .rate(new BigDecimal("1.2"))
                .amount(new BigDecimal("1000"))
                .date(LocalDate.now())
                .build());
    }
}
