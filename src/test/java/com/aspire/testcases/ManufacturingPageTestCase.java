package com.aspire.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aspire.base.Base;
import com.aspire.pagesObjects.LoginPage;
import com.aspire.pagesObjects.ManufacturingPage;

public class ManufacturingPageTestCase extends Base {

	LoginPage loginPage;
	ManufacturingPage manufacturingPage;

	public ManufacturingPageTestCase() {
		// call base class constructor
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		 loginPage=new LoginPage();
		 manufacturingPage=new ManufacturingPage();
	}

	//This method will create manufacture for created product
	@Test
	public void verifyManufacutureCreated()    {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		manufacturingPage.createManufacture();
		String OrdDone=manufacturingPage.orderDone.getText();
		Assert.assertEquals(OrdDone, "Aspire Demo Product");
	}
	
	//This method will close all browsers
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	

}
