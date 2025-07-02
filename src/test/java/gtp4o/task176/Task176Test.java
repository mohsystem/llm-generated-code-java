package gtp4o.task176;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Task176Test {

    private ProductOfNumbers productOfNumbers;

    @BeforeEach
    void setup() {
        productOfNumbers = new ProductOfNumbers();
    }

    @Test
    void testCase1_basicAddAndGet() {
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        assertEquals(20, productOfNumbers.getProduct(2));
    }

    @Test
    void testCase2_getLastThree() {
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        assertEquals(40, productOfNumbers.getProduct(3));
    }

    @Test
    void testCase3_getLastFourIncludesZero() {
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        assertEquals(0, productOfNumbers.getProduct(4));
    }

    @Test
    void testCase4_addAfterZero() {
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        productOfNumbers.add(8);
        assertEquals(32, productOfNumbers.getProduct(2));
    }

    @Test
    void testCase5_getLastThreeAfterMoreAdds() {
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        productOfNumbers.add(8);
        productOfNumbers.add(6);
        assertEquals(192, productOfNumbers.getProduct(3));
    }

    @Test
    void testCase6_singleAdd() {
        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(5);
        assertEquals(5, productOfNumbers.getProduct(1));
    }

    @Test
    void testCase7_addZeroAndGet() {
        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(5);
        productOfNumbers.add(0);
        assertEquals(0, productOfNumbers.getProduct(1));
    }

    @Test
    void testCase8_lastFourAfterZero() {
        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(5);
        productOfNumbers.add(0);
        productOfNumbers.add(1);
        productOfNumbers.add(2);
        productOfNumbers.add(3);
        productOfNumbers.add(4);
        assertEquals(24, productOfNumbers.getProduct(4));
    }

    @Test
    void testCase9_noZeros() {
        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(1);
        productOfNumbers.add(2);
        productOfNumbers.add(3);
        productOfNumbers.add(4);
        productOfNumbers.add(5);
        assertEquals(60, productOfNumbers.getProduct(3));
    }

    @Test
    void testCase10_zeroAfterMany() {
        productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(1);
        productOfNumbers.add(2);
        productOfNumbers.add(3);
        productOfNumbers.add(4);
        productOfNumbers.add(5);
        productOfNumbers.add(0);
        assertEquals(0, productOfNumbers.getProduct(2));
    }
}
