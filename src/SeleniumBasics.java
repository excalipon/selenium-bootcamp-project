import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBasics {
	private WebDriver driver;
	
	@Before
	public void initiatilize() {
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\java-exercises\\JUnitProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
	
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class); 
		loginPage.login("mercury", "mercury");
	}
	
	@Test
	public void bookFlight() {
		
		MercuryReservationPage firstPage = PageFactory.initElements(driver, MercuryReservationPage.class);
		firstPage.firstClassRdBtn.get(2).click();
		
		//Select first class
		//List<WebElement> firstClassRdBtn = driver.findElements(By.name("servClass"));
		//firstClassRdBtn.get(2).click();
		
		//Select Unified Airline
		//Select airlineDrpDown = new Select(driver.findElement(By.name("airline")));
		//airlineDrpDown.selectByVisibleText("Unified Airlines");
		
		firstPage.getSelect().selectByVisibleText("Unified Airlines");
		
		//Click continue
		WebElement contBtn = driver.findElement(By.name("findFlights"));
		contBtn.click();
		
		
		
		
		
		//Select Pangea Airline 362 for Depart
		WebElement pangeaRdBtn = driver.findElement(By.xpath("//input[@value='Pangea Airlines$362$274$9:17']"));
		pangeaRdBtn.click();
		
		//Select Blue Skies Airlines
		WebElement blueRdBtn = driver.findElement(By.xpath("//input[@value='Blue Skies Airlines$630$270$12:23']"));
		blueRdBtn.click();
		
		// Click continue 
		WebElement reserveBtn = driver.findElement(By.name("reserveFlights"));
		reserveBtn.click();
		
		//Fill out First Name, Last Name
		WebElement fNameTxtBox = driver.findElement(By.name("passFirst0"));
		WebElement sNameTxtBox = driver.findElement(By.name("passLast0"));
		fNameTxtBox.sendKeys("Randy");
		sNameTxtBox.sendKeys("Cunanan");
		
		//Click secure purchase
		WebElement secureBtn = driver.findElement(By.name("buyFlights"));
		secureBtn.click();
		
		//Assert by checking the confirmation message
		WebElement itineraryLbl = driver.findElement(By.xpath("//font[@size='+1']"));
		String itiText = itineraryLbl.getText();
		assertEquals(itiText,"Your itinerary has been booked!");

		//Click logout
		WebElement logoutBtn = driver.findElement(By.xpath("//img[@src='/images/forms/Logout.gif']"));
		logoutBtn.click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
