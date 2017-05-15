package com.jess.utilities;

import static org.junit.Assert.*;

/**
 * Created by Jess on 5/12/17.
 */
public class UtilitiesTest {
    private static Utilities util;

    @org.junit.Before
    public void setup(){
        util = new Utilities();

    }

    @org.junit.Test
    public void everyNthChar()  {
        char[] input = {'h','e','l','l','o'};
        char[] output = {'e','l'};
        assertArrayEquals(output, util.everyNthChar(input,2));

    }

    @org.junit.Test
    public void everyNthChar_nOutOfBounds(){
        char[] input = {'h','e','l','l','o'};
        char[] output = {'e','l'};
        assertArrayEquals("n passed in was larger than length of string",input, util.everyNthChar(input,10));

    }
    public void removePairs() {
        String answer = util.removePairs("AABCDDEFF");
        assertEquals("ABCDEF", answer);

        answer = util.removePairs("ABCBEDDF");
        assertEquals("ABCBEDF", answer);

        answer = util.removePairs("@");
        assertEquals("@", answer);

        answer = util.removePairs("");
        assertEquals("", answer);
    }

    @org.junit.Test
    public void removePairs_null(){
        assertNull("Did not get null returned when argument was passed null ", util.removePairs(null));
    }

    @org.junit.Test
    public void converter()  {
        assertEquals(300, util.converter(10,5));
    }

    @org.junit.Test (expected = ArithmeticException.class)
    public void converter_ArithmeticException()  throws Exception {
        util.converter(10,0);
        fail("should have thrown an Arithmetic Exception");
    }

    @org.junit.Test
    public void nullIfOddLength()  {

        String answer = util.nullIfOddLength("1234");
        assertEquals("even length should return input","1234", answer);

        assertNull("odd length should return null", util.nullIfOddLength("123"));
    }

}