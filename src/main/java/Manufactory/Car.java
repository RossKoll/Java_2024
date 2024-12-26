package Manufactory;

public class Car {
    private String color;
    private String producer;
    private double cost;

    protected void printCarCharacteristic(Car car){
        System.out.println(String.format("The %s has %s color and cost %s",
                car.getProducer(),
                car.getColor(),
                car.getCost()));
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
}
