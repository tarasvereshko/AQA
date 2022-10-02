package hillel;

import org.junit.Assert;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTests {

    private WebDriver driver;

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
    hillel hillel = new hillel(driver);
    hillel.navigate();
    hillel.fillCardNumber(cardsNumber);
    hillel.fillmonthYear(monthYear);
    hillel.fillCvv(cvvNumber);
    hillel.fillFirstName(firstNames);
    hillel.filLastName(lastNames);
    hillel.fillNumberReceiver(receiverCard);
    hillel.fillFirstNameReceiver(firstNameReceivers);
    hillel.fillLastNameReceiver(lastNameReceiveds);
    hillel.fillamound(sumAmound);
    hillel.submitButtonClik();
    CartModal cartModal = new CartModal(driver);
    Assert.assertEquals(cardPayerValue, cartModal.getcardPayerValue());
    Assert.assertEquals(cardReceiverValue,cartModal.getcardReceiverValue());
    Assert.assertEquals(payerAmountValue, cartModal.getpayerAmountValue());

    Thread.sleep (3000);
    }
}
