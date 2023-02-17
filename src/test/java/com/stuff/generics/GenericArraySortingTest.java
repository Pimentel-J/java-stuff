package com.stuff.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of class GenericArraySorting
 *
 * @author Pimentel
 */
class GenericArraySortingTest {

    private String[] unsortedArray;
    private final String[] sortedArray = {"a", "b", "c", "d", "e"};

    @BeforeEach
    void setUp() {
        unsortedArray = new String[]{"e", "c", "d", "a", "b"};
    }

    @Test
    void testSwapTwoArrayElements() {
        System.out.println("swapTwoArrayElements");
        GenericArraySorting.swapTwoArrayElements(unsortedArray, 1, 4);
        assertArrayEquals(unsortedArray, new String[]{"e", "b", "d", "a", "c"});
    }

    @Test
    void testSelectionSort() {
        System.out.println("selectionSort");
        GenericArraySorting.selectionSort(unsortedArray);
        assertArrayEquals(unsortedArray, sortedArray);
    }

    @Test
    void testBubbleSort() {
        System.out.println("bubbleSort");
        GenericArraySorting.bubbleSort(unsortedArray);
        assertArrayEquals(unsortedArray, sortedArray);
    }

    @Test
    void testInsertionSort() {
        System.out.println("insertionSort");
        GenericArraySorting.insertionSort(unsortedArray);
        assertArrayEquals(unsortedArray, sortedArray);
    }

    @Test
    void testMergeSort() {
        System.out.println("mergeSort");
        GenericArraySorting.mergeSort(unsortedArray);
        assertArrayEquals(unsortedArray, sortedArray);
    }

    @Test
    void testQuicksort() {
        System.out.println("quickSort");
        GenericArraySorting.quicksort(unsortedArray);
        assertArrayEquals(unsortedArray, sortedArray);
    }

}