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
        // Withdraw should not accept negative values
        assertFalse(account1.withdraw(-100));
        assertEquals(1000, account1.getBalance(), 0.01);
    }

    @Test
    void testDepositNegativeAmount() {
        // Deposit should not accept negative values
        assertFalse(account1.deposit(-100));
        assertEquals(1000, account1.getBalance(), 0.01);
    }

    @Test
    void testCloseAccount() {
        account1.closeAccount();
        assertFalse(account1.deposit(200));
        assertFalse(account1.withdraw(100));
        assertEquals(1000, account1.getBalance(), 0.01); // Balance should remain unchanged
    }

//    @Test
//    void testCloseAccountTwice() {
//        account1.closeAccount();
//        assertFalse(account1.closeAccount()); // Attempt to close an already closed account
//        assertFalse(account1.deposit(200));
//        assertFalse(account1.withdraw(100));
//        assertEquals(1000, account1.getBalance(), 0.01); // Balance should remain unchanged
//    }
    @Test
    void testDepositAndWithdrawOnClosedAccount() {
        account1.closeAccount(); // Close the account

        // Verify that deposits and withdrawals fail on a closed account
        assertFalse(account1.deposit(200)); // Deposits should fail and return false
        assertFalse(account1.withdraw(100)); // Withdrawals should fail and return false

        // Verify that the balance remains unchanged after failed operations
        assertEquals(1000, account1.getBalance(), 0.01); // Balance should remain unchanged
    }

    @Test
    void testDepositToClosedAccount() {
        account1.closeAccount();
        assertFalse(account1.deposit(200));
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

        assertTrue(account1.getBalance() >= 900 && account1.getBalance() <= 1200);
        assertTrue(account2.getBalance() >= 450 && account2.getBalance() <= 650);
    }
    @Test
    void testDepositToClosedAccountTwice() {
        account1.closeAccount(); // Close the account
        assertFalse(account1.deposit(200)); // Deposits should fail and return false
        assertFalse(account1.deposit(50));  // Deposits should still fail and return false
        assertEquals(1000, account1.getBalance(), 0.01); // Balance should remain unchanged
    }

}
