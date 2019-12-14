package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsCars extends BasicPage {

	//private By tabel = By.cssSelector("#content > div.panel.panel-default > div.panel-body tbody");
	private List<WebElement> rows = driver.findElements(By.className("xcrud-row"));
	
	public TravelsCars(WebDriver driver) 
	{
		super(driver);
	}
	
	public List<WebElement> carsList()
	{
		List<WebElement> cars = new ArrayList<WebElement>();
	
		for(int i = 0; i < rows.size(); i++) 
		{
			WebElement name = rows.get(i).findElements(By.tagName("td")).get(4);
			cars.add(name);
		}
		return cars;
	}
	
	public int carsCount()
	{
		return carsList().size();
	}
	
	public int getOrders()
	{
		int sum = 0;
		for(int i = 0; i < rows.size(); i++) 
		{
			WebElement order = rows.get(i).findElements(By.tagName("td")).get(9).findElement(By.cssSelector("[type='number']"));
			sum = sum + Integer.parseInt(order.getAttribute("value"));
		}
		return sum;
	}
	
}
