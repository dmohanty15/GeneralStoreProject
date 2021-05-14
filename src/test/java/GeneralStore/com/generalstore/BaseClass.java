package GeneralStore.com.generalstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass  {
	public static AndroidDriver<AndroidElement> driver;
	static AppiumDriverLocalService service;
	
	public static AppiumDriverLocalService startServer()
	{
		//
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	
	public void startEmulator() throws IOException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\DineshEmulator.bat");
	}
	

	public AndroidDriver<AndroidElement> getCapabilities() throws IOException, InterruptedException
	{
		//startServer();
		DesiredCapabilities cap=new DesiredCapabilities();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\globalconfig.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
	    File  file=new File(System.getProperty("user.dir")+"\\src\\main\\resources");
		File app=new File(file,(String) prop.get("AppName"));
		
		String device=(String) prop.get("DeviceName");
		if(device.contains("Emulator"))
		{
			startEmulator();
			Thread.sleep(6000);
		}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		//cap.setCapability(MobileCapabilityType.ACCEPT_SSL_CERTS, true);
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public static  void getScreenshot(String str) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\GeneralStoreAppium\\com.generalstore\\target\\'"+str+"'.png"));
	}

}
