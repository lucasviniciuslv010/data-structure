package com.lucas.datastructure.arrays;

import java.io.Serializable;
import java.util.Collection;

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

	public Array(Collection<T> collection) {
		elements = (T[]) new Object[DEFAULT_CAPACITY];
		for (T c : collection) {
			add(c);
		}
	}

	public T get(int index) {
		checkIfTheIndexWasUsed(index);
		return elements[index];
	}
	
	public Object[] toArray() {
		int s = size;
		T[] result = (T[]) new Object[s];
		System.arraycopy(elements, 0, result, 0, size);
		return result;
	}

	public T set(int index, T element) {
		checkIfTheIndexWasUsed(index);
		T result = elements[index];
		elements[index] = element;
		return result;
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

	public void remove(T element) {
		int index = indexOf(element);
		if (index >= 0) {
			for (int i = index; i < size - 1; i++) {
				elements[i] = elements[i + 1];
			}
			elements[size - 1] = null;
			size--;
		}
	}
	
	public void remove(int index) {
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[size - 1] = null;
		size--;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int indexOf(T element) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(T element) {
		for (int i = size - 1; i >= 0; i--) {
			if (elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	public boolean contains(T element) {
		int result = indexOf(element);
		return result >= 0;
	}

	public void trimToSize() {
		T[] newElements = (T[]) new Object[size];
		System.arraycopy(elements, 0, newElements, 0, size);
		elements = newElements;
	}

	public void ensureCapacity() {
		if (size == elements.length) {
			T newElements[] = (T[]) new Object[(size + 1) * 2];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (size != 0) {
			for (int i = 0; i < size - 1; i++) {
				sb.append(elements[i]);
				sb.append(", ");
			}
			sb.append(elements[size - 1]);
		}
		sb.append("]");
		return sb.toString();
	}
}