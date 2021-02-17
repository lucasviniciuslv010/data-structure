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
		checkIfTheIndexWasUsed(index);
		return elements[index];
	}
	
	public void set(int index, T element) {
		checkIfTheIndexWasUsed(index);
		elements[index] = element;
	}
	
	public boolean add(T element) {
		ensureCapacity();
		elements[size++] = element;
		return true;
	}
	
	public void add(int index, T element) {
		checkIndexAvailability(index);
		ensureCapacity();
		for (int i = size; i > index; i--) {
			elements[i] = elements[i - 1];
		}
		elements[index] = element;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int indexOf(String element) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	public void ensureCapacity() {
		if (size == elements.length) {
			T newElements[] = (T[]) new Object[(size + 1) * 2];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
	}
	
	public void checkIfTheIndexWasUsed(int index) {
		if (!(index >= 0 && index < size)) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public void checkIndexAvailability(int index) {
		if (!(index >= 0 && index <= size)) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
}