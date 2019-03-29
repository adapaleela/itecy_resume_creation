package pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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
	public WebElement profile_link;
	
	@FindBy(linkText="Log off")
	public WebElement logoff;
	
	public ItecyResumeUploadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void click_upload_resume() throws Exception
	{
		upload_resume.click();
		//Automate file upload file(Java Robot)
        Thread.sleep(10000); //for file upload window
        StringSelection x=new StringSelection("xxxxx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x,null);
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(5000);
	}
	
	public void click_download_resume()
	{
		download_resume.click();
	}
	
	public void click_profile_link()
	{
		profile_link.click();
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
