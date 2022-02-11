package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    Product smartphone = new Smartphone(1, "Xperia", 1000, "Sony");
    Product book = new Book(2, "Remark", 100, "Sony");
    ProductManager productManager = new ProductManager(repo);

    @BeforeEach
    public void setUp() {
        productManager.add(smartphone);
        productManager.add(book);
    }

    @Test
    public void shouldFind2equals() {

        Product[] actual = productManager.searchBy("Sony");
        Product[] expected = new Product[] {smartphone, book};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldFindEqual() {

        Product[] actual = productManager.searchBy("Remark");
        Product[] expected = new Product[] {book};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldNotFindEquals() {

        Product[] actual = productManager.searchBy("Apple");
        Product[] expected = new Product[] {};

        assertArrayEquals(expected,actual);
    }
}