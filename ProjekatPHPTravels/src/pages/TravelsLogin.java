package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsLogin extends BasicPage {

	private By email = By.name("email");
	private By password = By.name("password");
	private By rememberMe = By.cssSelector("ins.iCheck-helper");
	private By forgetPassword = By.id("link-forgot");
	private By loginBtn = By.cssSelector("button");
	
	
	public TravelsLogin(WebDriver driver) 
	{
		super(driver);
	}
	
	public void setEmail(String email) 
	{
		this.driver.findElement(this.email).sendKeys(email);
	}
	
	public void setPassword(String password) 
	{
		this.driver.findElement(this.password).sendKeys(password);
	}
	
	public void setRememberMe()
	{
		this.driver.findElement(this.rememberMe).click();
	}
	
	public WebElement clicForgetPassword()
	{
		return this.driver.findElement(forgetPassword);
	}
	
	public void clickOnLoginBtn() 
	{
		this.driver.findElement(this.loginBtn).click();
	}
	
	public void signIn(String email, String password) throws InterruptedException 
	{
		Thread.sleep(2000);
		this.setEmail(email);
		Thread.sleep(2000);
		this.setPassword(password);
		this.setRememberMe();
		this.clickOnLoginBtn();
	}

}
