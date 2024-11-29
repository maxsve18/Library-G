package se.yrgo.booklibG;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanTest {

    //VG
    @Test
    public void testDueDate() {
        Customer customer = new Customer("Mr", "Tom", "Paris", "Something Street", "tom@paris.com", "2450", 4, GenderType.MALE);
        Book book2 = new Book(2, "Neuromancer", "William Gibson", "978 1 399 60777 3", "Gollancz", 297);
        Loan loan = new Loan(1, customer, book2);

        LocalDate expectedDueDate = LocalDate.now().plusDays(14);
        LocalDate actualDueDate = loan.getDueDate();

        assertEquals(expectedDueDate, actualDueDate);
    }
}