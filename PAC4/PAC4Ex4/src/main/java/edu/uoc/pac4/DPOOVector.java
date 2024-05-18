package edu.uoc.pac4;

public class DPOOVector<T> {
    // Attributes
    private T[] elements;
    private int size;

    // Constructor
    @SuppressWarnings("unchecked")
    public DPOOVector(int maxElements) {
        elements = (T[]) new Object[maxElements];
        size = 0;
    }

    // Add method
    public boolean add(T elem) {
        if (elem == null) {
            return false;
        }
        if (size >= elements.length) {
            return false;
        }
        elements[size++] = elem;
        return true;
    }

    // Size method
    public int size() {
        return size;
    }

    // Get method
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return elements[index];
    }

    // Remove method
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return; // Do nothing if the index is out of the range
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Clear the very last element
    }
}
