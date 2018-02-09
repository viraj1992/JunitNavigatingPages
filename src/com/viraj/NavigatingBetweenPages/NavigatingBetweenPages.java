package com.viraj.NavigatingBetweenPages;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class NavigatingBetweenPages {

	WebDriver driver;
	String baseUrl;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/viraj/Downloads/chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	void test() throws InterruptedException {
		driver.get(baseUrl);
		String title = driver.getTitle();
		System.out.println("The title of the page is : " + title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is : " + currentUrl);
		
		String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		driver.navigate().to(urlToNavigate);
		System.out.println("Navigating to Login");
		
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is : " + currentUrl);
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		System.out.println("Navigate Back");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is : " + currentUrl);
		
		Thread.sleep(2000);
		
		driver.navigate().forward();
		System.out.println("Navigate Forward");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is : " + currentUrl);
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		System.out.println("Navigate Back");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is : " + currentUrl);
		
		driver.navigate().refresh();
		System.out.println("Navigate Refresh");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is : " + currentUrl);
		
		driver.get(currentUrl);
		System.out.println("Navigate Refresh Twice");
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is : " + currentUrl);
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
			
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

}
