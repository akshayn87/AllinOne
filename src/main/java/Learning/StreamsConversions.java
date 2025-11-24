package Learning;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsConversions {
    public static void main(String[] args) {
        ArrayToForms();
        ListToForms();
        setsToForms();
        QueueToForms();
        StackToForms();
        MaptoForms();
    }



    private static void ArrayToForms() {
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

    public static void ListToForms(){
        List<String> list =new ArrayList<>();
        List<Integer> numlist =new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        list.add("Mohan");
        list.add("Rohan");
        list.add("Sohan");
        list.add("Boman");
        System.out.println(list);

        String[] array = list.stream().toArray(String[]::new);
        System.out.println("Using Streams only :-"+Arrays.asList(array));
        String[] array1 = list.stream().toArray(n -> new String[n]);
        System.out.println("Using Lambda expression only :-"+Arrays.asList(array1));
        Integer[] array2 = numlist.stream().toArray(Integer[]::new);
        System.out.println("Using Streams for Number arrays only :-"+Arrays.asList(array2));

        Set<String> hSet = new HashSet<String>(list);
        hSet.addAll(list);
        System.out.println("Created HashSet is");
//        for (String x : hSet)
//            System.out.println(x);
        System.out.println("String Set :-"+hSet);
        Set<Integer> set = numlist.stream().collect(Collectors.toSet());
        System.out.println("Number Set :-"+set);

        Stack<String> st = new Stack<String>();

        st.addAll(list);
        System.out.println("Stack is :"+st);

        Queue<String> strqueue = new LinkedList<>(list);
        Queue<String> numqueue = new LinkedList<>(list);
        System.out.println(strqueue);
        System.out.println(numqueue);

        List<String> keys = Arrays.asList("A", "B", "C");
        List<String> values = Arrays.asList("1", "2", "3");
        List<Integer> values1 = Arrays.asList(1, 2, 3);

        Map<String, String> map = IntStream.range(0, keys.size())
                .collect(HashMap::new, (m, i) -> m.put(keys.get(i), values.get(i)), Map::putAll);
        System.out.println("MAP with String and String :-"+map);
        Map<String, String> map1 = IntStream.range(0, keys.size())
                .collect(HashMap::new, (m, i) -> m.put(keys.get(i), String.valueOf(values1.get(i))), Map::putAll);
        System.out.println("MAP with String and Integer:-"+map1);

    }
    public static void setsToForms() {
        Set<String> strs = new HashSet<String>();
        strs.add("Welcome");
        strs.add("to");
        strs.add("java");
        Set<Integer> ints = new HashSet<Integer>();
        ints.add(20);
        ints.add(50);
        ints.add(40);
        ints.add(10);
        ints.add(10);
        ints.add(60);
        System.out.println(strs);
        System.out.println(ints);
        String[] strarr = strs.stream().toArray(String[]::new);
        Integer[] intarr = ints.stream().toArray(Integer[]::new);


        System.out.println("Set to String Array :-" + Arrays.toString(strarr));
        System.out.println("Set to Integer Array :-" + Arrays.toString(intarr));

        List<Integer> intlist = ints.stream().collect(Collectors.toList());
        System.out.println("Integer Set to Integer List :-" + intlist);
        List<String> strlist = strs.stream().collect(Collectors.toList());
        System.out.println("String Set to String List :-" + strlist);

        // convert a set to stream
        Stream<Integer> stream = ints.stream();
        Queue strq = new LinkedTransferQueue();
        Queue intq = new LinkedTransferQueue();
        // convert stream back to set
        strq = strs.stream().collect(Collectors.toCollection(LinkedTransferQueue::new));
        intq = ints.stream().collect(Collectors.toCollection(LinkedTransferQueue::new));

        System.out.println("Converting Set to Queue" + strq);
        System.out.println("Converting Set to Queue" + intq);

        Stack intstk = new Stack();
        Stack strstk = new Stack();

        intstk = ints.stream().collect(Collectors.toCollection(Stack::new));
        System.out.println("Stack of Integers"+intstk);

        strstk = strs.stream().collect(Collectors.toCollection(Stack::new));
        System.out.println("Stack of Strings"+strstk);
        Map<Integer, Integer> map = new HashMap<>();
        map =ints.stream().collect(Collectors.toMap(Function.identity(),Function.identity()));
        System.out.println("Integer set to Map Identity"+map);
        Map<String, String> strmap = new HashMap<>();
        strmap =strs.stream().collect(Collectors.toMap(Function.identity(),Function.identity()));
        System.out.println("Integer set to Map Identity"+strmap);

        Map<Set<Integer>, Set<String>> map3 = new HashMap<>();
       map3.put(ints, strs);
        System.out.println(map3);

    }

    public  static  void QueueToForms(){
        //Define Queue
        Queue<Integer> q = new LinkedBlockingQueue();
        q.add(1);
        q.add(3);
        q.add(5);
        q.add(7);
        System.out.format("The integer Queue is : %s %n",q);
        Queue strq = new LinkedBlockingQueue();
        strq.add("Apple");
        strq.add("Grapes");
        strq.add("Guava");
        strq.add("Mangoes");
        strq.add("Mangoes");
        System.out.format("The String Queue is : %s %n",strq);

        //Queue to Arrays
        Integer [] arr = new Integer[q.size()];
        arr = q.toArray(arr);
        for(int i:arr) {
            System.out.print(i+",");
        }
        System.out.println("\n");
        String [] arr1 = new String[strq.size()];
        System.out.format("The Queue %s to Array is %s %n",strq,strq.stream().collect(Collectors.toCollection(ArrayList::new)));
        //Queue to Lists
        System.out.format("%n Queue %s to Arraylist is %s %n",strq,strq.stream().collect(Collectors.toList()));
        //Queue to Sets
        Set<String> hash_Set = new HashSet<String>();
        System.out.format("The set for the Queue %s is %s %n",strq,strq.stream().collect(Collectors.toSet()));
        //Queue to Stack
        System.out.format("The stack for the Queue %s is %s %n",strq,strq.stream().collect(Collectors.toCollection(Stack::new)));
        //Queue to Map
        System.out.printf("The Map for the Queue %s is %s %n",strq,strq.stream().map(Function.identity()), Function.identity());
        List list = new ArrayList<>();
        list = Arrays.asList(strq.toArray());
        List finalList = list;
        Map<Integer, List<Integer>> map = (Map<Integer, List<Integer>>) list
                .stream()
                .collect(Collectors.groupingBy(a->a,
                        LinkedHashMap::new,
                        Collectors.mapping(b-> finalList.indexOf(b),
                                Collectors.toList())));

        map.entrySet().forEach(System.out::println);
    }

    private static void StackToForms() {
        Stack<Integer> intstk = new Stack();
        Stack<String> strstk = new Stack();

        intstk.add(10);
        intstk.add(30);
        intstk.add(20);
        intstk.add(50);
        System.out.format("The Integer Stack is %s %n",intstk);
        strstk.add("Apple");
        strstk.add("Grapes");
        strstk.add("Mangoes");
        strstk.add("Mangoes");
        System.out.printf("The String Stack is %s %n",strstk);
        //  Stack to Arrays
        System.out.println("Stack to Integer Array"+Arrays.toString(intstk.toArray()));
        System.out.println("Stack to String Array"+Arrays.toString(strstk.toArray()));

        //  Stack to Lists
        System.out.println("Stack to List"+intstk.stream().collect(Collectors.toList()));
        System.out.println("Stack to List"+strstk.stream().collect(Collectors.toList()));
        //  Stack to Sets
        System.out.println("Stack to Integer Set"+intstk.stream().collect(Collectors.toSet()));
        System.out.println("Stack to String Set"+strstk.stream().collect(Collectors.toSet()));
        //  Stack to Queues
        System.out.println("Stack to Queue"+intstk.stream().collect(Collectors.toCollection(PriorityQueue::new)));
        System.out.println("Stack to Queue"+strstk.stream().collect(Collectors.toCollection(PriorityQueue::new)));
        //  Stack to Maps
        Map<Stack, Stack> map = new HashMap<>();
        map.put(intstk,strstk);
        System.out.println(map);

    }

    public static  void MaptoForms(){
        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("RED", "#FF0000");
        hashMap.put("BLUE", "#0000FF");

        String[] key = hashMap.keySet().toArray(new String[0]);
        String[] values = hashMap.values().toArray(new String[0]);
        System.out.println("Map to keys"+Arrays.toString(key));
        System.out.println("Map to values"+Arrays.toString(values));
        int i=0;
        for (Map.Entry<String, String> entry: hashMap.entrySet())
        {
            key[i] = entry.getKey();
            values[i++] = entry.getValue();
        }
        for (i = 0; i < hashMap.size(); i++) {
            System.out.println( "{" + key[i] + "=" + values[i] + "}" );
        }
        //Maps to Lists
        List<String> listkeys = new ArrayList<>();
        List<String> listvalues = new ArrayList<>();
        listkeys =hashMap.keySet().stream().collect(Collectors.toList());
        listvalues =hashMap.values().stream().collect(Collectors.toList());
        System.out.println("Map to Keys List"+listkeys);
        System.out.println("Map to Values List"+listvalues);
        //Maps to QUEUE
        Queue<String>q = new PriorityQueue<>();
        q =hashMap.keySet().stream().collect(Collectors.toCollection(PriorityQueue::new));

        System.out.println("Map to Keys Queue"+q);
        Set<String> s= new HashSet<>();
        s =hashMap.values().stream().collect(Collectors.toSet());
        System.out.println("Map to Keys Set"+s);
        Stack<String>stkkeys = new Stack<>();
        Stack<String>stkvalues = new Stack<>();
        stkkeys =hashMap.keySet().stream().collect(Collectors.toCollection(Stack::new));
        stkvalues =hashMap.values().stream().collect(Collectors.toCollection(Stack::new));

        System.out.println("Map to Keys Stack"+stkkeys);
        System.out.println("Map to Values Stack"+stkvalues);

    }
}
