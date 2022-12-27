package com.stuff.generics;

import java.util.Arrays;

/**
 * Generic Array Sorting class
 *
 * @author Pimentel
 */
public class ArraySorting {

    /**
     * Swaps two array positions
     *
     * @param array
     * @param i
     * @param j
     * @param <E>
     */
    public static <E> void swap(E[] array, int i, int j) {

        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Prints the array
     *
     * @param array
     * @param <E>
     */
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.println(", " + element);
        }
    }

    /**
     * Selection Sort Algorithm
     *
     * @param array
     * @param <E>
     */
    public static <E extends Comparable<E>> void selectionSort(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int k = i + 1; k < array.length; k++) {
                if (array[k].compareTo(array[min]) < 0) {
                    min = k;
                }
            }
            swap(array, i, min);
        }
    }

    /**
     * Bubble Sort Algorithm
     *
     * @param array array
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] array) {
        boolean swap = true;
        for (int i = 0; i < array.length && swap; i++) {
            swap = false;
            for (int k = array.length - 1; k > i; k--) {
                if (array[k].compareTo(array[k - 1]) < 0) {
                    swap(array, k - 1, k);
                    swap = true;
                }
            }
        }
    }

    /**
     * Insertion Sort Algorithm
     *
     * @param array
     * @param <E>
     */
    public static <E extends Comparable<E>> void insertionSort(E[] array) {
        for (int i = 1; i < array.length; i++) {
            //sorted array element
            int temp = i;
            // key to compare others
            E k = array[i];

            while (temp > 0 && array[temp - 1].compareTo(k) > 0) {
                array[temp] = array[temp - 1];
                temp -= 1;
            }

            array[temp] = k;
        }
    }

    /**
     * Merge Sort Algorithm
     * E[] S1 = Arrays.copyOfRange(S, 0, mid);
     *
     * @param S1
     * @param S2
     * @param S
     * @param <E>
     */
    private static <E extends Comparable<E>> void merge(E[] S1, E[] S2, E[] S) {
        int i = 0; int j = 0; int k = 0;
        while (i < S1.length && j < S2.length) {
            if (S1[i].compareTo(S2[j]) >= 0) {
                S[k] = S2[j];
                k++;
                j++;
            } else {
                S[k] = S1[i];
                k++;
                i++;
            }
        }
        while (i < S1.length) {
            S[k] = S1[i];
            k++;
            i++;
        }
        while (j < S2.length) {
            S[k] = S2[j];
            k++;
            j++;
        }
    }

    /**
     * Merge Sort Algorithm (public)
     *
     * @param S
     * @param <E>
     */
    public static <E extends Comparable<E>> void mergeSort(E[] S) {
        if (S.length >= 2) {
            int mid = S.length / 2;
            E[] S1 = Arrays.copyOfRange(S, 0, mid);
            E[] S2 = Arrays.copyOfRange(S, mid, S.length);

            mergeSort(S1);
            mergeSort(S2);
            merge(S1, S2, S);
        }
    }

    /**
     * Quicksort algorithm (public)
     *
     * @param array
     * @param <E>
     */
    public static <E extends Comparable<E>> void quickSort(E array[]) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Quicksort algorithm
     *
     * @param array
     * @param left
     * @param right
     * @param <E>
     */
    private static <E extends Comparable<E>> void quickSort(E array[], int left, int right) {
        E pivot = array[(left + right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSort(array, left, j);
        }
        if (right > i) {
            quickSort(array, i, right);
        }
    }
}
