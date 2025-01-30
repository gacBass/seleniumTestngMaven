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

    @Test
    public void checkPaginator() {
        elements = new ElementsInPage(driver);
        //expect to be 7, 5 buttons + back and next
        Assert.assertEquals(7, elements.paginator.size());
        //now click in third row and validate that button is enabled
        elements.paginatorFirstElement.getText(); //this is to locate the button
        elements.findElementInTable("3", elements.paginator);
        //check that third element is correctly number 3
        Assert.assertEquals("3", elements.paginator.get(3).getText());
        //check that active attribute is present in correct value (value is highlighted in blue
        Assert.assertEquals("page-item active", elements.paginator.get(3).getAttribute("class"));


    }

}
