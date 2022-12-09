package com.cantor.cantorspring.controller;

import com.cantor.cantorspring.model.Transaction;
import com.cantor.cantorspring.repository.TransactionRepository;
import com.cantor.cantorspring.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDate;
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
