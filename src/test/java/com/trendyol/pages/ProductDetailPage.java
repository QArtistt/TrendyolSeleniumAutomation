package com.trendyol.pages;

import com.trendyol.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    public ProductDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   @FindBy(xpath = "//div[@class='product-price-container']//span[@class='prc-dsc']")
    public WebElement productPriceOnCart;

   @FindBy(xpath = "//h1//a")
    public WebElement productTitleOnCart;

}
