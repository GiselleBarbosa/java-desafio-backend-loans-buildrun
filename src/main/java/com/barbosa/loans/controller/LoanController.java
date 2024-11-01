package com.barbosa.loans.controller;

import com.barbosa.loans.controller.dto.CustomerLoanRequest;
import com.barbosa.loans.controller.dto.CustomerLoanResponse;
import com.barbosa.loans.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(value = "customer-loans")
    public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody CustomerLoanRequest request) {

        var loanResponse = loanService.checkLoanAvailability(request);
        return ResponseEntity.ok(loanResponse);
    }
}
