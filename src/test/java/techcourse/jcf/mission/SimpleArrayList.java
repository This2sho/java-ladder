package techcourse.jcf.mission;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList{
    private int CAPACITY;

    private String[] array;
    private int lastIdx = 0;

    public SimpleArrayList() {
        CAPACITY = 20;
        this.array = new String[CAPACITY];
    }

    public SimpleArrayList(int initSize) {
        CAPACITY = initSize;
        this.array = new String[CAPACITY];
    }

    @Override
    public boolean add(String value) {
        growCapacity();
        array[lastIdx++] = value;
        return false;
    }

    private void growCapacity() {
        if (lastIdx == array.length) {
            CAPACITY *= 2;
            array = Arrays.copyOf(array, CAPACITY);
        }
    }

    @Override
    public void add(int index, String value) {

    }

    @Override
    public String set(int index, String value) {
        return null;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean contains(String value) {
        return false;
    }

    @Override
    public int indexOf(String value) {
        return 0;
    }

    @Override
    public int size() {
        return lastIdx;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(String value) {
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    public static void main(String[] args) {
        int capacity = 2;
        String[] arr = new String[capacity];
        System.out.println(arr.length);
        arr = Arrays.copyOf(arr, capacity * 2);
        System.out.println(arr.length);

    }
}
