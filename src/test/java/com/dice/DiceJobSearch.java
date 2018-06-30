package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	public static void main(String[] args) throws InterruptedException{
		//set up chrome driver path
		WebDriverManager.chromedriver().setup();
//		invoke selenium driver
		WebDriver driver = new ChromeDriver();
		//fullscreen
		driver.manage().window().fullscreen();
		//set universal  wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		//step 1-launch browser and navigate to https://dice.com
//		expected; dice hime page should be displayed
		
		String url="https://dice.com";
		driver.get(url);
		String actualTitle=driver.getTitle();
//		System.out.println(actualTitle+"actualTitle");
		String expectedTitle="Job Search for Technology Professionals | Dice.com";
		
		if(actualTitle.equals(expectedTitle) ){
			System.out.println("Step passed");
			}else {
				System.out.println("Loading failed");
				throw new RuntimeException("Loading failed2");
			}
		String keyword="Java Developer";
		//clears the field
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		 String location ="11720";
		 driver.findElement(By.id("search-field-location")).clear();
		 driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		 driver.findElement(By.id("findTechJobs")).click();
		 String count = driver.findElement(By.id("posiCountMobileId")).getText();
		 System.out.println(count);
		 
		driver.close();
	}

}
