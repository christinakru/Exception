package org.exception;

public class ProductManager {
    private Repository repository;

    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.addProduct(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                int size = result.length;
                Product[] newRes = new Product[size + 1];
                System.arraycopy(result, 0, newRes, 0, size);
                newRes[size] = product;
                result = newRes;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}
