import org.junit.jupiter.api.Assertions;

public class SimpleBlockchainTest {

    private final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
    private final java.io.PrintStream originalOut = System.out;

    @org.junit.jupiter.api.BeforeEach
    void setUpStreams() {
        System.setOut(new java.io.PrintStream(outContent));
    }

    @org.junit.jupiter.api.AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @org.junit.jupiter.api.Test
    void testMain() {
        // Call the main method which will create blocks and add them to the blockchain
        SimpleBlockchain.main(new String[]{});

        // Verify the output contains expected strings
        String output = outContent.toString();
        Assertions.assertTrue(output.contains("Welcome to my Blockchain program"));
        Assertions.assertTrue(output.contains("Genesis block added to blockchain"));
        Assertions.assertTrue(output.contains("Second block added to blockchain"));
        Assertions.assertTrue(output.contains("Third block added to blockchain"));
        Assertions.assertTrue(output.contains("--- BLOCKCHAIN CONTENTS ---"));

        // Verify block hashes are displayed
        Assertions.assertTrue(output.contains("Block hash:"));
        Assertions.assertTrue(output.contains("Previous Hash:"));
        Assertions.assertTrue(output.contains("Current Hash:"));

        // Verify transactions are displayed
        Assertions.assertTrue(output.contains("Transactions:"));
        Assertions.assertTrue(output.contains("Alice pays Bob"));
    }

    @org.junit.jupiter.api.Test
    void testDisplayBlockchain() throws Exception {
        // This method tests the displayBlockchain method by using reflection to call it directly
        // First, setup a sample blockchain
        java.lang.reflect.Method mainMethod = SimpleBlockchain.class.getDeclaredMethod("main", String[].class);
        mainMethod.invoke(null, (Object) new String[]{});

        // Clear the output stream
        outContent.reset();

        // Call displayBlockchain method using reflection
        java.lang.reflect.Method displayMethod = SimpleBlockchain.class.getDeclaredMethod("displayBlockchain");
        displayMethod.setAccessible(true);
        displayMethod.invoke(null);

        // Verify expected output
        String output = outContent.toString();
        Assertions.assertTrue(output.contains("--- BLOCKCHAIN CONTENTS ---"));
        Assertions.assertTrue(output.contains("Block #0"));
        Assertions.assertTrue(output.contains("Previous Hash: 0"));
    }
}