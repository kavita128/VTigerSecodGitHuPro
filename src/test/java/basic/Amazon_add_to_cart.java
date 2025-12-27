package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Amazon_add_to_cart 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.edge.driver", ".softwares/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon']")).sendKeys("puma");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/61FOEya575L._AC_UL320_.jpg']")).click();
		driver.findElement(By.id("a-autoid-4-announce")).click();
	}
}
