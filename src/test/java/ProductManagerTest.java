import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(87, "Атлант расправил плечи. Непротиворечие", 450, "Айн Рэнд");
    Book book2 = new Book(88, "Атлант расправил плечи. Или-или", 450, "Айн Рэнд");
    Book book3 = new Book(89, "Атлант расправил плечи. А есть А", 780, "Айн Рэнд");
    Book book4 = new Book(37, "Гарри Поттер и философский камень", 640, "Джоан Роулинг");
    Book book5 = new Book(54, "Гарри Поттер и тайная комната", 638, "Джоан Роулинг");
    Book book6 = new Book(57, "Гарри Поттер и узник Азкабана", 706, "Джоан Роулинг");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(book6);
    }

    @Test
    public void shouldSearchByNameSome() {

        Product[] expected = {book4, book5, book6};
        Product[] actual = manager.searchBy("Гарри Поттер");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameOne() {

        Product[] expected = {book4};
        Product[] actual = manager.searchBy("Гарри Поттер и философский камень");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameNotFound() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Путь художника");

        Assertions.assertArrayEquals(expected, actual);
    }
}
