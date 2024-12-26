package animal;

public class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println(getClass().getSimpleName() + " is doing Wow");
    }
}
