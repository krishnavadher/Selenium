package WindowHandle;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandle {
	public static String browser;
	static WebDriver Driver;

	public static void setBrowser() {
		browser = "Firefox";
	}
	public static void setBrowserConfig() {
		//String projectlocation= System.getProperty("user.dir"); 
		if(browser=="Firefox") {
			//System.setProperty("webdriver.gecko.driver", /*projectlocation+*/ "C:\\Users\\krishna.vadher\\eclipse-workspace\\Selenium\\lib\\Gecko Driver\\geckodriver.exe");
			//System.setProperty("webdriver.firefox.bin", /*projectlocation+*/ "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			WebDriverManager.firefoxdriver().setup();
			Driver= new FirefoxDriver();}
		if (browser=="Chrome") { 
			//System.setProperty("webdriver.chrome.driver", /*projectlocation+*/ "C:\\Users\\krishna.vadher\\eclipse-workspace\\Selenium\\lib\\Chrome Driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			Driver= new ChromeDriver();}
		if (browser=="Edge") { 
			WebDriverManager.edgedriver().setup();
			Driver= new EdgeDriver();}
	}

	public static void URL() {
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.get("https://demoqa.com/browser-windows");
	}
	public static void NewWindow() {
		String main = Driver.getWindowHandle();
		System.out.println("Main : "+main);
		WebElement Button = ( Driver.findElement(By.xpath("//button[@id='windowButton']")));
		Button.click();
		Set<String> all= Driver.getWindowHandles();
		for(String allwin: all ) {
			System.out.println("Handle : "+allwin);
			if(!allwin.equals(main)) {
				Driver.switchTo().window(allwin);
				System.out.println(
						Driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
				Driver.close();
			}
		}
			Driver.switchTo().window(main);
			System.out.println(
					Driver.findElement(By.xpath("//div[@class='main-header']")).getText());
			Driver.close();
	}
	public static void main(String[] args) {
		setBrowser();
		setBrowserConfig();
		URL();
		NewWindow();
	}

}    


