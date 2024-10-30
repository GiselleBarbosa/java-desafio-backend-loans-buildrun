package com.barbosa.loans.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @PostMapping(value = "customer-loans")
    public ResponseEntity<?> customerLoans() {
    }
}
