package gemini.task195;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task195Test {

    private MedianFinder medianFinder;

    @BeforeEach
    void setUp() {
        medianFinder = new MedianFinder();
    }

    @Test
    void testAddNumAndFindMedian1() {
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian(), 1e-5);
    }

    @Test
    void testAddNumAndFindMedian2() {
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian(), 1e-5);
    }

    @Test
    void testAddNumAndFindMedian3() {
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian(), 1e-5);
    }

    @Test
    void testAddNumAndFindMedian4() {
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        medianFinder.addNum(4);
        medianFinder.addNum(2);
        medianFinder.addNum(5);
        assertEquals(3.0, medianFinder.findMedian(), 1e-5);
    }

    @Test
    void testAddNumAndFindMedian5() {
        medianFinder.addNum(10);
        medianFinder.addNum(5);
        medianFinder.addNum(15);
        medianFinder.addNum(20);
        medianFinder.addNum(25);
        medianFinder.addNum(30);
        assertEquals(17.5, medianFinder.findMedian(), 1e-5);
    }

    @Test
    void testAddNumAndFindMedian6() {
        medianFinder.addNum(0);
        medianFinder.addNum(0);
        medianFinder.addNum(0);
        assertEquals(0.0, medianFinder.findMedian(), 1e-5);
    }

    @Test
    void testAddNumAndFindMedian7() {
        medianFinder.addNum(-1);
        medianFinder.addNum(0);
        medianFinder.addNum(1);
        assertEquals(0.0, medianFinder.findMedian(), 1e-5);
    }

    @Test
    void testAddNumAndFindMedian8() {
        medianFinder.addNum(-10);
        medianFinder.addNum(-20);
        medianFinder.addNum(-30);
        medianFinder.addNum(-40);
        medianFinder.addNum(-50);
        assertEquals(-30.0, medianFinder.findMedian(), 1e-5);
    }

    @Test
    void testAddNumAndFindMedian9() {
        medianFinder.addNum(100);
        medianFinder.addNum(200);
        medianFinder.addNum(300);
        medianFinder.addNum(400);
        medianFinder.addNum(500);
        medianFinder.addNum(600);
        medianFinder.addNum(700);
        assertEquals(400.0, medianFinder.findMedian(), 1e-5);
    }

    @Test
    void testAddNumAndFindMedian10() {
        medianFinder.addNum(1);
        medianFinder.addNum(3);
        medianFinder.addNum(2);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(7);
        medianFinder.addNum(8);
        medianFinder.addNum(9);
        assertEquals(5.0, medianFinder.findMedian(), 1e-5);
    }
}
