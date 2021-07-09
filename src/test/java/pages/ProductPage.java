package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ProductPage {
	WebDriver driver;

	public String prodpagetitle = "Cash Management Services - Investing & Retirement Planning | Aspiration";

	By aspiretion_pic = By.xpath("//div[contains(@class,'card-original')]");
	By aspiretionplus_pic = By.xpath("//div[contains(@class,'card-plus')]");

	By aspiretionplus_pic2 = By.xpath("//div[contains(@class,'logo-plus')]");

	By aspiretion_but = By.xpath("//button[contains(@ng-click,'getOriginalPlan()')]");
	By aspiretionplus_but = By.xpath("//button[contains(@ng-click,'getAspirationPlus()')]");

	By modalasp_email = By.xpath("//input[contains(@name,'email')]");
	By modalasp_start = By.xpath("//div[contains(text(),'Get Started')]");

	By modalasp_year = By.xpath("//*[contains(text(),'Yearly')]");
	By modalasp_month = By.xpath("//*[contains(text(),'Monthly')]");

	By modalasp_text_year = By.xpath("//p/b[text()='$71.88']//parent::p");
	By modalasp_text_month = By.xpath("//p/b[text()='$7.99']//parent::p");
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public String isProdPage() {
		String title = driver.getTitle();
		return title;
	}

	public void isTwoProdDisplayed() {
		driver.findElement(aspiretion_pic).isDisplayed();
		driver.findElement(aspiretionplus_pic).isDisplayed();
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
		driver.findElement(modalasp_month).isDisplayed();
	}

	public String modalAspPlusYearText() {
		String text1 = driver.findElement(modalasp_text_year).getText();
		return text1;
		
	}

	public String modalAspPlusMonthText() {
		String text2 = driver.findElement(modalasp_text_month).getText();
		return text2;
	}

}
