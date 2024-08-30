package codestral.task32;

import claude.task32.Task32_CLAUDE_claude_3_5_sonnet_20240620;
import org.junit.jupiter.api.Test;

import static codestral.task32.Task32_MISTRAL_codestral_latest.calculateYears;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task32Test {

    @Test
    void testExactThreeYears() {
        // Test case where it takes exactly 3 years to reach the desired sum
        assertEquals(3, Task32_CLAUDE_claude_3_5_sonnet_20240620.calculateYears(1000.00, 0.05, 0.18, 1100.00));
    }

    @Test
    void testZeroYears() {
        // Test case where desired sum equals initial principal
        assertEquals(0, Task32_CLAUDE_claude_3_5_sonnet_20240620.calculateYears(1000.00, 0.05, 0.18, 1000.00));
    }

    @Test
    void testSmallIncreaseOneYear() {
        // Test case where it takes exactly 1 year to reach the desired sum
        assertEquals(1, Task32_CLAUDE_claude_3_5_sonnet_20240620.calculateYears(1000.00, 0.05, 0.18, 1040.00));
    }

    @Test
    void testLongTermInvestment() {
        // Test case where it takes many years to reach the desired sum
        assertEquals(18, Task32_CLAUDE_claude_3_5_sonnet_20240620.calculateYears(1000.00, 0.05, 0.18, 2000.00));//
    }

    @Test
    void testNoTax() {
        // Test case where there is no tax on the interest
        assertEquals(15, Task32_CLAUDE_claude_3_5_sonnet_20240620.calculateYears(1000.00, 0.05, 0.00, 2000.00));
    }

    @Test
    void testHighTax() {
        // Test case where the tax rate is high
        assertEquals(29, Task32_CLAUDE_claude_3_5_sonnet_20240620.calculateYears(1000.00, 0.05, 0.50, 2000.00));//
    }

    @Test
    void testHighInterestLowTax() {
        // Test case with high interest and low tax rate
        assertEquals(9, Task32_CLAUDE_claude_3_5_sonnet_20240620.calculateYears(1000.00, 0.10, 0.10, 2000.00));//
    }

    @Test
    void testLowInterestHighTax() {
        // Test case with low interest and high tax rate
        assertEquals(70, Task32_CLAUDE_claude_3_5_sonnet_20240620.calculateYears(1000.00, 0.02, 0.50, 2000.00));////
    }

    @Test
    void testMinimalInterest() {
        // Test case where the interest rate is very small
        assertEquals(170, Task32_CLAUDE_claude_3_5_sonnet_20240620.calculateYears(1000.00, 0.005, 0.18, 2000.00));//
    }

    @Test
    void testHighPrincipalAndDesiredSum() {
        // Test case where both the principal and desired sum are very large
        assertEquals(18, Task32_CLAUDE_claude_3_5_sonnet_20240620.calculateYears(1000000.00, 0.05, 0.18, 2000000.00));//
    }
}
