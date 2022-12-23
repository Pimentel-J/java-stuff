package com.stuff.recursion;

/**
 * Recursion palindrome example
 *
 * @author Pimentel
 */
public class Palindrome {

    /**
     * Recursively returns the inverted number
     *
     * @param origin  number to invert
     * @param reverse reversed number (created incrementally)
     * @return        inverted number
     */
    public static int palindromeNumber(int origin, int reverse) {
        if (origin == 0) {
            return reverse;
        }
        int lastDig = origin % 10;
        reverse = reverse * 10 + lastDig;
        return palindromeNumber(origin / 10, reverse);
    }

    /**
     * Recursive palindrome test for a given number.
     *
     * @param num number
     * @return    palindrome test result (boolean)
     */
    public static boolean isPalindromeNumber(int num) {
        if (num < 10) {
            return true;
        }
        return num == palindromeNumber(num, 0);
    }

    /**
     * Recursive palindrome test for a given word.
     *
     * @param origin string
     * @return       palindrome test result (boolean)
     */
    public static boolean isPalindromeString(String origin) {
        if (origin.length() < 2) {
            return true;
        }
        if (origin.charAt(0) != origin.charAt(origin.length() - 1)) {
            return false;
        }
        return isPalindromeString(origin.substring(1, origin.length() - 1));
    }
}
