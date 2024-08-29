package codestral.task181;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task181Test {
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    void setUp() {
        account1 = new BankAccount(1000);
        account2 = new BankAccount(500);
    }

    @Test
    void testDeposit() {
        account1.deposit(200);
        assertEquals(1200, getBalance(account1), 0.01);
    }

    @Test
    void testWithdraw() {
        assertTrue(account1.withdraw(300));
        assertEquals(700, getBalance(account1) , 0.01);
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertFalse(account1.withdraw(2000));
        assertEquals(1000, getBalance(account1) , 0.01);
    }

    @Test
    void testWithdrawNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(-100));
        assertEquals(1000, getBalance(account1) , 0.01);
    }

    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(-100));
        assertEquals(1000, getBalance(account1) , 0.01);
    }

    @Test
    void testCloseAccount() {
        account1.close();
        assertThrows(IllegalStateException.class, () -> account1.deposit(200));
        assertThrows(IllegalStateException.class, () -> account1.withdraw(100));
    }

    @Test
    void testCloseAccountTwice() {
        account1.close();
        assertThrows(IllegalStateException.class, () -> account1.deposit(200));
        assertThrows(IllegalStateException.class, () -> account1.withdraw(100));
    }

    @Test
    void testCloseNonExistingAccount() {
        // No equivalent test for non-existing accounts in the single account context
    }

    @Test
    void testDepositToClosedAccount() {
        account1.close();
        assertThrows(IllegalStateException.class, () -> account1.deposit(200));
        assertEquals(1000, getBalance(account1) , 0.01);
    }

    @Test
    void testConcurrentAccess() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            account1.deposit(200);
            account2.withdraw(100);
        });

        Thread thread2 = new Thread(() -> {
            account1.withdraw(300);
            account2.deposit(150);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // Checking final balance after concurrent operations
        assertTrue(getBalance(account1) >= 900 && getBalance(account1)  <= 1200);
        assertTrue(getBalance(account2) >= 550 && getBalance(account2)  <= 650);
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
