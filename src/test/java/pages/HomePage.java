package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;



public class HomePage {
	String syspath = System.getProperty("user.dir");
	
	WebDriver driver;

	String homepage = "https://www.aspiration.com/";
	String hometitle = "Aspiration | Green Financial Services";

	By spandsave = By.xpath("//a[text()='Spend & Save']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;	
	}

	public void goToHomePage() {
		System.out.println("User enters aspiration.com: "+homepage);	
		driver.navigate().to(homepage);
	}
	
	public void isHomePage() { 
		
		String title = driver.getTitle();
		String curl = driver.getCurrentUrl();
		assertEquals(hometitle, title);
		assertEquals(homepage, curl);
		
	}


	public void goToProduct() {
		driver.findElement(spandsave).click();
	}
	

}
