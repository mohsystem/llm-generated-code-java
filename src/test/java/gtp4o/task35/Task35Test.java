package gtp4o.task35;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static gtp4o.task35.Task35_OPENAI_gpt_4o.numberOfPeople;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task35Test {

    @Test
    void testSingleStop() {
        // Test with only one stop where no one gets off
        ArrayList<int[]> stops = new ArrayList<>();
        stops.add(new int[]{10, 0});
        assertEquals(10, numberOfPeople(stops));
    }

    @Test
    void testAllGetOff() {
        // Test where everyone gets off at the last stop
        ArrayList<int[]> stops = new ArrayList<>();
        stops.add(new int[]{10, 0});
        stops.add(new int[]{3, 5});
        stops.add(new int[]{2, 10});
        assertEquals(0, numberOfPeople(stops));
    }

    @Test
    void testMoreGetOnThanOff() {
        // Test where more people get on the bus than get off at each stop
        ArrayList<int[]> stops = new ArrayList<>();
        stops.add(new int[]{5, 0});
        stops.add(new int[]{7, 3});
        stops.add(new int[]{4, 2});
        assertEquals(11, numberOfPeople(stops));
    }

    @Test
    void testSameNumberGetOnAndOff() {
        // Test where the same number of people get on and off the bus at each stop
        ArrayList<int[]> stops = new ArrayList<>();
        stops.add(new int[]{3, 0});
        stops.add(new int[]{2, 2});
        stops.add(new int[]{0, 0});
        assertEquals(3, numberOfPeople(stops));
    }

    @Test
    void testAllGetOnAtOnce() {
        // Test where all people get on at the first stop and none get off until the end
        ArrayList<int[]> stops = new ArrayList<>();
        stops.add(new int[]{20, 0});
        stops.add(new int[]{0, 0});
        stops.add(new int[]{0, 0});
        assertEquals(20, numberOfPeople(stops));
    }

    @Test
    void testDecreasingPassengers() {
        // Test where the number of people decreases gradually
        ArrayList<int[]> stops = new ArrayList<>();
        stops.add(new int[]{10, 0});
        stops.add(new int[]{0, 3});
        stops.add(new int[]{0, 5});
        stops.add(new int[]{0, 2});
        assertEquals(0, numberOfPeople(stops));
    }

    @Test
    void testEmptyBusStops() {
        // Test with stops that have zero people getting on and off
        ArrayList<int[]> stops = new ArrayList<>();
        stops.add(new int[]{10, 0});
        stops.add(new int[]{0, 0});
        stops.add(new int[]{0, 0});
        assertEquals(10, numberOfPeople(stops));
    }

    @Test
    void testOnePersonLeft() {
        // Test where one person remains on the bus after all stops
        ArrayList<int[]> stops = new ArrayList<>();
        stops.add(new int[]{1, 0});
        stops.add(new int[]{0, 0});
        assertEquals(1, numberOfPeople(stops));
    }

    @Test
    void testComplexScenario() {
        // Test with a complex scenario with varying numbers
        ArrayList<int[]> stops = new ArrayList<>();
        stops.add(new int[]{10, 0});
        stops.add(new int[]{3, 5});
        stops.add(new int[]{5, 8});
        stops.add(new int[]{10, 2});
        stops.add(new int[]{0, 3});
        stops.add(new int[]{7, 3});
        assertEquals(14, numberOfPeople(stops));
    }

    @Test
    void testLargeNumbers() {
        // Test with large numbers
        ArrayList<int[]> stops = new ArrayList<>();
        stops.add(new int[]{1000, 0});
        stops.add(new int[]{500, 300});
        stops.add(new int[]{200, 200});
        stops.add(new int[]{300, 100});

        assertEquals(1400, numberOfPeople(stops));
    }
}
