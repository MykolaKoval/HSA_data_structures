package com.course.hsa.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountingSortTest {

    @Test
    void sort_GivenAnArray_ShouldSortTheInputAsExpected() {
        int k = 5;
        int[] input = { 4, 3, 2, 5, 4, 3, 5, 1, 0, 2, 5 };

        int[] sorted = CountingSort.sort(input, k);

        // Our sorting algorithm and Java's should return the same result
        Arrays.sort(input);
        assertArrayEquals(input, sorted);
    }
}
