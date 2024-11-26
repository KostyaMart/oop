package com.example.creditapp.model;

public class Credit {
    private String id;
    private String name;
    private String bankName;
    private double interestRate;
    private double maxAmount;
    private boolean earlyRepaymentAvailable;
    private boolean creditLineIncreaseAvailable;

    public Credit(String id, String name, String bankName, double interestRate, double maxAmount,
                  boolean earlyRepaymentAvailable, boolean creditLineIncreaseAvailable) {
        this.id = id;
        this.name = name;
        this.bankName = bankName;
        this.interestRate = interestRate;
        this.maxAmount = maxAmount;
        this.earlyRepaymentAvailable = earlyRepaymentAvailable;
        this.creditLineIncreaseAvailable = creditLineIncreaseAvailable;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBankName() {
        return bankName;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public boolean isEarlyRepaymentAvailable() {
        return earlyRepaymentAvailable;
    }

    public boolean isCreditLineIncreaseAvailable() {
        return creditLineIncreaseAvailable;
    }

    @Override
    public String toString() {
        return String.format("Кредит: %s | Банк: %s | Відсоткова ставка: %.2f%% | Максимальна сума: %.2f | Дострокове погашення: %s | Збільшення лінії: %s",
                name, bankName, interestRate, maxAmount,
                earlyRepaymentAvailable ? "Так" : "Ні",
                creditLineIncreaseAvailable ? "Так" : "Ні");
    }
}
