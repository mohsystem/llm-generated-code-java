package gtp4o.task161;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task161Test {

    @Test
    @DisplayName("No items should yield zero value")
    void testNoItems() {
        int capacity = 50;
        int[] weights = {};
        int[] values = {};
        int n = 0;
        assertEquals(0, Task161_OPENAI_gpt_4o.knapsack(capacity, weights, values, n));
    }

    @Test
    @DisplayName("Zero capacity should yield zero value")
    void testZeroCapacity() {
        int capacity = 0;
        int[] weights = {1, 2, 3};
        int[] values = {10, 20, 30};
        int n = 3;
        assertEquals(0, Task161_OPENAI_gpt_4o.knapsack(capacity, weights, values, n));
    }

    @Test
    @DisplayName("Single item that fits should return its value")
    void testSingleItemFits() {
        int capacity = 10;
        int[] weights = {5};
        int[] values = {100};
        int n = 1;
        assertEquals(100, Task161_OPENAI_gpt_4o.knapsack(capacity, weights, values, n));
    }

    @Test
    @DisplayName("Single item too heavy should yield zero value")
    void testSingleItemTooHeavy() {
        int capacity = 4;
        int[] weights = {5};
        int[] values = {100};
        int n = 1;
        assertEquals(0, Task161_OPENAI_gpt_4o.knapsack(capacity, weights, values, n));
    }

    @Test
    @DisplayName("Multiple items: optimal combination selection")
    void testMultipleItemsSimple() {
        int capacity = 50;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int n = 3;
        assertEquals(220, Task161_OPENAI_gpt_4o.knapsack(capacity, weights, values, n));
    }

    @Test
    @DisplayName("Exact fit with all items")
    void testExactFitAllItems() {
        int capacity = 60;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int n = 3;
        assertEquals(280, Task161_OPENAI_gpt_4o.knapsack(capacity, weights, values, n));
    }

    @Test
    @DisplayName("Items with zero values should yield zero")
    void testZeroValues() {
        int capacity = 50;
        int[] weights = {10, 20, 30};
        int[] values = {0, 0, 0};
        int n = 3;
        assertEquals(0, Task161_OPENAI_gpt_4o.knapsack(capacity, weights, values, n));
    }

    @Test
    @DisplayName("Zero weight item should be included once")
    void testZeroWeightItem() {
        int capacity = 10;
        int[] weights = {0, 5, 4};
        int[] values = {10, 20, 30};
        int n = 3;
        assertEquals(60, Task161_OPENAI_gpt_4o.knapsack(capacity, weights, values, n));
    }

    @Test
    @DisplayName("Multiple optimal subsets with same capacity")
    void testMultipleOptimal() {
        int capacity = 5;
        int[] weights = {1, 2, 3, 2};
        int[] values = {8, 4, 0, 5};
        int n = 4;
        assertEquals(17, Task161_OPENAI_gpt_4o.knapsack(capacity, weights, values, n));
    }

    @Test
    @DisplayName("Random moderate case")
    void testRandomModerateCase() {
        int capacity = 7;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int n = 4;
        assertEquals(9, Task161_OPENAI_gpt_4o.knapsack(capacity, weights, values, n));
    }
}