package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItecyResumeUploadPage 
{
public WebDriver driver;
	
	@FindBy(name="uploadResume")
	public WebElement upload_resume;
	
	@FindBy(linkText="Download  Resume")
	public WebElement download_resume;
	
	@FindBy(xpath="//*[@value='Submit Your Details']")
	public WebElement submitt;
	
	@FindBy(xpath="//*[@class='dropdown-toggle signin']")
	public WebElement profile_ink;
	
	@FindBy(linkText="Log off")
	public WebElement logoff;
	
	public ItecyResumeUploadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void click_upload_resume()
	{
		upload_resume.click();
		//java robot
	}
	
	public void click_download_resume()
	{
		download_resume.click();
	}
	
	public void click_profile_ink()
	{
		profile_ink.click();
	}
	
	public void click_logoff()
	{
		logoff.click();
	}
	
	public void click_submitt()
	{
		submitt.click();
	}
	
}
