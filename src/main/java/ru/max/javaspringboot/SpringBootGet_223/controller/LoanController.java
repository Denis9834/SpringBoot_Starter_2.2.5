package ru.max.javaspringboot.SpringBootGet_223.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.max.javaspringboot.SpringBootGet_223.service.LoanService;

@Controller
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loan")
    public Double getCredit(@RequestParam(value = "userId", required = false) Long userId) {
            return loanService.approveLoan(userId);
    }
}
