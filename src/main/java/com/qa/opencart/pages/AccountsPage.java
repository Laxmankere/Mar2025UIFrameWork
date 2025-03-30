package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	// WebDriver instance
	private WebDriver driver;
	// Utility class instance for element interactions
	private ElementUtil eleUtil;

	// Locators
	private By logoutLink = By.linkText("Logout");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");

	// Constructor to initialize WebDriver and ElementUtil
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. public page Actions/Method
	public String getAccountsPageTitle() {
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNTS_PAGE_TITLE,
				AppConstants.DEFAULT_SHORT_TIME_OUT);

//		String title = driver.getTitle();
		System.out.println("Accounts page titile : " + title);
		return title;
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.isElementDisplayed(logoutLink);
//		return driver.findElement(logoutLink).isDisplayed();
	}
	
	public int getTotalAccountsPageHeader() {
	    return eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
	}

	public List<String> getAccPageHeaders() {
		List<WebElement> headersList = eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		// Create a list to store the header texts
		List<String> headersValueList = new ArrayList<String>();
		// Iterate through the header elements and extract their text
		for (WebElement e : headersList) {
			String header = e.getText();
			headersValueList.add(header);
		}
		// Return the list of header values
		return headersValueList;
	}
	
	public ResultsPage doSearch(String searchKey) {
	    System.out.println("Search Key ==> " + searchKey);
	    WebElement searchEle = eleUtil.waitForElementVisible(search, AppConstants.DEFAULT_SHORT_TIME_OUT);
	    eleUtil.doSendKeys(searchEle, searchKey);
	    eleUtil.doClick(searchIcon);
	    return new ResultsPage(driver);
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
