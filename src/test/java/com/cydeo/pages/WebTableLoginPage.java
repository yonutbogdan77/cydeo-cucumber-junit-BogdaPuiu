package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {
    public WebTableLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    /**
     * No parameters
     * When we call this method, it will directly login using
     * <p>
     * Username: Test
     * Password: Tester
     */
    public void login() {
        this.usernameInputBox.sendKeys("Test");
        this.passwordInputBox.sendKeys("Tester");
        this.loginButton.click();

    }

    /**
     * Login method with 2 arguments
     *
     * @param username
     * @param password
     */

    public void login(String username, String password) {
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }

    /**
     * This method will login using credentials from
     * configuration.properties
     */
    public void loginWithConfig() {
        usernameInputBox.sendKeys(ConfigurationReader.getProperty("web.table.username"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("web.table.password"));
        loginButton.click();
    }


}
