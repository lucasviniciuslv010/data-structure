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
		array.add(5, "AQUI");
		
		array.trimToSize();
		
	}
}