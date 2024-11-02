package com.barbosa.loans.config;

import com.barbosa.loans.services.strategy.ConsignedLoanStrategy;
import com.barbosa.loans.services.strategy.GuaranteedLoanStrategy;
import com.barbosa.loans.services.strategy.LoanStrategy;
import com.barbosa.loans.services.strategy.PersonalLoanStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoanStrategyConfig {

    @Bean
    public List<LoanStrategy> loanStrategies() {
        return List.of(
                new PersonalLoanStrategy(),
                new ConsignedLoanStrategy(),
                new GuaranteedLoanStrategy()
        );
    }
}
