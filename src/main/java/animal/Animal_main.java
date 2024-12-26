package animal;

public class Animal_main {
    public static void main(String[] args) {
     makeSound(new Cat());
     makeSound(new Dog());
    }

    public static void makeSound(Animal animal){
        animal.sound();
    }
}
