package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getTitle().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Book
            Smartphone smartphone = (Smartphone) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (smartphone.getManufacturer().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (smartphone.getTitle().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof TShirt) { // если в параметре product лежит объект класса Book
            TShirt tShirt = (TShirt) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (tShirt.getColor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (tShirt.getSize().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }


}
