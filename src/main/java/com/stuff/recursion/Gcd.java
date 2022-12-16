package com.stuff.recursion;

/**
 * Recursive greatest common divisor (GCD) calculator.
 * The greatest common factor of two numbers is the largest number that divides them both.
 */
public class Gcd {

    /**
     * Calculate the GCD of two given numbers (big and small).
     *
     * @param big   biggest number
     * @param small smallest number
     * @return      GCD
     */
    public static int gcd(int big, int small) {
        int remain = big % small;
        if (remain == 0) {
            return small;
        }
        System.out.println("Remain: " + remain);
        return gcd(small, remain);
    }

}
