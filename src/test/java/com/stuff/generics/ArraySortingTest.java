package com.stuff.generics;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of class ArraySorting
 *
 * @author Pimentel
 */
class ArraySortingTest {

    /**
     * Test of swap method, of class ArraySorting.
     */
    @Test
    void testSwap() {
        System.out.println("swap");
        String[] strArray = {"a", "b", "c", "d", "e"};
        ArraySorting.swap(strArray, 1, 4);
        assertArrayEquals(strArray, new String[]{"a", "e", "c", "d", "b"});
    }

    @Disabled
    void testPrintArray() {
    }

    /**
     * Test of selectionSort method, of class ArraySorting.
     */
    @Test
    void testSelectionSort() {
        System.out.println("selectionSort");
        String[] strArray = {"e", "d", "c", "b", "a"};
        ArraySorting.selectionSort(strArray);
        assertArrayEquals(strArray, new String[]{"a", "b", "c", "d", "e"});
    }

    @Disabled
    void testBubbleSort() {
    }

    @Disabled
    void testInsertionSort() {
    }

    @Disabled
    void testMergeSort() {
    }

    @Disabled
    void testQuickSort() {
    }
}