package com.barbosa.loans.services.strategy;

import com.barbosa.loans.domain.Customer;

public class ConsignedLoanStrategy implements LoanStrategy {

    @Override
    public boolean isLoanAvailable(Customer customer) {
        return customer.isIncomeEqualOrGreaterThan(5000.00);
    }

    @Override
    public double getInterestRate() {
        return 2.0;
    }
}
