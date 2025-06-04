# Running Tests Without Maven

## Using IntelliJ IDEA

If you cannot install Maven or prefer to use IntelliJ's built-in test runner:

1. Make sure you have the JUnit libraries in this folder:
   - junit-jupiter-api-5.10.1.jar
   - junit-jupiter-engine-5.10.1.jar
   - junit-platform-commons-1.10.1.jar
   - junit-platform-engine-1.10.1.jar
   - opentest4j-1.3.0.jar

2. In IntelliJ, right-click on the test directory
3. Select 'Run All Tests'

## Manually Running Tests

You can also run tests from the command line without Maven:

```bash
# Compile the main code
javac -d out/production -cp src src/*.java

# Compile the test code
javac -d out/test -cp out/production:lib/* test/*.java

# Run the tests
java -cp out/production:out/test:lib/* org.junit.platform.console.ConsoleLauncher --scan-classpath
```

## Downloading JUnit JARs

To download the JUnit JARs without Maven:

1. Visit the Maven repository website:
   - JUnit Jupiter API: https://repo1.maven.org/maven2/org/junit/jupiter/junit-jupiter-api/5.10.1/
   - JUnit Jupiter Engine: https://repo1.maven.org/maven2/org/junit/jupiter/junit-jupiter-engine/5.10.1/
   - JUnit Platform Commons: https://repo1.maven.org/maven2/org/junit/platform/junit-platform-commons/1.10.1/
   - JUnit Platform Engine: https://repo1.maven.org/maven2/org/junit/platform/junit-platform-engine/1.10.1/
   - OpenTest4J: https://repo1.maven.org/maven2/org/opentest4j/opentest4j/1.3.0/

2. Download the .jar files and place them in the lib/ directory

3. For the console launcher, also download:
   - JUnit Platform Console: https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console/1.10.1/junit-platform-console-1.10.1.jar
