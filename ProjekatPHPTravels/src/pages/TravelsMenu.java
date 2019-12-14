package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelsMenu extends BasicPage {

	private By dashboard = By.cssSelector("strong");
	private By updates = By.cssSelector("i.fa.fa-refresh");
	private By modules = By.cssSelector("#social-sidebar-menu > li:nth-child(3) > a");
	private By tours = By.cssSelector("#social-sidebar-menu > li:nth-child(9) > a");
	private By addNew = By.xpath("//*[@id=\"Tours\"]/li[2]/a");
	private By cars = By.cssSelector("#social-sidebar-menu > li:nth-child(10) > a");
	private By carsSubMenu = By.cssSelector("#Cars > li:nth-child(1) > a");
	private By coupons = By.cssSelector("#social-sidebar-menu > li:nth-child(15) > a");
	private By newsletter = By.cssSelector("#social-sidebar-menu > li:nth-child(16) > a");
	private By bookings = By.cssSelector("#social-sidebar-menu > li:nth-child(17) > a");
	
	public TravelsMenu(WebDriver driver) 
	{
		super(driver);
	}
	
	public void getDashbord()
	{
		this.driver.findElement(this.dashboard).click();
	}
	
	public void getUpdates()
	{
		this.driver.findElement(this.updates).click();
	}
	
	public void getModules()
	{
		this.driver.findElement(this.modules).click();
	}
	
	public void getTours()
	{
		this.driver.findElement(this.tours).click();
	}
	
	public void getAddNew()
	{
		this.driver.findElement(this.addNew).click();
	}
	
	public void getCars()
	{
		this.driver.findElement(this.cars).click();
	}
	
	public void getCarsSubMenu()
	{
		this.driver.findElement(this.carsSubMenu).click();
	}
	
	public void getCoupons()
	{
		this.driver.findElement(this.coupons).click();
	}
	
	public void getNewsletter()
	{
		this.driver.findElement(this.newsletter).click();
	}
	
	public void getBookings()
	{
		this.driver.findElement(this.bookings).click();
	}
	
	public void setNewTours() throws InterruptedException
	{
		this.getTours();
		Thread.sleep(1000);
		this.getAddNew();
	}
	
	public void setCars()
	{
		this.getCars();
		this.getCarsSubMenu();
	}

}
