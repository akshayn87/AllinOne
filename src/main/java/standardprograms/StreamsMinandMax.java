package standardprograms;

import java.util.ArrayList;

public class StreamsMinandMax {


    public static ArrayList<Integer> getInputs() {
        ArrayList<Integer> Inputs = new ArrayList<>();
        Inputs.add(0);
        Inputs.add(2);
        Inputs.add(15);
        Inputs.add(7);
        Inputs.add(11);
        return Inputs;
    }

    public static Integer Minimum() {
        int Minimum = getInputs().stream().min((i1, i2) -> i1.compareTo(i2)).get();
        return Minimum;
    }

    public static Integer Maximum() {
        int Maximum = getInputs().stream().max((i1, i2) -> i1.compareTo(i2)).get();
        return Maximum;
    }

    public static void main(String[] args) {
        System.out.println("Min Value:" + Minimum());
        System.out.println("Max Value:" + Maximum());

    }

}
