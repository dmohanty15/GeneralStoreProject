package GenaralStore.com.resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import GeneralStore.com.generalstore.BaseClass;

public class ListenerClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
	    // not implemented
		String str=result.getName();
		try {
			BaseClass.getScreenshot(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
