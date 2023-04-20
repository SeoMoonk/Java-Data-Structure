package com.ll.ArrayList;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class MyArrayList<T> {

    public boolean debug = false;
    private Object[] data;

    private int size = 0;

    public MyArrayList() {
        this(2);
    }

    public MyArrayList(int dataLength) {
        data = new Object[dataLength];
    }

    public int size() {

        return size;
    }

    public boolean add(Object element) {

        size++;

        //만약에 공간이 부족하다면 새 data 객체를 만든다.
        makeNewDataIfNotEnough();

        data[size - 1] = (String) element;

        return true;
    }

    private void makeNewDataIfNotEnough() {

        if (ifNotEnough()) {
            makeNewData();
        }
    }

    private void makeNewData() {

        //1이 늘어난 size 를 기반으로 새로운 저장소를 만듦 -> 동적임은 맞지만 호출 횟수가 과하게 많음.
        //String[] newData = new String[size];
        Object[] newData = new String[data.length * 2];

        //덮어쓰기 (새 창고로 옮기기)
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        if ( debug ) {
            System.out.printf("배열크기 증가 : %d => %d\n", data.length, newData.length);
        }

        // 기존 창고과 계약을 해지한다.
        // 더 이상 리스트가 기존 배열을 가리키지 않도록 하여, 자연스럽게 가비지컬렉팅이 되도록 한다.
        //길이도 늘어났고, 덮어써진 배열을 바꿈
        data = newData;
    }

    private boolean ifNotEnough() {
        return size > data.length;
    }


    public Object get(int index) {

        return data[index];
    }

    public int indexOf(Object element) {

        for(int i=0; i<data.length; i++)
        {
            if(element.equals(data[i]))
            {
                return i;
            }
        }

//        return IntStream.range(0, size)
//                .mapToObj(index -> new Object[]{index, data[index]})
//                .filter(arr -> element.equals(arr[1]))
//                .mapToInt(arr -> (int)arr[0])
//                .findFirst()
//                .orElse(-1);

        return -1;



    }


//    public String remove(int index) {
//
//        System.out.println("삭제할 index = " + index);
//        System.out.println("현재 size = " + size);
//
//        String removeData = data[index];
//
//        if (index == 0) {
//            //맨 앞을 삭제하고, 그 뒤의걸 전부 앞으로 당겨와야 함.
//
//            size--;
//            return removeData;
//        } else if (index == size - 1) {
//            //맨 뒤의 것을 삭제하고, 그자리만 비워주면 된다.
//
//            data[index] = null;
//
//            size--;
//            return removeData;
//        } else {
//            //삭제한 곳을 비워주고, 삭제한 곳 뒤의 내용을 당겨와야 한다.
//
//            for (int i = index; i < size - 1; i++) {
//                data[index] = data[index + 1];
//            }
//
//            data[index] = null;
//
//            size--;
//            return removeData;
//        }
//    }

}
