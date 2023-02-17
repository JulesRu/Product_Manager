import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Book book1 = new Book(87, "Атлант расправил плечи. Непротиворечие", 450, "Айн Рэнд");
    Book book2 = new Book(88, "Атлант расправил плечи. Или-или", 450, "Айн Рэнд");
    Book book3 = new Book(89, "Атлант расправил плечи. А есть А", 780, "Айн Рэнд");
    Smartphone smartphone1 = new Smartphone(34, "Samsung A52", 14000, "Hungary");
    Smartphone smartphone2 = new Smartphone(42, "iPhone 5s", 15000, "China");
    Smartphone smartphone3 = new Smartphone(2, "Huawei nova", 14500, "China");

    @Test
    public void findByIdFound() {

        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone3);
        repo.save(smartphone2);

        Product expected = book2;
        Product actual = repo.findById(88);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByIdNotFound() {

        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone3);
        repo.save(smartphone2);

        Product expected = null;
        Product actual = repo.findById(66);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeByIdExist() {

        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone3);
        repo.save(smartphone2);
        repo.removeById(88);

        Product[] expected = {book1, book3, smartphone1, smartphone3, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdNotFound() {

        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone3);
        repo.save(smartphone2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(64);
        });
    }

    @Test
    public void shouldSaveByNewId() {

        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(smartphone2);

        Product[] expected = {book1, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSaveSameIdItem() {

        ProductRepository repo = new ProductRepository();
        Book book4 = new Book(87, "Атлант расправил плечи. А есть А", 780, "Айн Рэнд");

        repo.save(book1);
        repo.save(book2);


        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(book4);
        });
    }
}
