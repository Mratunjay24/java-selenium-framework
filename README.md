# Java Selenium Framework

This is a Selenium test automation framework built using **Java**, **Maven**, and **TestNG**.  
It is designed to support UI test automation with reusable components, page object model (POM) design, and easy scalability.# Java Selenium Framework
java-selenium-framework
│── .idea/ # IntelliJ project settings
│── src/main/ # Application source files (if any)
│── src/test/java/ # Test classes
│── src/test/resources/ # Test resources (config, test data, etc.)
│── pom.xml # Maven configuration file
│── .gitignore # Files to be ignored by Git

## ⚙️ Prerequisites

- [Java JDK 8+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [IntelliJ IDEA / Eclipse](https://www.jetbrains.com/idea/download/)
- [Google Chrome](https://www.google.com/chrome/)
- [ChromeDriver](https://chromedriver.chromium.org/downloads) (matching your Chrome version)

## 🚀 How to Run Tests

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/java-selenium-framework.git
   cd java-selenium-framework

2. Run tests with Maven:
mvn clean test

3. Reports will be generated inside:
target/surefire-reports/

🧩 Features

Java + Selenium WebDriver
Maven for build and dependency management
TestNG for test execution & reporting
Page Object Model (POM) for better maintainability
Cross-browser support (Chrome, Firefox, Edge, etc.)
Extensible structure for adding more tests

📖 Example Test (Sample)
@Test
public void openGoogleTest() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    Assert.assertEquals(driver.getTitle(), "Google");
    driver.quit();
}

📌 Next Steps

Add utility classes (driver manager, config reader, etc.)
Integrate with reporting tools (Extent Report, Allure Report)
Add CI/CD support (Jenkins, GitHub Actions)

👨‍💻 Author
Mratunjay Sharma

📜 License
Feel free to use and modify.
