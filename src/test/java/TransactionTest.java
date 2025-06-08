import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void testTransactionCreation() {
        // Arrange & Act
        String sender = "Alice";
        String recipient = "Bob";
        double amount = 5.0;
        Transaction transaction = new Transaction(sender, recipient, amount);

        // Assert
        assertEquals(sender, transaction.getSender());
        assertEquals(recipient, transaction.getRecipient());
        assertEquals(amount, transaction.getAmount());
    }

    @Test
    void testToString() {
        // Arrange
        Transaction transaction = new Transaction("Alice", "Bob", 5.0);

        // Act
        String result = transaction.toString();

        // Assert
        assertEquals("Alice pays Bob 5.0 BTC", result);
    }

    @Test
    void testZeroAmount() {
        // Arrange
        Transaction transaction = new Transaction("Charlie", "Dave", 0.0);

        // Assert
        assertEquals(0.0, transaction.getAmount());
        assertEquals("Charlie pays Dave 0.0 BTC", transaction.toString());
    }

    @Test
    void testNegativeAmount() {
        // Arrange
        Transaction transaction = new Transaction("Eve", "Frank", -1.5);

        // Assert
        assertEquals(-1.5, transaction.getAmount());
        assertEquals("Eve pays Frank -1.5 BTC", transaction.toString());
    }
}