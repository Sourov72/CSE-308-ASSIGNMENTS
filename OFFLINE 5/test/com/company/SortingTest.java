package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    Sorting sort;
    List<Integer> randomList;

    Random rand = new Random();

    public void RandomListGenerator(int size){
        int number;
        randomList = new ArrayList<Integer>(size);
        while (size > 0){
            number = rand.nextInt(Integer.MAX_VALUE);
            randomList.add(number);
            size--;

        }
    }

    public void equalListGenerator(int size){
        int number;
        randomList = new ArrayList<Integer>(size);
        number = rand.nextInt(Integer.MAX_VALUE);
        while (size > 0){
            randomList.add(number);
            size--;

        }
    }

    public void ascendingListGenerator(int size){
        int number;
        randomList = new ArrayList<Integer>(size);
        number = rand.nextInt(214748364);
        while (size > 0){
            randomList.add(number);
            size--;
            number += rand.nextInt(20);

        }
    }

    public void descendingListGenerator(int size){
        int number;
        randomList = new ArrayList<Integer>(size);
        number = rand.nextInt(214748364);
        while (size > 0){
            randomList.add(number);
            size--;
            number -= rand.nextInt(20);
        }
    }

    @BeforeEach
    void setUp() {
        sort = new Sorting();
    }


    @DisplayName("Function for blank list, list with one element, list with two elements checking")
    @ParameterizedTest
    @CsvSource({"0", "1", "2"})
    void randomSortedList(int size) {
        RandomListGenerator(size);

        assertEquals(true, sort.sortCheck(randomList));
        assertEquals(true, sort.elementCheck(randomList));
    }


    @DisplayName("Function for random number of elements list checking")
    @Test
    void randomNumberList(){
        int size = 20;
        RandomListGenerator(size);

        assertEquals(true, sort.sortCheck(randomList));
        assertEquals(true, sort.elementCheck(randomList));

    }

    @DisplayName("Function for random size list checking")
    @Test
    void randomSizeList(){
        int size = rand.nextInt(50) + 1;
        RandomListGenerator(size);

        assertEquals(true, sort.sortCheck(randomList));
        assertEquals(true, sort.elementCheck(randomList));

    }

    @DisplayName("Function for ascending and descending order list checking")
    @ParameterizedTest
    @CsvSource({"true", "false"})
    void sortedList(boolean order) {
        int size = rand.nextInt(50) + 1;
        if(order)
            ascendingListGenerator(size);
        else
            descendingListGenerator(size);

        assertEquals(true, sort.sortCheck(randomList));
        assertEquals(true, sort.elementCheck(randomList));

    }

    @DisplayName("Function for equal element list")
    @Test
    void equalList(){
        int size = rand.nextInt(50) + 1;
        equalListGenerator(size);

        assertEquals(true, sort.sortCheck(randomList));
        assertEquals(true, sort.elementCheck(randomList));

    }


    @AfterEach
    void tearDown() {
        sort = null;
    }
}