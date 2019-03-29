package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItecyAddSkillsPage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[@class='chosen-search-input default']")
	public WebElement add_skills_link;
	
	@FindBy(xpath="//*[@title='Next']")
	public WebElement aspnext_button;
	
	public ItecyAddSkillsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void click_add_skills_link()
	{
		add_skills_link.click();
		//pending
	}
	
	public void aspclick_next()
	{
		aspnext_button.click();
	}
	
	
}
