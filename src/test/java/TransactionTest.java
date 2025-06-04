import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    void testTransactionCreation() {
        // Arrange & Act
        String sender = "Alice";
        String recipient = "Bob";
        double amount = 5.0;
        Transaction transaction = new Transaction(sender, recipient, amount);

        // Assert
        Assertions.assertEquals(sender, transaction.getSender());
        Assertions.assertEquals(recipient, transaction.getRecipient());
        Assertions.assertEquals(amount, transaction.getAmount(), 0.000001);
    }

    @Test
    void testToString() {
        // Arrange
        Transaction transaction = new Transaction("Alice", "Bob", 5.0);

        // Act
        String result = transaction.toString();

        // Assert
        Assertions.assertEquals("Alice pays Bob 5.0 BTC", result);
    }

    @Test
    void testZeroAmount() {
        // Arrange
        Transaction transaction = new Transaction("Charlie", "Dave", 0.0);

        // Assert
        Assertions.assertEquals(0.0, transaction.getAmount(), 0.000001);
        Assertions.assertEquals("Charlie pays Dave 0.0 BTC", transaction.toString());
    }

    @Test
    void testNegativeAmount() {
        // Arrange
        Transaction transaction = new Transaction("Eve", "Frank", -1.5);

        // Assert
        Assertions.assertEquals(-1.5, transaction.getAmount(), 0.000001);
        Assertions.assertEquals("Eve pays Frank -1.5 BTC", transaction.toString());
    }
}