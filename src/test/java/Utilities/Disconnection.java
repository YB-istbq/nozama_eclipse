package Utilities;

import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Disconnection {
	
	public static void disconnect(WebDriver driver) {
		try {
			driver.findElement(By.linkText("Se d�connecter"));
		} catch (Error e) {
			assertFalse(e.toString(), false);
		}
		driver.findElement(By.linkText("Se d�connecter")).click();
		driver.close();
	}
	
	
}

