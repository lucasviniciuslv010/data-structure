package com.lucas.datastructure.arrays;

import java.io.Serializable;

public class Array<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private T[] elements;
	
	private int size;
	
	public Array() {
		this(DEFAULT_CAPACITY);
	}

	public Array(int capacity) {
		this.elements = (T[]) new Object[capacity];
	}
	
	public T get(int index) {
		if (index < 0 || index >= elements.length) {
			throw new IllegalArgumentException();
		}
		return elements[index];
	}
	
	public boolean add(T element) {
		if (elements.length == size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		elements[size++] = element;
		return true;
	}
}