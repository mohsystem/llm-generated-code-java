package claude.task181;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task181Test {
    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        bank.openAccount("123", 1000);
        bank.openAccount("456", 500);
    }

    @Test
    void testDeposit() {
        assertTrue(bank.deposit("123", 200));
        assertEquals(1200, bank.getAccount("123").getBalance(), 0.01);
    }

    @Test
    void testWithdraw() {
        assertTrue(bank.withdraw("123", 300));
        assertEquals(700, bank.getAccount("123").getBalance(), 0.01);
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertFalse(bank.withdraw("123", 2000));
        assertEquals(1000, bank.getAccount("123").getBalance(), 0.01);
    }

    @Test
    void testWithdrawNegativeAmount() {
        assertFalse(bank.withdraw("123", -100));
        assertEquals(1000, bank.getAccount("123").getBalance(), 0.01);
    }

    @Test
    void testCloseAccount() {
        assertTrue(bank.closeAccount("123"));
        assertFalse(bank.deposit("123", 200));
        assertFalse(bank.withdraw("123", 100));
    }

    @Test
    void testCloseNonExistingAccount() {
        assertFalse(bank.closeAccount("789"));
    }

    @Test
    void testDepositToClosedAccount() {
        bank.closeAccount("123");
        assertFalse(bank.deposit("123", 200));
        assertEquals(1000, bank.getAccount("123").getBalance(), 0.01);
    }

    @Test
    void testOpenAccountWithExistingAccountNumber() {
        assertFalse(bank.openAccount("123", 1500));
    }

    @Test
    void testOpenAccountSuccess() {
        assertTrue(bank.openAccount("789", 1500));
        assertEquals(1500, bank.getAccount("789").getBalance(), 0.01);
    }

    @Test
    void testConcurrentAccess() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            bank.deposit("123", 200);
            bank.withdraw("456", 100);
        });

        Thread thread2 = new Thread(() -> {
            bank.withdraw("123", 300);
            bank.deposit("456", 150);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        assertEquals(900, bank.getAccount("123").getBalance(), 0.01);
        assertEquals(550, bank.getAccount("456").getBalance(), 0.01);
    }
}
