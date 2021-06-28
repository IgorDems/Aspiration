package pages;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ProductPage {
	WebDriver driver;

	String prodpagetitle = "Cash Management Services - Investing & Retirement Planning | Aspiration";

	By aspiretion_pic = By.xpath("//div[contains(@class,'card-original')]");
	By aspiretion_pic2 = By.xpath("//div[contains(@class,'card-plus')]");
	By aspiretionplus_pic = By.xpath("//div[contains(@class,'logo-original')]");
	By aspiretionplus_pic2 = By.xpath("//div[contains(@class,'logo-plus')]");

	By aspiretion_but = By.xpath("//button[contains(@ng-click,'getOriginalPlan()')]");
	By aspiretionplus_but = By.xpath("//button[contains(@ng-click,'getAspirationPlus()')]");

	By modalasp_email = By.xpath("//input[contains(@name,'email')]");
	By modalasp_start = By.xpath("//div[contains(text(),'Get Started')]");

	By modalasp_year = By.xpath("//*[contains(text(),'Yearly')]");
	By modalasp_month = By.xpath("//*[contains(text(),'Monthly')]");

	By modalasp_text_year = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/p");
	By modalasp_text_month = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/p");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
//	public ProductPage() {
//		
//	}

	public void isProdPage() {
		String title = driver.getTitle();
		assertEquals(prodpagetitle, title);
	}

	public void isTwoProdDisplayed() {
		driver.findElement(aspiretion_pic).isDisplayed();
		driver.findElement(aspiretion_pic2).isDisplayed();
		driver.findElement(aspiretionplus_pic).isDisplayed();
		driver.findElement(aspiretionplus_pic2).isDisplayed();
	}

	public void getAspiration() {
		driver.findElement(aspiretion_but).click();
	}

	public void AspirationModalEmail() {
		driver.findElement(modalasp_email).isDisplayed();
	}

	public void AspirationModalStart() {
		driver.findElement(modalasp_start).isDisplayed();
	}

	public void getAspirationPlus() {
		driver.findElement(aspiretionplus_but).click();
	}

	public void modalAspirationPlusHere() {
		driver.findElement(modalasp_year).isDisplayed();
		System.out.println("A modal with yearly text: "+driver.findElement(modalasp_year).getText());
		driver.findElement(modalasp_month).isDisplayed();
		System.out.println("A modal with monthly text: "+driver.findElement(modalasp_month).getText());
	}

	public void modalAspPlusYearText(String year_price) {
		String text1 = driver.findElement(modalasp_text_year).getText();
		System.out.println("A modal radio option yearly text: "+driver.findElement(modalasp_text_year).getText());
		assertEquals("$71.88 paid once yearly", text1);
	}

	public void modalAspPlusMonthText(String month_price) {
		String text2 = driver.findElement(modalasp_text_month).getText();
		System.out.println("A modal radio option monthly text: "+driver.findElement(modalasp_text_month).getText());
		assertEquals("$7.99 paid monthly", text2);
	}

}
