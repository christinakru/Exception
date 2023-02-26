package org.exception;

public abstract class Product {
    private int ID;
    private String name;
    private int cost;

    public Product(int id, String name, int cost) {
        ID = id;
        this.name = name;
        this.cost = cost;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
