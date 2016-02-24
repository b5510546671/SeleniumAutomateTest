package com.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RorPapTestOnChrome {
	
	private static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {

		// Setup google chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\library\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://localhost:8080/#!/");
		
		testSignUpForPasswordMatching();
		

		//driver.close();

	}
	
	/**
	 * Test for Create User Account module.
	 * 		Test for signing up when password mismatch.
	 * @throws InterruptedException 
	 */
	public static void testSignUpForPasswordMatching() throws InterruptedException{
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("firstName")).sendKeys("TesterName");
		driver.findElement(By.id("lastName")).sendKeys("TesterLastName");
		driver.findElement(By.id("emailAddress")).sendKeys("testerX1@tester.com");
		driver.findElement(By.id("password1")).sendKeys("123456");
		driver.findElement(By.id("password2")).sendKeys("123456");
		
		WebElement dateWidget = driver.findElement(By.id("dateOfBirth"));
		dateWidget.
		List<WebElement> columns = dateWidget.findElements(By.ta)
		
		/*((JavascriptExecutor)driver).executeScript ("document.getElementById('dateOfBirth').removeAttribute('type',0);");
		WebElement dateOfBirth= driver.findElement(By.id("dateOfBirth"));
		dateOfBirth.clear();
		dateOfBirth.sendKeys("20/01/2016");*/
		
		/*WebElement element = driver.findElement(By.id("acceptPolicy"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(element).click().perform();*/
		
		if(!driver.findElement(By.id("acceptPolicyLabel")).isSelected()){
			driver.findElement(By.id("acceptPolicyLabel")).click();
		}
		
		//driver.findElement(By.xpath("//div[@id='modalSignup']/div/form[@id='signUpForm']/div/center/input[@id='acceptPolicy']")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 60);
		
		
		Thread.sleep(3000);
		driver.findElement(By.id("signUpBtn")).click();
		//driver.findElement(By.linkText("SIGN UP")).click();
		
		
		
		//driver.findElement(By.xpath("//div[@id='modalSignup']/div/form[@id='signUpForm']/div/center/input[@id='acceptPolicy']")).click();
		
		Thread.sleep(3000);
		
		System.out.println("I'm done with \'Test Sign Up For Password Matching \'");
	}

}
