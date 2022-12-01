package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {

    String baseUrl="https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        //1.2 Mouse Hover on “Cell phones” and click

        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
       Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]"));

        //1.3 Verify the text “Cell phones”
        Thread.sleep(2000);
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        String expectedText="Cell phones";
        Assert.assertEquals("Not verified Message",actualText,expectedText);

    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]"));

        //2.3 Verify the text “Cell phones”
        Thread.sleep(2000);
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        String expectedText="Cell phones";
        Assert.assertEquals("Not verified Message",actualText,expectedText);

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(2000);
        String actualTextLumia = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        String expectedTextLumia="Nokia Lumia 1020";
        Assert.assertEquals("Not verified Message",actualTextLumia,expectedTextLumia);

        //2.7 Verify the price “$349.00”
        //span[contains(text(),'$349.00')]
        Thread.sleep(2000);
        String actualTextLumiaPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        String expectedTextLumiaPrice="$349.00";
        Assert.assertEquals("Not verified Message",actualTextLumiaPrice,expectedTextLumiaPrice);

        //2.8 Change quantity to 2
        WebElement Qty = driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        Qty.clear();
        Qty.sendKeys("2");

        //2.9 Click on “ADD TO CART” tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(3000);
        String actualTextPriceShopping = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        String expectedTextPriceShopping="The product has been added to your shopping cart";
        Assert.assertEquals("Not verified Message",actualTextPriceShopping,expectedTextPriceShopping);
        driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]")).click();

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        // clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //fix with JavaScript executor
        WebElement m = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", m);

        //2.12 Verify the message "Shopping cart"
        Thread.sleep(8000);
        String actualTextPriceCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        String expectedTextPriceCart="Shopping cart";
        Assert.assertEquals("Not verified Message",actualTextPriceCart,expectedTextPriceCart);

        //2.13 Verify the quantity is 2
        Thread.sleep(2000);
        WebElement Quantity = driver.findElement(By.xpath("//td[@class='quantity']/child::input"));
        Quantity.clear();
        Quantity.sendKeys("2");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.14 Verify the Total $698.00
        Thread.sleep(4000);
        String actualTextTotal = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]"));
        String expectedTextTotal="$698.00";
        Assert.assertEquals("Not verified Message",actualTextTotal,expectedTextTotal);

        //2.15 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

        //2.16 Click on “CHECKOUT”
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        //2.17 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(4000);
        String actualTextSignIn = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String expectedTextSignIn="Welcome, Please Sign In!";
        Assert.assertEquals("Not verified Message",actualTextSignIn,expectedTextSignIn);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        Thread.sleep(4000);
        String actualTextRegister = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        String expectedTextRegister="Register";
        Assert.assertEquals("Not verified Message",actualTextRegister,expectedTextRegister);

        //2.20 Fill the mandatory fields
        sendTextToElements(By.xpath("//input[@id='FirstName']"),"Rio");
        sendTextToElements(By.xpath("//input[@id='LastName']"),"Romio");
        sendTextToElements(By.xpath("//input[@id='Email']"),"rio236@gmail.com");
        sendTextToElements(By.xpath("//input[@id='Password']"),"rio1234");
        sendTextToElements(By.xpath("//input[@id='ConfirmPassword']"),"rio1234");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        Thread.sleep(4000);
        String actualTextRegister1 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String expectedTextRegister1="Your registration completed";
        Assert.assertEquals("Not verified Message",actualTextRegister1,expectedTextRegister1);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping card”
        String actualTextCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        String expectedTextCart="Shopping cart";
        Assert.assertEquals("Not verified Message",actualTextCart,expectedTextCart);

        //2.25 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
       selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"Alaska");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_City']"),"Texas");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Foxton Road");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"TX003");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"98983456789");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='shippingoption_1']")).click();

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        // 2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        //2.32 Select “Visa” From Select credit card dropdown
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Visa");

        //2.33 Fill all the details
        sendTextToElements(By.xpath("//input[@id='CardholderName']"),"Jaimini Vyas");
        sendTextToElements(By.xpath("//input[@id='CardNumber']"),"5555555555554444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"12");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2031");
        sendTextToElements(By.xpath("//input[@id='CardCode']"),"879");

        //2.34 Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.35 Verify “Payment Method” is “Credit Card”
        Thread.sleep(3000);
        String actualTextPayment = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        String expectedTextPayment="Credit Card";
        Assert.assertEquals("Not verified Message",actualTextPayment,expectedTextPayment);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(3000);
        String actualTextShippingMethod = getTextFromElement(By.xpath("//span[contains(text(),'(Next Day Air)')]"));
        String expectedTextShippingMethod="(Next Day Air)";
        Assert.assertEquals("Not verified Message",actualTextShippingMethod,expectedTextShippingMethod);

        //2.37 Verify Total is “$698.00”
        Thread.sleep(4000);
        String actualTextTotal1 = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        String expectedTextTotal1="$698.00";
        Assert.assertEquals("Not verified Message",actualTextTotal1,expectedTextTotal1);

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”
        Thread.sleep(3000);
        String actualTextThankYou = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        String expectedTextThankYou="Thank you";
        Assert.assertEquals("Not verified Message",actualTextThankYou,expectedTextThankYou);

        //2.40 Verify the message “Your order has been successfully processed!”
        Thread.sleep(3000);
        String actualTextOrder = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        String expectedTextOrder="Your order has been successfully processed!";
        Assert.assertEquals("Not verified Message",actualTextOrder,expectedTextOrder);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        Thread.sleep(2000);
        String actualTextMain = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        String expectedTextMain="Welcome to our store";
        Assert.assertEquals("Not verified Message",actualTextMain,expectedTextMain);

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        Thread.sleep(2000);
        String VerifyActualUrl = getTextFromElement(By.xpath("//body/div[6]/div[4]/div[2]/div[2]/a[1]"));
        String VerifyExpectedUrl="nopCommerce";
        Assert.assertEquals("Not verified Message",VerifyActualUrl,VerifyExpectedUrl);




    }

   /* @After
    public void tearDown(){
        closeBrowser();
    }
*/

}
