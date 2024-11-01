package com.barbosa.loans.domain;

import com.barbosa.loans.expections.LoanIsNotAvailableException;

public class Loan {

    Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable() {
        return basicLoanAvailable();
    }

    public double getPersonalLoanInterestRate() {
        if (isPersonalLoanAvailable()) {
            return 4.0;
        }

        throw new LoanIsNotAvailableException();
    }

    public boolean getConsignedLoanAvailable() {
        return customer.isIncomeEqualOrGreaterThan(5000.00);
    }

    public double getConsignedLoanInterestRate() {
        if (getConsignedLoanAvailable()) {
            return 2.0;
        }

        throw new LoanIsNotAvailableException();
    }

    public boolean getGuaranteedLoanAvailable() {
        return basicLoanAvailable();
    }

    public double getGuaranteedLoanInterestRate() {
        if (isPersonalLoanAvailable()) {
            return 3.0;
        }

        throw new LoanIsNotAvailableException();
    }

    public boolean basicLoanAvailable() {

        if (customer.isIncomeEqualOrLowerThan(3000.00)) {
            return true;
        }

        return customer.isIncomeBetween(3000.00, 5000.00)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }
}
