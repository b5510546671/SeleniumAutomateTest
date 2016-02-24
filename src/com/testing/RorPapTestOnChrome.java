package com.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RorPapTestOnChrome {
	
	private WebDriver driver;
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password1;
	private String password2;
	
	
	public RorPapTestOnChrome(){
		try {
			// Setup google chrome driver
			System.setProperty("webdriver.chrome.driver", "C:\\library\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://localhost:8080/#!/");
			
			init();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Some Error Has Occured in RorPapTestOnChrome.java");
			e.printStackTrace();
		}
	}
	

	public void init() throws InterruptedException {
		
		testSignUpForPasswordMisMatching();
		testSignUpWithIncorrectDateOfBirth();
		
		driver.close();

	}
	
	/**
	 * Test for Create User Account module.
	 * 		Test for signing up when the date of birth is invalid.
	 * @throws InterruptedException 
	 */
	private void testSignUpWithIncorrectDateOfBirth() throws InterruptedException {
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("firstName")).sendKeys("TesterName1");
		driver.findElement(By.id("lastName")).sendKeys("TesterLastName1");
		driver.findElement(By.id("emailAddress")).sendKeys("testerX2@tester.com");
		driver.findElement(By.id("password1")).sendKeys("123456");
		driver.findElement(By.id("password2")).sendKeys("123456");
		
		WebElement dateOfBirth= driver.findElement(By.id("dateOfBirth"));
		// Set Date to be 31
		for(int i = 0; i < 31; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}		
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Month to be February
		for(int i = 0; i < 2; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Year to be 2016
		dateOfBirth.sendKeys(Keys.ARROW_UP);
		
		if(!driver.findElement(By.id("acceptPolicyLabel")).isSelected()){
			driver.findElement(By.id("acceptPolicyLabel")).click();
		}
		
		driver.findElement(By.id("signUpBtn")).click();
				
		Thread.sleep(3000);
		
		System.out.println("I'm done with \'Test Sign Up When Date of Birth is invalid.\'");		
	}


	/**
	 * Test for Create User Account module.
	 * 		Test for signing up when password mismatch.
	 * @throws InterruptedException 
	 */
	public void testSignUpForPasswordMisMatching() throws InterruptedException{
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("firstName")).sendKeys("TesterName");
		driver.findElement(By.id("lastName")).sendKeys("TesterLastName");
		driver.findElement(By.id("emailAddress")).sendKeys("testerX1@tester.com");
		driver.findElement(By.id("password1")).sendKeys("123456");
		driver.findElement(By.id("password2")).sendKeys("654321");
		
		WebElement dateOfBirth= driver.findElement(By.id("dateOfBirth"));
		dateOfBirth.sendKeys(Keys.ARROW_UP);
		dateOfBirth.sendKeys(Keys.TAB);
		dateOfBirth.sendKeys(Keys.ARROW_UP);
		dateOfBirth.sendKeys(Keys.TAB);
		dateOfBirth.sendKeys(Keys.ARROW_UP);
		
		if(!driver.findElement(By.id("acceptPolicyLabel")).isSelected()){
			driver.findElement(By.id("acceptPolicyLabel")).click();
		}
		
		driver.findElement(By.id("signUpBtn")).click();
				
		Thread.sleep(3000);
		
		System.out.println("I'm done with \'Test Sign Up For Password Mismatching\'");
	}

}
