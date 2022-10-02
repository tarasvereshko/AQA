package hillel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class AutoTest {
    By cardNumber = By.xpath("//Input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//Input[@data-qa-node='expiredebitSource']");
    By cvv = By.xpath("//Input[@data-qa-node='cvvdebitSource']");
    By numberReceiver = By.xpath("//Input[@data-qa-node='numberreceiver']");
    By firstName = By.xpath("//Input[@data-qa-node='firstNamedebitSource']");
    By lastName = By.xpath("//Input[@data-qa-node='lastNamedebitSource']");
    By firstNameReceiver = By.xpath("//Input[@data-qa-node='firstNamereceiver']");
    By lastNameReceiver = By.xpath("//Input[@data-qa-node='lastNamereceiver']");
    By amound = By.xpath("//Input[@data-qa-node='amount']");
    By submitButton = By.xpath("//button[@type='submit']");

    By payer = By.xpath("//span[@data-qa-node='payer-card']");
    By receiver = By.xpath("//span[@data-qa-node='receiver-card']");
    By payerAmount = By.xpath("//div[@data-qa-node='payer-amount']");

    String cardsNumber = "4444333322221111";
    String monthYear = "1224";
    String cvvNumber = "123";
    String firstNames = "Taras";
    String lastNames = "Shevchenko";
    String receiverCard = "4111 1111 1111 1111";
    String firstNameReceivers = "Taras";
    String lastNameReceiveds = "Shevchenko";

    String sumAmound = "500 UAH";

    String cardPayerValue = "4444 3333 2222 1111";
    String cardReceiverValue = "4111 1111 1111 1111";
    String payerAmountValue = "500 UAH";

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://Users//Gold//IdeaProjects//AQA//src//main//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://next.privat24.ua/money-transfer/card");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void chekcardtocard() throws InterruptedException {
        driver.findElement(cardNumber).sendKeys(cardsNumber);
        driver.findElement(expiredDate).sendKeys(monthYear);
        driver.findElement(cvv).sendKeys(cvvNumber);
        driver.findElement(firstName).sendKeys(firstNames);
        driver.findElement(lastName).sendKeys(lastNames);
        driver.findElement(numberReceiver).sendKeys(receiverCard);
        driver.findElement(firstNameReceiver).sendKeys(firstNameReceivers);
        driver.findElement(lastNameReceiver).sendKeys(lastNameReceiveds);
        driver.findElement(amound).sendKeys(sumAmound);
        driver.findElement(submitButton).submit();

        Assert.assertEquals(cardPayerValue, driver.findElement(payer).getText());
        Assert.assertEquals(cardReceiverValue, driver.findElement(receiver).getText());
        Assert.assertEquals(payerAmountValue, driver.findElement(payerAmount).getText());


        Thread.sleep(3000);


    }
}





