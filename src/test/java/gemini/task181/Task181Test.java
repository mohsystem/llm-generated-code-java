package gemini.task181;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task181Test {
    private Task181_GEMINI_gemini_1_5_pro_001 account1;
    private Task181_GEMINI_gemini_1_5_pro_001 account2;
    private Task181_GEMINI_gemini_1_5_pro_001 closedAccount;

    @BeforeEach
    void setUp() {
        account1 = new Task181_GEMINI_gemini_1_5_pro_001(1000);
        account2 = new Task181_GEMINI_gemini_1_5_pro_001(500);
        closedAccount = new Task181_GEMINI_gemini_1_5_pro_001(2000); // Account to be closed for testing
        closedAccount.close();
    }

    @Test
    void testDeposit() {
        account1.deposit(200);
        assertEquals(1200, account1.getBalance(), 0.01);
    }

    @Test
    void testWithdraw() {
        account1.withdraw(300);
        assertEquals(700, account1.getBalance(), 0.01);
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(2000));
        assertEquals(1000, account1.getBalance(), 0.01);
    }

    @Test
    void testWithdrawNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(-100));
        assertEquals(1000, account1.getBalance(), 0.01);
    }

    @Test
    void testCloseAccount() {
        account1.close();
        assertThrows(IllegalStateException.class, () -> account1.deposit(200));
        assertThrows(IllegalStateException.class, () -> account1.withdraw(100));
    }

    @Test
    void testCloseNonExistingAccount() {
        assertThrows(IllegalStateException.class, () -> closedAccount.close());
    }

    @Test
    void testDepositToClosedAccount() {
        assertThrows(IllegalStateException.class, () -> closedAccount.deposit(200));
        assertEquals(2000, closedAccount.getBalance(), 0.01);
    }

    @Test
    void testOpenAccountWithExistingAccountNumber() {
        account1.open();
    }

    @Test
    void testOpenAccountSuccess() {
        Task181_GEMINI_gemini_1_5_pro_001 account3 = new Task181_GEMINI_gemini_1_5_pro_001(1500);
        assertEquals(1500, account3.getBalance(), 0.01);

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
        assertTrue(account2.getBalance() >= 550 && account2.getBalance() <= 650);
    }
}
