package com.cantor.controller;

import com.cantor.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequiredArgsConstructor
@Controller
@RequestMapping("/history")
public class ListController {

    //todo do poprawy serwic
    private final TransactionRepository transactionRepository;

    @PostMapping
    public String getAll(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        return "list";
    }

    @GetMapping
    public String returnHomePage() {
        return "redirect:/";
    }
}
