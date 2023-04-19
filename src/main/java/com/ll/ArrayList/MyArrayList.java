package com.ll.ArrayList;

public class MyArrayList<T> {

//    private T[] data = (T[])new String[2];
    private String[] data = new String[2];

    private int size = 0;

    public int size() {

        return size;
    }

    public boolean add(T element) {

        size++;

        //만약에 공간이 부족하다면 새 data 객체를 만든다.
        makeNewDataIfNotEnough();

        data[size-1] = (String)element;

        return true;
    }

    private void makeNewDataIfNotEnough() {

        if(ifNotEnough())
        {
            makeNewData();
        }
    }

    private void makeNewData() {

        //1이 늘어난 size를 기반으로 새로운 저장소를 만듦
        String[] newData = new String[size];

        //덮어쓰기
        for(int i=0; i<data.length; i++)
        {
            newData[i] = data[i];
        }

        //길이도 늘어났고, 덮어써진 배열을 바꿈
        data = newData;
    }

    private boolean ifNotEnough() {
        
        return size > data.length;
    }


    public String get(int index) {

        return (String) data[index];
    }
}
