package localhost;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.WebDriverWait;

//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
    }

	public static void main1(String[] args) {		
		
		String drvclass="webdriver.gecko.driver";
		String f = "geckodriver";
//		String d = "/home/doc/opt/github/ooleon/dockercompose-springboot-mongodb-nginx/src/main/resources/"
//				+ f;
		String d = "/home/doc/opt/webdriver/" + f;
        System.out.println("Application: " + drvclass);
        System.out.println(d);
		System.setProperty(drvclass,d);
//        System.setProperty("webdriver.gecko.driver", d);
//        System.setProperty("webdriver.firefox.marionette", d);
    	WebDriver driver = new FirefoxDriver();
        System.out.println("WebDriver driver = new FirefoxDriver");
        String baseUrl = "http://google.com";
        String tagName = "";
        
        System.out.println("driver.get(baseUrl) " + baseUrl);
        driver.get(baseUrl);
        System.out.println("driver.get(baseUrl) " + baseUrl);
        try {
        	System.out.println("Waiting before proceeding");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
        driver.close();
        System.exit(0);


//		SpringApplication.run(ViamongoApplication.class, args);
	}

}
