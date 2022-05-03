package Learning;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsConversions {
    public static void main(String[] args) {
        Integer[] a = {33, 3, 4, 5};//declaration, instantiation and initialization
        System.out.println(Arrays.toString(a));
        List<Integer> list = Arrays.stream(a).collect(Collectors.toList());
        System.out.println(list);
        Set<Integer> set = Arrays.stream(a).collect(Collectors.toSet());
        System.out.println(set);
        //Arrays to Queue
        Queue<Integer> possibleRewards = new LinkedBlockingQueue<>();
        possibleRewards = Arrays.stream(a).collect(Collectors.toCollection(PriorityQueue::new));
        System.out.println(possibleRewards);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.stream().collect(Collectors.toCollection(LinkedBlockingQueue::new));
        System.out.println("Linked :-" + queue);
        queue.stream().forEach(System.out::println);
        Stack<Integer> stk = new Stack<>();
        stk = Arrays.stream(a).collect(Collectors.toCollection(Stack::new));
        System.out.println("Stack is :- " + stk);
        Map<String, Double> kvs =
                Arrays.asList("a:1.0", "b:2.0", "c:3.0")
                        .stream()
                        .map(elem -> elem.split(":"))
                        .filter(elem -> elem.length == 2)
                        .collect(Collectors.toMap(e -> e[0], e -> Double.parseDouble(e[1])));

        System.out.println(kvs);

    }

}
