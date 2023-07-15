package PageRepo;

import BaseClass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsPage extends TestBase {
    @FindBy(xpath = "//img[@alt='Saucelabs']")
    WebElement imgSauceLabs;
    public SauceLabsPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean imgValidateSauceLabsPage(){
        return imgSauceLabs.isDisplayed();
    }
}
