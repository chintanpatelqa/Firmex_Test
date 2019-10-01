package com.ap.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ap.qa.base.TestBase;

/**
 * 
 * @author Chintan
 *
 */
public class HomePage extends TestBase {

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public WebElement SignInButton() {
		return driver.findElement(By.xpath("//a[@class='button login']"));
	}

}
