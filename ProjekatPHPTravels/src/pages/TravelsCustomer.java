package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TravelsCustomer extends BasicPage {

	//private By accounts = By.cssSelector(".fa.fa-user-circle");
	private By accounts = By.cssSelector("#social-sidebar-menu > li:nth-child(5) > a > i");
	private By customers = By.cssSelector("#ACCOUNTS > li:nth-child(3) > a");
	private By editCustomer = By.cssSelector(".btn.btn-default.btn-xcrud.btn.btn-warning");
	private By firstName = By.cssSelector(".form-control");
	private By lastName = By.name("lname");
	private By customerEmail = By.name("email");
	private By mobileNo = By.name("mobile");
	private By country = By.cssSelector(".select2-chosen");
	private By countrySearch = By.cssSelector(".select2-input");
	private By address = By.name("address1");
	private By status = By.name("status");
	private By checkbox = By.cssSelector("[type='checkbox']");
	private By submitBtn = By.cssSelector("button.btn.btn-primary");
	private By searchBtn = By.cssSelector("a.xcrud-search-toggle.btn.btn-default");
	private By searchField = By.cssSelector("input.xcrud-searchdata.xcrud-search-active.input-small.form-control");
	private By customerRows = By.className("xcrud-row");
	
	public TravelsCustomer(WebDriver driver) 
	{
		super(driver);
	}
	
	public void getAccount()
	{
		this.driver.findElement(this.accounts).click();
	}
	
	public void getCustomers()
	{
		this.driver.findElement(this.customers).click();
	}
	
	public void getEditCustomer()
	{
		this.driver.findElement(this.editCustomer).click();
	}

	public void setFirstName(String firstName)
	{
		WebElement input = this.driver.findElement(this.firstName);
		input.clear();
		input.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		WebElement input = this.driver.findElement(this.lastName);
		input.clear();
		input.sendKeys(lastName);
	}
	
	public void setEmail(String email)
	{
		WebElement input = this.driver.findElement(this.customerEmail);
		input.clear();
		input.sendKeys(email);
	}
	
	public void setMobileNo(String mobileNo)
	{
		WebElement input = this.driver.findElement(this.mobileNo);
		input.clear();
		input.sendKeys(mobileNo);
	}
	
	public void setCountry(String selectCountry) throws InterruptedException
	{
		this.driver.findElement(this.country).click();
		Thread.sleep(1000);
		WebElement search = this.driver.findElement(this.countrySearch);
		search.sendKeys(selectCountry);
		search.sendKeys(Keys.ENTER);
	}
	
	public void setAddress(String address)
	{
		WebElement input = this.driver.findElement(this.address);
		input.clear();
		input.sendKeys(address);
	}
	
	public void setStatus(String selectStatus)
	{
		Select select = new Select(this.driver.findElement(this.status));
		select.selectByVisibleText(selectStatus);
	}
	
	public void getCheckbox()
	{
		this.driver.findElement(this.checkbox).click();
	}
	
	public void clickSubmit() throws InterruptedException
	{
		WebElement submit = this.driver.findElement(this.submitBtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", submit);
		Thread.sleep(1000);
		submit.click();
	}
	
	public void searchCustomer(String searchTerm)
	{
		this.driver.findElement(this.searchBtn).click();
		WebElement searchField = this.driver.findElement(this.searchField);
		searchField.sendKeys(searchTerm);
		searchField.sendKeys(Keys.ENTER);
	}
	
	public void changeCustomer(String firstName, String lastName, String email, String mobileNo, String selectCountry, String address, String selectStatus) 
			throws InterruptedException
	{
		Thread.sleep(2000);
		this.getAccount();
		Thread.sleep(2000);
		this.getCustomers();
		Thread.sleep(2000);
		this.getEditCustomer();
		Thread.sleep(2000);
		this.setFirstName(firstName);
		Thread.sleep(500);
		this.setLastName(lastName);
		Thread.sleep(500);
		this.setEmail(email);
		Thread.sleep(500);
		this.setMobileNo(mobileNo);
		Thread.sleep(500);
		this.setCountry(selectCountry);
		Thread.sleep(500);
		this.setAddress(address);
		Thread.sleep(500);
		this.setStatus(selectStatus);
		Thread.sleep(500);
		this.getCheckbox();
		Thread.sleep(500);
		this.clickSubmit();
		
	}
	
	public String doesCustomerExists(String email) throws InterruptedException
	{
		this.searchCustomer(email);
		Thread.sleep(2000);
		List<WebElement> rows = driver.findElements(this.customerRows);
		List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
		
		if(columns.size() >= 5)
		{
			return columns.get(4).getText();
		}
		else
		{
			return columns.get(0).getText();
		}
	}
	
	
	
}
