package step;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pom.Search_Page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Search_Step extends Base {

    Search_Page searchPage;
    @Given("User launch the browser as {string}")
    public void userLaunchTheBrowserAs(String browser) {
            initializeBrowser(browser);
    }
    @And("User launch the url")
    public void userLaunchTheUrl() {
        lauchUrl("https://www.swiggy.com/");
        windowMax();
        waitImplicitly();
        searchPage = new Search_Page();
    }
    @When("User click on the search button")
    public void userClickOnTheSearchButton() {
        driver.findElement(searchPage.searchBtn).click();

    }
    @When("User enter product in search box {string}")
    public void userEnterProductInSearchBox(String product) {
        driver.findElement(searchPage.searchBox).sendKeys(product);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Then("User verifies that shop with high ratings")
    public void userVerifiesThatShopWithHighRatings() {

            List<WebElement> restaurentLists = driver.findElements(searchPage.ratings);
            List<Float> rate = new ArrayList<>();
            List<String> name = new ArrayList<>();



            for (WebElement eachRate:restaurentLists){
                String rateText = eachRate.getText();
                float rateInNum = Float.parseFloat(rateText);
                rate.add(rateInNum);
            }
            System.out.println(rate);
            float highestNumber =Collections.max(rate);
            System.out.println(highestNumber);

            List<WebElement> products = driver.findElements(searchPage.productName);
            for (WebElement eachProduct: products){
                String productText =eachProduct.getText();
                name.add(productText);
            }
            System.out.println(name);
            float indexOfHighestRating = rate.indexOf(highestNumber);
            String highestRatedProduct = String.valueOf(name.get((int) indexOfHighestRating));

            System.out.println("The highest rating product is: " + highestRatedProduct);
    }


}
