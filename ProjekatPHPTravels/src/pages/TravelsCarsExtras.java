package pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravelsCarsExtras extends BasicPage {

	private By cars = By.cssSelector("#social-sidebar-menu li:nth-child(10) a");
	private By extras = By.cssSelector("#Cars > li:nth-child(2) > a");
	private By addBtn = By.cssSelector(".btn.btn-success.xcrud-action");
	private By addImage = By.name("xcrud-attach");
	private By name = By.cssSelector(".xcrud-input.form-control");
	private By status = By.cssSelector("#content div.panel.panel-default div.panel-body div div div.xcrud-ajax div.xcrud-view div div:nth-child(3) div select");
	private By price = By.cssSelector("#content div.panel.panel-default div.panel-body div div div.xcrud-ajax div.xcrud-view div div:nth-child(4) div input");
	private By save = By.cssSelector(".btn.btn-primary.xcrud-action");
	private By searchBtn = By.cssSelector("a.xcrud-search-toggle.btn.btn-default");
	private By searchField = By.cssSelector("input.xcrud-searchdata.xcrud-search-active.input-small.form-control");
	private By carsRows = By.className("xcrud-row");
	
	public TravelsCarsExtras(WebDriver driver) 
	{
		super(driver);
	}
	
	public void getCars()
	{
		this.driver.findElement(this.cars).click();
	}
	
	public void getExtras()
	{
		this.driver.findElement(this.extras).click();
	}
	
	public void getAddBtn()
	{
		this.driver.findElement(this.addBtn).click();
	}
	
	public void getAddImage(String path)
	{
		this.driver.findElement(this.addImage).sendKeys(new File(path).getAbsolutePath());
	}
	
	public void getName(String name)
	{
		this.driver.findElement(this.name).sendKeys(name);
	}
	
	public void changeStatus(String statusValue)
	{
		Select select = new Select(this.driver.findElement(this.status));
		select.selectByVisibleText(statusValue);
	}
	
	public String setPrice(String price) throws InterruptedException 
	{
		WebElement priceElement = this.driver.findElement(this.price);
		priceElement.sendKeys(price);
		Thread.sleep(2000);
		
		return priceElement.getAttribute("value");
		
	}
	
	public void getSaveBtn()
	{
		this.driver.findElement(this.save).click();
	}
	
	public void searchCar(String searchTerm)
	{
		this.driver.findElement(this.searchBtn).click();
		WebElement searchField = this.driver.findElement(this.searchField);
		searchField.sendKeys(searchTerm);
		searchField.sendKeys(Keys.ENTER);
	}
	
	public String doesCarExists(String carName) throws InterruptedException
	{
		this.searchCar(carName);
		Thread.sleep(2000);
		List<WebElement> rows = driver.findElements(this.carsRows);
		List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
		
		if(columns.size() >= 4)
		{
			return columns.get(3).getText();
		}
		else
		{
			return columns.get(0).getText();
		}
	}
	
	public boolean doesCarImageExists() throws InterruptedException
	{
		//this.searchCar(carName);
		Thread.sleep(2000);
		List<WebElement> rows = driver.findElements(this.carsRows);
		List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
		
		if(columns.size() >= 3)
		{
			return columns.get(2).findElement(By.tagName("img")) != null;
		}
		else
		{
			return false;
		}
	}

}
