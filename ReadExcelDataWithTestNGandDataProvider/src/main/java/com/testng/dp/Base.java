package com.testng.dp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Base {
	
	public WebDriver driver;
	
  @BeforeClass
  public void beforeClass() throws IOException {
	  System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.17.0-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get(Constant.url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  ExcelUtility.setExcelFile(Constant.path, Constant.sheetName);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
