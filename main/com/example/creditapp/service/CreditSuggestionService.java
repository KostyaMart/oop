package com.example.creditapp.service;

import com.example.creditapp.model.Credit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreditSuggestionService {
    private List<Credit> credits = new ArrayList<>();

    public void addCredit(Credit credit) {
        credits.add(credit);
    }

    public List<Credit> searchCredits(double maxInterestRate, boolean earlyRepayment, boolean creditLineIncrease) {
        return credits.stream()
                .filter(credit -> credit.getInterestRate() <= maxInterestRate)
                .filter(credit -> !earlyRepayment || credit.isEarlyRepaymentAvailable())
                .filter(credit -> !creditLineIncrease || credit.isCreditLineIncreaseAvailable())
                .collect(Collectors.toList());
    }

    public List<Credit> getAllCredits() {
        return new ArrayList<>(credits);
    }
}
