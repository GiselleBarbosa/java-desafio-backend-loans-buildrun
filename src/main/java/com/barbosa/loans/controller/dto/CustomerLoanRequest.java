package com.barbosa.loans.controller.dto;

public record CustomerLoanRequest(
        Integer age,
        String cpf,
        String name,
        Double income,
        String location
) {
}
