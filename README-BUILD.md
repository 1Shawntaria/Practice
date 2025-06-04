# Build Instructions

## Maven Build

To build the project with Maven:

```
mvn clean compile
```

To run the tests:

```
mvn test
```

To package the application:

```
mvn package
```

## Build Troubleshooting

If you're experiencing build failures, try the following:

1. **Clean and rebuild**: `mvn clean install`

2. **Check Java version**: Make sure you're using Java 24 as specified in the pom.xml
   ```
   java -version
   ```

3. **Check Maven version**: Make sure you're using Maven 3.6 or higher
   ```
   mvn -version
   ```

4. **Debug Maven build**: For more verbose output, use
   ```
   mvn clean install -X
   ```

5. **Verify directory structure**: Ensure your source files are in the correct directories
   - main.java.SimpleBlockchain Java files should be in: `/src`
   - Test Java files should be in: `/test`

6. **Update dependencies**: Try running
   ```
   mvn dependency:resolve
   ```

If you're still experiencing issues, check the Maven output for specific error messages.
