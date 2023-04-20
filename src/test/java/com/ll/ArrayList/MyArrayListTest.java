package com.ll.ArrayList;

import com.ll.TestUt.TestUt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    @DisplayName("Test_Size")
    void t001() {

        MyArrayList<String> list = new MyArrayList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Test_add(\"Baby, Lion\")")
    void t002() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Baby");
        list.add("Lion");

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test_Get")
    void t003() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Baby");
        list.add("Lion");
        list.add("ArrayList");
        list.add("Generic");

        assertThat(list.get(0)).isEqualTo("Baby");
        assertThat(list.get(1)).isEqualTo("Lion");
        assertThat(list.get(2)).isEqualTo("ArrayList");
        assertThat(list.get(3)).isEqualTo("Generic");
    }

    @Test
    @DisplayName("Test_Array Dynamically")
    void t004() {

        MyArrayList<String> list = new MyArrayList<>();

        // 초창기 배열의 길이
        int dataLength1 = ((Object[]) TestUt.getFieldValue(list, "data", null)).length;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, dataLength1 + 1)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        // 현재 배열의 길이
        int dataLength2 = ((Object[]) TestUt.getFieldValue(list, "data", null)).length;
        assertThat(dataLength2).isGreaterThan(dataLength1);
    }

    @Test
    @DisplayName("MyArrayList 초기화(new) 시 생성자 인자로 data 배열의 사이즈 지정")
    void t005() {
        MyArrayList<String> list = new MyArrayList<>(200);

        // 초창기 배열의 길이
        int dataLength = ((Object[]) TestUt.getFieldValue(list, "data", null)).length;

        assertThat(dataLength).isEqualTo(200);
    }

    @Test
    @DisplayName("Debug : 데이터를 많이 넣으면 배열증가가 많이 발생함")
    void t006() {
        MyArrayList<String> list = new MyArrayList<>();
        list.debug = true;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));
    }

    @Test
    @DisplayName("Debug : 애초에 큰 배열로 만들면 데이터를 많이 넣어도 배열증가가 빈번하지 않음")
    void t007() {
        MyArrayList<String> list = new MyArrayList<>(25);
        list.debug = true;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));
    }

    @Test
    @DisplayName("Test_IndexOf")
    void t008() {
        MyArrayList<String> list = new MyArrayList<>(100);

        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        assertThat(list.indexOf("사과 0")).isEqualTo(0);
        assertThat(list.indexOf("사과 1")).isEqualTo(1);
        assertThat(list.indexOf("사과 5")).isEqualTo(5);
        assertThat(list.indexOf("사과 99")).isEqualTo(99);
        assertThat(list.indexOf("사과 100")).isEqualTo(-1);
    }

    @Test
    @DisplayName("Test_Add Boolean(By Generic (String -> Object))")
    void t009() {
        MyArrayList<Boolean> list = new MyArrayList<>();

        list.add(true);
        list.add(false);

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test_Add, get Boolean")
    void t010() {

        MyArrayList<Boolean> list = new MyArrayList<>();

        list.add(true);
        list.add(false);

        boolean e0 = list.get(0);
        boolean e1 = list.get(1);

//        boolean e0 = (boolean) list.get(0);
//        boolean e1 = (boolean) list.get(1);

        assertThat(e0).isEqualTo(true);
        assertThat(e1).isEqualTo(false);
    }


    @Test
    @DisplayName("Test_Remove")
    void t011() {

        MyArrayList<String> list = new MyArrayList<>(10);

        list.add("Baby");
        list.add("Lion");
        list.add("ArrayList");

        assertEquals("Lion", list.remove(1));

        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(0) = " + list.get(1));

        //null 이 들어오는 건 확인 했는데, 어떻게 완벽히 지워버릴 수가 있는거지?
        System.out.println("list.get(0) = " + list.get(2));
        System.out.println("list.get(0) = " + list.get(3));

        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Test_Contains")
    void t012() {

        MyArrayList<String> list = new MyArrayList<>(10);

        list.add("Baby");
        list.add("Lion");
        list.add("ArrayList");

        assertTrue(list.contains("Lion"));
        assertFalse(list.contains("Blog"));
    }

    @Test
    @DisplayName("Test_contains(\"사과 0\")")
    void t013() {
        MyArrayList<String> list = new MyArrayList<>(2);

        IntStream.range(0, 2)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        assertThat(list.contains("사과 0")).isEqualTo(true);
        assertThat(list.contains("사과 1")).isEqualTo(true);
        assertThat(list.contains("사과 2")).isEqualTo(false);
    }



    @Test
    @DisplayName("Test_Clear")
    void t014() {

        MyArrayList<String> list = new MyArrayList<>(10);

        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

    }

    @Test
    @DisplayName("addAt")
    void t015() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Element1"); // 0번 좌석에 착석
        list.add("Element2"); // 1번 좌석에 착석
        list.add("Element3"); // 2번 좌석에 착석

        list.add(1, "Element4");
        // 2 => 3
        // 1 => 2
        // 1번 좌석에 착석

        assertThat(list.size()).isEqualTo(4);

        assertThat(list.get(0)).isEqualTo("Element1");
        assertThat(list.get(1)).isEqualTo("Element4");
        assertThat(list.get(2)).isEqualTo("Element2");
        assertThat(list.get(3)).isEqualTo("Element3");
    }

    @Test
    @DisplayName("set")
    void t13() {

        MyArrayList<String> list = new MyArrayList<>();
        list.add("Element1"); // 0
        list.add("Element2"); // 1
        list.add("Element3"); // 2

        assertThat(list.set(0, "Element4")).isEqualTo("Element1");
        assertThat(list.size()).isEqualTo(3);

        assertThat(list.get(0)).isEqualTo("Element4");
        assertThat(list.get(1)).isEqualTo("Element2");
        assertThat(list.get(2)).isEqualTo("Element3");
    }



}