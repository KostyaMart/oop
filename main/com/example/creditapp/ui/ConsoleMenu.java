package com.example.creditapp.ui;

import com.example.creditapp.model.Credit;
import com.example.creditapp.service.CreditSuggestionService;
import com.example.creditapp.storage.FileStorage;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private static CreditSuggestionService creditService = new CreditSuggestionService();
    private static FileStorage fileStorage = new FileStorage();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Кредитний додаток ===");
            System.out.println("1. Додати кредит");
            System.out.println("2. Пошук кредиту");
            System.out.println("3. Зберегти кредити у файл");
            System.out.println("4. Завантажити кредити з файлу");
            System.out.println("5. Вихід");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистити вхідний потік

            switch (choice) {
                case 1:
                    addCredit(scanner);
                    break;
                case 2:
                    searchCredits(scanner);
                    break;
                case 3:
                    saveCredits();
                    break;
                case 4:
                    loadCredits();
                    break;
                case 5:
                    System.out.println("До побачення!");
                    return;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void addCredit(Scanner scanner) {
        System.out.print("Назва кредиту: ");
        String name = scanner.nextLine();
        System.out.print("Назва банку: ");
        String bankName = scanner.nextLine();
        System.out.print("Відсоткова ставка: ");
        double interestRate = scanner.nextDouble();
        System.out.print("Максимальна сума: ");
        double maxAmount = scanner.nextDouble();
        System.out.print("Дострокове погашення (true/false): ");
        boolean earlyRepayment = scanner.nextBoolean();
        System.out.print("Збільшення кредитної лінії (true/false): ");
        boolean creditLineIncrease = scanner.nextBoolean();

        Credit credit = new Credit(String.valueOf(System.currentTimeMillis()), name, bankName, interestRate, maxAmount,
                earlyRepayment, creditLineIncrease);
        creditService.addCredit(credit);
        System.out.println("Кредит успішно додано!");
    }

    private static void searchCredits(Scanner scanner) {
        System.out.print("Максимальна відсоткова ставка: ");
        double maxInterestRate = scanner.nextDouble();
        System.out.print("Дострокове погашення (true/false): ");
        boolean earlyRepayment = scanner.nextBoolean();
        System.out.print("Збільшення кредитної лінії (true/false): ");
        boolean creditLineIncrease = scanner.nextBoolean();

        List<Credit> results = creditService.searchCredits(maxInterestRate, earlyRepayment, creditLineIncrease);
        if (results.isEmpty()) {
            System.out.println("Кредитів не знайдено.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private static void saveCredits() {
        try {
            fileStorage.saveCredits(creditService.getAllCredits());
            System.out.println("Кредити збережено успішно!");
        } catch (Exception e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }

    private static void loadCredits() {
        try {
            List<Credit> credits = fileStorage.loadCredits();
            credits.forEach(creditService::addCredit);
            System.out.println("Кредити завантажено успішно!");
        } catch (Exception e) {
            System.out.println("Помилка завантаження: " + e.getMessage());
        }
    }
}
