package Turtlepagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Turtlepagecls {


WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"NewsletterPopup-newsletter-popup\"]/div/div/button")
	WebElement popup;
	
	@FindBy(xpath="//*[@id=\"SiteHeader\"]/div[1]/div/div[3]/div/div/a[1]")
	WebElement alogin;
	@FindBy(xpath="//*[@id=\"customer_register_link\"]")
	WebElement caccount;
	@FindBy(id="FirstName")
	WebElement fname;
	@FindBy(id="LastName")
	WebElement lname;
	@FindBy(name="customer[email]")
	WebElement emailid;
	
	@FindBy(id="CreatePassword")
	WebElement pswd;
	@FindBy(xpath="//*[@id=\"create_customer\"]/p/input")
	WebElement button;
	@FindBy(id="CustomerPassword")
	WebElement pass;
	@FindBy(xpath="//*[@id=\"customer_login\"]/p[1]/button")
	WebElement loginbutton;
	
	
	public Turtlepagecls(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void popupwindow() throws Exception
	{
		Thread.sleep(2000);
		popup.click();
	}
	
	public void login() 
	{
		alogin.click();
		
	}
	public void createaccount()
	{
		caccount.click();
		fname.sendKeys("Athulya");
		lname.sendKeys("S");
		emailid.sendKeys("athulyas293@gmail.com");
		pswd.sendKeys("abc123");
		button.click();
	}
		public void acctlogin(String emails, String password)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//emailid.clear();
		emailid.sendKeys(emails);
		//pass.clear();
		pass.sendKeys(password);
		loginbutton.click();
		
	}
}
