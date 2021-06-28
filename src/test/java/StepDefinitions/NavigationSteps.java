package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.HomePage;
import pages.ProductPage;

public class NavigationSteps {
	WebDriver driver = null;
	HomePage hp;
	ProductPage pp;
	
	@Before
	public void setupTest() {
		String syspath = System.getProperty("user.dir");
		System.out.println("Project path: " + syspath);
		System.setProperty("webdriver.chrome.driver", syspath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
//		driver.manage().window().maximize();

	}

//	HomePage hp = new HomePage(driver);
//	ProductPage pp = new ProductPage(driver);
	
	@Given("Browser is open")
	public void user_had_opened_the_chrome_browser() {
		System.out.println("Browser is open");
	}

	@When("User enters aspiration.com")
	public void user_put_aspiration_com_in_url_field() {
		 hp = new HomePage(driver);
		
		System.out.println("===========================================");
//		driver.navigate().to("http://google.com");
		hp.goToHomePage();
		System.out.println("-------------------------------------------");
	}

	@When("Hits enter")
	public void clicked_enter_button() {
		System.out.println("Hits enter");
	}

	@Then("User have to see Aspiration home_page")
	public void user_have_to_see_aspiration_com_home_page() {
		hp = new HomePage(driver);
		System.out.println("User have to see aspiration.com home page");
		hp.isHomePage();
	}

//////////////////////////////////////////////////////////////////////////////////////	
	@Given("User had navigated to Home_page")
	public void user_had_navigated_to_home_page() {
		hp = new HomePage(driver);
		hp.goToHomePage();
		hp.isHomePage();
		
	}

	@When("User clicked Spend&Save link at the top of the home page")
	public void user_clicked_spend_save_link_at_the_top_of_the_home_page() throws InterruptedException {
		hp = new HomePage(driver);
		pp = new ProductPage(driver);
		hp.goToProduct();
		pp.isProdPage();
	
		
	}

	@Then("User can see two card products, Aspiration and Aspiration_Plus")
	public void user_can_view_our_products_and_prices() {
		pp = new ProductPage(driver);
		pp.isTwoProdDisplayed();

	}

	@Given("User on Spend&Save page")
	public void user_on_spend_save_page() throws InterruptedException {
		hp = new HomePage(driver);
		hp.goToHomePage();
		hp.goToProduct();
	}

	@When("User clicked GetAspiration button")
	public void user_clicked_get_aspiration_button() {
		pp = new ProductPage(driver);
		pp.getAspiration();
	}

	@Then("A modal input field for an emailaddress are displayed")
	public void a_modal_input_field_for_an_emailaddress_are_displayed() {
		pp = new ProductPage(driver);
		pp.AspirationModalEmail();
	}

	@Then("^A modal  sign_up button are displayed$")
	public void a_modal_sign_up_button_are_displayed() {
		pp = new ProductPage(driver);
		pp.AspirationModalStart();
	}
	
	
	
	@When("User clicked GetAspirationPlus button")
	public void user_clicked_get_aspiration_plus_button() {
		pp = new ProductPage(driver);
		pp.getAspirationPlus();
	}

	@Then("A modal with monthly and yearly plans are displayed")
	public void a_modal_with_monthly_and_yearly_plans_are_displayed() {
		pp = new ProductPage(driver);
		pp.modalAspirationPlusHere();
	    
	}

	@Then("^Yearly radio option the is (.*) and visible$")
	public void yearly_radio_option_the_is_and_visible(String year_price) {
		pp = new ProductPage(driver);
	    pp.modalAspPlusYearText(year_price);
	}

	@Then("^Monthly radio option is (.*) and visible$")
	public void monthly_radio_option_is_and_visible(String month_price) {
		pp = new ProductPage(driver);
	    pp.modalAspPlusMonthText(month_price);
	}

}
