package com.lucas.datastructure;

import java.util.ArrayList;

import com.lucas.datastructure.arrays.Array;

public class Program {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.add("I");
		list.add("J");
		list.add("K");

		Array<String> array = new Array<String>(list);
		
		System.out.println(array);
		
		Object[] newArray = array.toArray();
		
		System.out.println("===========================================");
		
		for (int i = 0; i < newArray.length; i++) {
			System.out.println(newArray[i]);
		}
	}
}