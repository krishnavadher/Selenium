package Learn;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class First {
	public static String browser; 
	static WebDriver Driver;
	//toSetBrowser
	public static void setBrowser() {
		browser = "Firefox"; 
	}
	//toSetDriver
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
	//toRunURL
	public static void runURL() {
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.get("https://www.saucedemo.com/");
	}
	//Login
	public static void logIn() {
		WebElement user = ( Driver.findElement(By.xpath("//input[@id='user-name']")));
		user.sendKeys("standard_user");

		WebElement pass = ( Driver.findElement(By.xpath("//input[@id='password']")));
		pass.sendKeys("secret_sauce");


		WebElement submit = ( Driver.findElement(By.xpath("//input[@id='login-button']")));
		submit.click();
	}
	//toClickonDrawer
	public static void drawer() {
		WebElement drawer = ( Driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")));
		drawer.click();
	}

	public static void about() throws InterruptedException {	
		//Find About and click from menu
		Driver.findElement(By.xpath("//a[@id='about_sidebar_link'][@class='bm-item menu-item']")).click();

		WebElement LearnMore = ( Driver.findElement(By.xpath("//a[@href='/enterprise']//button[@type='button'][normalize-space()='Learn more']")));
		LearnMore.click();
		Thread.sleep(3000);
		//Frame handling of google sign-in Option
		Driver.switchTo().frame(Driver.findElement(By.xpath("//iframe[@title='Sign in with Google Dialogue']")));
		Driver.findElement(By.xpath("//div[@id='close'][@class='TvD9Pc-Bz112c ZYIfFd-aGxpHf-FnSee']")).click();
		Driver.switchTo().defaultContent();	
		Thread.sleep(3000);
		Driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']//button[@class='onetrust-close-btn-handler banner-close-button ot-close-icon']")).click();
		//navigation
		Driver.navigate().back();
		Driver.navigate().back();
	}

	public static void allItems() throws InterruptedException {	
		//handling drop down and click on options
		WebElement sort = Driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		sort.click();
		Select sort_dd = new Select(sort);
		sort_dd.selectByVisibleText("Name (Z to A)");
		Thread.sleep(3000);
		WebElement sort1 = Driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		sort1.click();		
		Select sort1_dd = new Select(sort1);
		sort1_dd.selectByVisibleText("Price (low to high)");
		Thread.sleep(3000);
		WebElement sort2 = Driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		sort2.click();		
		Select sort2_dd = new Select(sort2);
		sort2_dd.selectByVisibleText("Price (high to low)");
		Thread.sleep(3000);
		WebElement sort3 = Driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		sort3.click();		
		Select sort3_dd = new Select(sort3);
		sort3_dd.selectByVisibleText("Name (A to Z)");
	}


	public static void addToCart() {	

		WebElement add = ( Driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")));
		add.click();

		WebElement checkAdd = ( Driver.findElement(By.xpath("//a[@class='shopping_cart_link']")));
		checkAdd.click();

		WebElement qty = ( Driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]"))); 
		System.out.println("Get Item Quantity: " + qty.getText());

		WebElement desc = ( Driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']"))); 
		System.out.println("Get Item Description: " + desc.getText());	

		Driver.navigate().back();//to go back
	}

	public static void addNextCart() {	

		WebElement addNext = ( Driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")));
		addNext.click();

		WebElement checkAddNext = ( Driver.findElement(By.xpath("//a[@class='shopping_cart_link']")));
		checkAddNext.click();

		WebElement qtyNext = ( Driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]"))); 
		System.out.println("Get Item Quantity: " + qtyNext.getText());

		WebElement descNext = ( Driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bolt T-Shirt']"))); 
		System.out.println("Get Item Description: " + descNext.getText());	

		WebElement cartQty = ( Driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")));
		System.out.println("Cart Badge Qty: "+ cartQty.getText());
	}

	public static void removeItem() {	

		WebElement remove = ( Driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']")));
		remove.click();

		WebElement cartQty = ( Driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")));
		System.out.println("Cart Badge Qty: "+ cartQty.getText());

		Driver.navigate().back();//to go back

		WebElement removeNext = ( Driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")));
		removeNext.click();
	}

	public static void logOut() {
		WebElement drawerClick = ( Driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")));
		drawerClick.click();

		WebElement logOut = ( Driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")));
		logOut.click();

		String title= Driver.getTitle();
		System.out.println(title);
		//assertion
		//assert title.equals("Swag Labs") : "Title doesn't match";
		if(title.equalsIgnoreCase("Swag Labs"))
			System.out.println("Test passed !!!!");
		else
			System.out.println("Test failed");

		Driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		setBrowser();
		setBrowserConfig();
		runURL();
		logIn();
		drawer();
		about();
		allItems();
		addToCart();
		addNextCart();
		removeItem();
		logOut();
	}
}
