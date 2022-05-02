package Learning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        DefineSets();
        SetsOperations();
        addorremoveelementfromSet();
        sortedset();
        addingtwoSets();
        getElementByIndex();
    }

    public static void DefineSets() {
        Set<String> hash_Set = new HashSet<String>();

        // Adding elements to the Set
        // using add() method
        hash_Set.add("Geeks");
        hash_Set.add("For");
        hash_Set.add("Geeks");
        hash_Set.add("Example");
        hash_Set.add("Set");

        // Printing elements of HashSet object
        System.out.println(hash_Set);
    }

    public static void SetsOperations() {
        Set<Integer> a = new HashSet<Integer>();
        a.addAll(Arrays.asList(1, 3, 2, 4, 8, 9, 0));
        System.out.println(a);
        Set<Integer> b = new HashSet<Integer>();
        b.addAll(Arrays.asList(1, 3, 7, 5, 4, 0, 7, 5));
        System.out.println(b);
        // To find union
        Set<Integer> union = new HashSet<Integer>(a);
        union.addAll(b);
        System.out.print("Union of the two Set");
        System.out.println(union);

        // To find intersection
        Set<Integer> intersection = new HashSet<Integer>(a);
        intersection.retainAll(b);
        System.out.print("Intersection of the two Set");
        System.out.println(intersection);

        // To find the symmetric difference
        Set<Integer> difference = new HashSet<Integer>(a);
        difference.removeAll(b);
        System.out.print("Difference of the two Set");
        System.out.println(difference);

    }

    public static void addorremoveelementfromSet() {
        Set<Integer> a = new HashSet<Integer>();
        a.addAll(Arrays.asList(1, 3, 2, 4, 8, 9, 0));
        System.out.println("Elements of set a" + a);
        Set<Integer> b = new HashSet<Integer>();
        b.addAll(Arrays.asList(1, 3, 7, 5, 4, 0, 7, 5));
        System.out.println("Elements of set b" + b);
        a.remove(0);
        System.out.println(a);
        a.add(5);
        a.add(5);
        a.add(10);
        System.out.println(a);
        System.out.println("Empty Set :-" + b.isEmpty());
        System.out.println("Empty Set size : " + b.size());
    }

    public static void sortedset() {
        Set<Integer> a = new HashSet<Integer>();
        a.addAll(Arrays.asList(11, 13, 2, 4, 8, 9, 0));
        System.out.println("Elements of set a : " + a);
        a.stream().sorted();
        System.out.println("Sorted Set : " + a);

    }

    public static void addingtwoSets() {
        Set<Integer> a = new HashSet<Integer>();
        a.addAll(Arrays.asList(1, 3, 2, 4, 8, 9, 0));
        System.out.println("Elements of set a" + a);
        Set<Integer> b = new HashSet<Integer>();
        b.addAll(Arrays.asList(1, 3, 7, 5, 4, 0, 7, 5));
        System.out.println("Elements of set b" + b);
        Set<Integer> c = new HashSet<Integer>();
        c.addAll(Arrays.asList(new Integer[]{}));
        System.out.println("Elements of set c" + c);
        a.addAll(b);
        System.out.println(a);
        for (int i : b) {
            for (int j : a) {
                int k = i * j;
                c.add(k);
            }

        }
        System.out.println(c);
    }

    public static void getElementByIndex() {
        Set<Integer> a = new HashSet<Integer>();
        a.addAll(Arrays.asList(1, 3, 2, 4, 8, 9, 0));
        System.out.println("Elements of set a" + a);
        Integer[] a_element = a.toArray(new Integer[a.size()]);
        // Accessing elements by index
        System.out.println("Element at index 3 is: " + a_element[5]);

    }

}
