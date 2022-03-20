package standardprograms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingBasedOnIncreasingLength {

    public static ArrayList<String> SortingBasedOnLength() {
        ArrayList<String> Names = new ArrayList<>();
        Names.add("Sunny Leone");
        Names.add("Kajal");
        Names.add("Prabhas");
        Names.add("Anushka");
        Names.add("Mallika");
        Names.add("Pooja");
        System.out.println(Names);
        List<String> sortedList = Names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        //(s1,s2)->s1.compareTo(s2) ==>Natural Sorting Order
        //(s1,s2)->s2.compareTo(s1) ==>Reverse Order
        //(s1,s2)->-s1.compareTo(s2) ==>Reverse Order
        //Getting the Sorting based on increasing length we Use Comparator
        Comparator<String> c = (s1, s2) -> {
            int l1 = s1.length();
            int l2 = s2.length();
            if (l1 < l2) return -1;
            else if (l2 < l1) return 1;
            else return s1.compareTo(s2);
        };
        List<String> sortedListbasedOnLength = Names.stream().sorted(c).collect(Collectors.toList());
        System.out.println(sortedListbasedOnLength);
        return Names;
    }

    public static void main(String[] args) {
        SortingBasedOnLength();
    }

}
