package com.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.base;

public class loginpage extends base{
	
	
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='company-branding']")
	private WebElement logo;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p'][1]")
	private WebElement usernamecred;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p'][2]")
	private WebElement passwordcred;
	
	@FindBy(name="username")
	private WebElement usernametextbox;
	
	@FindBy(name="password")
	private WebElement passwordtextbox;
	
	@FindBy(xpath="//div[@class='oxd-input-group__label-wrapper']/i")
	private WebElement usericon;
	
	@FindBy(xpath="//div[@class='oxd-input-group__label-wrapper']/label")
	private WebElement usernametitle;
	
	@FindBy(xpath="//label[text()='Password']")
	private WebElement passtitle;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-key oxd-input-group__label-icon']")
	private WebElement passicon;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement loginbutton;
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	private WebElement forgootepasslink;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][1]")
	private WebElement errormessageuser;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	private WebElement errormessagepass;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement commonerrormessage;
	
	public boolean logoisdisplayed()
	{
		boolean e = logo.isDisplayed();
		return e;
	}
	
	public String fetchuserid()
	{
		String e = usernamecred.getText();
		 return e.substring(e.indexOf('A'));
	}
	
	public String fetchPassword()
	{
		String e = passwordcred.getText();
		return e.substring(e.lastIndexOf('a'));
	}
	
	public String SendUsername(String e)
	{
		String a = usernametextbox.getText();
		System.out.println(a);
		usernametextbox.sendKeys(e);
		System.out.println("Entered Username");
		return a;
	}
	
	public String SendPassword(String e)
	{
		String a = passwordtextbox.getText();
		System.out.println(a);
		passwordtextbox.sendKeys(e);
		System.out.println("Entered Password");
		return a;
	}
	
	public boolean UsernameFildIcon()
	{
		boolean e = usericon.isDisplayed();
		return e;
	}
	
	public boolean Passworfildicon()
	{
		boolean e = passicon.isDisplayed();
		return e;
	}
	
	public String GetTittleonusernamefield()
	{
		String e = usernametitle.getText();
		return e;
	}

	public String GetTitleofpasswordFeild()
	{
		String e = passtitle.getText();
		return e;
	}
	
	public loginpage ClickonLoginButton()
	{
		if(loginbutton.isEnabled())
		{
			loginbutton.click();
		}
		return new loginpage();
	}
	
	public forgottepasspage Clickonforgottenpasslink()
	{
		if(forgootepasslink.isEnabled())
		{
			forgootepasslink.click();
		}
		return new forgottepasspage();
	}
	
	public String gettexterrormessageuser()
	{
			String e = errormessageuser.getText();
		return e;
	}
	
	public String gettexterrormessagepass()
	{
			String e = errormessagepass.getText();
		return e;
	}
	
	public String gettexterrormsgforboth()
     {
		String e = commonerrormessage.getText();
		return e;
	}
}
