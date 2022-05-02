package Learning;

import org.apache.commons.lang3.ArrayUtils;


import java.util.*;

public class Lists {
    public static void main(String[] args) {
        DefineLists();
        AddelemnttoList();
        RemoveelementfromList();
        SortList();
        ConcanateTwoLists();
        addandmultiplylist();
        getArraylistElement();

    }

    public static List<Object> DefineLists() {
        ArrayList<Integer> intlist = new ArrayList<>();
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        for (int i : arr) {
            intlist.add(i);
        }
        System.out.println(intlist);
        ArrayList<String> strlist = new ArrayList<>();
        String[] strarr = {"Apple", "Banana", "Grapes", "Peas", "Mangoes"};
        for (String str : strarr) {
            strlist.add(str);
        }
        System.out.println(strlist);

        byte[] b = {11, 21, 31, 41, 51, 61, 71, 81, 91, 101};
        //List<Byte> byteList = Bytes.asList(b);
        List<Byte> byteList = Arrays.asList(ArrayUtils.toObject(b));
        System.out.println("Arrays as List :-" + byteList);

        return Arrays.asList(intlist, strlist, b);

    }

    public static void AddelemnttoList() {
        List<Object> list = DefineLists();
        ArrayList<Integer> intlist = (ArrayList<Integer>) list.get(0);
        intlist.add(2);
        System.out.println("Add Operation :-" + intlist);
        ArrayList<String> strlist = (ArrayList<String>) list.get(1);
        strlist.add("PineApple");
        System.out.println("Add Operation :-" + strlist);
//        ArrayList<Byte> bytelist = list.get(2);
//        bytelist.add((byte) 211);
//        System.out.println("Add Operation :-"+bytelist);
    }

    public static void RemoveelementfromList() {
        List<Object> list = DefineLists();
        ArrayList<Integer> intlist = (ArrayList<Integer>) list.get(0);
        intlist.remove(3);
        System.out.println("Remove Operation :-" + intlist);
        ArrayList<String> strlist = (ArrayList<String>) list.get(1);
        strlist.remove(2);
        System.out.println("Remove Operation :-" + strlist);
//        ArrayList<Byte> bytelist = list.get(2);
//        bytelist.add((byte) 211);
//        System.out.println("Add Operation :-"+bytelist);
    }

    public static void SortList() {
        ArrayList<Integer> intlist = new ArrayList<>();
        int[] arr = {10, 20, 50, 40, 30, 60, 70, 80, 90, 100};
        for (int i : arr) {
            intlist.add(i);
        }
        Collections.sort(intlist);
        System.out.println("Sorting :-" + intlist);
        Collections.sort(intlist, Collections.reverseOrder());
        System.out.println("Reverse Sorting :-" + intlist);
        ArrayList<String> strlist = new ArrayList<>();
        String[] strarr = {"Apple", "Banana", "Grapes", "Peas", "Mangoes"};
        for (String str : strarr) {
            strlist.add(str);
        }
        Collections.sort(strlist);
        System.out.println("Sorting :-" + strlist);
        Collections.sort(strlist, Collections.reverseOrder());
        System.out.println("Reverse Sorting :-" + strlist);

        byte[] b = {11, 21, 31, 41, 51, 61, 71, 81, 91, 101};
        //List<Byte> byteList = Bytes.asList(b);
        List<Byte> byteList = Arrays.asList(ArrayUtils.toObject(b));
        Collections.sort(byteList);
        System.out.println("Sorting Byte List :-" + byteList);
        Collections.sort(byteList, Collections.reverseOrder());
        System.out.println("Reverse Sorting of  Byte List :-" + byteList);
    }

    public static void ConcanateTwoLists() {
        List<Integer> even = new ArrayList<Integer>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        List<String> strlist = new ArrayList<>();
        even = (ArrayList<Integer>) DefineLists().get(0);
        strlist = (ArrayList<String>) DefineLists().get(1);
        int[] oddarr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : oddarr) {
            odd.add(i);
        }
        odd.add(110);
        odd.add(120);
        odd.add(130);
        odd.add(140);

        result.addAll(even);
        result.addAll(odd);
        strlist.add("mango");
        System.out.println(strlist);
        System.out.println(result);
    }

    public static void addandmultiplylist() {
        Arrays1 a1 = new Arrays1();
        System.out.println(Arrays.toString(a1.AddArray()));
    }

    public static void getArraylistElement() {
        ArrayList<Integer> intlist = new ArrayList<>();
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        for (int i : arr) {
            intlist.add(i);
        }
        System.out.println(intlist.get(0));
        System.out.println(intlist.get(intlist.size() - 1));

    }
}
