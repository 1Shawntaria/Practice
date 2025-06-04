import java.util.ArrayList;

public class Block {

    private String previousHash;
    private String currentHash;
    private ArrayList<Transaction> transactions;

    public Block(String previousHash, ArrayList<Transaction> transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;
        this.currentHash = calculateHash();
    }

    private String calculateHash() {
        // A simple hash calculation for demonstration purposes.
        StringBuilder sb = new StringBuilder();
        for (Transaction tx : transactions) {
            sb.append(tx.toString());
        }
        return Integer.toHexString((previousHash + sb.toString()).hashCode());
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}