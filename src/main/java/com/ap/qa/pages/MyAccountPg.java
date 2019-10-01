package com.ap.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ap.qa.base.TestBase;
/**
 * 
 * @author Chintan
 *
 */
public class MyAccountPg extends TestBase {

	public String validateMyAccountPage() {
		return driver.getTitle();
	}

	public WebElement Username() {
		return driver.findElement(By.xpath("//div[@class='header_user_info']//a[@class='account']"));
	}
	
	public WebElement logout() {
		return driver.findElement(By.className("logout"));
	}
}
