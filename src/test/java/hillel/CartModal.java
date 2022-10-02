package hillel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartModal {

    By payer = By.xpath("//span[@data-qa-node='payer-card']");
    By receiver = By.xpath("//span[@data-qa-node='receiver-card']");
    By payerAmount = By.xpath("//div[@data-qa-node='payer-amount']");
    private static WebDriver driver;
    public CartModal(WebDriver driver){
        this.driver = driver;
    }
    public String getcardPayerValue(){
        return driver.findElement(payer).getText();
    }
    public String getcardReceiverValue(){
        return driver.findElement(receiver).getText();
    }
    public String getpayerAmountValue(){
        return driver.findElement(payerAmount).getText();
    }

}
