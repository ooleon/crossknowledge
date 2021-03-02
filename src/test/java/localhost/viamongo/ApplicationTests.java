package localhost.viamongo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class ApplicationTests {

	@Test
	public void form() {
		System.out.println("teamshift");
		String d = "/home/doc/opt/webdriver/geckodriver";
		System.out.println(d);
        System.setProperty("webdriver.gqecko.driver", d); 

        long duration = Duration.ofSeconds(10).getSeconds();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, duration);
        try {
        	
        	driver.manage().window().maximize();
        	driver.manage().deleteAllCookies();
        	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("http://teamshift-qa.crossknowledge.com/");

//      	clik Log In
            driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
//            driver.findElement(By.linkText("Log In")).click();
            
            driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
            
//          	insert user text into input login-form__login
//            driver.findElement(By.id("login-form__login")).sendKeys("ostyleon@gmail.com");
            driver.findElement(By.xpath("//input[@id='login-form__login']")).sendKeys("ostyleon@gmail.com");
            
//      	clik next
//            driver.findElement(By.linkText("Next")).click();
//            driver.findElement(By.xpath("//button[@textContent='Next']")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

//      	insert password text into input login-form__password
//            driver.findElement(By.id("login-form__password")).sendKeys("WLS2020qa");
//            driver.findElement(By.tagName("member_password")).sendKeys("WLS2020qa");
            driver.findElement(By.xpath("//input[@id='login-form__password']")).sendKeys("WLS2020qa");

//      	clik LOGIN
//          driver.findElement(By.linkText("Login")).click();
//          driver.findElement(By.xpath("//button[@textContent='Login']")).click();
          driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

          driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
            
            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
            System.out.println(firstResult.getAttribute("textContent"));
        } finally {
            driver.quit();
        }

	}
	

}
