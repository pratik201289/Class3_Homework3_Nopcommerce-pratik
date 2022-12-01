package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl="https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        //click on the computer tab
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //click on desktop tab
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //select A to Z
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: A to Z");
        //Verify the Product will arrange in Descending order.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        // 2.2 Click on desktop tab
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));

        //2.3 select A to Z
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: A to Z");

        //2.4 click on Add to Cart
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //2.5 Verify the text Build your own Computer
        Thread.sleep(3000);
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        String expectedText="Build your own computer";
        Assert.assertEquals("Not verified Build your own Computer",actualText,expectedText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"),"2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click();

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        driver.findElement(By.xpath("//input[@id='product_attribute_4_9']")).click();

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        driver.findElement(By.xpath("//label[text()='Total Commander [+$5.00]']")).click();

        //2.11 2.11 Verify the price "$1,475.00"
        Thread.sleep(6000);
        String actualTextPrice = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        String expectedTextPrice="$1,475.00";
        Assert.assertEquals("Not verified The Price",actualTextPrice,expectedTextPrice);

        //2.12 Click on "ADD TO CARD" Button.
        Thread.sleep(4000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on To green Bar
        Thread.sleep(4000);
        String actualTextPriceShopping = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        String expectedTextPriceShopping="The product has been added to your shopping cart";
        Assert.assertEquals("Not verified Message",actualTextPriceShopping,expectedTextPriceShopping);
        driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]")).click();

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.

        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
       // clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //fix with JavaScript executor
        WebElement m = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", m);

        // 2.15 Verify the message "Shopping cart"
        Thread.sleep(8000);
        String actualTextPriceCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        String expectedTextPriceCart="Shopping cart";
        Assert.assertEquals("Not verified Message",actualTextPriceCart,expectedTextPriceCart);

        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(2000);
        WebElement Quantity = driver.findElement(By.xpath("//td[@class='quantity']/child::input"));
        Quantity.clear();
        Quantity.sendKeys("2");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        // 2.17 Verify the Total"$2,950.00"
        Thread.sleep(4000);
        String actualTextTotal = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]"));
        String expectedTextTotal="$2,950.00";
        Assert.assertEquals("Not verified Message",actualTextTotal,expectedTextTotal);

        // 2.18 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//input[@id='termsofservice']")).click();

        //2.19 Click on “CHECKOUT”
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        //2.20 Verify the Text “Welcome, Please Sign In!”
        Thread.sleep(4000);
        String actualTextSignIn = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String expectedTextSignIn="Welcome, Please Sign In!";
        Assert.assertEquals("Not verified Message",actualTextSignIn,expectedTextSignIn);

        //2.21 Click on “CHECKOUT AS GUEST” Tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        // 2.22 Fill the all mandatory field
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Pratik");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Vyas");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_Email']"),"pratik23@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"India");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_City']"),"Nadiad");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Panchvati Soc Near Mai Temple");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"387002");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"8866300550");
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='shippingoption_1']")).click();
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),1);

        //2.28 Fill all the details
        sendTextToElements(By.xpath("//input[@id='CardholderName']"),"Pratik Vyas");
        sendTextToElements(By.xpath("//input[@id='CardNumber']"),"5555555555554444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"11");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2032");
        sendTextToElements(By.xpath("//input[@id='CardCode']"),"678");

        //2.29 Click on “CONTINUE”
        Thread.sleep(3000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.30 Verify “Payment Method” is “Credit Card”
        Thread.sleep(3000);
        String actualTextPayment = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        String expectedTextPayment="Credit Card";
        Assert.assertEquals("Not verified Message",actualTextPayment,expectedTextPayment);

        //2.32 Verify “Shipping Method” is “Next Day Air
        Thread.sleep(3000);
        String actualTextShippingMethod = getTextFromElement(By.xpath("//span[contains(text(),'(Next Day Air)')]"));
        String expectedTextShippingMethod="(Next Day Air)";
        Assert.assertEquals("Not verified Message",actualTextShippingMethod,expectedTextShippingMethod);

        //2.33 Verify Total is “$2,950.00”
        Thread.sleep(3000);
        String actualTextTotal1 = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));
        String expectedTextTotal1="$2,950.00";
        Assert.assertEquals("Not verified Message",actualTextTotal1,expectedTextTotal1);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.35 Verify the Text “Thank You”
        Thread.sleep(3000);
        String actualTextThankYou = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        String expectedTextThankYou="Thank you";
        Assert.assertEquals("Not verified Message",actualTextThankYou,expectedTextThankYou);

        //2.36 Verify the message “Your order has been successfully processed!”
        Thread.sleep(3000);
        String actualTextOrder = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        String expectedTextOrder="Your order has been successfully processed!";
        Assert.assertEquals("Not verified Message",actualTextOrder,expectedTextOrder);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.38 Verify the text “Welcome to our store”
        Thread.sleep(2000);
        String actualTextMain = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        String expectedTextMain="Welcome to our store";
        Assert.assertEquals("Not verified Message",actualTextMain,expectedTextMain);


    }

      public void tearDown(){
        closeBrowser();
    }

}


