package inheritance;

public class GermanCar extends Car1 {

    public GermanCar(String model, String manufactured){
        this.model = model;
        this.manufactured = manufactured;
    }
    public GermanCar(){}

    public void setCarDetails(){
        manufactured = "Renault";
        model = "Grand Scenic";
    }

}
