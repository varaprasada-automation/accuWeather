package accuWeather;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class accuWeatherWeb extends Base {
	public String getTemparature(String city) {
		initialize();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String temparature = driver.findElement(By.xpath("//span[@class='header-temp']")).getText();
		System.out.println(temparature);
		return temparature;
	}
}
