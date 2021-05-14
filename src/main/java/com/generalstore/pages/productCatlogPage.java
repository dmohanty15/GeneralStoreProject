package com.generalstore.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class productCatlogPage extends BasePage {

	public productCatlogPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public List<AndroidElement> list_Products;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public List<AndroidElement> btn_addToCart;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public AndroidElement icon_Cart;
	
	
}
