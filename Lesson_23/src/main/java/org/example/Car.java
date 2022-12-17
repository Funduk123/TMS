package org.example;

public class Car {
    private Integer id;
    private String brand;
    private String model;

    public Car() {
    }

    public Car(Integer id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Car: " +
                "id = " + id +
                ", brand = '" + brand + '\'' +
                ", model = '" + model + '\'' +
                '}';
    }
}
