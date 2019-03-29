package tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.ItecyHomePage;
import pages.ItecyLoginPage;

public class ItecyGluecode 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public ItecyHomePage hp;
	public ItecyLoginPage lp;
	public Scenario s;
	public Properties p;
	
	@Before
	public void method1(Scenario s)throws Exception
	{
		this.s=s;
		File f=new File("E:\\leelajava\\itecy\\src\\test\\resources\\repository\\itecy_properties.properties");
		FileReader fr=new FileReader(f);
		p=new Properties();
		p.load(fr);
	}
	
	@Given("^launch site$")
	public void launch_site() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",p.getProperty("cpath"));
		driver=new ChromeDriver();
		hp=new ItecyHomePage(driver);
		lp=new ItecyLoginPage(driver);
		driver.get(p.getProperty("url"));
		wait=new WebDriverWait(driver,50);
		driver.manage().window().maximize();
	}
	
	@When("^click on signin link$")
	public void click_on_signin_link()
	{
		wait.until(ExpectedConditions.visibilityOf(lp.signin));
		lp.clickSignin();
	}
	
	@And("^fill username \"(.*)\"$")
	public void fill_username(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.uid));
		lp.fillUid(x);
	}
	
	@And("^fill password \"(.*)\"$")
	public void fill_password(String y)
	{
		wait.until(ExpectedConditions.visibilityOf(lp.pwd));
		lp.fillPwd(y);
	}
	
	@And("^click login button$")
	public void click_login_button()
	{
		wait.until(ExpectedConditions.visibilityOf(lp.login));
		lp.clickLogin();
	}
	
	@Then("^validate output for criteria \"(.*)\" for \"(.*)\" and \"(.*)\" for \"(.*)\"$")
	public void validate_output(String uc,String u,String pc,String p)throws Exception
	{
		Thread.sleep(5000);
	    try 
	    {
	    	if(uc.equals("valid") && pc.equals("valid") && hp.messg.isDisplayed())
	    	{
	    		
	    		wait.until(ExpectedConditions.visibilityOf(hp.messg));
	    		s.write("valid userid and password test passed");
	    		hp.clickMessg();
	    		wait.until(ExpectedConditions.visibilityOf(hp.logoff));
	    		hp.clickLogoff();
	    		
	    	}
	    	else if(uc.equals("uid_blank") && pc.equals("valid") && lp.alertmessg.isDisplayed())
	    	{
	    		s.write("blank userid test passed");
	    	}
	    	else if(uc.equals("valid") && pc.equals("pwd_blank") && lp.alertmessg.isDisplayed())
	    	{
	    		s.write("blank pwd test passed");
	    	}
	    	else if(uc.equals("invalid") && pc.equals("valid") && lp.uidinvaliderrmessg.isDisplayed())
	    	{
	    		s.write("invalid uid test passed");
	    	}
	    	else if(uc.equals("invalid") && pc.equals("valid") && lp.pwdinvaliderrmessg.isDisplayed())
	    	{
	    		s.write("invalid uid test passed");
	    	}
	    	else
	    	{
	    		byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    		s.embed(ss,"login test failed");
	    		Assert.fail();
	    	}
	    }
	    catch(Exception ex)
	    {
	    	byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    		s.embed(ss,ex.getMessage());
    		Assert.fail();
	    }
	
	}
	@And("^close site$")
	@When("^close site$")
	public void close_site()
	{
		driver.close();
	}
	
	@And("^click on jobseeker dropdown in login page$")
	public void click_on_jobseeker_dropdown()
	{
		
	}
	
	@And("^click on create resume$")
	public void click_on_create_resume()
	{
		
	}
	
	@And("^fill the fields in creation page$")
	public void fill_fields_in_creation_page(DataTable dt) throws Exception
	{
		
	}
	
	@And("^click on next$")
	public void click_on_next()
	{
		
	}
	
	@And("^fill the fields in general information page$")
	public void fill_fields_in_general_information_page(DataTable dt) throws Exception
	{
		
	}
	
	@And("^click on Add education and fill fields$")
	public void fill_fields_in_add_education_page(DataTable dt) throws Exception
	{
		
	}
	
	@And("^click on save changes button$")
	public void click_on_save_changes()
	{
		
	}
	
	@And("^click on close button$")
	public void click_on_close_button()
	{
		
	}
	
	@And("^click on Add experience and fill fields$")
	public void fill_fields_in_add_experience_page(DataTable dt) throws Exception
	{
		
	}
	
	@And("^click on Add certification and fill fields$")
	public void fill_fields_in_add_certification_page(DataTable dt) throws Exception
	{
		
	}
	
	
	@And("^click on add skills dropdown and select required skills$")
	public void select_required_skills_from_dropdown(DataTable dt) throws Exception
	{
		
	}
	
	@And("^fill the fields of social profile$")
	public void fill_fields_in_social_profile_page(DataTable dt) throws Exception
	{
		
	}
	
	@And("^upload resume$")
	public void upload_resume()
	{
		
	}
	
	@And("^click on download resume to download resume$")
	public void download_resume()
	{
		
	}
	
	@And("^click on submit your details button to submitt$")
	public void click_on_submitt()
	{
		
	}
	
	@And("^click on hi message to logout$")
	public void click_on_messg()
	{
		
	}
	
	@And("^click on logoff$")
	public void click_on_logoff()
	{
		
	}
	
	
}
