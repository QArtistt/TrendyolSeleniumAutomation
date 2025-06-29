package com.trendyol.pages;

import com.trendyol.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public HomePage() {
        //this.wait() = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='modal-close']")
    public WebElement closeGenderPopup;

    @FindBy(xpath = "//input[@data-testid='suggestion']")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@class='link account-basket']")
    public WebElement goToBasket;





}
