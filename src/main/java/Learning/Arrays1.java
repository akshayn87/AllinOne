package Learning;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;


public class Arrays1 {
    public static void main(String[] args) throws IOException {
        DefineArrays();
        ConvertArrayasList();
        AddelementToarray();
        RemoveElementFromArray();
        SortArray();
        Arrays1 a1 = new Arrays1();
        a1.AddArray();
        getArrayElement();
        getArrayElement();
    }

    public static void DefineArrays() {
        int[] intarr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        String[] strarr = {"apple", "grapes", "banana", "Jackfruit"};
        byte[] b = {11, 21, 31, 41, 51, 61, 71, 81, 91, 101};
        char[] c = {'A', 'B', 'C'};
        for (int a : intarr) {
            System.out.print(a + ",");
        }
        System.out.print("\n");
        for (String l : strarr) {
            System.out.print(l + ",");
        }
        System.out.print("\n");
        for (int m : b) {
            System.out.print(m + ",");
        }
        System.out.print("\n");
        for (char c1 : c) {
            System.out.print(c1 + ",");
        }
        System.out.print("\n");

    }

    public static void ConvertArrayasList() throws IOException {
        int[] intarr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        List<Integer> list = IntStream.of(intarr).boxed().collect(Collectors.toList());
        System.out.println("Arrays as List :-" + list);
        String[] strarr = {"apple", "grapes", "banana", "Jackfruit"};
        System.out.println("Arrays as List :-" + Arrays.asList(strarr));
        byte[] b = {11, 21, 31, 41, 51, 61, 71, 81, 91, 101};
        //List<Byte> byteList = Bytes.asList(b);
        List<Byte> byteList = Arrays.asList(ArrayUtils.toObject(b));
        System.out.println("Arrays as List :-" + byteList);
    }

    public static void AddelementToarray() throws IOException {
        int[] intarr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        List<Integer> list = IntStream.of(intarr).boxed().collect(Collectors.toList());
        list.add(110);
        System.out.println("Add element by Instream :-" + list);
        //Another Method to Add element to list
        List<Integer> intList = new ArrayList<Integer>(intarr.length);
        for (int i : intarr) {
            intList.add(i);
        }
        intList.add(120);
        System.out.println("Add element with for Loop :-" + intList);
        String[] strarr = {"apple", "grapes", "banana", "Jackfruit"};
        List<String> strlist = Arrays.asList(strarr);
        ArrayList a = new ArrayList<>();
        a.addAll(strlist);
        a.add("BlueBerries");
        System.out.println(a);
        byte[] b = {11, 21, 31, 41, 51, 61, 71, 81, 91, 101};
        List<Byte> byteList = Arrays.asList(ArrayUtils.toObject(b));
        ArrayList bb = new ArrayList<>();
        bb.addAll(byteList);
        bb.add(111);
        System.out.println(bb);
    }

    public static void RemoveElementFromArray() {
        int[] intarr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        List<Integer> list = IntStream.of(intarr).boxed().collect(Collectors.toList());
        list.remove(9);
        System.out.println(list);
        String[] strarr = {"apple", "grapes", "banana", "Jackfruit"};
        List<String> strlist = Arrays.asList(strarr);
        ArrayList a = new ArrayList<>();
        a.addAll(strlist);
        a.remove(strlist.stream().count() - 1);
        System.out.println(a);
        byte[] b = {11, 21, 31, 41, 51, 61, 71, 81, 91, 101};
        List<Byte> byteList = Arrays.asList(ArrayUtils.toObject(b));
        ArrayList bb = new ArrayList<>();
        bb.addAll(byteList);
        bb.remove(9);
        System.out.println(bb);

    }

    public static void SortArray() {
        int[] intarr = {10, 20, 70, 40, 50, 60, 30, 80, 90, 100};
        int[] array = new int[]{10, 20, 70, 40, 50, 60, 30, 80, 90, 100};
        System.out.println(Arrays.toString(array));
        String[] strarr = {"apple", "grapes", "banana", "Jackfruit"};
        byte[] b = {11, 21, 31, 41, 51, 61, 71, 81, 91, 101};
        Arrays.sort(intarr);
        System.out.println("Sorted Integer Array :-" + Arrays.toString(intarr));
        Arrays.sort(strarr);
        System.out.println("Sorted String Array :-" + Arrays.toString(strarr));
        Arrays.sort(b);
        System.out.println("Sorted Byte Array :-" + Arrays.toString(b));
        //Reverse Order
        Integer[] output = new Integer[intarr.length];
        for (int i = 0; i < intarr.length; i++) {
            output[i] = intarr[i];
        }
        Arrays.sort(output, Collections.reverseOrder());
        System.out.println("Reverse Sort Integer Array :-" + Arrays.toString(output));
        String[] output1 = new String[strarr.length];
        for (int i = 0; i < strarr.length; i++) {
            output1[i] = strarr[i];
        }
        Arrays.sort(output1, Collections.reverseOrder());
        System.out.println("Reverse Sort String Array :-" + Arrays.toString(output1));
        Byte[] output2 = new Byte[b.length];
        for (int i = 0; i < b.length; i++) {
            output2[i] = b[i];
        }
        Arrays.sort(output2, Collections.reverseOrder());
        System.out.println("Reverse Sort Byte Array :-" + Arrays.toString(output2));

    }

    public static void getArrayElement() {
        int[] intarr = {10, 20, 70, 40, 50, 60, 30, 80, 90, 100};
        String[] strarr = {"apple", "grapes", "banana", "Jackfruit"};
        byte[] b = {11, 21, 31, 41, 51, 61, 71, 81, 91, 101};
        System.out.println(intarr[0]);
        System.out.println(intarr[intarr.length - 1]);
        System.out.println(strarr[strarr.length - 1]);
        System.out.println(b[2]);

    }

    public int[] AddArray() {
        int[] even = {2, 4, 6, 8, 10, 12, 14};
        int[] odd = {1, 3, 5, 7, 9};
        int[] result = new int[even.length];
        int length;
        if (even.length > odd.length) {
            length = odd.length;
        } else if (odd.length < even.length) {
            length = even.length;
        } else {
            length = even.length;
        }

        for (int i = 0; i < length; i++) {
            result[i] = even[i] + odd[i];
        }
        System.out.println("Even Numbers :-" + Arrays.toString(even));
        System.out.println("Odd Numbers :-" + Arrays.toString(odd));
        System.out.println("Addition of Arrays :-" + Arrays.toString(result));
        return result;
    }


}
