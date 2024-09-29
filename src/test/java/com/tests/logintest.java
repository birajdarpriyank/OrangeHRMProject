package com.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.base.base;
import com.pom.loginpage;
import com.utilities.extent_report;

public class logintest extends base{
	
	loginpage log;
	SoftAssert asr = new SoftAssert();
	
	@BeforeMethod
	public void SetUP() throws IOException
	{
		Initialization();
		log = new loginpage();
		extent_report.extentReportInitialization();
	}
	@Test(priority=1)
	public void Validatelogo() throws InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertTrue(log.logoisdisplayed());
		extent_report.extentReportCreateTest("Validatelogo");
	}
	@Test(priority=2)
	public void validateTitle()
	{
		String actual = driver.getTitle();
		String expected = pro.getProperty("logititle");
		asr.assertEquals(actual, expected);
		extent_report.extentReportCreateTest("validateTitle");
	}
	
	@Test(priority=3)
	public void ValidateURL()
	{
		String actual = driver.getCurrentUrl();
		String expected = pro.getProperty("loginurl");
		Assert.assertEquals(actual, expected);
		extent_report.extentReportCreateTest("ValidateURL");
	}
	
	@Test(priority=4)
	public void validateSuccessfullLogin() throws InterruptedException
	{
		log.SendUsername(log.fetchuserid());
		Thread.sleep(5000);
		log.SendPassword(log.fetchPassword());
		Thread.sleep(5000);
		log.ClickonLoginButton();
		String actual = driver.getCurrentUrl();
		String expected = pro.getProperty("homeurl");
		Assert.assertEquals(actual, expected);
		extent_report.extentReportCreateTest("validateSuccessfullLogin");
	}
	
	@Test(priority=5)
	public void ValidateloginwithBlankCredentials()
	{
		log.SendUsername("");
		log.SendPassword("");
		log.ClickonLoginButton();
		String actual = log.gettexterrormessageuser();
		String expected = pro.getProperty("errormessagetext");
		asr.assertEquals(actual, expected);
		String actual1 = log.gettexterrormessagepass();
		String expected1 = pro.getProperty("errormessagetext");
		asr.assertEquals(actual1, expected1);
		asr.assertAll();
		extent_report.extentReportCreateTest("ValidateloginwithBlankCredentials");
	}
	
	@Test(priority=6)
	public void Validateloginwithblankpass()
	{
		log.SendUsername(log.fetchuserid());
		log.SendPassword("");
		log.ClickonLoginButton();
		String actual = log.gettexterrormessagepass();
		String expected = pro.getProperty("errormessagetext");
		asr.assertEquals(actual, expected);
		asr.assertAll();
		extent_report.extentReportCreateTest("Validateloginwithblankpass");
	}
	
	@Test(priority=7)
	public void ValidateloginwithblankUsername()
	{
		log.SendUsername("");
		log.SendPassword(log.fetchPassword());
		log.ClickonLoginButton();
		String actual = log.gettexterrormessageuser();
		String expected = pro.getProperty("errormessagetext");
		asr.assertEquals(actual, expected);
		asr.assertAll();
		extent_report.extentReportCreateTest("ValidateloginwithblankUsername");
	}
	
	@Test(priority=8)
	public void validateloginwithinvalidcredentials()
	{
		log.SendUsername("HGYBFYTYTygyg dbfjsdgfuygu djfbjdhfb djfhjudhfud dkjfhudshfuhdbjufhdrufhu");
		log.SendPassword("jdbfjhb djfbjdhbfdbjfbdhjsbfhjdbghyfjbdhyjfbgydgbfyhug");
		log.ClickonLoginButton();
		String actual = log.gettexterrormsgforboth();
		String expected = pro.getProperty("wronguserandpasserror");
		Assert.assertEquals(actual, expected);
		extent_report.extentReportCreateTest("validateloginwithinvalidcredentials");
	}
	
	@Test(priority=9)
	public void Validateclickonforgottenpasslink()
	{
		log.Clickonforgottenpasslink();
		String actual = driver.getCurrentUrl();
		String expected = pro.getProperty("forgottenlink");
		Assert.assertEquals(actual, expected);
		extent_report.extentReportCreateTest("Validateclickonforgottenpasslink");
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
		extent_report.extentReportGenerate();
	}
	
	

}
