package Practice;

import java.util.*;
import java.util.stream.Collectors;

public class Practice1 {

    public static void main(String[] args) {
        System.out.println("Hello");
        int[] a = {1, 2, 5, 6, 3, 2};
        List aa = Arrays.stream(a).boxed().sorted().collect(Collectors.toList());
        System.out.println(aa);
        String ThirdLargest = String.valueOf(aa.get(aa.size() - 3));
        System.out.println(ThirdLargest);
    }
}

