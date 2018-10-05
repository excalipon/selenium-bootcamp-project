import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class MercuryReservationPage {
	
	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "servClass")
	public List<WebElement> firstClassRdBtn;
	
	@FindBy(how = How.NAME, using = "airline")
	public WebElement airlineDrpDown;
	
	@FindBy(how = How.NAME, using = "findFlights")
	public WebElement contBtn;
	
	//Constructor
	public MercuryReservationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Select getSelect() {
		return new Select(airlineDrpDown);
	}

}
