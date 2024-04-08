package stepDefinitions.ui;

import com.ui.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

import static com.ui.pages.PageFactoryLoader.loginPage;

public class Sauce_LoginStepfinition {



    @Given("User logs tries login into application")
    public void user_logs_tries_login_into_application() throws InterruptedException {
        loginPage.loginToPage();
    }
    @When("user should login to the Application successfully")
    public void user_should_login_to_the_application_successfully() {
        System.out.println("Not executed steps needed to implemented");
    }
    @Then("User should be shown the products")
    public void user_should_be_shown_the_products() {
        System.out.println("Not executed steps needed to implemented");

    }

    @Then("User should be shown the products in screen")
    public void user_should_be_shown_the_products_screen() {
        System.out.println("Not executed steps needed to implemented");
        Assert.assertFalse(Boolean.parseBoolean("true"));
        int a = 4,b=0;
        int c= a/b;
    }

}
