package lib;

import java.util.Arrays;

public class SimpleArrayList<T> {
    private int size = 0;
    private int ARRAY_LEN = 2;
    private T[] items;

    public SimpleArrayList() {
        this.items = (T[]) new Object[ARRAY_LEN];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (isEmpty() || index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        return items[index];
    }

    public void set(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        items[index] = item;
    }

    public void add(T item) {
        items[size] = item;
        size++;
        if (size == ARRAY_LEN) {
            items = Arrays.copyOf(items, ARRAY_LEN * 2);
            ARRAY_LEN = ARRAY_LEN * 2;
        }
    }

    public T remove(int index) {
        if (isEmpty() || index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        T removedValue = items[index];
        items[index] = null;

        if (size > 1) {
            int i = index;
            while (items[i + 1] != null) {
                items[i] = items[i + 1];
                i++;
            }
            items[i] = null;
        }

        size--;

        if (size > 1 && size < (ARRAY_LEN / 2)) {
            ARRAY_LEN = ARRAY_LEN / 2;
            items = Arrays.copyOf(items, ARRAY_LEN);
        }

        return removedValue;
    }

    public void clear() {
        size = 0;
        ARRAY_LEN = 2;
        items = (T[]) new Object[ARRAY_LEN];
    }

    public T[] toArray() {
        return Arrays.copyOf(items, size);
    }
}
