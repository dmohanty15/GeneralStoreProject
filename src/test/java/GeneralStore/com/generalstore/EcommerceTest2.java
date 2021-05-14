package GeneralStore.com.generalstore;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import com.generalstore.commonutils.FunctionUtils;
import com.generalstore.pages.CheckoutPage;
import com.generalstore.pages.HomePage;
import com.generalstore.pages.productCatlogPage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class EcommerceTest2 extends BaseClass {
	
	
	@Test
	public void ecommerceTest2() throws InterruptedException, IOException
	{
		driver=getCapabilities();
		HomePage homepage=new HomePage(driver);
		FunctionUtils.click(homepage.spinner_Country);
		FunctionUtils functionutil=new FunctionUtils(driver);
		//functionutil.scrollToText("Argentina");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		FunctionUtils.click(homepage.spinner_Argentina);
		FunctionUtils.text_To_Input(homepage.txtbox_Name, "text");
		driver.hideKeyboard();
		
		FunctionUtils.click(homepage.radio_Female);
		FunctionUtils.click(homepage.Btn_Letsgo);
		Thread.sleep(4000);
		productCatlogPage pcpage=new productCatlogPage(driver);
		int count =pcpage.list_Products.size();
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollIntoView(text(\"Converse All Star\"));");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Converse All Star\").instance(0))"));
	//	System.out.println("******************"+i);
		for (int i=0;i<count;i++)
		{
			if(pcpage.list_Products.get(i).getText().equalsIgnoreCase("Converse All Star"))
			{
				FunctionUtils.click(pcpage.btn_addToCart.get(i));
			}
			else if(pcpage.list_Products.get(i).getText().equalsIgnoreCase("Air Jordan 9 Retro"))
			{
				FunctionUtils.click(pcpage.btn_addToCart.get(i));
			}
		}
		
	     FunctionUtils.click(pcpage.icon_Cart);
	     CheckoutPage check=new CheckoutPage(driver);
	     FunctionUtils.tapActions(check.checkbox_terms);
	     FunctionUtils.longpressAction(check.btn_visitToWebsite);
	     //Set<String>  contexts=FunctionUtils.getContext();
	     FunctionUtils.getContext();
	     FunctionUtils.click((AndroidElement) check.link_sign);
	   //  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	     
	    
	    		  }
	
	@Test
	public void Test2()
	{
		System.out.println("Test2");
	}

	}


