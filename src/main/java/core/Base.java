package core;

	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import java.util.logging.Logger;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Base {
	
		public static WebDriver driver;
		public static Properties properties;
		public static Logger logger;
		private String propertyPath =".\\src\\test\\resources\\input\\property.properties";
		private String log4jPath ="\\src\\test\\resources\\input\\lock4j.properties";
		
		public Base() {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(propertyPath));
	            properties = new Properties();
	            properties.load(reader);
	            reader.close();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
			public static String getUrl() {
				String url = properties.getProperty("url");
				return url;
				}
			public static String getBrowser() {
				String browser = properties.getProperty("browser");
				return browser;
			}
			public static void openBrowser() {
				driver.get(getUrl());
			}
			public static void tearDown() {
				driver.close();
				driver.quit();
				
			}
			
			public static void browser() {
				String browserName = getBrowser();
				switch(browserName) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "ff":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new ChromeDriver();
					
				}
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			    driver.manage().deleteAllCookies();
			    
			}
			
		
		}




