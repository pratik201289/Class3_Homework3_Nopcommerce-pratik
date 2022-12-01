package utilities;

import browserTesting.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by){
        WebElement loginLink= driver.findElement(by);
        loginLink.click();
    }
    /**
     * This method will send the text on field
     */
    public void sendTextToElements(By by,String text){
        WebElement emailField = driver.findElement(by);
        //Type email to email field
        emailField.sendKeys(text);
    }
    /**
     * This method will get the text on field
     */
    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }


    //********************Alert Method******************************

    /**
     *  Alert Method to switch to alert
     * */
    public void switchToAlert(){
        driver.switchTo().alert();
    }
    //  Homework 4 Method acceptAlert,dismissAlert, String(rtn type) getTextFromAlert, sendTextToAlert(String str)

    /**
     * alert method of Accept
     */
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    /**
     * Alert method of Dismiss
     */
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    /**
     * Method to write getting text from Alert
     */
    public String getTextFromAlert(){

        String str= driver.switchTo().alert().getText();
        return str;

    }
    /**
     *  Method to write send Text to alert
     */
    public void sendTextToAlert(String str){
        driver.switchTo().alert().sendKeys(str);
    }


//**************************Select Class Method*********************************
    /**
     * This method will select option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by,String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    /**
     * This method will select option by value
     */
    public void selectByVisibleValueFromDropDown(By by,String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }
    /**
     * This method will select option by index
     */
    public void selectByVisibleTextFromDropDown(By by,int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

//**********************Window Class******************************

//***********************Action Class******************************
//mouseHoverToElement(By by), mouseHoverElementAndClick(By by)
    /**
     * This method will Mouse Hover to Elements
     */
    public void mouseHoverToElement(By by){

        Actions actions =new Actions(driver);
        WebElement computer=driver.findElement(by);
        WebElement software=driver.findElement(by);

        actions.moveToElement(computer).moveToElement(software).click().build().perform();

    }
    public void mouseHoverElementAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(by);
        actions.contextClick(button).build().perform(); // to perform right click on button

    }


}
