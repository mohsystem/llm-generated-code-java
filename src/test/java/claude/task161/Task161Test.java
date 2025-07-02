package claude.task161;

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
        assertEquals(0, Task161_CLAUDE_claude_3_5_sonnet_20240620.knapsack(capacity, weights, values, 0));
    }

    @Test
    @DisplayName("Zero capacity should yield zero value")
    void testZeroCapacity() {
        int capacity = 0;
        int[] weights = {1, 2, 3};
        int[] values = {10, 20, 30};
        assertEquals(0, Task161_CLAUDE_claude_3_5_sonnet_20240620.knapsack(capacity, weights, values, 3));
    }

    @Test
    @DisplayName("Single item that fits should return its value")
    void testSingleItemFits() {
        int capacity = 10;
        int[] weights = {5};
        int[] values = {100};
        assertEquals(100, Task161_CLAUDE_claude_3_5_sonnet_20240620.knapsack(capacity, weights, values, 1));
    }

    @Test
    @DisplayName("Single item too heavy should yield zero value")
    void testSingleItemTooHeavy() {
        int capacity = 4;
        int[] weights = {5};
        int[] values = {100};
        assertEquals(0, Task161_CLAUDE_claude_3_5_sonnet_20240620.knapsack(capacity, weights, values, 1));
    }

    @Test
    @DisplayName("Multiple items: optimal combination selection")
    void testMultipleItemsSimple() {
        int capacity = 50;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        // Best is 20+30 => value 100+120 = 220
        assertEquals(220, Task161_CLAUDE_claude_3_5_sonnet_20240620.knapsack(capacity, weights, values, 3));
    }

    @Test
    @DisplayName("Exact fit with all items")
    void testExactFitAllItems() {
        int capacity = 60;
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        // All items fit exactly: total value = 280
        assertEquals(280, Task161_CLAUDE_claude_3_5_sonnet_20240620.knapsack(capacity, weights, values, 3));
    }

    @Test
    @DisplayName("Items with zero values should yield zero")
    void testZeroValues() {
        int capacity = 50;
        int[] weights = {10, 20, 30};
        int[] values = {0, 0, 0};
        assertEquals(0, Task161_CLAUDE_claude_3_5_sonnet_20240620.knapsack(capacity, weights, values, 3));
    }

    @Test
    @DisplayName("Zero weight item should be included once")
    void testZeroWeightItem() {
        int capacity = 10;
        int[] weights = {0, 5, 4};
        int[] values = {10, 20, 30};
        // Zero weight adds 10, then 5+4 weights add 20 and 30 => total = 60
        assertEquals(60, Task161_CLAUDE_claude_3_5_sonnet_20240620.knapsack(capacity, weights, values, 3));
    }

    @Test
    @DisplayName("Multiple optimal subsets with same capacity")
    void testMultipleOptimal() {
        int capacity = 5;
        int[] weights = {1, 2, 3, 2};
        int[] values = {8, 4, 0, 5};
        // Best is items 0,1,3 => weight 1+2+2 = 5 => value 8+4+5 = 17
        assertEquals(17, Task161_CLAUDE_claude_3_5_sonnet_20240620.knapsack(capacity, weights, values, 4));
    }

    @Test
    @DisplayName("Random moderate case")
    void testRandomModerateCase() {
        int capacity = 7;
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        // Best is items 1 and 2: weight 3+4 = 7 => value 4+5 = 9
        assertEquals(9, Task161_CLAUDE_claude_3_5_sonnet_20240620.knapsack(capacity, weights, values, 4));
    }
}
