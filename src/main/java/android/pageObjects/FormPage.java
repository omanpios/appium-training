package android.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import android.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage extends AndroidActions {

	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	private WebElement title;

	public String title() {
		return title.getText();
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[189,829][1251,895]']")
	private WebElement countryLabel;

	public String countryLabel() {
		return countryLabel.getText();
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryDropDown;

	public void setCountry(String country) {
		countryDropDown.click();
		scrollToText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + country + "\"]")).click();
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[189,1163][1251,1229]']")
	private WebElement nameInputLabel;

	public String nameInputLabel() {
		return nameInputLabel.getText();
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameInput;

	public void setName(String name) {
		nameInput.sendKeys(name);
		driver.hideKeyboard();
	};

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;

	public void setGender(String gender) {
		if (gender.contains("female")) {
			femaleOption.click();
		} else {
			maleOption.click();
		}
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButton;
	
	public void clickLetsShopButton() {
		letsShopButton.click();
	}	
}
