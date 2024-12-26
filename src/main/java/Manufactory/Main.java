package Manufactory;

import Moto.Motocycle;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car();
        car1.setProducer("Honda");
        car1.setColor("white");
        car1.setCost(5999.0);

        car1.printCarCharacteristic(car1);

        Motocycle motocycle2 = new Motocycle();
        motocycle2.printCarCharacteristic(motocycle2);
    }
}
