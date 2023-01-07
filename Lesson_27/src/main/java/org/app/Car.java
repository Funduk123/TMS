package org.app;

public class Car {

    private Long id;
    private String brand;
    private String model;
    private Long cost;

    public Car() {
    }

    public Car(Long id, String brand, String model, Long cost) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                '}';
    }
}
