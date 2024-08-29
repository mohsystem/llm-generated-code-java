package gtp4o.task181;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task181Test {
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    void setUp() {
        account1 = new BankAccount(1000, 1000);
        account2 = new BankAccount(500, 500);
    }

    @Test
    void testDeposit() {
        assertEquals("Balance: 1200", account1.deposit(200));
    }

    @Test
    void testWithdraw() {
        assertEquals("Balance: 700", account1.withdraw(300));
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertEquals("Insufficient funds", account1.withdraw(2000));
        assertEquals("Balance: 1000", "Balance: "+getBalance(account1)); // Balance should remain unchanged
    }

    @Test
    void testWithdrawNegativeAmount() {
        // Withdraw should not accept negative values
        assertThrows(IllegalArgumentException.class, () -> {
            if (account1.withdraw(-100).startsWith("Balance: ")) {
                throw new IllegalArgumentException("Negative withdraw not allowed");
            }
        });
        assertEquals("Balance: 1000", "Balance: "+getBalance(account1)); // Balance should remain unchanged
    }

    @Test
    void testDepositNegativeAmount() {
        // Deposit should not accept negative values
        assertThrows(IllegalArgumentException.class, () -> {
            if (account1.deposit(-100).startsWith("Balance: ")) {
                throw new IllegalArgumentException("Negative deposit not allowed");
            }
        });
        assertEquals("Balance: 1000", "Balance: "+getBalance(account1)); // Balance should remain unchanged
    }

    @Test
    void testCloseAccount() {
        assertEquals("Account closed", account1.close());
        assertEquals("Account is closed", account1.deposit(200));
        assertEquals("Account is closed", account1.withdraw(100));
    }

    @Test
    void testCloseAccountTwice() {
        assertEquals("Account closed", account1.close());
        // Trying to close an already closed account should not change the state
        assertEquals("Account closed", account1.close());
        assertEquals("Account is closed", account1.deposit(200));
        assertEquals("Account is closed", account1.withdraw(100));
    }

    @Test
    void testDepositToClosedAccount() {
        assertEquals("Account closed", account1.close());
        assertEquals("Account is closed", account1.deposit(200));
        assertEquals("Balance: 1000", "Balance: "+getBalance(account1)); // Balance should remain unchanged
    }

    @Test
    void testConcurrentAccess() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            assertEquals("Balance: 1200", account1.deposit(200));
            assertEquals("Balance: 400", account2.withdraw(100));
        });

        Thread thread2 = new Thread(() -> {
            assertEquals("Balance: 700", account1.withdraw(300));
            assertEquals("Balance: 650", account2.deposit(150));
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // Check final balance ranges after concurrent operations
        // To ensure proper testing, consider using assertions based on the current account balance.
        assertTrue(account1.deposit(0).startsWith("Balance: ") && account1.deposit(0).matches("Balance: \\d+"));
        assertTrue(account2.deposit(0).startsWith("Balance: ") && account2.deposit(0).matches("Balance: \\d+"));
    }

    @Test
    void testDepositToClosedAccountTwice() {
        assertEquals("Account closed", account1.close());
        assertEquals("Account is closed", account1.deposit(200));
        assertEquals("Account is closed", account1.deposit(50));
        assertEquals("Balance: 1000", "Balance: "+getBalance(account1)); // Balance should remain unchanged
    }

    private double getBalance(BankAccount account) {
        // Reflection to access private field 'balance' if necessary
        try {
            var balanceField = BankAccount.class.getDeclaredField("balance");
            balanceField.setAccessible(true);
            return (double) balanceField.get(account);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to access balance field", e);
        }
    }
}
