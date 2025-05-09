package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}

	public String getRandomEmail() {
		return "uiautomation" + System.currentTimeMillis() + "@open.com";
	}

	@DataProvider
	public Object[][] getRegData() {
		return ExcelUtil.getTestData(AppConstants.REG_SHEET_NAME);
	}

	@Test(dataProvider = "getRegData")
	public void userRegisterTest(String firstname, String lastmame, String telephone, String password, String subscribe) {
		Assert.assertTrue(registerPage.userRegistration(firstname, lastmame, getRandomEmail(), telephone, password, subscribe));
	}

//	@Test  // without data provider
//	public void userRegisterTest() {
//		Assert.assertTrue(registerPage.userRegistration("Veena", "automation", getRandomEmail(), "9876567654",
//				"veena@123", "yes"));
//	}

}
