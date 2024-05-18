package edu.uoc.pac4;

import java.util.Arrays;

public class DPOOVector<T> {
    private T[] elems;
    private int size;

    @SuppressWarnings("unchecked")
    public DPOOVector(int maxElements) {
        elems = (T[]) new Object[maxElements];
        size = 0;
    }

    public boolean add(T elem) {
        if (elem == null) {
            return false;
        }
        if (size >= elems.length) {
            return false;
        }
        elems[size++] = elem;
        return true;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return elems[index];
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            elems[i] = elems[i + 1];
        }
        elems[--size] = null; // Clear the last element
        return true;
    }
}
