package org.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

         WebDriver driver;
         String url = "https://automationexercise.com/products";

            System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
            System.out.println("STEP - Open Chrome Browser");
            driver = new ChromeDriver();
            System.out.println("STEP - Enter url");
            driver.get(url);
            driver.switchTo().defaultContent();
            driver.manage().window().maximize();





    }
}