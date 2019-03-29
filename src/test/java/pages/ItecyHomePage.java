package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItecyHomePage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[text()='Hi komalkumar ghonmode !']")
	public WebElement messg;
	
	@FindBy(linkText="Log off")
	public WebElement logoff;
	
	@FindBy(xpath="//*[text()='Job Seeker']")
	public WebElement jobseeker_dropdown_link;
	
	@FindBy(xpath="//*[text()='Create Resume']")
	public WebElement create_resume_option;
	
	
	
	public ItecyHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void click_jobseeker_dropdown_link()
	{
		jobseeker_dropdown_link.click();
	}
	
	public void click_create_resume_option()
	{
		create_resume_option.click();
	}
	
	public void clickMessg()
	{
		messg.click();
	}
	
	public void clickLogoff()
	{
		logoff.click();
	}
}
