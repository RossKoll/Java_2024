package interfaces;

public class SecondClass implements Int_second{
    @Override
    public void doFirst() {
        System.out.println("Implementation of first Interface");
    }

    @Override
    public void doSecond() {
        System.out.println("Implementation of second Interface");
    }
}
