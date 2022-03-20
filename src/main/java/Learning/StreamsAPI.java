package Learning;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

public class StreamsAPI {
    //What are Streams
    // Streams are used to perform Operations on Group of Elements of any squence or objects
    //Perform Printing Operations with Streams on Intgers,Strings,Characters,ArrayList,Arrays,Maps,boolean,Doubles etc

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.addAll(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println(input);
        ArrayList<String> strinput = new ArrayList<>();
        strinput.addAll(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaa"));
        System.out.println(strinput);
        ArrayList<String> strinput1 = strinput;
        //allMatch(Predicate<? super T> predicate)
        //Returns whether all elements of this stream match the provided predicate.
        boolean a = input.stream().allMatch(s -> s % 5 == 0);
        System.out.println(a);
        System.out.println(input.stream().allMatch(s -> s % 3 == 0));
        //Difference between value of and address comparision
        System.out.println("Result with Value of :" + strinput.stream().allMatch(ss -> ss.equals(String.valueOf(strinput1))));
        //Comparision without value of
        System.out.println("Result without Value of :" + strinput.stream().allMatch(ss -> ss.equals(strinput1)));

        //anyMatch
        //boolean anyMatch(Predicate<? super T> predicate)
        //Returns whether any elements of this stream match the provided predicate
        boolean b = input.stream().anyMatch(s -> s % 2 == 0);
        System.out.println(b);
        System.out.println(input.stream().anyMatch(s -> s % 7 == 0));
        //builder()
        //Returns a builder for a Stream.
        Stream<Integer> ss = Stream.of(9, 99, 999, 9999);
        System.out.println(Stream.builder());
        //collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
        //Performs a mutable reduction operation on the elements of this stream.
        System.out.println("Printing Collectors :" + ss.collect(toList()));
        Stream<Integer> ss1 = Stream.of(9, 99, 999, 9999);
        System.out.println("Printing Collectors are dividing by 9 :" + ss1.map(c -> c / 9).collect(toList()));
        //Reversing the String
        Stream<String> ss2 = Stream.of("a", "aa", "aaa", "aaaa");
        System.out.println("Printing Reverse :" + ss2.sorted(Comparator.reverseOrder()).collect(toList()));
        Stream<String> ss3 = Stream.of("a", "bb", "ccc", "dddd");
        System.out.println("Printing Joining :" + ss3.collect(Collectors.joining()));
        Stream<String> ss4 = Stream.of("a", "bb", "ccc", "dddd");
        System.out.println("Printing Joining with delimiter:" + ss4.collect(Collectors.joining(",")));
        Stream<String> ss5 = Stream.of("a", "bb", "ccc", "dddd");
        System.out.println("Printing Counting of String Stream elements :" + ss5.collect(Collectors.counting()));
        //Collectors Operations on Integers
        Stream<Integer> in1 = Stream.of(10, 5, 15, 23, 6, 9, 100, 1213, 9, 6, 3, 15);
        System.out.println("Printing the Integer elements in Streams :" + in1.collect(toList()));
        Stream<Integer> in2 = Stream.of(10, 10, 15, 15, 10);
        System.out.println("Printing the Integer elements in Streams :" + in2.collect(Collectors.averagingInt(s -> s)));
        Stream<Integer> in3 = Stream.of(10, 10, 15, 15, 10);
        System.out.println("Printing the Integer elements in Streams :" + in3.collect(Collectors.averagingDouble(s -> s * 2)));
        Stream<Integer> in4 = Stream.of(10, 10, 15, 15, 10);
        System.out.println("Printing the Integer elements in Streams :" + in4.collect(Collectors.summarizingLong(s -> s)));
        Stream<Integer> in5 = Stream.of(10, 10, 15, 15, 10);
        System.out.println("Printing the Integer elements in Streams :" + in5.collect(Collectors.groupingBy(s -> s)));
        Stream<Integer> in6 = Stream.of(10, 10, 15, 15, 10);
        System.out.println("Printing the Integer elements in Streams :" + in6.collect(Collectors.groupingByConcurrent(s -> s / 5)));
        Stream<Integer> in7 = Stream.of(10, 10, 15, 15, 10);
        System.out.println("Printing the Integer elements in Streams :" + in7.collect(Collectors.partitioningBy(s -> s % 5 == 0)));
        Stream<Integer> in8 = Stream.of(10, 10, 15, 15, 10);
        System.out.println("Printing the Integer elements in Streams :" + in8.collect(Collectors.partitioningBy(s -> s / 5 == 0)));
        Stream<Integer> in9 = Stream.of(10, 10, 15, 15, 10);
        System.out.println("Printing the Integer elements in Streams :" + in9.collect(Collectors.counting()));
        Stream<Integer> in10 = Stream.of(3, 10, 10, 15, 15, 10, 1);
        System.out.println("Printing the Integer elements in Streams :" + in10.collect(Collectors.maxBy((s1, s2) -> s1 > s2 ? 1 : 0)));
        Stream<Integer> in11 = Stream.of(3, 10, 10, 15, 15, 10, 1);
        System.out.println("Printing the Integer elements in Streams :" + in11.collect(Collectors.minBy(Comparator.naturalOrder())));
        //Concat
        Stream<String> ss6 = Stream.of("abc", "abcd", "abcde");
        Stream<String> ss7 = Stream.of("def", "efgh", "fghij");
        System.out.println(Stream.concat(ss6, ss7).collect(toList()));
        //count
        Stream<Integer> in12 = Stream.of(3, 10, 10, 15, 15, 10, 1);
        System.out.println(in12.count());
        //distinct
        Stream<Integer> in13 = Stream.of(3, 10, 10, 15, 15, 10, 1);
        System.out.println(in13.distinct().collect(toList()));
        //dropwhile
        //dropWhile(Predicate<? super T> predicate)
        //Returns, if this stream is ordered, a stream consisting of the remaining elements
        // of this stream after dropping the longest prefix of elements that match the given predicate.
        Stream<Integer> in14 = Stream.of(3, 10, 10, 15, 15, 10, 1);
        System.out.println("Dropwhile :" + in14.dropWhile(s -> s < 15).collect(toList()));
        Stream<Integer> in15 = Stream.of(3, 10, 10, 15, 15, 10, 1);
        System.out.println(in15.sorted().dropWhile(s -> s % 5 != 0).collect(toList()));
        Stream<Integer> in16 = Stream.of(3, 10, 10, 15, 15, 10, 17, 1, 15, 17, 10);
        System.out.println(in16.dropWhile(s -> s != 17).collect(toList()));
        //empty
        Stream<Integer> in17 = Stream.of(3, 10, 10, 15, 15, 10, 17, 1, 15, 17, 10);
        System.out.println(in17.sorted().collect(toList()).isEmpty());
        //Creating the Empty Stream
        Stream<String> ss8 = Stream.empty();
        System.out.println(ss8.collect(toList()));
        //filter method
        //String Methods
        Stream<String> ss9 = Stream.of("David", "Jhon", "David", "akshay", "Jackie");
        System.out.println(ss9.filter(s -> s != "David").collect(toList()));
        //First letter is J
        //Get the String starting with D
        String[] names = {"Sam", "Pamela", "Dave", "Pascal", "Erik"};
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names[i].length(); j++) {
                //System.out.println("for every i : "+names[i]+" you get "+ names[i].charAt(j));
                if (names[i].charAt(j) == 'D') {
                    System.out.println(names[i]);
                }

            }
        }
        Stream<String> ss10 = Stream.of("Sam", "Pamela", "Dave", "Pascal", "Erik");
        System.out.println(ss10.filter(i -> i.charAt(0) == 'D').collect(Collectors.joining()));

    }

}
