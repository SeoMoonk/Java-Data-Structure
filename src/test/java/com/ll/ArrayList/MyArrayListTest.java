package com.ll.ArrayList;

import org.junit.jupiter.api.BeforeEach;
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

        assertThat(list.get(1)).isEqualTo("Lion");



    }


}