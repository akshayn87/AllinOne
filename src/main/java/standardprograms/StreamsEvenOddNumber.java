package standardprograms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsEvenOddNumber {


    public static ArrayList voidtreamsExample() {
        ArrayList<Integer> Marks = new ArrayList<Integer>();
        Marks.add(0);
        Marks.add(5);
        Marks.add(10);
        Marks.add(15);
        Marks.add(20);
        Marks.add(25);
        System.out.println(Marks);
        ArrayList<Integer> MarksFilteredEven = (ArrayList<Integer>) Marks.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(MarksFilteredEven);
        //Count the Even number of Marks Students
        long MarksFilteredEvenCount = Marks.stream().filter(i -> i % 2 == 0).count();
        System.out.println("Even Marks Counts :" + MarksFilteredEvenCount);
        //get the Sorted List -default or natural Sorting Ascending Order
        List<Integer> SortedEvenmarks = Marks.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        System.out.println("Sorted Marks :-" + SortedEvenmarks);
        //get Sorted in Descending order
        // We will use Comparator Object Comparator -->Compare(i1,i2) e.g Compare(10,20) which is bigger?
        // +ve if i1<i2 , -ve if i1>i2 and 0 if i1=i2
        //(i1,i2)->(i1<i2)?1:(i1>i2)?-1:0
        List<Integer> MarksDescending = Marks.stream().sorted((i1, i2) -> (i1 < i2) ? 1 : (i1 > i2) ? -1 : 0).collect(Collectors.toList());
        System.out.println("Sorted Descending Marks Order :" + MarksDescending);
        //Descending Order using default Comparable having -->CompareTo() Method
        List<Integer> MarksDescendingwithComparator = Marks.stream().sorted((i1, i2) -> -i1.compareTo(i2)).collect(Collectors.toList());
        System.out.println("Sorted Descending Marks Order :" + MarksDescendingwithComparator);
        //More Alternative Reversing Methods
        // i2.compare(i1) or -i1.compareTo(i2))

        ArrayList<Integer> MarksFilteredOdd = (ArrayList<Integer>) Marks.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        System.out.println(MarksFilteredOdd);
        //Add 5 Marks for each Student as Grace marks for each and every Student
        //Predicate -returns only boolean value- filter method use this
        // map - uses fuction and can return any value
        ArrayList<Integer> MarksAddGrace = (ArrayList<Integer>) Marks.stream().map(i -> i + 5).collect(Collectors.toList());
        System.out.println(MarksAddGrace);
        return Marks;

    }

    public static void main(String[] args) {
        voidtreamsExample();
    }
}
