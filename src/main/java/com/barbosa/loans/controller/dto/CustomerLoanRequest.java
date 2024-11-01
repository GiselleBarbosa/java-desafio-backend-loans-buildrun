package com.barbosa.loans.controller.dto;

import com.barbosa.loans.domain.Customer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerLoanRequest(
        @Min(18) @NotNull Integer age,
        @CPF String cpf,
        @NotBlank String name,
        @Min(1000) @NotNull Double income,
        @NotBlank String location
) {
    public Customer toCustomer() {
        return new Customer(age, cpf, name, income, location);
    }
}
