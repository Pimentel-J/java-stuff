package com.stuff.recursion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of class Gcd.
 */
class GcdTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Test of gcd method, of class Gcd.
     */
    @Test
    void testGcd() {
        System.out.println("gcd");
        int big = 48;
        int small = 30;
        int expResult = 6;
        int result = Gcd.gcd(big, small);
        assertEquals(expResult, result);
    }
}