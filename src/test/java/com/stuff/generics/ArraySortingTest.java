package com.stuff.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of class ArraySorting
 *
 * @author Pimentel
 */
class ArraySortingTest {

    private String[] strArray;

    @BeforeEach
    void setUp() {
        strArray = new String[]{"e", "c", "d", "a", "b"};
    }

    @Test
    void testSwap() {
        System.out.println("swap");
        ArraySorting.swapArrayElement(strArray, 1, 4);
        assertArrayEquals(strArray, new String[]{"e", "b", "d", "a", "c"});
    }

    @Test
    void testSelectionSort() {
        System.out.println("selectionSort");
        ArraySorting.selectionSort(strArray);
        assertArrayEquals(strArray, new String[]{"a", "b", "c", "d", "e"});
    }

    @Test
    void testBubbleSort() {
        System.out.println("bubbleSort");
        ArraySorting.bubbleSort(strArray);
        assertArrayEquals(strArray, new String[]{"a", "b", "c", "d", "e"});
    }

    @Test
    void testInsertionSort() {
        System.out.println("insertionSort");
        ArraySorting.insertionSort(strArray);
        assertArrayEquals(strArray, new String[]{"a", "b", "c", "d", "e"});
    }

    @Test
    void testMergeSort() {
        System.out.println("mergeSort");
        ArraySorting.mergeSort(strArray);
        assertArrayEquals(strArray, new String[]{"a", "b", "c", "d", "e"});
    }

    @Test
    void testQuickSort() {
        System.out.println("quickSort");
        ArraySorting.quickSort(strArray);
        assertArrayEquals(strArray, new String[]{"a", "b", "c", "d", "e"});
    }

}