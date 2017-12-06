package com.testng.dp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Util {
	WebDriver driver;

	public Util(WebDriver driver) {
		this.driver = driver;

	}

	public void typeUsername(String username, String pass)

	{

		SoftAssert sa = new SoftAssert();
		driver.findElement(By.name("login_email")).sendKeys(username);
		driver.findElement(By.name("login_password")).sendKeys(pass);
		driver.findElement(By.name("submit")).click();
		String logoutText = driver.findElement(By.xpath("//div[@id='header_container']//div[3]/a[2]")).getText();
		System.out.println(logoutText);
		sa.assertTrue(logoutText.contains("LOGOUT"), "User is not able to login");
		sa.assertAll();

	}
}
