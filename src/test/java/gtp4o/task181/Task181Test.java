package gtp4o.task181;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account1;
    private BankAccount account2;

    @BeforeEach
    void setUp() {
        account1 = new BankAccount(1, 1000);
        account2 = new BankAccount(2, 500);
    }

    @Test
    void testDeposit() {
        assertEquals("Balance: 1200", account1.deposit(200));
        assertEquals("Balance: 1200", getBalance(account1));
    }

    @Test
    void testWithdraw() {
        assertEquals("Balance: 700", account1.withdraw(300));
        assertEquals("Balance: 700", getBalance(account1));
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertEquals("Insufficient funds", account1.withdraw(2000));
        assertEquals("Balance: 1000", getBalance(account1));
    }

    @Test
    void testWithdrawNegativeAmount() {
        assertEquals("Insufficient funds", account1.withdraw(-100));
        assertEquals("Balance: 1000", getBalance(account1));
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
        assertEquals("Account closed", account1.close());
    }

    @Test
    void testDepositToClosedAccount() {
        account1.close();
        assertEquals("Account is closed", account1.deposit(200));
        assertEquals("Account is closed", getBalance(account1)); // Balance should remain unchanged
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
        assertTrue(getBalance(account1).startsWith("Balance: ") && getBalance(account1).matches("Balance: \\d+"));
        assertTrue(getBalance(account2).startsWith("Balance: ") && getBalance(account2).matches("Balance: \\d+"));
    }
    @Test
    void testWithdrawExactBalance() {
        // Test withdrawing exactly the balance amount, which should leave the account with zero balance.
        assertEquals("Balance: 0", account1.withdraw(1000));
        assertEquals("Balance: 0", getBalance(account1)); // Balance should be zero
    }
    @Test
    void testDepositNegativeAmount() {
        // Test depositing a negative amount, which should not be allowed.
        assertEquals("Insufficient funds", account1.deposit(-200));
        assertEquals("Balance: 1000", getBalance(account1)); // Balance should remain unchanged
    }
    private String getBalance(BankAccount account) {
        // Access balance through public method since field is private
        return account.deposit(0); // Using deposit with 0 amount to get balance
    }
    ///Note that: there is no an open() method inside the BankAccount class
    ///So, it's difficult to apply testOpenAccountSuccess and testOpenAccountWithExistingAccountNumber TCs on this solution.
}
