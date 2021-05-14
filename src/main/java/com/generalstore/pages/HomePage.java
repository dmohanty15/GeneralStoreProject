package com.generalstore.pages;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

	public HomePage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public AndroidElement spinner_Country;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Argentina']")
	public AndroidElement spinner_Argentina;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public AndroidElement txtbox_Name;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	public AndroidElement radio_Female;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public AndroidElement Btn_Letsgo;
	
	
}
