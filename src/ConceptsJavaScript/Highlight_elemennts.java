package ConceptsJavaScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Highlight_elemennts {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dhatavkarshraddha@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("shivganga1993");
	//driver.findElement(By.xpath("//input[@id='u_0_2']")).click();
	WebElement loginBtn= driver.findElement(By.id("loginbutton"));
		flash(loginBtn,driver);

	}
	public static void flash(WebElement element,WebDriver driver) {
		JavascriptExecutor js =((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<100;i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}

	public static void changeColor(String color,WebElement element, WebDriver driver) {
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor ='"+color+"'",element);
		try {Thread.sleep(20);
		}
		catch(InterruptedException e) 
		{
			
		}
	}
}
