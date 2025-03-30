package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators: page objects
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By logo = By.cssSelector("img.img-responsive");
	

	// 2. public page constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. public page Actions/Method
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE,
				AppConstants.DEFAULT_SHORT_TIME_OUT);

//		String title = driver.getTitle();
		System.out.println("Login page titile : " + title);
		return title;
	}

	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL,
				AppConstants.DEFAULT_SHORT_TIME_OUT);

//		String url = driver.getCurrentUrl();
		System.out.println("Login page titile : " + url);
		return url;
	}

	public boolean isForgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgotPwdLink);
//		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public boolean isLogoExist() {
		return eleUtil.isElementDisplayed(logo);
//		return driver.findElement(logo).isDisplayed();
	}

	public AccountsPage doLogin(String userName, String pwd) {
		System.out.println("User credentials : " + userName + " & " + pwd);
		eleUtil.waitForElementVisible(username, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);

//		driver.findElement(username).sendKeys(userName);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
//		String accPageTitle = driver.getTitle();

//		String accPageTitle = eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNTS_PAGE_TITLE,
//				AppConstants.DEFAULT_SHORT_TIME_OUT);
//		System.out.println("Acc page title: " + accPageTitle);
//		return accPageTitle;
	}
	
	public RegisterPage navigateToRegisterPage() {
	    eleUtil.doClick(registerLink);
	    return new RegisterPage(driver);
	}
}
