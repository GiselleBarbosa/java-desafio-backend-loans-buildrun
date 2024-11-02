package com.barbosa.loans.services.strategy;

import com.barbosa.loans.domain.Customer;

public class GuaranteedLoanStrategy implements LoanStrategy {

    @Override
    public boolean isLoanAvailable(Customer customer) {
        return customer.isIncomeBetween(1000.00, 5000.00) &&
                customer.isAgeLowerThan(30) &&
                customer.isFromLocation("SP");
    }

    @Override
    public double getInterestRate() {
        return 3.0;
    }
}