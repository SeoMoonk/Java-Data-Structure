package com.ll.ArrayList;

import com.ll.TestUt.TestUt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        String[] data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(2);

        list.add("사과");
        list.add("포도");

        data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(2);

        list.add("당근");

        data = TestUt.getFieldValue(list, "data", null);
        assertThat(data.length).isEqualTo(3);

        assertThat(list.size()).isEqualTo(3);
    }



}