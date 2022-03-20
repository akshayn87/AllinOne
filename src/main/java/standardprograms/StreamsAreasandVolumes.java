package standardprograms;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;

public class StreamsAreasandVolumes {


    public static ArrayList<Double> Inputs() {
        ArrayList<Double> input = new ArrayList<>();
        input.add(5.00);
        input.add(8.00);
        input.add(6.00);
        input.add(2.00);

        return input;
    }

    public static void main(String[] args) {
        Consumer<Double> square = i -> {
            System.out.println("Square of " + i + " is " + i * i);
        };
        Inputs().stream().forEach(square);
        //or in one line
        Inputs().stream().forEach(i -> System.out.println("Square of " + i + " is " + (i * i) + " with Streams"));
        Inputs().stream().forEach(i -> System.out.println("Area Of Circle of " + i + " is " + 3.14 * i * i));
        int[] lengths = {9, 5, 6, 7, 9, 11};
        int[] Breadths = {19, 15, 60, 9, 21, 13};
        for (int i = 0; i < lengths.length; i++) {
            System.out.println("Area of Rectangle :" + lengths[i] * Breadths[i]);
        }
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.addAll(Arrays.asList(2, 3, 5, 10));
        double Sum = listOfIntegers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Sum of list Of Integers :" + Sum);
        //We already have import java.util.*; then why we require to define import java.util.function.*;
        //If you want to make sub packages in the interface available we require to call the package
        //until subpackage level
        //To convert Stream of Objects into Array using toArray();
        //Reason :Array are better in performance compared to streams
        Double[] i = Inputs().stream().toArray(Double[]::new);
        for (Double i1 : i) {
            System.out.println("Get array values :" + i1);
        }
        //or in one line
        // Stream.of(i).forEach(System.out::println);
        Stream.of(i).forEach(s -> System.out.println("Get Array in one line :" + s));
        Stream<Integer> s = Stream.of(9, 99, 999, 9999);
        s.forEach(System.out::println);
        s.close();
        //java.lang.IllegalStateException: stream has already been operated upon or closed
        Stream<Integer> ss = Stream.of(9, 99, 999, 9999);
        ss.forEach(s1 -> System.out.println("The 9's Stream :" + s1));
        //System.out.println(s.count());
        Stream<Integer> sss = Stream.of(9, 99, 999, 9999);
        System.out.println(sss.max(Comparator.naturalOrder()));
        //System.out.println(s.max((s1,s2)->s2.compareTo(s1)).get());
        Integer[] j = {110, 20, 30, 40, 50, 60};
        Stream.of(j).sorted().forEach(System.out::println);
        //or
        Stream.of(j).sorted().forEach(jsorted -> System.out.println("Ascending Sorted Order :" + jsorted));
        Stream.of(j).sorted((i1, i2) -> -i1.compareTo(i2)).forEach(System.out::println);
        //or
        Stream.of(j).sorted((i1, i2) -> -i1.compareTo(i2)).forEach(jdescendingsortted -> System.out.println("Descending :" + jdescendingsortted));
        Stream.of(j).filter(k -> k % 3 == 0).forEach(k -> System.out.println("Multiples of 3 are " + k));

    }
}
