import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    public void matchesBookByName() {

        Book book = new Book(87, "Атлант расправил плечи. Непротиворечие", 450, "Айн Рэнд");

        boolean expected = true;
        boolean actual = book.matches("Атлант");

        Assertions.assertTrue(expected);
    }

    @Test
    public void matchesBookByAuthor() {
        Book book = new Book(87, "Атлант расправил плечи. Непротиворечие", 450, "Айн Рэнд");

        boolean expected = true;
        boolean actual = book.matches("энд");

        Assertions.assertTrue(expected);

    }

    @Test
    public void matchesBookByNameNotFound() {

        Book book = new Book(87, "Атлант расправил плечи. Непротиворечие", 450, "Айн Рэнд");

        boolean expected = false;
        boolean actual = book.matches("Harry");

        Assertions.assertFalse(expected);
    }

    @Test
    public void matchesBookByAuthorNotFound() {

        Book book = new Book(87, "Атлант расправил плечи. Непротиворечие", 450, "Айн Рэнд");

        boolean expected = false;
        boolean actual = book.matches("энд");

        Assertions.assertFalse(expected);

    }

    @Test
    public void matchesSmartphoneByName() {

        Smartphone smartphone = new Smartphone(34, "Samsung A52", 14000, "Hungary");

        boolean expected = true;
        boolean actual = smartphone.matches("Sam");

        Assertions.assertTrue(expected);
    }

    @Test
    public void matchesSmartphoneByMadeIn() {

        Smartphone smartphone = new Smartphone(34, "Samsung A52", 14000, "Hungary");

        boolean expected = true;
        boolean actual = smartphone.matches("Hungary");

        Assertions.assertTrue(expected);
    }

    @Test
    public void matchesSmartphoneByNameNotFound() {

        Smartphone smartphone = new Smartphone(34, "Samsung A52", 14000, "Hungary");

        boolean expected = false;
        boolean actual = smartphone.matches("iPhone");

        Assertions.assertFalse(expected);
    }

    @Test
    public void matchesSmartphoneByMadeInNotFound() {

        Smartphone smartphone = new Smartphone(34, "Samsung A52", 14000, "Hungary");

        boolean expected = false;
        boolean actual = smartphone.matches("China");

        Assertions.assertFalse(expected);
    }
}
