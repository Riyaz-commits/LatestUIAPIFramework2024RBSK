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

}
