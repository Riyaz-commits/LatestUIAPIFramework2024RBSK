package stepDefinitions.ui;

import com.ui.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.ui.pages.PageFactoryLoader.loginPage;
import static com.ui.pages.PageFactoryLoader.productPage;

public class LoginPageSteps extends BaseClass {

    @Given("user launches swag labs")
    public void user_launches_swag_labs() throws InterruptedException {
        loginPage.loginToPage();
    }
    @Given("user logs into swag labs")
    public void user_logs_into_swag_labs() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        productPage.clickProduct();


    }
    @Then("verify the user details")
    public void verify_the_user_details() {
        // Write code here that turns the phrase above into concrete actions

    }


    @Then("user enter the information")
    public void user_enter_the_information() throws InterruptedException {

     productPage.fillCheckoutDetails();
    }


    @Given("user launches swag labs in chrome")
    public void user_launches_swag_labs_in_chrome() throws InterruptedException {
        loginPage.loginToPage();
    }
    @Given("user logs into swag labs successfully")
    public void user_logs_into_swag_labs_successfully() {

    }
    @Then("verify the user details afer login")
    public void verify_the_user_details_afer_login() {

    }
    @Then("user enter the information in the checkout page")
    public void user_enter_the_information_in_the_checkout_page() {

    }


}
