package model;

public class Car {

    private String name;
    private Integer noOfWheels;
    private Boolean isElectric;
    private Double cost;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, Integer noOfWheels, Boolean isElectric, Double cost) {
        this.name = name;
        this.noOfWheels = noOfWheels;
        this.isElectric = isElectric;
        this.cost = cost;
    }

    public Car() {
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public String getName() {
        return name;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", noOfWheels=" + noOfWheels +
                ", isElectric=" + isElectric +
                ", cost=" + cost +
                '}';
    }


}
