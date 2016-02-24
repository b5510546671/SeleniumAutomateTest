package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class googleSearchTesting {
	
	public static void main(String[] args) throws InterruptedException {
		// Create firefox driver to drive browser
		WebDriver driver = new FirefoxDriver();
		// Open google home page
		driver.get("http://www.google.co.th");
		
		// Find what field and enter selenium
		Thread.sleep(2000);
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
		
		// Find location field and enter Kasetsart
		
		// Find Google Search button and click on it
		Thread.sleep(2000);
		driver.findElement(By.name("btnG")).click();
		// From result page, get page title and records found message
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.id("resultStats")).getText());
		driver.close();
	}
	
}
