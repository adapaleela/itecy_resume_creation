package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItecyLoginPage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[text()='Jobseeker Sign In']")
	public WebElement signin;
	
	@FindBy(name="email")
	public WebElement uid;
	
	@FindBy(name="password")
	public WebElement pwd;
	
	@FindBy(xpath="//*[contains(text(),'Login')]")
	public WebElement login;
	
	@FindBy(xpath="//*[@class='alert alert-danger']")
	public WebElement uidinvaliderrmessg;
	
	@FindBy(xpath="//*[@class='alert alert-danger']")
	public WebElement pwdinvaliderrmessg;
	
	@FindBy(xpath="//*[@name='__RequestVerificationToken'][@type='hidden'][1]")
	public WebElement alertmessg;
	
	public ItecyLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickSignin()
	{
		signin.click();;
	}
	
	public void fillUid(String x)
	{
		uid.sendKeys(x);
	}
	
	public void fillPwd(String x)
	{
		pwd.sendKeys(x);
	}
	
	public void clickLogin()
	{
		login.click();
	}
}
