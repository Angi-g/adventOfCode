package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void whenGivenInputThenParsStrLineToArreyIntReturnAValidArrayOfInt() {

        String input = "9 7 6 2 1";
        int[] expected = new int[]{9, 7, 6, 2, 1};

        assertArrayEquals(expected, Main.parseStrLineToArrayInt(input));
    }

    @Test
    void givenInputInWithAllSpacesAreBetween1And2isSpaceValidThenReturnTrue() {
        int[] input = new int[]{9, 7, 4, 3, 2};
        assertTrue(Main.isSpaceValid(input));
    }

    @Test
    void givenInputInWithSpacesNotBetween1And2isSpaceValidThenReturnFalse() {
        int[] inputMoreThan3 = new int[]{9, 4, 3, 2, 1};
        int[] inputLessThan1 = new int[]{9, 7, 5, 5, 1};

        assertFalse(Main.isSpaceValid(inputMoreThan3));
        assertFalse(Main.isSpaceValid(inputLessThan1));
    }

    @Test
    void givenInputAlwaysIncreaseThenIsAlwaysIncreaseReturnTrue() {
        int[] input = new int[]{1, 2, 3, 4, 5};

        assertTrue(Main.isAlwaysIncrease(input));
    }

    @Test
    void givenInputNotAlwaysIncreaseThenIsAlwaysIncreaseReturnFalse() {
        int[] input = new int[]{1, 2, 3, 2, 5};

        assertFalse(Main.isAlwaysIncrease(input));
    }
    @Test
    void givenInputAlwaysDecreaseThenIsAlwaysIncreaseReturnTrue() {
        int[] input = new int[]{5, 4, 3, 2, 1};

        assertTrue(Main.isAlwaysDecrease(input));
    }
    @Test
    void givenInputNotAlwaysDecreaseThenIsAlwaysIncreaseReturnFalse() {
        int[] input = new int[]{5, 4, 5, 2, 1};

        assertFalse(Main.isAlwaysDecrease(input));
    }

    @Test
    void givenValidIncreasingLineThenIsLineSafeReturnsTrue() {
        int[] input = new int[]{1, 2, 3, 4, 5};
        assertTrue(Main.isLineSafe(input));
    }

    @Test
    void givenValidDecreasingLineThenIsLineSafeReturnsTrue() {
        int[] input = new int[]{5, 4, 3, 2, 1};
        assertTrue(Main.isLineSafe(input));
    }

    @Test
    void givenLineWithInvalidSpacesThenIsLineSafeReturnsFalse() {
        int[] input = new int[]{1, 2, 6, 4, 5};
        assertFalse(Main.isLineSafe(input));
    }

    @Test
    void givenLineNotMonotonicThenIsLineSafeReturnsFalse() {
        int[] input = new int[]{1, 2, 3, 2, 4};
        assertFalse(Main.isLineSafe(input));
    }

    @Test
    void givenLineBecomesValidIncreasingWhenOneValueIgnoredThenReturnsTrue() {
        int[] input = new int[]{1, 2, 5, 3, 4};
        assertTrue(Main.isLineSafeWithOneValueIgnored(input, 2));
    }

    @Test
    void givenLineBecomesValidDecreasingWhenOneValueIgnoredThenReturnsTrue() {
        int[] input = new int[]{9, 7, 4, 6, 2};
        assertTrue(Main.isLineSafeWithOneValueIgnored(input, 3));
    }

    @Test
    void givenLineWithInvalidSpacesEvenWhenIgnoringOneValueThenReturnsFalse() {
        int[] input = new int[]{1, 4, 8, 2, 3};
        assertFalse(Main.isLineSafeWithOneValueIgnored(input, 2));
        assertFalse(Main.isLineSafeWithOneValueIgnored(input, 1));
    }

    // ----- EDGE CASE -----

    @Test
    void givenTwoElementsLineWithValidSpaceThenIsLineSafeReturnsTrue() {
        int[] input = new int[]{10, 8};
        assertTrue(Main.isLineSafe(input));
    }

    @Test
    void givenTwoElementsLineWithInvalidSpaceThenIsLineSafeReturnsFalse() {
        int[] input = new int[]{10, 5};
        assertFalse(Main.isLineSafe(input));
    }

    @Test
    void givenEqualElementsThenIsLineSafeReturnsFalse() {
        int[] input = new int[]{7, 7, 7, 7};
        assertFalse(Main.isLineSafe(input));
    }

}