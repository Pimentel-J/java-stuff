package com.stuff.generics;

import java.util.Arrays;

/**
 * Generic Array Sorting class
 * • Selection Sort
 * • Bubble Sort
 * • Insertion Sort
 * • Merge Sort
 * • Quicksort
 *
 * @author Pimentel
 */
public class GenericArraySorting {

    /**
     * Swaps two array elements (auxiliary method)
     *
     * @param array           array with generic type E elements
     * @param firstElemIndex  first element index
     * @param secondElemIndex second element index
     */
    public static <E> void swapTwoArrayElements(E[] array, int firstElemIndex, int secondElemIndex) {
        E temp = array[firstElemIndex];
        array[firstElemIndex] = array[secondElemIndex];
        array[secondElemIndex] = temp;
    }

    /**
     * Selection Sort algorithm
     *
     * @param array array with generic type E elements
     */
    public static <E extends Comparable<E>> void selectionSort(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int k = i + 1; k < array.length; k++) {
                if (array[k].compareTo(array[min]) < 0) {
                    min = k;
                }
            }
            swapTwoArrayElements(array, i, min);
        }
    }

    /**
     * Bubble Sort algorithm
     *
     * @param array array with generic type E elements
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] array) {
        boolean swap = true;

        for (int i = 0; i < array.length && swap; i++) {
            swap = false;
            for (int k = array.length - 1; k > i; k--) {
                if (array[k].compareTo(array[k - 1]) < 0) {
                    swapTwoArrayElements(array, k - 1, k);
                    swap = true;
                }
            }
        }
    }

    /**
     * Insertion Sort algorithm
     *
     * @param array array with generic type E elements
     */
    public static <E extends Comparable<E>> void insertionSort(E[] array) {
        for (int i = 1; i < array.length; i++) {
            // array's key element to compare with others to it's left
            E keyElement = array[i];
            // find the key's sorted index
            while (i > 0 && array[i - 1].compareTo(keyElement) > 0) {
                array[i] = array[i - 1];
                i -= 1;
            }
            array[i] = keyElement;
        }
    }

    /**
     * Merge Sort algorithm (sort and merge the divided arrays)
     *
     * @param arrayFirstHalf  array's first half
     * @param arraySecondHalf array's second half
     * @param array           array with generic type E elements
     */
    private static <E extends Comparable<E>> void sortMergeDividedArrays(E[] arrayFirstHalf, E[] arraySecondHalf, E[] array) {
        int i = 0; int k = 0; int n = 0;

        while (i < arrayFirstHalf.length && k < arraySecondHalf.length) {
            if (arrayFirstHalf[i].compareTo(arraySecondHalf[k]) >= 0) {
                array[n++] = arraySecondHalf[k++];
            } else {
                array[n++] = arrayFirstHalf[i++];
            }
        }
        while (i < arrayFirstHalf.length) {
            array[n++] = arrayFirstHalf[i++];
        }
        while (k < arraySecondHalf.length) {
            array[n++] = arraySecondHalf[k++];
        }
    }

    /**
     * Merge Sort algorithm
     *
     * @param array array with generic type E elements
     */
    public static <E extends Comparable<E>> void mergeSort(E[] array) {
        if (array.length >= 2) {
            int middle = array.length / 2;
            E[] arrayFirstHalf = Arrays.copyOfRange(array, 0, middle);
            E[] arraySecondHalf = Arrays.copyOfRange(array, middle, array.length);

            mergeSort(arrayFirstHalf);
            mergeSort(arraySecondHalf);
            sortMergeDividedArrays(arrayFirstHalf, arraySecondHalf, array);
        }
    }

    /**
     * Quicksort algorithm
     *
     * @param array array with generic type E elements
     */
    public static <E extends Comparable<E>> void quicksort(E[] array) {
        quicksort(array, 0, array.length - 1);
    }

    /**
     * Quicksort algorithm (auxiliary private method)
     *
     * @param array             array with generic type E elements
     * @param leftSubListIndex  left sub-list index (elements less than the pivot)
     * @param rightSubListIndex right sub-list index (elements greater than the pivot)
     */
    private static <E extends Comparable<E>> void quicksort(E[] array, int leftSubListIndex, int rightSubListIndex) {
        E pivot = array[(leftSubListIndex + rightSubListIndex) / 2];
        int i = leftSubListIndex; int k = rightSubListIndex;

        while (i <= k) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (array[k].compareTo(pivot) > 0) {
                k--;
            }
            if (i <= k) {
                swapTwoArrayElements(array, i, k);
                i++;
                k--;
            }
        }
        if (leftSubListIndex < k) {
            quicksort(array, leftSubListIndex, k);
        }
        if (rightSubListIndex > i) {
            quicksort(array, i, rightSubListIndex);
        }
    }
}
