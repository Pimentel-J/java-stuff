package com.stuff.recursion;

/**
 * Recursive labyrinth
 */
public class Labyrinth {

    /**
     * Checks if there's a way throw the labyrinth
     * <p>
     * The right path it marked with 1
     * The dead-end is marked with 2
     * The path taken is marked with 9
     *
     * @param actual the labyrinth in its actual (marked) form
     * @param y      coordinate y in the labyrinth
     * @param x      coordinate x in the labyrinth
     * @return the marked labyrinth or null if there is no way
     */
    public static int[][] check(int[][] actual, int y, int x) {

        actual[y][x] = 9;

        if (y == actual.length - 1 && x == actual[y].length - 1) {
            return actual;
        }
        //North
        if (isValid(actual, y - 1, x)) {
            if (check(actual, y - 1, x) != null) {
                return actual;
            }
        }
        //East
        if (isValid(actual, y, x + 1)) {
            if (check(actual, y, x + 1) != null) {
                return actual;
            }
        }
        //South
        if (isValid(actual, y + 1, x)) {
            if (check(actual, y + 1, x) != null) {
                return actual;
            }
        }
        //West
        if (isValid(actual, y, x - 1)) {
            if (check(actual, y, x - 1) != null) {
                return actual;
            }
        }

        //Backtracking
        actual[y][x] = 2;
        return null;
    }

    /**
     * Verifies if the next step is a wall (or the labyrinth limit)
     *
     * @param actual actual position
     * @param y      y coordinate
     * @param x      x coordinate
     * @return validation result (boolean)
     */
    public static boolean isValid(int[][] actual, int y, int x) {
        return (y >= 0 && x >= 0 && y < actual.length && x < actual[y].length && actual[y][x] == 1);
    }

    /**
     * Prints the matrix
     * @param matrix labyrinth
     */
    private static void printMatrix(int[][] matrix) {
        System.out.println("Labyrinth matrix");
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                System.out.print(matrix[x][y] + " ");
            }
            System.out.println();
        }
    }
}
