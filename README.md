# Practice
This repo is for practicing coding skills only
# Blockchain Demo Application

## Overview
This is a simple blockchain demonstration application that shows the basic concepts of blockchain technology including blocks, transactions, and hashing.

## Features
- Creation of blockchain with genesis block
- Adding transactions to blocks
- Simple hash calculation
- Complete test coverage

## Project Structure
- `src/` - Source code
  - `main.java.SimpleBlockchain.java` - main.java.SimpleBlockchain application entry point
  - `main.java.Block.java` - main.java.Block implementation
  - `main.java.Transaction.java` - main.java.Transaction implementation
  - `main.java.DSA.java` - Data structures and algorithms examples
- `test/` - Test cases for all classes

## Running the Application
```
java -cp target/classes main.java.SimpleBlockchain
```

## Running Tests
This project uses JUnit 5 for testing. You can run the tests in several ways:

### Using Maven (requires Maven installation)
```
mvn test
```
If you get the error `zsh: command not found: mvn`, you need to install Maven first. See the `SETUP_INSTRUCTIONS.md` file for detailed installation instructions.

### Using the provided scripts (no Maven required)
On macOS/Linux:
```bash
chmod +x run_tests.sh  # Make the script executable (first time only)
./run_tests.sh
```

On Windows:
```
run_tests.bat
```

### Manual Setup
If you're not using Maven, you'll need to download the following JUnit 5 JAR files and add them to your project's `lib` directory:

1. junit-jupiter-api-5.10.1.jar
2. junit-jupiter-engine-5.10.1.jar
3. junit-platform-commons-1.10.1.jar
4. junit-platform-engine-1.10.1.jar
5. opentest4j-1.3.0.jar

You can download these from the Maven Central Repository:
https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.10.1

Then configure your IDE to include these libraries in your project's classpath.

## Test Coverage
The project uses JaCoCo for test coverage reporting. After running tests with Maven, you can find the coverage report at:

```
target/site/jacoco/index.html
```

The test suite provides 100% code coverage for all classes in the application.

## Build Requirements
- Java SDK 24
- Maven 3.6 or higher