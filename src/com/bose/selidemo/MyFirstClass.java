/**
 * 
 */
package com.bose.selidemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author capestart
 *
 */
public class MyFirstClass {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// WebDriver driver = new SafariDriver();

		WebDriver driver = new ChromeDriver();
		// driver.get("http://www.fullintel.com");
		// driver.findElement(By.name("q")).sendKeys("Download Selenium");
		// Thread.sleep(2000);
		// driver.findElement(By.name("btnK")).click();
		Maximize the window
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Access the Url
		driver.get("http://stageapi.fullintel.com/3.6.0/login");

		// Get the Title
		System.out.println(driver.getTitle());
		// Setting a default time out for identifying objects (after the page is
		// completely loaded)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Enter Username
		driver.findElement(By.id("email")).sendKeys("anumanthu.e@capestart.com");

		// Enter password
		driver.findElement(By.id("password")).sendKeys("start");

		// Click Login
		driver.findElement(By.name("submit")).click();

		WebElement customer = driver.findElement(By.id("ui-id-1"));
		List<WebElement> dropDown = customer.findElements(By.tagName("li"));
		int size = dropDown.size();
		System.out.println("No of items in dropdown is" + size);
		for (WebElement option : dropDown) {
			System.out.println(option.getText());
			if ("Samsung Viji".equals(option.getText())) {
				option.click();
				break;
			}
		}

		driver.findElement(By.linkText("Add Article")).click();
		// Add Article
		driver.findElement(By.id("heading")).sendKeys("Films");
		driver.findElement(By.id("url")).sendKeys("http://www.msn.com/en-in/sports");

		driver.findElement(By.id("datetimepicker")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Click on prev so that we will be in previous month
		driver.findElement(By.className("xdsoft_prev")).click();

		WebElement dateWidget = driver.findElement(By.className("xdsoft_calendar"));
		List<WebElement> rows = dateWidget.findElements(By.tagName("tr"));
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

		for (WebElement cell : columns) {

			System.out.println("Cells: " + cell.getText());
			// Select 13th Date
			if (cell.getText().equals("13")) {
				wait.until(ExpectedConditions.elementToBeClickable(
						cell.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/table/tbody/tr[3]/td[1]/div"))))
						.click();
				// cell.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/table/tbody/tr[3]/td[1]/div")).click();
				break;
			}
		}

		driver.findElement(By.id("articleImage"))
				.sendKeys("http://www.msn.com/en-in/sports/cricket/cricketers-then-and-now/ss-BBktOBO");
		// Outlet
		driver.findElement(By
				.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[5]/div[2]/auto-complete-tag/div/ul/li/input"))
				.click();
		driver.findElement(By
				.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[5]/div[2]/auto-complete-tag/div/ul/li/input"))
				.sendKeys("test");

		WebElement autoOptions = driver.findElement(By.xpath(
				"/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[5]/div[2]/auto-complete-tag/div/ul/li/input"));
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(autoOptions));

		driver.findElement(By
				.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[5]/div[2]/auto-complete-tag/div/div/ul/li[1]"))
				.click();
		// Contacts
		driver.findElement(By
				.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[6]/div[2]/auto-complete-tag/div/ul/li/input"))
				.click();
		driver.findElement(By
				.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[6]/div[2]/auto-complete-tag/div/ul/li/input"))
				.sendKeys("cap");

		WebElement autoOptions1 = driver.findElement(By.xpath(
				"/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[6]/div[2]/auto-complete-tag/div/ul/li/input"));
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(autoOptions1));

		driver.findElement(By
				.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[6]/div[2]/auto-complete-tag/div/div/ul/li[1]"))
				.click();

		driver.findElement(By
				.xpath("/html/body/div[3]/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[7]/div[2]/auto-complete-tag/div/ul/li/input"))
				.sendKeys("https://twitter.com/?lang=en-in");

		driver.findElement(By.id("articleDescription")).sendKeys(
				"Sport is generally recognised as system of activities which are based in physical athleticism or physical dexterity, with the largest major competitions such as the Olympic Games admitting only sports meeting this definition.");

		WebElement markAsImportant = driver.findElement(By.id("markAsImportant"));
		markAsImportant.click();

		// switch to frame
		WebElement editorFrame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(editorFrame);
		driver.findElement(By.tagName("body")).sendKeys(
				"Sport (UK) or sports (US) are all usually forms of competitive physical activity or games which,[1] through casual or organized participation, aim to use, maintain or improve physical ability and skills while providing enjoyment to participants, and in some cases, entertainment for spectators.[2] Usually the contest or game is between two sides, each attempting to exceed the other. Some sports allow a tie game; others provide tie-breaking methods, to ensure one winner and one loser. A number of such two-sided contests may be arranged in a tournament producing a champion. Many sports leagues make an annual champion by arranging games in a regular sports season, followed in some cases by playoffs. Hundreds of sports exist, from those between single contestants, through to those with hundreds of simultaneous participants, either in teams or competing as individuals. In certain sports such as racing, many contestants may compete, each against each other, with one winner.");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("saveandclose")).click();
		// driver.quit();
	}

}
