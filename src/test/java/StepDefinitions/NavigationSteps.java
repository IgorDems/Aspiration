package StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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
		driver.manage().window().maximize();

	}

	@Given("Browser is open")
	public void user_had_opened_the_chrome_browser() {
		System.out.println("Browser is open");
	}

	@When("User enters aspiration.com and hits enter")
	public void user_put_aspiration_com_in_url_field() throws InterruptedException {
		hp = new HomePage(driver);
		hp.goToHomePage();
		Thread.sleep(2000);
	}

	@Then("User have to see Aspiration home_page")
	public void user_have_to_see_aspiration_com_home_page() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals(hp.hometitle, hp.homeTitle());
		assertEquals(hp.homepage, hp.homeUrl());
	}

	@Given("User had navigated to Home_page")
	public void user_had_navigated_to_home_page() {
		hp.goToHomePage();
		assertEquals(hp.hometitle, hp.homeTitle());
		assertEquals(hp.homepage, hp.homeUrl());

	}

	@When("User clicked Spend&Save link at the top of the home page")
	public void user_clicked_spend_save_link_at_the_top_of_the_home_page() throws InterruptedException {
		pp = new ProductPage(driver);
		hp.goToProduct();
//		pp.isProdPage();
		assertEquals(pp.prodpagetitle, pp.isProdPage());

	}

	@Then("User can see two card products, Aspiration and Aspiration_Plus")
	public void user_can_view_our_products_and_prices() {
		pp.isTwoProdDisplayed();

	}

	@Given("User on Spend&Save page")
	public void user_on_spend_save_page() throws InterruptedException {
		hp.goToHomePage();
		hp.goToProduct();
	}

	@When("User clicked GetAspiration button")
	public void user_clicked_get_aspiration_button() {
		pp.getAspiration();
	}

	@Then("A modal input field for an emailaddress are displayed")
	public void a_modal_input_field_for_an_emailaddress_are_displayed() {
		pp.AspirationModalEmail();
	}

	@And("A modal sign_up button are displayed")
	public void a_modal_sign_up_button_are_displayed() {
		pp.AspirationModalStart();
	}

	@When("User clicked GetAspirationPlus button")
	public void user_clicked_get_aspiration_plus_button() {
		pp.getAspirationPlus();
	}

	@Then("A modal with monthly and yearly plans are displayed")
	public void a_modal_with_monthly_and_yearly_plans_are_displayed() {
		pp.modalAspirationPlusHere();

	}

	@Then("^Yearly radio option the is (.*) and visible$")
	public void yearly_radio_option_the_is_and_visible(String year_price) {
//		pp.modalAspPlusYearText(year_price);
		assertEquals("$71.88 paid once yearly", pp.modalAspPlusYearText());
	}

	@Then("^Monthly radio option is (.*) and visible$")
	public void monthly_radio_option_is_and_visible(String month_price) {
//		pp.modalAspPlusMonthText(month_price);
		assertEquals("$7.99 paid monthly", pp.modalAspPlusMonthText());
	}

	@After
	public void endTest() {
		driver.close();
		driver.quit();

	}

}
