package com.generalstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CheckoutPage extends BasePage{

	public CheckoutPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    @FindBy(className="android.widget.CheckBox")
	 public WebElement checkbox_terms;
    
    @FindBy(id="com.androidsample.generalstore:id/btnProceed")
	 public WebElement btn_visitToWebsite;
    
    @FindBy(xpath="//a[contains(.,'Sign')]")
	public WebElement link_sign;

}
