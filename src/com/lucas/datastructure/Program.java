package com.lucas.datastructure;

import com.lucas.datastructure.arrays.Array;

public class Program {

	public static void main(String[] args) {
		
		Array<String> array = new Array<>(0);
		
		array.add("A");
		array.add("B");
		array.add("C");
		array.add("D");
		array.add("E");
		array.add("F");
		array.add("G");
		array.add("H");
		array.add("I");
		array.add("J");
		
		System.out.println(array.get(0));
		System.out.println(array.get(1));
		System.out.println(array.get(2));
		System.out.println(array.get(3));
		System.out.println(array.get(4));
	}
}