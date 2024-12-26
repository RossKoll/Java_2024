package array_daysOfTheWeek;

import java.util.ArrayList;
import java.util.ListIterator;

public class DayOfTheWeeks {
    public static void main(String[] args) {
        String[] daysOfTheWeek = {"Mon","Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (int i = 0; i <= daysOfTheWeek.length-1; i++){
            System.out.println(daysOfTheWeek[i]);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < 8; i++){
            arr.add(i);
        }

        System.out.println("-----------------");
        ListIterator<Integer> iteration = arr.listIterator();

        for (Integer element : arr) {
            System.out.println(element);
        }

        System.out.println("----- Iteration ------");
//        while (iteration.hasNext()){
//            System.out.println(iteration.next());
//        }

//        while (iteration.hasPrevious()){
//            System.out.println(iteration.previous());
//        }

        while (iteration.hasNext()){
           int i = iteration.next();
           if(i % 2 == 1){
               i++;
               iteration.set(i);
           }
        }

        System.out.println(arr);

    }


}
