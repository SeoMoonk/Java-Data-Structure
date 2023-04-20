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
        int dataLength1 = ((String[]) TestUt.getFieldValue(list, "data", null)).length;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터를 넣는다.
        IntStream.range(0, dataLength1 + 1)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        // 현재 배열의 길이
        int dataLength2 = ((String[]) TestUt.getFieldValue(list, "data", null)).length;
        assertThat(dataLength2).isGreaterThan(dataLength1);
    }

    @Test
    @DisplayName("MyArrayList 초기화(new) 시 생성자 인자로 data 배열의 사이즈 지정")
    void t005() {
        MyArrayList<String> list = new MyArrayList<>(200);

        // 초창기 배열의 길이
        int dataLength = ((String[]) TestUt.getFieldValue(list, "data", null)).length;

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
    @DisplayName("Test_Remove")
    void t008() {

        MyArrayList<String> list = new MyArrayList<>();
        list.add("Baby");
        list.add("Lion");
        list.add("ArrayList");

        assertEquals("Lion", list.remove(1));
        assertEquals(2, list.size());
    }

}