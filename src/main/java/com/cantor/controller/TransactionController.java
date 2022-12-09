package com.cantor.controller;

import com.cantor.model.Transaction;
import com.cantor.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/exchange")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    private String addTransaction(Transaction transaction) {
        Transaction result = transactionService.exchangeMoney(transaction.getCurrencyFrom(), transaction.getCurrencyTo(), transaction.getAmount());
        transactionService.save(result);
        return "redirect:/";
    }




}
