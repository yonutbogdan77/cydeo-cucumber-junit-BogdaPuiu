package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.Order_Page;
import com.cydeo.pages.ViewAllOrders_Page;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class WebTableOrder_StepDefinitions {
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    Order_Page order_page = new Order_Page();
    ViewAllOrders_Page viewAllOrders_page=new ViewAllOrders_Page();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
        webTableLoginPage.login();
        basePage.order.click();

    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(order_page.productDropdown);
        select.selectByVisibleText(string);

    }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int quantity) {
        order_page.quantityBox.clear();
        order_page.quantityBox.sendKeys(String.valueOf(quantity));
    }


    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        order_page.customerName.sendKeys(string);
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        order_page.street.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        order_page.city.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        order_page.state.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        order_page.zip.sendKeys(string);

    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String string) {
        BrowserUtils.clickRadioButton(order_page.cardType, string);
    }


    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        order_page.cardNumber.sendKeys(string);

    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        order_page.expiryDate.sendKeys(string);

    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        order_page.processOrder.click();

    }

    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {
        Assert.assertEquals("Test failed!", expectedName, viewAllOrders_page.nameBox.getText());
    }


}
