package com.trendyol.step_definitions;

import com.trendyol.pages.HomePage;
import com.trendyol.pages.ProductDetailPage;
import com.trendyol.pages.SearchResultPage;
import com.trendyol.pages.ShoppingCartPage;
import com.trendyol.utilities.ConfigReader;
import com.trendyol.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import java.util.ArrayList;
import java.util.logging.Logger;

public class TrendyolStepDef {

    Logger logger = Logger.getLogger(TrendyolStepDef.class.getName());
    HomePage hp = new HomePage();
    SearchResultPage srp= new SearchResultPage();
    ProductDetailPage pdp= new ProductDetailPage();
    ShoppingCartPage scp= new ShoppingCartPage();

    // Keep the Name and price of the product from search result to compare with the one in the detail page
    private String firstProductNameFromSearch;
    private String secondProductNameFromSearch;

    private String firstproductPriceFromSearch;
    private String secondproductPriceFromSearch;

    public void switchToWindow() {
        ArrayList<String> tabs2 = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tabs2.get(1));
    }

    @Given("I am on the Trendyol")
    public void i_am_on_the_trendyol() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("URL: " + Driver.getDriver().getCurrentUrl());
    }

    @When("I search for {string}")
    public void iSearchFor(String data) {
        hp.searchBox.sendKeys(data + Keys.ENTER);
    }

    @Then("Close Gender popup")
    public void closeGenderPopup() {
        hp.closeGenderPopup.click();
    }

    @Then("I should see that the search results include {string}")
    public void iShouldSeeThatTheSearchResultsInclude(String arg0) {
        Assert.assertEquals(srp.partofsearchresults.getText(), arg0);
    }

    @And("I click on the first product in the search results")
    public void iClickOnTheFirstProductInTheSearchResults() throws InterruptedException {
        firstProductNameFromSearch = srp.firstProductBrandTitleElement.getText();
        firstproductPriceFromSearch = srp.firstProductPriceElement.getText();
        Thread.sleep(2000);

        srp.firstProductBrandTitleElement.click();
        Thread.sleep(1000);
        switchToWindow();
        Thread.sleep(2000);
    }

    @Then("I should be on the product details page")
    public void iShouldBeOnTheProductDetailsPage() {

        if (scp.consentButton.isDisplayed()){
            scp.consentButton.click();
            System.out.println("consentButton is displayed and clicked");
        }

        String currentTitle = Driver.getDriver().getTitle();
        assert currentTitle != null;
        Assert.assertTrue(currentTitle.contains(pdp.productTitleOnCart.getText()));
    }

    @And("I should see the product details are displayed correctly")
    public void iShouldSeeTheProductDetailsAreDisplayedCorrectly() {
        Assert.assertTrue(firstProductNameFromSearch.equals(pdp.productTitleOnCart.getText()));
        Assert.assertTrue(firstproductPriceFromSearch.equals(pdp.productPriceOnCart.getText()));
        System.out.println(scp.productNameInCart.getText());
        System.out.println(scp.productPriceInCart.getText());
    }

    @When("I click on the Add to Cart bottun for first product")
    public void iClickOnTheAddToCartBottunForFirstProduct() {
        firstProductNameFromSearch = srp.firstProductBrandTitleElement.getText();
        firstproductPriceFromSearch = srp.firstProductPriceElement.getText();

        srp.addToBasketButton.click();
    }

    @And("I click on Goto Shopping Cart button")
    public void iClickOnGotoShoppingCartButton() {
        hp.goToBasket.click();
    }

    @Then("I should see the product is added correctly with details")
    public void i_should_see_the_product_is_added_correctly_with_details() {

        System.out.println(scp.productNameInCart.getText());
        System.out.println(scp.productPriceInCart.getText());
        System.out.println(firstProductNameFromSearch);
        System.out.println(firstproductPriceFromSearch);

        Assert.assertTrue(firstProductNameFromSearch.equals(scp.productNameInCart.getText()));
        Assert.assertTrue(firstproductPriceFromSearch.equals(scp.productPriceInCart.getText()));
    }

    @And("I click on the Add to Cart button for the second product")
    public void iClickOnTheAddToCartButtonForTheSecondProduct() throws InterruptedException {
        Thread.sleep(2000);
        secondProductNameFromSearch = srp.secondProductBrandTitleElement.getText();
        secondproductPriceFromSearch = srp.secondProductPriceElement.getText();

        srp.addSecProductToBasketButton.click();
        Thread.sleep(2000);
    }

    @Then("I sholud see the total amount is shown correctly")
    public void iSholudSeeTheTotalAmountIsShownCorrectly() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(Integer.parseInt(firstproductPriceFromSearch.replace(".", "").replaceAll("[^0-9]", "")) + Integer.parseInt(secondproductPriceFromSearch.replace(".", "").replaceAll("[^0-9]", "")));

    }

    @And("I click on remove button for the first item")
    public void iClickOnRemoveButtonForTheFirstItem() throws InterruptedException {
        Thread.sleep(2000);
        firstProductNameFromSearch = scp.productNameInCart.getAttribute("title").trim();
        Thread.sleep(2000);

        if (scp.consentButton.isDisplayed()){
            scp.consentButton.click();
            System.out.println("consentButton is displayed and clicked");
            }

        scp.removeFirstProdInCartButton.click();

        Thread.sleep(4000);
        System.out.println("first Product is removed");
    }

    @Then("I should see that first item is removed from the cart")
    public void iShouldSeeThatFirstItemIsRemovedFromTheCart() {
        System.out.println("doğrulama dımındayız");
        boolean firstItemIsDisplayed = false;
        try {
            firstItemIsDisplayed = scp.productNameInCart.isDisplayed();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue("first item is not displayed", firstItemIsDisplayed);
    }
}
