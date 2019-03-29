package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItecySocialProfilePage
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[@placeholder='Facebook Link']")
	public WebElement facebook;
	
	@FindBy(xpath="//*[@placeholder='Twitter Link']")
	public WebElement twitter;
	
	@FindBy(xpath="//*[@placeholder='Linkdin Link']")
	public WebElement linkdin;
	
	@FindBy(xpath="//*[@placeholder='G+ Link']")
	public WebElement glink;
	
	@FindBy(xpath="//*[@placeholder='Instagram Link']")
	public WebElement instagram;
	
	@FindBy(xpath="//*[@placeholder='Dribble Link']")
	public WebElement dribble;
	
	@FindBy(xpath="//*[@title='Next']")
	public WebElement sppnext_button;
	
	public ItecySocialProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void fill_facebook(String x)
	{
		facebook.sendKeys(x);
	}
	
	public void fill_linkdin(String x)
	{
		linkdin.sendKeys(x);
	}
	
	public void fill_glink(String x)
	{
		glink.sendKeys(x);
	}
	
	public void fill_instagram(String x)
	{
		instagram.sendKeys(x);
	}
	
	public void fill_dribble(String x)
	{
		dribble.sendKeys(x);
	}
	
	public void fill_twitter(String x)
	{
		twitter.sendKeys(x);
	}
	
	public void sppclick_next()
	{
		sppnext_button.click();
	}
}
