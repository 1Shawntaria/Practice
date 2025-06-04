# Maven Installation Instructions

## macOS

### Using Homebrew (Recommended)

1. Install Homebrew if you haven't already:
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```

2. Install Maven:
   ```bash
   brew install maven
   ```

3. Verify installation:
   ```bash
   mvn -version
   ```

### Manual Installation

1. Download Maven from https://maven.apache.org/download.cgi
2. Extract the archive:
   ```bash
   tar -xzvf apache-maven-3.9.5-bin.tar.gz
   ```
3. Move to /opt or another location:
   ```bash
   sudo mv apache-maven-3.9.5 /opt/
   ```
4. Add to PATH in your ~/.zshrc file:
   ```bash
   echo 'export PATH="/opt/apache-maven-3.9.5/bin:$PATH"' >> ~/.zshrc
   source ~/.zshrc
   ```

## Windows

1. Download Maven binary zip archive from https://maven.apache.org/download.cgi
2. Unzip to a directory of your choice (e.g., C:\Program Files\Apache\maven)
3. Add Maven bin directory to the PATH environment variable:
   - Right-click on 'This PC' or 'My Computer' and select 'Properties'
   - Click 'Advanced system settings'
   - Click 'Environment Variables'
   - Under System Variables, find 'Path' and click 'Edit'
   - Add the path to Maven bin directory (e.g., C:\Program Files\Apache\maven\bin)
   - Click 'OK' to close all dialogs
4. Verify installation by opening a new command prompt and typing:
   ```cmd
   mvn -version
   ```

## Linux

### Using package manager

For Ubuntu/Debian:
```bash
sudo apt update
sudo apt install maven
```

For Fedora:
```bash
sudo dnf install maven
```

For CentOS/RHEL:
```bash
sudo yum install maven
```

### Manual Installation

1. Download Maven from https://maven.apache.org/download.cgi
2. Extract the archive:
   ```bash
   tar -xzvf apache-maven-3.9.5-bin.tar.gz
   ```
3. Move to /opt:
   ```bash
   sudo mv apache-maven-3.9.5 /opt/
   ```
4. Add to PATH in your ~/.bashrc or ~/.zshrc:
   ```bash
   echo 'export PATH="/opt/apache-maven-3.9.5/bin:$PATH"' >> ~/.bashrc
   source ~/.bashrc
   ```

## Alternative: Running without Maven installation

If you're unable to install Maven, you can use IntelliJ IDEA's built-in Maven integration:

1. Open your project in IntelliJ IDEA
2. Right-click on the `pom.xml` file
3. Select 'Add as Maven Project'
4. Use the Maven tool window (usually on the right side) to run Maven commands

Or use the Maven wrapper:

1. Add the Maven wrapper to your project:
   ```bash
   mvn wrapper:wrapper
   ```
2. Use the wrapper script to run Maven commands:
   - On Unix/macOS: `./mvnw clean install`
   - On Windows: `mvnw.cmd clean install`
