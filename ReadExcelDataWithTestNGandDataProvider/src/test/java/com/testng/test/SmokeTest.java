package com.testng.test;

import org.testng.annotations.Test;

import com.testng.dp.Base;
import com.testng.dp.ExcelUtility;
import com.testng.dp.Util;

import org.testng.annotations.DataProvider;

public class SmokeTest extends Base {

	@DataProvider(name = "login")
	public Object[][] dp() 
	{
		Object[][] data = ExcelUtility.getTestData();
		return data;
	}

	@Test(dataProvider = "login")
	public void test(String userName, String password) 
	
	{

		Util util = new Util(driver);
		util.typeUsername(userName, password);
	}
}
