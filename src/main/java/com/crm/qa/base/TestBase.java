package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public  static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		
		try {
		 prop=new Properties();
		
		
			//fis = new FileInputStream("D:\\Selenium\\Selenium Prog1\\TestNGFrameWork\\src\\multibrowsing\\config.properties");
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		}
		 catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
			 
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "c:\\driver\\geckodriver.exe");
			 
			driver=new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
	}

}
