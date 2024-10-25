import java.time.LocalDate;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();
	
	String MyWebsite = "https://global.almosafer.com/en";
	
	Random rand = new Random();
	
	@BeforeTest
	public void MySetUp() {
		
		driver.manage().window().maximize();
		
		driver.get(MyWebsite);
		

		WebElement buttonForTheCurrency = 
		driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		
		buttonForTheCurrency.click();
		
	}
	
	
	@Test(priority = 1,enabled = false)
	public void CheckTheEnglishLanguageIsDefault() {
		
		String ActualURL = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedURL = "en";
		
		Assert.assertEquals(ActualURL, ExpectedURL);
		

	}
	
	@Test(priority = 2,enabled = false)
	public void CheckTheDefaultCurrencyIsSAR() {
		
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		String ExpectedCurrency = "SAR";
		
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
		
		
	}
	
	@Test(priority = 3,enabled = false)
	public void CheckTheNumber() {
		
		String ActualNumaber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		
		String ExpectedNumber = "+966554400000";
		
		Assert.assertEquals(ActualNumaber, ExpectedNumber);
		
		
	}
	
	@Test(priority = 4,enabled = false)
		public void CheckIfQitafLogoIsDisplayed() {
		WebElement TheFooter = driver.findElement(By.tagName("footer"));
			boolean ActualResult = TheFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
			boolean ExpectedResult = true; 
			
			Assert.assertEquals(ActualResult, ExpectedResult);
			
		
			
		}
	
	
	@Test(priority = 5,enabled = false)
	public void CheckIfHotelsSearchIsNotSelected() {
		
	 String ActualResult = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected");
	 
	 String ExpectedResult = "false";
	 
	 Assert.assertEquals(ActualResult, ExpectedResult);
	 
		
	}
		
	
	@Test(priority = 6,enabled = false)
	 public void CheckDepartureDate() {
		
		int Today = LocalDate.now().getDayOfMonth();
		
		int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
		
		
		String ActualDeparture = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText();
		
		String ExpectedDeparture = Integer.toString(Tomorrow);
		
		Assert.assertEquals(ActualDeparture, ExpectedDeparture);
		
	
	}
	
	@Test(priority = 7,enabled = false)
	 public void CheckReturnDate() {
		
		int Today = LocalDate.now().getDayOfMonth();
		
		int TheDayAfterTommorow = LocalDate.now().plusDays(2).getDayOfMonth();
		
		
		String ActualReturn = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText();
		
		String ExpectedReturn = Integer.toString(TheDayAfterTommorow);
		
		Assert.assertEquals(ActualReturn, ExpectedReturn);
				
	
	}
	
	@Test(priority = 8)
	public void RandomChangeTheLanguage() {
		
		String [] myWebsites = {"https://global.almosafer.com/en", "https://global.almosafer.com/ar"};
		
		int randomIndex = rand.nextInt(myWebsites.length);
		
		driver.get(myWebsites[randomIndex]);
		
		if(driver.getCurrentUrl().equals("https://www.almosafer.com/ar")) {
			String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "ar";

			Assert.assertEquals(ActualLaguage, ExpectedLanguage);
			
		}else {
			
			String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "en";

			Assert.assertEquals(ActualLaguage, ExpectedLanguage);
			
		}	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
		
		
	}
	
	
	
	


