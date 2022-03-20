package standardprograms;

import java.util.*;
import java.util.function.Consumer;

public class StreamsAreasandVolumes {


    public static ArrayList<Double> Inputs() {
        ArrayList<Double> input = new ArrayList<>();
        input.add(5.00);
        input.add(8.00);
        input.add(6.00);

        return input;
    }

    public static void main(String[] args) {
        Consumer<Double> square = i -> {
            System.out.println("Square of " + i + " is " + i * i);
        };
        Inputs().stream().forEach(square);
        Consumer<Double> AreaOfCircle = i -> {
            System.out.println("Area Of Circle of " + i + " is " + 3.14 * i * i);
        };
        Inputs().stream().forEach(AreaOfCircle);
        int[] lengths = {9, 5, 6, 7, 9, 11};
        int[] Breadths = {19, 15, 60, 9, 21, 13};
        for (int i = 0; i < lengths.length; i++) {
            System.out.println("Area of Rectangle :" + lengths[i] * Breadths[i]);
        }
    }
}
