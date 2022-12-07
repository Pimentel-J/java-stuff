package com.stuff.recursion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of class Palindrome.
 */
class PalindromeTest {

    @BeforeAll
    static void setUpAll() {
    }

    @AfterAll
    static void tearDownAll() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

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