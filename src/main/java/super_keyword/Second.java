package super_keyword;

public class Second extends First {
    public void doThis(){
        System.out.println("Do this from Second");
    }

    public void xyz(){
        super.doThis();
        System.out.println("Executed from Second");
    }
}
