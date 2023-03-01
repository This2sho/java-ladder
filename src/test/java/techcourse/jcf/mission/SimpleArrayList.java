package techcourse.jcf.mission;

import java.util.ArrayList;
import java.util.Arrays;

public class SimpleArrayList implements SimpleList {


    public static final int INITIAL_CAPACITY = 20;
    private int CAPACITY;

    private String[] array;
    private int size = 0;

    public SimpleArrayList() {
        CAPACITY = INITIAL_CAPACITY;
        this.array = new String[CAPACITY];
    }

    public SimpleArrayList(int initSize) {
        CAPACITY = initSize;
        this.array = new String[CAPACITY];
    }

    @Override
    public boolean add(String value) {
        growCapacity();
        array[size++] = value;
        return true;
    }

    private void growCapacity() {
        if (size == array.length) {
            CAPACITY *= 2;
            array = Arrays.copyOf(array, CAPACITY);
        }
    }

    @Override
    public void add(int index, String value) {
        growCapacity();
        System.arraycopy(array, index,
            array, index + 1,
            size - index);
        array[index] = value;
        size = size + 1;
    }

    @Override
    public String set(int index, String value) {
        String oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        return array[index];
    }

    @Override
    public boolean contains(String value) {
        for (String s : array) {
            if (s.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        int findIndex = indexOf(value);
        if (findIndex == -1) {
            return false;
        }
        remove(findIndex);
        return true;
    }

    @Override
    public String remove(int index) {
        String removeValue = array[index];
        if (size - 1 - index >= 0)
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return removeValue;
    }

    @Override
    public void clear() {
        array = new String[INITIAL_CAPACITY];
        CAPACITY = INITIAL_CAPACITY;
        size = 0;
    }
}
