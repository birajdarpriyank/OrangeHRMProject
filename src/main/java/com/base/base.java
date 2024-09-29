package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static WebDriver driver;
	public Properties pro;
	
	public WebDriver Initialization()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 
		pro = new Properties();
		

		try {
			FileInputStream file = new FileInputStream("D:\\OLD LAPTOP DATA\\DESK DATA\\eclipse-workspace\\Orange_HRM_project\\src\\test\\resources\\Properties\\config.properties");
				pro.load(file);
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}
		catch (IOException e1) {
			
			e1.printStackTrace();
			throw new RuntimeException(e1);
		}
		
		driver.get(pro.getProperty("loginurl"));
		return driver;
	
	}

}
