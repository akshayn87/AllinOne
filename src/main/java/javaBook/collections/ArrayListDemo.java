package javaBook.collections;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<String>a1 = new ArrayList<>();
		//Size of ArrayList
		a1.add("C");
		a1.add("B");
		a1.add("A");
		a1.add("D");
		a1.add("F");
		a1.add(1,"A2");
		
		
		//Display contents of a1
		System.out.println("contents of a1"+a1);
		//Size of the a1
		System.out.println("Size of a1 :- "+a1.size());
		
		//Remove elements from Arraylist
		a1.remove("F");
		a1.remove(2);
		System.out.println("Size of a1 :- "+a1.size());
		System.out.println("contents of a1"+a1);
		
		//Converting ArrayList to Array
		String a2[] = new String[a1.size()];
		a2 =a1.toArray(a2);
		System.out.println("contents of a1"+a1.toArray());
		System.out.println("contents of a2"+a2);
		for(String a:a2) {	System.out.print(a+" ");}
	}
}
