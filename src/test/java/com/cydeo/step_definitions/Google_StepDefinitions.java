package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefinitions {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();


    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String searchKeyword) {

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
//        wait.until(ExpectedConditions.visibilityOf(googleSearchPage.searchBox));
        googleSearchPage.acceptAllButton.click();
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);

    }

    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String string) {

        String expectedTitle = string + " - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        //Junit assertion accepts first arg as expected, second arg as actual
        Assert.assertEquals("Title is not as expected!", expectedTitle, actualTitle);

    }


    @When("user is on Google search page")
    public void user_is_on_google_search_page() {

        Driver.getDriver().get("https://www.google.com");
        googleSearchPage.acceptAllButton.click();
    }

    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);


    }
    @When("user types capital of {string} and clicks enter")
    public void user_types_capital_of_and_clicks_enter( String country) {
        googleSearchPage.searchBox.sendKeys("capital of "+country+ Keys.ENTER);
    }
    @Then("User should see {string} in the result")
    public void user_should_see_in_the_result(String expectedCapital) {
        String actualValue = googleSearchPage.getCapital();
        Assert.assertEquals(expectedCapital,actualValue);
    }




}
