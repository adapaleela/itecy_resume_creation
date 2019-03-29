package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItecyCreatePage 
{
public WebDriver driver;
	
	@FindBy(name="ResumeTitle")
	public WebElement resume_title;
	
	@FindBy(name="IndustryId")
	public WebElement industry_id;
	
	@FindBy(name="Summary")
	public WebElement summary;
	
	@FindBy(xpath="//*[@title='Next']")
	public WebElement cpnext_button;
	
	public ItecyCreatePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void fill_resume_title(String x)
	{
		resume_title.sendKeys(x);
	}
	
	public void select_industry()
	{
		industry_id.click();
		Select s=new Select(industry_id);
		s.selectByValue("IT Computers / Software");
	}
	
	public void fill_summary(String x)
	{
		summary.sendKeys(x);
	}
	
	public void cpclick_next()
	{
		cpnext_button.click();
	}
}
