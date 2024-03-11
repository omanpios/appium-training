package android.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import android.pageObjects.FormPage;
import android.utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest extends AppiumUtils{
	
	public AndroidDriver driver;
	public AppiumDriverLocalService appium;
	public FormPage formPage;
	
	@BeforeClass(alwaysRun = true)
	public void configureAppium() throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/android/resources/data.properties");
		props.load(fis);
		String ipAddress = System.getProperty("IP_ADDRESS") != null ? System.getProperty("IP_ADDRESS")
				: props.getProperty("IP_ADDRESS");
		String port = props.getProperty("PORT");
		String deviceName = props.getProperty("ANDROID_DEVICE");

		appium = startAppiumServer(ipAddress, Integer.parseInt(port));
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp(System.getProperty("user.dir") + "/src/test/java/android/app/General-Store.apk");

		driver = new AndroidDriver(appium.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		appium.stop();
		System.out.println("Appium stopped!");
	}
}
