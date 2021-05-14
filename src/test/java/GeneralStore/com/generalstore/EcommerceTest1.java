package GeneralStore.com.generalstore;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.generalstore.commonutils.FunctionUtils;
import com.generalstore.pages.HomePage;
import com.generalstore.pages.productCatlogPage;

import io.appium.java_client.MobileBy;

public class EcommerceTest1 extends BaseClass{
	Logger log=Logger.getLogger(EcommerceTest1.class);
	
	@Test
	public void ecommerceTest1() throws IOException, InterruptedException
	{
		driver=getCapabilities();
		HomePage homepage=new HomePage(driver);
		log.info("clcik on Country spinner");
		FunctionUtils.click(homepage.spinner_Country);
		FunctionUtils functionutil=new FunctionUtils(driver);
		//functionutil.scrollToText("Argentina");
		log.info("scroll to adgentina");
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
	}

}
