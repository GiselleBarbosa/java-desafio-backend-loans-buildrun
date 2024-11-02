package com.barbosa.loans.services;

import com.barbosa.loans.controller.dto.CustomerLoanRequest;
import com.barbosa.loans.controller.dto.CustomerLoanResponse;
import com.barbosa.loans.controller.dto.LoanResponse;
import com.barbosa.loans.domain.Customer;
import com.barbosa.loans.domain.enums.LoanType;
import com.barbosa.loans.services.strategy.ConsignedLoanStrategy;
import com.barbosa.loans.services.strategy.GuaranteedLoanStrategy;
import com.barbosa.loans.services.strategy.LoanStrategy;
import com.barbosa.loans.services.strategy.PersonalLoanStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    private final List<LoanStrategy> loanStrategies;

    public LoanService(List<LoanStrategy> loanStrategies) {
        this.loanStrategies = loanStrategies;
    }

    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest request) {
        Customer customer = request.toCustomer();
        List<LoanResponse> loans = new ArrayList<>();

        for (LoanStrategy strategy : loanStrategies) {
            if (strategy.isLoanAvailable(customer)) {
                LoanType loanType = getLoanTypeFromStrategy(strategy);
                loans.add(new LoanResponse(loanType, strategy.getInterestRate()));
                ;
            }
        }

        return new CustomerLoanResponse(request.name(), loans);
    }

    private LoanType getLoanTypeFromStrategy(LoanStrategy strategy) {
        if (strategy instanceof PersonalLoanStrategy) {
            return LoanType.PERSONAL;
        } else if (strategy instanceof ConsignedLoanStrategy) {
            return LoanType.CONSIGNMENT;
        } else if (strategy instanceof GuaranteedLoanStrategy) {
            return LoanType.GUARANTEED;
        }
        throw new IllegalArgumentException("Tipo de empréstimo não suportado: " + strategy.getClass().getSimpleName());
    }

}
