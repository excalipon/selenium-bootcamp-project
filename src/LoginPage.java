import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	//Fields
	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "userName")
	private WebElement userNameField;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordField;
	
	@FindBy(how = How.NAME, using = "login")
	private WebElement loginBtn;
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String username, String password) {
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}

}
