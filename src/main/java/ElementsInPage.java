import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsInPage {

    WebDriver driver;

    public ElementsInPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements!

    }

    @FindBy(css = "select option[value=\"name,asc\"]")
    public WebElement dropdownOption;

    @FindBy(css = "select.form-select")
    public WebElement searchBox;

    @FindBy(css = "select option")
    List<WebElement> listElements;

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


    public void findElementInTable(String labelToFind, List<WebElement> listElements) {

        for (WebElement element : listElements) {
            if (element.getText().equals(labelToFind)) {
                element.click();
                break;
            }
        }
    }


}