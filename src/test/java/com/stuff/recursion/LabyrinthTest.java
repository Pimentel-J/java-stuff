package com.stuff.recursion;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of class Labyrinth.
 */
class LabyrinthTest {

    /**
     * Test of check method, of class Labyrinth.
     * <p>
     * The right path it marked with 1
     * The dead-end is marked with 2
     * The path taken is marked with 9
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[][] actual = {
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        int y = 0, x = 0;

        int[][] expResult = {
                {9, 9, 9, 0, 2, 2, 0, 0, 0, 2, 2, 2, 2},
                {1, 0, 9, 9, 9, 0, 2, 2, 2, 2, 2, 0, 2},
                {1, 0, 0, 0, 9, 0, 2, 0, 2, 0, 2, 0, 2},
                {1, 0, 0, 0, 9, 2, 2, 0, 2, 0, 2, 2, 2},
                {1, 1, 1, 1, 9, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 9, 9, 9, 9, 9, 9, 9, 9, 9}
        };

        int[][] result = Labyrinth.check(actual, y, x);
        assertArrayEquals(expResult, result);

        int[][] impossibleActual = {
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        expResult = null;
        result = Labyrinth.check(impossibleActual, y, x);
        assertArrayEquals(expResult, result);
    }

    @Disabled
    void isValid() {
    }

    @Disabled
    void printMatrix() {
    }
}