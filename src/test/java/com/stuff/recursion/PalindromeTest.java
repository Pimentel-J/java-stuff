package com.stuff.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of class Palindrome.
 */
class PalindromeTest {

    /**
     * Test of palindrome method, of class Palindrome.
     */
    @Test
    void testPalindromeNumber() {
        System.out.println("palindromeNumber");
        int origin = 12321;
        int reverse = 0;
        int expResult = 12321;
        int result = Palindrome.palindromeNumber(origin, reverse);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPalindrome method, of class Palindrome.
     */
    @Test
    void testIsPalindromeNumber() {
        System.out.println("isPalindromeNumber");
        int num = 12321;
        boolean expResult = true;
        boolean result = Palindrome.isPalindromeNumber(num);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPalindromeString method, of class Palindrome.
     */
    @Test
    void testIsPalindromeString() {
        System.out.println("isPalindromeString");
        String word = "tenet";
        boolean expResult = true;
        boolean result = Palindrome.isPalindromeString(word);
        assertEquals(expResult, result);
    }

}