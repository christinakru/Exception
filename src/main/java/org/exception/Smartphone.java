package org.exception;

public class Smartphone extends Product {
    private String vendor;

    public Smartphone(int id, String name, int cost, String vendor) {
        super(id, name, cost);
        this.vendor = vendor;
    }
}
