package ru.max.javaspringboot.SpringBootGet_223.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.max.javaspringboot.SpringBootGet_223.model.Car;
import ru.max.javaspringboot.SpringBootGet_223.service.LoanService;

import java.util.List;

@Controller
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<Double> getCredit(@RequestParam(value = "userId", required = false) Long userId) {
        Double loan = loanService.approveLoan(userId);
        return ResponseEntity.ok(loan);
    }
}
