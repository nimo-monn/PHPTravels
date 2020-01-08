package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.TravelsCars;
import pages.TravelsCarsExtras;
import pages.TravelsCustomer;
import pages.TravelsLogin;
import pages.TravelsMenu;
import utils.TravelsExcel;

public class PHPTravelsTest extends BasicTest {
	
	
	private String baseUrl = "https://www.phptravels.net/admin";
	
	@Test(priority = 0)
	public void login() throws InterruptedException, Exception {
		
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		TravelsLogin tl = new TravelsLogin(driver);
		Thread.sleep(2000);
		//tl.signIn("admin@phptravels.com", "demoadmin");
		
		TravelsExcel te = new TravelsExcel();
		te.readExcel();
		
		tl.signIn(te.getUsername(), te.getPassword());
		Thread.sleep(2000);
		te.workbookClose();
		
		Assert.assertEquals(tl.getMainTitle(), "Dashboard");
		
	}
	
	@Test(priority = 2)
	public void menuDashboard() throws InterruptedException 
	{
		TravelsMenu tm = new TravelsMenu(driver);
		
		tm.getDashbord();
		Thread.sleep(3000);
		Assert.assertEquals(tm.getMainTitle(), "Dashboard");
	}
	
	@Test(priority = 1)
	public void menuUpdates() throws InterruptedException 
	{
		TravelsMenu tm = new TravelsMenu(driver);
		
		Thread.sleep(3000);
		tm.getUpdates();
		Thread.sleep(3000);
		Assert.assertEquals(tm.getMainTitle(), "Updates");
	}
	
	@Test(priority = 3)
	public void menuModules() throws InterruptedException 
	{
		TravelsMenu tm = new TravelsMenu(driver);
		
		tm.getModules();
		Thread.sleep(3000);
		Assert.assertEquals(tm.getMainTitle(), "Modules");
	}
	
	@Test(priority = 4)
	public void menuNewTours() throws InterruptedException 
	{
		TravelsMenu tm = new TravelsMenu(driver);
		
		tm.setNewTours();
		Thread.sleep(3000);
		Assert.assertEquals(tm.getMainTitle(), "Add Tour");
	}
	
	@Test(priority = 5)
	public void menuCars() throws InterruptedException 
	{
		TravelsMenu tm = new TravelsMenu(driver);
		
		tm.setCars();
		Thread.sleep(3000);
		Assert.assertEquals(tm.getMainTitle(), "Cars Management");
	}
	
	@Test(priority = 6)
	public void menuCoupons() throws InterruptedException 
	{
		TravelsMenu tm = new TravelsMenu(driver);
		
		tm.getCoupons();
		Thread.sleep(3000);
		Assert.assertEquals(tm.getMainTitle(), "Coupon Codes Management");
	}
	
	@Test(priority = 7)
	public void menuNewsletter() throws InterruptedException 
	{
		TravelsMenu tm = new TravelsMenu(driver);
		
		tm.getNewsletter();
		Thread.sleep(3000);
		Assert.assertEquals(tm.getMainTitle(), "Newsletter Management");
	}
	
	@Test(priority = 8)
	public void menuBookings() throws InterruptedException 
	{
		TravelsMenu tm = new TravelsMenu(driver);

		tm.getBookings();
		Thread.sleep(3000);
		Assert.assertEquals(tm.getMainTitle(), "Booking Management");
	}
	
	@Test(priority = 9)
	public void cars() throws InterruptedException
	{
		driver.get("https://www.phptravels.net/admin/cars");
		Thread.sleep(2000);
		
		TravelsCars tc = new TravelsCars(driver);
		
		Thread.sleep(2000);
		Assert.assertEquals(tc.carsCount(), 10);
	}
	
	@Test(priority = 10)
	public void ordersCount() throws InterruptedException
	{
		driver.get("https://www.phptravels.net/admin/cars");
		Thread.sleep(2000);
		
		TravelsCars tc = new TravelsCars(driver);
		
		Thread.sleep(2000);
		Assert.assertTrue(tc.getOrders() > 50);
	}
	
	@Test(priority = 11)
	public void carsExtras() throws InterruptedException
	{
		TravelsCarsExtras tce = new TravelsCarsExtras(driver);
		Thread.sleep(2000);
		
		tce.getCars();
		Thread.sleep(2000);
		tce.getExtras();
		Thread.sleep(2000);
		tce.getAddBtn();
		Thread.sleep(2000);
		tce.getAddImage("bmw.jpg");
		Thread.sleep(2000);
		tce.getName("BMW");
		Thread.sleep(2000);
		tce.changeStatus("Yes");
		Thread.sleep(2000);
		tce.setPrice("4500");
		Thread.sleep(2000);
		tce.getSaveBtn();
		Thread.sleep(2000);
		Assert.assertEquals(tce.doesCarExists("BMW"), "BMW");
		
	}
	
	@Test(priority = 12)
	public void carsExtrasImage() throws InterruptedException
	{
		TravelsCarsExtras tce = new TravelsCarsExtras(driver);
		Assert.assertTrue(tce.doesCarImageExists());
		
	}
	
	@Test(priority = 13)
	public void carsExtrasPrice() throws InterruptedException
	{
		TravelsCarsExtras tce = new TravelsCarsExtras(driver);
		Thread.sleep(2000);
		
		tce.getCars();
		Thread.sleep(2000);
		tce.getExtras();
		Thread.sleep(2000);
		tce.getAddBtn();
		Thread.sleep(2000);
		Assert.assertEquals(tce.setPrice("35s00"), "35s00");
	}
	
	@Test(priority = 15)
	public void changeCustomers() throws InterruptedException
	{
		TravelsCustomer tCustomer = new TravelsCustomer(driver);
		tCustomer.changeCustomer("Mika", "Mikic", "mikamikic@gmail.com", "0321478", "Germany", "Waldenburger Strasse 7", "Disabled");
		
		Thread.sleep(2000);
		Assert.assertEquals(tCustomer.doesCustomerExists("mikamikic@gmail.com"), "mikamikic@gmail.com");
	}
	

}
