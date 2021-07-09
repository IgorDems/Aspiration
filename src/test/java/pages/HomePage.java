package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	public String homepage = "https://www.aspiration.com/";
	public String hometitle = "Aspiration | Green Financial Services";

	By spandsave = By.xpath("//a[text()='Spend & Save']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToHomePage() {
		driver.navigate().to(homepage);
	}

	public String homeTitle() {
		String title = driver.getTitle();
		return title;	
	}

	public String homeUrl() {
		String curl = driver.getCurrentUrl();
		return curl;
	}

	public void goToProduct() {
		driver.findElement(spandsave).click();
	}

}
