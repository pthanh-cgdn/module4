package com.codegyme.sanwish.models;

public class Order {
    private int id;
    private String[] condiments;

    public Order(int id, String[] condiments) {
        this.id = id;
        this.condiments = condiments;
    }

    public Order(String[] condiments) {
        this.condiments = condiments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getCondiments() {
        return condiments;
    }

    public void setCondiments(String[] condiments) {
        this.condiments = condiments;
    }
    public String toString(){
        String condimentsString = "";
        for (int i = 0; i < condiments.length; i++) {
            condimentsString += condiments[i]+" ";
        }
        return condimentsString;
    }
}
