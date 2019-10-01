package com.ap.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ap.qa.base.TestBase;

/**
 * 
 * @author Chintan
 *
 */
public class LoginPage extends TestBase {

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public WebElement emailID() {
		return driver.findElement(By.xpath("//form[@id='loginForm']//div[@id='div_login_email']"));
	}

	public WebElement password() {
		return driver.findElement(By.xpath("//input[@id='login_pw']"));
	}

	public void ClickNextButton() {
		driver.findElement(By.xpath("//div[@class='usernameBtn']//input")).click();
	}

	public void ClickLoginButton() {
		driver.findElement(By.xpath("//input[@id='login_btn']")).click();
	}

	public WebElement ErrorMsg() {
		return driver.findElement(By.xpath("//div[@class='form-message m15t ']//p"));
	}

	public WebElement MailErrorMsg() {
		return driver.findElement(By.xpath("//div[@class='form-message']//p"));
	}

}
