import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {

    @Test
    void testBlockCreation() {
        // Arrange
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Alice", "Bob", 5.0));
        transactions.add(new Transaction("Bob", "Charlie", 2.0));
        String previousHash = "0";

        // Act
        Block block = new Block(previousHash, transactions);

        // Assert
        assertEquals(previousHash, block.getPreviousHash());
        assertNotNull(block.getCurrentHash());
        assertEquals(transactions, block.getTransactions());
    }

    @Test
    void testHashGeneration() {
        // Arrange
        ArrayList<Transaction> transactions1 = new ArrayList<>();
        transactions1.add(new Transaction("Alice", "Bob", 5.0));
        String previousHash = "0";
        Block block1 = new Block(previousHash, transactions1);

        ArrayList<Transaction> transactions2 = new ArrayList<>();
        transactions2.add(new Transaction("Alice", "Bob", 5.0));
        Block block2 = new Block(previousHash, transactions2);

        // Same transactions, same previous hash should generate same hash
        assertEquals(block1.getCurrentHash(), block2.getCurrentHash());

        // Different transactions should generate different hash
        ArrayList<Transaction> transactions3 = new ArrayList<>();
        transactions3.add(new Transaction("Bob", "Charlie", 3.0));
        Block block3 = new Block(previousHash, transactions3);
        assertNotEquals(block1.getCurrentHash(), block3.getCurrentHash());

        // Different previous hash should generate different hash
        ArrayList<Transaction> transactions4 = new ArrayList<>();
        transactions4.add(new Transaction("Alice", "Bob", 5.0));
        Block block4 = new Block("different_hash", transactions4);
        assertNotEquals(block1.getCurrentHash(), block4.getCurrentHash());
    }
}