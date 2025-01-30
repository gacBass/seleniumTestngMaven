import org.testng.Assert;
import org.testng.annotations.Test;

public class mainPageTest extends baseClass {


    @Test
    public void clickElementInTable() throws InterruptedException {
        elements = new ElementsInPage(driver);
        elements.searchBox.click();
        elements.dropdownOption.click();
        Thread.sleep(3000); //not best practise but needed to wait for table to reload
        elements.findElementInTable("Belt Sander", elements.elementsInTable);
        Assert.assertEquals("Belt Sander", elements.titleInProductView.getText());

    }

    @Test
    public void otherCategory() {

        elements = new ElementsInPage(driver);
        elements.categorySelector.click();
        elements.otherCategory.click();
        Assert.assertEquals(elements.categoryTitle.getText(), "Category: Other");


    }

}
