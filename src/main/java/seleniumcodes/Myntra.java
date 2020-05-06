package seleniumcodes;

	import java.util.List;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class Myntra {
		public static void main(String[] args) throws InterruptedException {

			String url = "https://www.myntra.com/";
			// To display the console output in readable manner and to avoid time out messages
			System.setProperty("webdriver.chrome.silentOutput", "true");

//			To Launch the browser
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-notifications"); // To disable all notifications

			WebDriver driver = new ChromeDriver(op);
			driver.manage().window().maximize();
			driver.get(url); // Get the string value here
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
			// Mouse hover on Women
			Actions act = new Actions(driver);
			try {
				WebElement womm = driver.findElement(By.linkText("Women"));
				act.moveToElement(womm).perform();
				System.out.println("Mouse hover menu for Women");
				Thread.sleep(5000); // add thread.sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();  //print stack trace 
				                      //The printStackTrace() method of Java.lang.Throwable class used to print this Throwable along with other details like class name and line number where the exception occurred means its backtrace.
			}

			// Mouser hover on Jackets and Coats
			WebElement jackkk = driver.findElement(By.xpath("(//a[@class='desktop-categoryLink'])[72]"));
			act.moveToElement(jackkk).click().build().perform();
			System.out.println("Mouse hover sub menu on Jackets & Coatings");
			Thread.sleep(5000);

			// To Find the total count of an item
			String tcnt = driver.findElement(By.className("title-count")).getText();
			String jctcnt = tcnt.replaceAll("\\D", "");
			int totalcnt = Integer.parseInt(jctcnt); //Use Regular expression
			System.out.println("Total Count are:" + jctcnt);

			// To find the number of jackets in the categories

			String jacket = driver.findElement(By.className("categories-num")).getText();
			String Jackcount = jacket.replaceAll("\\D", "");
			Integer.parseInt(Jackcount);
			System.out.println("Jacket Count are:" + Jackcount);

			// To find the number of coats in the categories
			String coat = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
			String count = coat.replaceAll("\\D", "");
			Integer.parseInt(count);
			System.out.println("Cooats count are:" + count);

			Integer catfct = Integer.parseInt(jctcnt) + Integer.parseInt(count);

			if (catfct == totalcnt) {
				System.out.println("Count is Matched");
			}
			// To check the Coats
			driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]")).click();
			Thread.sleep(3000);
			// To click the + more option in the brand section.
			WebElement brand = driver.findElement(By.className("brand-more"));
			brand.click();
			// To search the mango
			WebElement search = driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']"));
			search.sendKeys("Mango");
			WebElement checkbox = driver.findElement(By.xpath("//label[@class=' common-customCheckbox']"));
			checkbox.click();
			Thread.sleep(2000);
			// To close the pop-up
			driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
			Thread.sleep(3000);

			List<WebElement> mango = driver.findElements(By.xpath("//h3[@class='product-brand']"));
			for (WebElement mangotext : mango) {
				String text = mangotext.getText();
				if (text.equalsIgnoreCase("MANGO")) {
					System.out.println("Branded names are equal");
				}
			}
			// Sort by Better Discount
			WebElement discount = driver
					.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']"));
			act.moveToElement(discount).perform();
			driver.findElement(By.xpath("//label[text()='Better Discount']")).click();

			Thread.sleep(3000);
			// Find the price of first displayed item
			String bestdiscout = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
			System.out.println("The price of first displayed item" + bestdiscout);

			// Mouse over on size of the first item
			WebElement disprice = driver.findElement(By.className("product-price"));
			act.moveToElement(disprice).perform();

			// Click on WishList Now
			driver.findElement(By.xpath("//span[@class='product-actionsButton product-wishlist product-prelaunchBtn']"))
					.click();
			System.out.println("Myntra Test Case Completed");
			// Close Browser
			driver.close();

		}

	}

