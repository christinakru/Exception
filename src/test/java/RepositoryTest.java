import org.junit.jupiter.api.Test;
import org.exception.*;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {
    @Test
    void testAddProduct() {
        Repository repository = new Repository();
        Book book = new Book(1, "Гарри Поттер", 100, "J. Roalling");
        Smartphone smartphone = new Smartphone(2, "iPhone 14", 1000, "Apple");

        repository.addProduct(book);
        repository.addProduct(smartphone);
        Product[] repositoryProducts = repository.findAll();

        assertEquals(2, repositoryProducts.length);
        assertEquals(book, repositoryProducts[0]);
        assertEquals(smartphone, repositoryProducts[1]);
    }

    @Test
    public void testRemoveProduct() {
        Repository repo = new Repository();
        Book book = new Book(1, "Гарри Поттер", 100, "J. Roalling");
        Smartphone smartphone = new Smartphone(2, "iPhone 14", 1000, "Apple");

        repo.addProduct(book);
        repo.addProduct(smartphone);
        repo.removeProduct(1);

        Product[] products = repo.findAll();
        assertEquals(1, products.length);
        assertEquals(smartphone, products[0]);
    }

    @Test
    public void testRemoveProductWithNonExistingId() {
        Repository repo = new Repository();
        Book book = new Book(1, "Гарри Поттер", 100, "J. Roalling");
        Smartphone smartphone = new Smartphone(2, "iPhone 14", 1000, "Apple");

        repo.addProduct(book);
        repo.addProduct(smartphone);
        repo.removeProduct(1);

        Product[] products = repo.findAll();

        assertEquals(1, products.length);
        assertEquals(smartphone, products[0]);

        assertThrows(NotFoundException.class, () -> repo.removeProduct(1));
    }
}
