package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Order_Page extends BasePage {
    public Order_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@name='product']")
    public WebElement productDropdown;
    @FindBy(xpath = "//input[@placeholder='Enter amount desired']")
    public WebElement quantityBox;

    @FindBy(name = "name")
    public WebElement customerName;

    @FindBy(name = "street")
    public WebElement street;

    @FindBy(name = "city")
    public WebElement city;

    @FindBy(name = "state")
    public WebElement state;

    @FindBy(name = "zip")
    public WebElement zip;

    @FindBy(name = "card")
    public List<WebElement> cardType;

    @FindBy(name="cardNo")
    public WebElement cardNumber;
    @FindBy(name = "cardExp")
    public WebElement expiryDate;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement processOrder;





  

    

    
}
