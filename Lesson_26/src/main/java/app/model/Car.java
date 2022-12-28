package app.model;

public class Car {
    public long id;
    public String brand;
    public String model;
    public int cost;

    public Car() {
    }

    public Car(long id, String brand, String model, int cost) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.cost = cost;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car " + id +
                " | Brand: " + brand +
                ", Model: " + model +
                ", Cost: " + cost;
    }
}
