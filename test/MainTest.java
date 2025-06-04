import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testMain() {
        // Call the main method which will create blocks and add them to the blockchain
        Main.main(new String[]{});

        // Verify the output contains expected strings
        String output = outContent.toString();
        assertTrue(output.contains("Welcome to my Blockchain program"));
        assertTrue(output.contains("Genesis block added to blockchain"));
        assertTrue(output.contains("Second block added to blockchain"));
        assertTrue(output.contains("Third block added to blockchain"));
        assertTrue(output.contains("--- BLOCKCHAIN CONTENTS ---"));

        // Verify block hashes are displayed
        assertTrue(output.contains("Block hash:"));
        assertTrue(output.contains("Previous Hash:"));
        assertTrue(output.contains("Current Hash:"));

        // Verify transactions are displayed
        assertTrue(output.contains("Transactions:"));
        assertTrue(output.contains("Alice pays Bob"));
    }

    @Test
    void testDisplayBlockchain() throws Exception {
        // This method tests the displayBlockchain method by using reflection to call it directly
        // First, setup a sample blockchain
        java.lang.reflect.Method mainMethod = Main.class.getDeclaredMethod("main", String[].class);
        mainMethod.invoke(null, (Object) new String[]{});

        // Clear the output stream
        outContent.reset();

        // Call displayBlockchain method using reflection
        java.lang.reflect.Method displayMethod = Main.class.getDeclaredMethod("displayBlockchain");
        displayMethod.setAccessible(true);
        displayMethod.invoke(null);

        // Verify expected output
        String output = outContent.toString();
        assertTrue(output.contains("--- BLOCKCHAIN CONTENTS ---"));
        assertTrue(output.contains("Block #0"));
        assertTrue(output.contains("Previous Hash: 0"));
    }
}
