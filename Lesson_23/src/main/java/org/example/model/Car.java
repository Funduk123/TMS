package org.example.model;

import java.util.Objects;

public class Car {
    public long id;
    public String brand;
    public String model;

    public Car(long id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car " + id + ", brand: " + brand + ", model: " + model;
    }
}
