package inheritance;

import Manufactory.JapanesesCar;

public class Main {
    public static void main(String[] args) {
        GermanCar germanCar = new GermanCar("308", "Pegeuot" );
        System.out.println(germanCar.model);
        System.out.println(germanCar.manufactured);

        JapanesesCar japanesesCar = new JapanesesCar();
        japanesesCar.manufactured = "toyota";
        
    }
}
