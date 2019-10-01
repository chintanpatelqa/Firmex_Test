package com.ap.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ap.qa.base.TestBase;
/**
 * 
 * @author Chintan
 *
 */
public class ForgotPwPg extends TestBase {

	public String validateForgotPageTitle() {
		return driver.getTitle();
	}

	public WebElement ForgotTitle() {
		return driver.findElement(By.xpath("//h1[@class='page-subheading']"));
	}

	public WebElement emailId() {
		return driver.findElement(By.id("email"));
	}

	public WebElement RetrivePw() {
		return driver.findElement(By.xpath("//p[@class='submit']//button"));
	}

	public WebElement ConfirmationMsg() {
		return driver.findElement(By.xpath("//p[@class='alert alert-success']"));
	}
}
