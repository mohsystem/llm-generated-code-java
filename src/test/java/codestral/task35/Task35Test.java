package codestral.task35;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static codestral.task35.Task35_MISTRAL_codestral_latest.countPassengers;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task35Test {

    @Test
    void testSingleStop() {
        // Test with only one stop where no one gets off
        int[][] stops = new int[1][];
        stops[0] = new int[]{10, 0};

        assertEquals(10, countPassengers(stops));
    }

    @Test
    void testAllGetOff() {
        // Test where everyone gets off at the last stop
        int[][] stops = new int[3][];
        stops[0] = new int[]{10, 0};
        stops[1] = new int[]{3, 5};
        stops[2] = new int[]{2, 10};

        assertEquals(0, countPassengers(stops));
    }

    @Test
    void testMoreGetOnThanOff() {
        // Test where more people get on the bus than get off at each stop
        int[][] stops = new int[3][];
        stops[0] = new int[]{5, 0};
        stops[1] = new int[]{7, 3};
        stops[2] = new int[]{4, 2};

        assertEquals(11, countPassengers(stops));
    }

    @Test
    void testSameNumberGetOnAndOff() {
        // Test where the same number of people get on and off the bus at each stop
        int[][] stops = new int[3][];
        stops[0] = new int[]{3, 0};
        stops[1] = new int[]{2, 2};
        stops[2] = new int[]{0, 0};

        assertEquals(3, countPassengers(stops));
    }

    @Test
    void testAllGetOnAtOnce() {
        // Test where all people get on at the first stop and none get off until the end
        int[][] stops = new int[3][];
        stops[0] = new int[]{30, 0};
        stops[1] = new int[]{0, 0};
        stops[2] = new int[]{0, 0};

        assertEquals(20, countPassengers(stops));
    }

    @Test
    void testDecreasingPassengers() {
        // Test where the number of people decreases gradually
        int[][] stops = new int[4][];
        stops[0] = new int[]{10, 0};
        stops[1] = new int[]{0, 3};
        stops[2] = new int[]{0, 5};
        stops[3] = new int[]{0, 2};

        assertEquals(0, countPassengers(stops));
    }

    @Test
    void testEmptyBusStops() {
        // Test with stops that have zero people getting on and off
        int[][] stops = new int[3][];
        stops[0] = new int[]{10, 0};
        stops[1] = new int[]{0, 0};
        stops[2] = new int[]{0, 0};

        assertEquals(10, countPassengers(stops));
    }

    @Test
    void testOnePersonLeft() {
        // Test where one person remains on the bus after all stops
        int[][] stops = new int[2][];
        stops[0] = new int[]{1, 0};
        stops[1] = new int[]{0, 0};

        assertEquals(1, countPassengers(stops));
    }

    @Test
    void testComplexScenario() {
        // Test with a complex scenario with varying numbers
        int[][] stops = new int[6][];
        stops[0] = new int[]{10, 0};
        stops[1] = new int[]{3, 5};
        stops[2] = new int[]{3, 8};
        stops[3] = new int[]{10, 2};
        stops[4] = new int[]{0, 3};
        stops[5] = new int[]{7, 3};

        assertEquals(14, countPassengers(stops));
    }

    @Test
    void testLargeNumbers() {
        // Test with large numbers
        int[][] stops = new int[4][];
        stops[0] = new int[]{1000, 0};
        stops[1] = new int[]{500, 300};
        stops[2] = new int[]{200, 200};
        stops[3] = new int[]{300, 100};

    }
}
