package com.ll.ArrayList;

public class MyArrayList<T> {

//    private T[] data = (T[])new String[2];
    private String[] data = new String[2];

    private int size = 0;

    public int size() {

        return size;
    }


    public boolean add(T element) {

        data[size] = (String)element;
        size++;

        return true;
    }


    public String get(int index) {

        return (String) data[index];
    }
}
