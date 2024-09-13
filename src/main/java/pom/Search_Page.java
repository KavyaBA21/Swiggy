package pom;

import base.Base;
import org.openqa.selenium.By;

public class Search_Page extends Base {

    public By searchBtn = By.xpath("//span[text()='Search']");
    public By searchBox =By.cssSelector("[placeholder='Search for restaurants and food']");
    public By ratings = By.xpath("//span[@class='styles_restaurantMetaRating__3MhTg']");
    public By productName = By.xpath("//div[contains(@class,'styles_restaurantName__5VIQZ styles_restaurantNameBold')]");
}
