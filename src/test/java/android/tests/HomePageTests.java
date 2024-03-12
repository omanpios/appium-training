package android.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import android.testUtils.BaseTest;

public class HomePageTests extends BaseTest{

	@Test
	public void checkTitle() {
		String title = formPage.title();
		Assert.assertEquals(title, "General Store");
	}
	
	@Test
	public void checkCountryLabel() {
		String countryLabel = formPage.countryLabel();
		Assert.assertEquals(countryLabel, "Select the country where you want to shop");
	}
	
	@Test
	public void checkNameLabel() {
		String nameLabel = formPage.nameInputLabel();
		Assert.assertEquals(nameLabel, "Your Name");
	}
	
	@Test
	public void checkDropDown() {
		formPage.setCountry("Colombia");
		String selectedCountry = formPage.selectedCountry();
		Assert.assertEquals(selectedCountry, "Colombia");
	}
	
	@Test
	public void checkGenderRadioButtons() {
		formPage.setGender("male");
		Assert.assertEquals(formPage.isMaleSelected(), "true");
		formPage.setGender("female");
		Assert.assertEquals(formPage.isFemaleSelected(), "true");
	}
}
