package test.com.example.creditapp;

import com.example.creditapp.model.Credit;
import com.example.creditapp.service.CreditSuggestionService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreditAppTests {

    @Test
    public void testAddAndSearchCredits() {
        CreditSuggestionService service = new CreditSuggestionService();

        Credit credit1 = new Credit("1", "Кредит на авто", "Банк А", 7.5, 100000, true, false);
        Credit credit2 = new Credit("2", "Іпотека", "Банк Б", 5.0, 500000, true, true);

        service.addCredit(credit1);
        service.addCredit(credit2);

        List<Credit> results = service.searchCredits(6.0, true, true);
        assertEquals(1, results.size());
        assertEquals("Іпотека", results.get(0).getName());
    }
}
