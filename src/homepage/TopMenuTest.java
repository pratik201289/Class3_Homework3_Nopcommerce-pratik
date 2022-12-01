package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
   String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        String mainMenu = menu.toLowerCase();
        String expression = "//a[@href ='/" + mainMenu + "']";
        driver.findElement(By.xpath(expression)).click();
        String currentUrl= driver.getCurrentUrl();
        Assert.assertEquals("Navigated successfully",currentUrl,baseUrl+ menu);
    }
    @Test
    public void verifyPageNavigation(){
        //verify the computer tab
        mouseHoverToElement(By.xpath("//a[@href='/electronics']"));
        selectMenu("electronics");
     /*   String expectedText="Computers";
        String actualText=getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        Assert.assertEquals("The computer tab not working",expectedText,actualText);

        //verify the electronic tab
        mouseHoverToElement(By.xpath("//a[@href='/electronics']"));
        selectMenu("electronics");
        String expectedText1="Electronics";
        String actualText1=getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        Assert.assertEquals("The Electronic tab not working",expectedText1,actualText1);
        */

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
