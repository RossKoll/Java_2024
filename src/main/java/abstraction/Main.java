package abstraction;

public class Main {
    public static void main(String[] args) {
        MobilePhone mobilePhone;
        mobilePhone = new Android();
        mobilePhone.doubleTap();

        mobilePhone = new IOS();
        mobilePhone.doubleTap();
    }
}
