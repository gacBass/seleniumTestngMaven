import org.testng.Assert;
import org.testng.annotations.Test;


public class mainPageTest extends baseClass {


    @Test
    public void clickElementInTable() throws InterruptedException {
        elements = new ElementsInPage(driver);
        elements.sortBox.click();
        elements.dropdownOption.click();
        Thread.sleep(3000); //not best practise but needed to wait for table to reload
        elements.findElementInTable("Belt Sander", elements.elementsInTable);
        Assert.assertEquals("Belt Sander", elements.titleInProductView.getText());

    }

    @Test
    public void validateTitleIsCorrect() {

        Assert.assertEquals("Practice Software Testing - Toolshop - v5.0", driver.getTitle());


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
        //expect to be 7 elements, 5 numbers + back and next buttons
        Assert.assertEquals(7, elements.paginator.size());
        //now click in third row and validate that button is enabled
        elements.paginatorFirstElement.getText(); //this is to locate the paginator
        //check that third element is correctly number 3
        elements.findElementInTable("3", elements.paginator);
        Assert.assertEquals("3", elements.paginator.get(3).getText());
        //check that active attribute is present in correct value (value is highlighted in blue)
        Assert.assertEquals("page-item active", elements.paginator.get(3).getAttribute("class"));


    }

    @Test
    public void changeLanguageWorks() {

        elements = new ElementsInPage(driver);
        elements.languageBtn.click();
        elements.findElementInTable("NL", elements.languages);
        elements.findElementInTable("NL", elements.languages);
        //we validate that titles changed to NL language

        Assert.assertEquals("Sorteren", elements.titles.get(0).getText());
        Assert.assertEquals("Prijsklasse", elements.titles.get(1).getText());
        Assert.assertEquals("Zoeken", elements.titles.get(2).getText());


    }

    @Test
    public void moveSliderMax() {
        elements = new ElementsInPage(driver);
        //moves the slider to a predefined value = 121, in this slider no other action method works
        elements.moveSlider(elements.sliderMax, 29);
        Assert.assertEquals("121", elements.sliderMaxLabel.getText());
    }

    @Test
    public void search() throws InterruptedException {

        elements = new ElementsInPage(driver);
        elements.searchBox.sendKeys("Random Orbit Sander");
        elements.searchBoxBtn.click();
        Thread.sleep(2000);
        Assert.assertEquals("Random Orbit Sander", elements.elementsInTable.get(0).getText());

    }


}
