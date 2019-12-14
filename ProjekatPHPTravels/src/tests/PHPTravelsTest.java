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
		
	}
	
	@Test(priority = 1)
	public void menu() throws InterruptedException 
	{
		TravelsMenu tm = new TravelsMenu(driver);
		
		Thread.sleep(3000);
		tm.getDashbord();
		Thread.sleep(3000);
		tm.getUpdates();
		Thread.sleep(3000);
		tm.getModules();
		Thread.sleep(3000);
		tm.setNewTours();
		Thread.sleep(3000);
		tm.setCars();
		Thread.sleep(3000);
		tm.getCoupons();
		Thread.sleep(3000);
		tm.getNewsletter();
		Thread.sleep(3000);
		tm.getBookings();
	}
	
	@Test(priority = 5)
	public void cars() throws InterruptedException
	{
		driver.get("https://www.phptravels.net/admin/cars");
		Thread.sleep(2000);
		
		TravelsCars tc = new TravelsCars(driver);
		
		Thread.sleep(2000);
		Assert.assertEquals(tc.carsCount(), 10);
	}
	
	@Test(priority = 6)
	public void ordersCount() throws InterruptedException
	{
		driver.get("https://www.phptravels.net/admin/cars");
		Thread.sleep(2000);
		
		TravelsCars tc = new TravelsCars(driver);
		
		Thread.sleep(2000);
		Assert.assertTrue(tc.getOrders() > 50);
	}
	
	@Test(priority = 10)
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
		tce.getName("BMW");
		Thread.sleep(2000);
		tce.changeStatus("Yes");
		Thread.sleep(2000);
		Assert.assertEquals(tce.setPrice("35s00"), "35s00");
		Thread.sleep(2000);
		tce.getSaveBtn();
		
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
