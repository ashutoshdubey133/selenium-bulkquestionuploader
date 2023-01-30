import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	public static void main(String[] args) {
		Credentials credentials = new Credentials();
		
		System.setProperty(credentials.getDriverName(), credentials.getDriverPath());

		WebDriver driver = new ChromeDriver();
		driver.get("https://admin.codingninjas.com/users/sign_in");

		String title = driver.getTitle();
		System.out.println(title);

		driver.findElements(By.className("login_link")).get(1).click();

		WebElement email = driver.findElement(By.cssSelector("input[type='email']"));
		email.sendKeys(credentials.getEmail());

		List<WebElement> findElements = driver.findElements(By.tagName("button"));
		for (int i = 0; i < findElements.size(); i++) {
			if (findElements.get(i).getText().equals("Next"))
				findElements.get(i).click();
		}

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		WebElement pwd = driver.findElement(By.id("password")).findElement(By.tagName("input"));
		pwd.sendKeys(credentials.getPassword());

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		findElements = driver.findElements(By.tagName("button"));
		for (int i = 0; i < findElements.size(); i++) {
			if (findElements.get(i).getText().equals("Next"))
				findElements.get(i).click();
		}

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.get("https://admin.codingninjas.com/problems/new");

		// driver.quit();

	}
}
