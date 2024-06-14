package Turtletestpkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Excelutils.Utilcls;
import Turtlepagepkg.Turtlepagecls;

public class Turtletestcls {

	WebDriver driver;
	String baseurl="https://www.turtle.in";
	Turtlepagecls ob;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
		
	}
	
	@BeforeMethod
	public void befmthd()
	{
		ob=new Turtlepagecls(driver);
	}
	
	@Test(priority = 1)
	public void popuptest() throws Exception 
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ob.popupwindow();
		ob.login();
		ob.createaccount();
		driver.navigate().to("https://turtle.in/account/login?return_url=%2Faccount");
		
	}
	
	@Test(priority = 2)
	public void logintest() throws Exception 
	{
		
		String xl="C:\\Users\\User\\Desktop\\sheet1.xlsx";
		String sheet="Sheet1";
		int rowcount=Utilcls.getRowCount(xl, sheet);
		for(int i=1;i<=rowcount;i++)
		{
			String email=Utilcls.getcellvalues(xl, sheet, i, 0);
			System.out.println("email="+email);
			String password=Utilcls.getcellvalues(xl, sheet, i, 1);
			System.out.println("password="+password);
			ob.acctlogin(email, password);
			
		}
		Thread.sleep(1000);	
		driver.close();
		
	}
	
}
