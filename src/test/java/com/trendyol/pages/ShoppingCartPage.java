package com.trendyol.pages;

import com.trendyol.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    public ShoppingCartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//p[@class='pb-item']//span")
    public WebElement productNameInCart;

    @FindBy(xpath = "(//p[@class='pb-item']//span)[2]")
    public WebElement secProdNameInCart;

    @FindBy(xpath = "//div[@class='price-wrapper']//div")
    public WebElement productPriceInCart;

    @FindBy(xpath = "(//span[text()='Sil'])[1]")
    public WebElement removeFirstProdInCartButton;

    @FindBy(xpath = "//button[text()='Anladım']")
    public WebElement consentButton;

}
