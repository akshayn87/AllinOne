package Learning;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maps {
    public static void main(String[] args) {
        DefineHashMap();
        getKeysandValues();
        addoeremovpair();
        replacevalue();
        sortedMap();
        AddTwoMaps();

    }

    public static Map DefineHashMap() {
        Map hm = new HashMap<>();
        hm.put("name", "akshay");
        hm.put("age", 34);
        hm.put(1, "addthis");
        System.out.println(hm);
        return hm;
    }

    public static void getKeysandValues() {
        Map hm1 = new TreeMap();
        hm1 = DefineHashMap();
        System.out.println(hm1.keySet());
        System.out.println(hm1.values());
        System.out.println(hm1.entrySet());
        System.out.println(hm1.get("name"));
    }

    public static void addoeremovpair() {
        Map hm2 = new HashMap<>();
        hm2.put("ID", 1000);
        hm2.put("firstname", "Akshay");
        hm2.put("seatno", 12);
        System.out.println(hm2.entrySet());
        hm2.remove("seatno");
        System.out.println(hm2.entrySet());
    }

    public static void replacevalue() {
        Map hm3 = new HashMap<>();
        hm3.put("ID", 1000);
        hm3.put(1, "Hello!");
        hm3.put(2, "World!");
        System.out.println(hm3);
        //replace the value
        hm3.put("ID", 1005);
        hm3.putAll(DefineHashMap());
        System.out.println(hm3);
    }

    public static void sortedMap() {
        Map hm4 = new TreeMap();
        hm4.put(1, "Akshay");
        hm4.put(2, "Rahul");
        hm4.put(3, "Mahesh");
        hm4.put(4, "Ravi");
        hm4.put(6, "Shyam");
        hm4.put(5, "Mohan");
        System.out.println(hm4);
        for (Object entry : hm4.entrySet()) {
            System.out.print(entry + ",");
        }
        System.out.println("\n");
//        for(Map.Entry<Integer, String> entry : hm4.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
        for (Object key : hm4.keySet()) {
            System.out.print(key + ":" + hm4.get(key) + ",");
        }
        System.out.println("\n");
        for (Object value : hm4.values()) {
            System.out.print(value + ",");
        }


    }

    public static void AddTwoMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>(map1);
        map1.put("A", 65);
        map1.put("B", 66);
        map1.put("C", 67);
        map1.put("D", 68);
        map2.put("E", 69);
        map2.put("F", 70);
        map2.put("G", 72);
        System.out.println(map1);
        System.out.println(map2);

        System.out.println(map1.entrySet());

    }

}
