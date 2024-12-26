package animal;

public class Cat extends Animal{

    @Override
    public void sound() {
        System.out.println(""+ getClass().getSimpleName() + " is doing meo");
    }
}
