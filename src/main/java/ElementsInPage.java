import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementsInPage {

    private WebDriver driver;

    public ElementsInPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements!

    }

    @FindBy(css = "select option[value=\"name,asc\"]")
    public WebElement dropdownOption;

    @FindBy(css = "select.form-select")
    public WebElement sortBox;

    @FindBy(css = "input#search-query")
    public WebElement searchBox;

    @FindBy(css = "button[data-test=\"search-submit\"]\n")
    public WebElement searchBoxBtn;

    @FindBy(css = "div.card-body h5")
    List<WebElement> elementsInTable;

    @FindBy(css = "div h1[data-test=\"product-name\"]")
    public WebElement titleInProductView;

    @FindBy(css = "li a[data-test=\"nav-categories\"]")
    public WebElement categorySelector;

    @FindBy(css = "a[data-test=\"nav-other\"]")
    public WebElement otherCategory;

    @FindBy(css = "h2[data-test=\"page-title\"]")
    public WebElement categoryTitle;

    @FindBy(css = "ul.pagination li")
    List<WebElement> paginator;

    @FindBy(css = "ul.pagination li")
    public WebElement paginatorFirstElement;

    @FindBy(css = "button[data-test=\"language\"]\n")
    public WebElement languageBtn;

    @FindBy(css = "ul.dropdown-menu.dropdown-menu-right.show li")
    List<WebElement> languages;

    @FindBy(css = "h4.grid-title")
    List<WebElement> titles;


    @FindBy(css = "span.ngx-slider-span.ngx-slider-pointer.ngx-slider-pointer-max")
    public WebElement sliderMax;

    @FindBy(css = "span.ngx-slider-span.ngx-slider-bubble.ngx-slider-model-high\n")
    public WebElement sliderMaxLabel;


    public void findElementInTable(String labelToFind, List<WebElement> listElements) {

        for (WebElement element : listElements) {
            if (element.getText().equals(labelToFind)) {
                element.click();
                break;
            }
        }
    }


    public void moveSlider(WebElement element, int value) {

        Actions action = new Actions(driver);
        action.clickAndHold(element).moveByOffset(value, 0).release().perform();


    }

    public void waitForElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(element));


    }
}