package arrays;

import java.util.HashSet;

public class UniqueHashSet {
    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i <= 5; i++ ){
            hashSet.add(i);
        }
        System.out.println("hasSet1 = " + hashSet);

        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int i = 4; i <=10; i++){
            hashSet2.add(i);
        }

        System.out.println("hashSet2 = " + hashSet2);

        hashSet.retainAll(hashSet2);

        System.out.println("retainAll = " + hashSet);

    }
}
