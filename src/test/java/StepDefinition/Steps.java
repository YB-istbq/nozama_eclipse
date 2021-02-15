package StepDefinition;

import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.Disconnection;
//import cucumber.api.PendingException;
//import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	private WebDriver driver;
	String baseUrl = "http://127.0.0.1/nozama/";
	
	
	
	
	@Given("^navigateur Chrome ouvert et application sur homepage$")
	public void navigateur_Chrome_ouvert_et_application_sur_homepage() /*throws Throwable*/ {
		System.out.println("le navigateurest lance");
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	    // Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
	}

	@When("^renseigner username et password$")
	public void renseigner_username_et_password() /*throws Throwable*/ {
		try {
			driver.findElement(By.xpath("//input[@id=\'edit-name\']"));
		} catch (Error e) {
			assertFalse(e.toString(), false);
		}
		try {
			driver.findElement(By.xpath("//input[@id=\'edit-pass\']"));
		} catch (Error e) {
			assertFalse(e.toString(), false);
		}
		
		
		{
			List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-name\']"));
			assert (elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-pass\']"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.xpath("//input[@id=\'edit-name\']")).sendKeys("store1");
		driver.findElement(By.xpath("//input[@id=\'edit-pass\']")).sendKeys("store1");
		System.out.println("login et mdp sont renseignes");
	}
	    // Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
	

	@When("^valider le formulaire$")
	public void valider_le_formulaire() /*throws Throwable*/ {
		try {
			driver.findElement(By.xpath("//input[@id=\'edit-submit\']"));
		} catch (Error e) {
			assertFalse(e.toString(), false);
		}
		{
			List<WebElement> elements = driver.findElements(By.xpath("//input[@id=\'edit-submit\']"));
			assert (elements.size() > 0);
		}
		driver.findElement(By.xpath("//input[@id=\'edit-submit\']")).submit();
		System.out.println("validation des formulaires");
	    // Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
	}

	@Then("^verifier que je suis connecte avec login et mdp$")
	public void verifier_que_je_suis_connecte_avec_login_et_mdp() /*throws Throwable*/ {
	
		{
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id=\'block-menu-menu-logout\']/div/h2"));
			assert (elements.size() > 0);
		}
		System.out.println("connecte avec login et mdp");
	    // Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
		Disconnection.disconnect(driver);
		
	}
	
	
}
