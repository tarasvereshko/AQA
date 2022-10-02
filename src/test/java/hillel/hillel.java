package hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class hillel {
    By cardsNumber = By.xpath("//Input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//Input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//Input[@data-qa-node='cvvdebitSource']");
    By numberReceiver = By.xpath("//Input[@data-qa-node='numberreceiver']");
    By firstName = By.xpath("//Input[@data-qa-node='firstNamedebitSource']");
    By lastName = By.xpath("//Input[@data-qa-node='lastNamedebitSource']");
    By firstNameReceiver = By.xpath("//Input[@data-qa-node='firstNamereceiver']");
    By lastNameReceiver = By.xpath("//Input[@data-qa-node='lastNamereceiver']");
    By amound = By.xpath("//Input[@data-qa-node='amount']");
    By submitButton = By.xpath("//button[@type='submit']");
    String hillelUrl = "https://next.privat24.ua/money-transfer/card";

    private static WebDriver driver;
    public hillel(WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.get(hillelUrl);
    }

    public void fillCardNumber(String cardsNumber){
        driver.findElement(this.cardsNumber).sendKeys(cardsNumber);
    }
    public void fillmonthYear(String monthYear){
        driver.findElement(this.expiredDate).sendKeys(monthYear);
    }
    public void fillCvv(String cvv){
        driver.findElement(this.cvv).sendKeys(cvv);
    }
    public void fillNumberReceiver(String numberReceiver){
        driver.findElement(this.numberReceiver).sendKeys(numberReceiver);
    }
    public void fillFirstName(String firstName){
        driver.findElement(this.firstName).sendKeys(firstName);
    }
    public void filLastName(String lastName){
        driver.findElement(this.lastName).sendKeys(lastName);
    }
    public void fillFirstNameReceiver(String firstNameReceiver){
        driver.findElement(this.firstNameReceiver).sendKeys(firstNameReceiver);
    }
    public void fillLastNameReceiver(String lastNameReceiver){
        driver.findElement(this.lastNameReceiver).sendKeys(lastNameReceiver);
    }
    public void submitButtonClik(){
        driver.findElement(submitButton).submit();
    }
    public void fillamound(String amound){
        driver.findElement(this.amound).sendKeys(amound);
    }

}
