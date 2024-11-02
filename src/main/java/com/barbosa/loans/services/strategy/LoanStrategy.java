package com.barbosa.loans.services.strategy;

import com.barbosa.loans.domain.Customer;

public interface LoanStrategy {
    boolean isLoanAvailable(Customer customer);

    double getInterestRate();
}