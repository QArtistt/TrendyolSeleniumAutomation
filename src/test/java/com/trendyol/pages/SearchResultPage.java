package com.trendyol.pages;

import com.trendyol.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    public SearchResultPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='dscrptn dscrptn-V2']//h1")
    public WebElement partofsearchresults;

    @FindBy(xpath = "(//h3[@class='prdct-desc-cntnr-ttl-w']//span[1])[1]")
    public WebElement firstProductBrandTitleElement;

    @FindBy(xpath = "(//h3[@class='prdct-desc-cntnr-ttl-w']//span[1])[2]")
    public WebElement secondProductBrandTitleElement;

    @FindBy(xpath = "(//div[@class='price-item lowest-price-discounted' or @class='price-item discounted'])[1]")
    public WebElement firstProductPriceElement;

    @FindBy(xpath = "(//div[@class='price-item lowest-price-discounted' or @class='price-item discounted'])[2]")
    public WebElement secondProductPriceElement;

    @FindBy(xpath = "(//button[@class='add-to-basket-button'])[1]")
    public WebElement addToBasketButton;

    @FindBy(xpath = "(//button[@class='add-to-basket-button'])[1]")
    public WebElement addSecProductToBasketButton;
}
