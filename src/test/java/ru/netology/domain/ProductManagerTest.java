package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void shouldFind2equals() {
        ProductRepository repo = new ProductRepository();
        Product smartphone = new Smartphone(1, "Xperia", 1000, "Sony");
        Product book = new Book(2, "Remark", 100, "Sony", 400);
        Product tShirt = new TShirt(3, "Puma", 200, "Red", "XL");
        ProductManager productManager = new ProductManager(repo);
        productManager.add(smartphone);
        productManager.add(book);
        productManager.add(tShirt);

        Product[] actual = productManager.searchBy("Sony");
        Product[] expected = new Product[] {smartphone, book};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldFindEqual() {
        ProductRepository repo = new ProductRepository();
        Product smartphone = new Smartphone(1, "Xperia", 1000, "Sony");
        Product book = new Book(2, "Remark", 100, "Sony", 400);
        Product tShirt = new TShirt(3, "Puma", 200, "Red", "XL");
        ProductManager productManager = new ProductManager(repo);
        productManager.add(smartphone);
        productManager.add(book);
        productManager.add(tShirt);

        Product[] actual = productManager.searchBy("XL");
        Product[] expected = new Product[] {tShirt};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldFind3Equals() {
        ProductRepository repo = new ProductRepository();
        Product smartphone = new Smartphone(1, "Xperia", 1000, "Red");
        Product book = new Book(2, "Remark", 100, "Red", 400);
        Product tShirt = new TShirt(3, "Puma", 200, "Red", "XL");
        ProductManager productManager = new ProductManager(repo);
        productManager.add(smartphone);
        productManager.add(book);
        productManager.add(tShirt);

        Product[] actual = productManager.searchBy("Red");
        Product[] expected = new Product[] {smartphone, book, tShirt};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldNotFindEquals() {
        ProductRepository repo = new ProductRepository();
        Product smartphone = new Smartphone(1, "Xperia", 1000, "Sony");
        Product book = new Book(2, "Remark", 100, "Sony", 400);
        Product tShirt = new TShirt(3, "Puma", 200, "Red", "XL");
        ProductManager productManager = new ProductManager(repo);
        productManager.add(smartphone);
        productManager.add(book);
        productManager.add(tShirt);

        Product[] actual = productManager.searchBy("Apple");
        Product[] expected = new Product[] {};

        assertArrayEquals(expected,actual);
    }
}