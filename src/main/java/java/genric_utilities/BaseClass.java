package java.genric_utilities;


import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;



public class BaseClass 
{
	// Inorderto access this class from outside the package we make the variables as "public"
	public DataBaseUtilities dbUtil=new DataBaseUtilities();
	public ExcelUtilities xlUtil=new ExcelUtilities();
	public javautils jUtil=new javautils();
	public PropFileUtils propUtil= new PropFileUtils();
	public WebdriverUtilities wbdUtil= new WebdriverUtilities();
	
	

	public WebDriver driver;
	//public static WebDriver sdriver;
	public static ThreadLocal<WebDriver> wdriver = new ThreadLocal<WebDriver>();

	// connect to Database
	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException
	{
		dbUtil.connectToDB();
		System.out.println("DataBase connected succesfully");
	}


	//Launching the Browser
	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws IOException
	{
		//Handling browser pop-ups
		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.addArguments("--diable-notification");
		EdgeOptions edgOpt = new EdgeOptions();
		edgOpt.addArguments("--diable-notification");
		FirefoxOptions fireOpt = new FirefoxOptions();
		fireOpt.addArguments("--diable-notification");

		//String Browser = propUtil.readDataFromPropertyFile("browser");
		String Url = propUtil.readDataFromPropertyFile("url");
	}
}
