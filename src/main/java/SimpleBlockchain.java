import java.util.ArrayList;

public class SimpleBlockchain {

    // This is the main method that runs the program.

    /**
     *
     * Hash = digital signature.
     * Each block will have:
     * 1. List of transactions
     * 2. Hash of the previous block
     * 3. Hash of the current block
     */

    private static ArrayList<Block> blockchain = new ArrayList<>();

    /**
     * Displays all blocks and their transactions in the blockchain
     */
    private static void displayBlockchain() {
        System.out.println("\n--- BLOCKCHAIN CONTENTS ---");
        for (int i = 0; i < blockchain.size(); i++) {
            Block block = blockchain.get(i);
            System.out.println("\nBlock #" + i);
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Current Hash: " + block.getCurrentHash());
            System.out.println("Transactions:");

            ArrayList<Transaction> transactions = block.getTransactions();
            for (int j = 0; j < transactions.size(); j++) {
                Transaction tx = transactions.get(j);
                System.out.println("  " + (j+1) + ". " + tx.toString());
            }
        }
        System.out.println("\n--- END OF BLOCKCHAIN ---");
    }

    public static void main(String[] args) {
        // This is where the program starts.
        System.out.println("Welcome to my Blockchain program!");

        // Create the genesis block.
        ArrayList<Transaction> genesisTransactions = new ArrayList<>();
        genesisTransactions.add(new Transaction("Alice", "Bob", 10000.0));
        genesisTransactions.add(new Transaction("Bob", "Charlie", 2.0));
        Block genesisBlock = new Block("0", genesisTransactions);

        // Add the genesis block to the blockchain
        blockchain.add(genesisBlock);

        System.out.println("Genesis block added to blockchain");
        System.out.println("Block hash: " + genesisBlock.getCurrentHash());

        // Create a second block with new transactions
        ArrayList<Transaction> secondBlockTransactions = new ArrayList<>();
        secondBlockTransactions.add(new Transaction("Charlie", "Dave", 1.5));
        secondBlockTransactions.add(new Transaction("Alice", "Eve", 3.2));
        secondBlockTransactions.add(new Transaction("Dave", "Bob", 0.8));

        // Create the second block using the hash of the genesis block
        Block secondBlock = new Block(genesisBlock.getCurrentHash(), secondBlockTransactions);

        // Add the second block to the blockchain
        blockchain.add(secondBlock);

        System.out.println("\nSecond block added to blockchain");
        System.out.println("Block hash: " + secondBlock.getCurrentHash());

        // Display the blockchain after two blocks
        System.out.println("\nBlockchain now contains " + blockchain.size() + " blocks");

        // Create a third block with new transactions
        ArrayList<Transaction> thirdBlockTransactions = new ArrayList<>();
        thirdBlockTransactions.add(new Transaction("Eve", "Alice", 1.0));
        thirdBlockTransactions.add(new Transaction("Charlie", "Eve", 4.5));
        thirdBlockTransactions.add(new Transaction("Bob", "Dave", 2.3));
        thirdBlockTransactions.add(new Transaction("Dave", "Alice", 0.5));

        // Create the third block using the hash of the second block
        Block thirdBlock = new Block(secondBlock.getCurrentHash(), thirdBlockTransactions);

        // Add the third block to the blockchain
        blockchain.add(thirdBlock);

        System.out.println("\nThird block added to blockchain");
        System.out.println("Block hash: " + thirdBlock.getCurrentHash());

        // Display the complete blockchain
        System.out.println("\nBlockchain now contains " + blockchain.size() + " blocks");
        displayBlockchain();
    }
}