package llama3.task181;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    void setUp() {
        account1 = new BankAccount(1000);
        account2 = new BankAccount(500);
    }

    @Test
    void testDeposit() {
        assertTrue(account1.deposit(200));
        assertEquals(1200, account1.getBalance(), 0.01);
    }

    @Test
    void testWithdraw() {
        assertTrue(account1.withdraw(300));
        assertEquals(700, account1.getBalance(), 0.01);
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertFalse(account1.withdraw(2000));
        assertEquals(1000, account1.getBalance(), 0.01);
    }

    @Test
    void testWithdrawNegativeAmount() {
        assertFalse(account1.withdraw(-100));
        assertEquals(1000, account1.getBalance(), 0.01);
    }

    @Test
    void testCloseAccount() {
        account1.closeAccount();
        assertFalse(account1.deposit(200));
        assertFalse(account1.withdraw(100));
    }

    @Test
    void testCloseAccountTwice() {
        account1.closeAccount();
        // Closing an already closed account should be a no-op; here it is expected to remain closed.
        assertFalse(account1.deposit(200));
        assertFalse(account1.withdraw(100));
    }

    @Test
    void testDepositToClosedAccount() {
        account1.closeAccount();
        assertFalse(account1.deposit(200));
        assertEquals(1000, account1.getBalance(), 0.01); // Balance should remain unchanged
    }

    @Test
    void testWithdrawExactBalance() {
        // Test withdrawing exactly the balance amount, which should leave the account with zero balance.
        assertTrue(account1.withdraw(1000));
        assertEquals(0, account1.getBalance(), 0.01); // Balance should be zero
    }
    @Test
    void testDepositNegativeAmount() {
        // Test depositing a negative amount, which should not be allowed.
        assertFalse(account1.deposit(-200));
        assertEquals(1000, account1.getBalance(), 0.01); // Balance should remain unchanged
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
        assertTrue(account1.getBalance() >= 900 && account1.getBalance() <= 1200);
        assertTrue(account2.getBalance() >= 550 && account2.getBalance() <= 650);
    }
}
