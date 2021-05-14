package com.generalstore.commonutils;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.util.Set;


public class FunctionUtils  {
	static AndroidDriver<AndroidElement> driver;
	
public FunctionUtils(AndroidDriver<AndroidElement> driver)
{
	this.driver=driver;
}
	
	public static  void text_To_Input(AndroidElement ele, String text)
	{
		ele.sendKeys(text);
	}
	
	public static  void click(AndroidElement ele)
	{
		ele.click();
	}
	
	public  void scrollToText(String text) throws InterruptedException
	{
		Thread.sleep(6000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"'"+text+"'\"));");
	}

	public static void tapActions(WebElement ele)
	{
		 TouchAction action=new TouchAction(driver);
	      action.tap(tapOptions().withElement(element(ele))).perform();
	}
	
	public static void longpressAction(WebElement ele)
	{
		TouchAction action=new TouchAction(driver);
		action.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(6))).release().perform();
	}
	
	public static void   getContext()
	{
		Set<String>  contexts=driver.getContextHandles();
		
		for(String newcontext: contexts)
		{
			System.out.println("************"+newcontext);
			if(newcontext.contains("WEBVIEW"))
			{
				driver.context(newcontext);
			}
			
		}
		
		
	}
}
