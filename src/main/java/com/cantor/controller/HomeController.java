package com.cantor.controller;

import com.cantor.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor //automatycznie wstrzyknie spring bina jak pola beda final
@Controller
public class HomeController {
    private final TransactionService transactionService;

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("options", transactionService.currencies());
        return "home";
    }
}
