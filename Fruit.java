package com.example.shiva.cureall;

public class Fruit {
   public int id;
   public String name;

    public Fruit( String name) {

        this.name = name;
    }

    public Fruit() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Fruit{name='" + name + '\'' +
                '}';
    }
}
