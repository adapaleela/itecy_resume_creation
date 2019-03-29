package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItecyAddEducationPage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[@value='Add Education']")
	public WebElement add_education;
	
	@FindBy(name="EducationId")
	public WebElement select_degree;
	
	@FindBy(xpath="//*[@title='Specialization']")
	public WebElement select_specialization;
	
	@FindBy(xpath="//*[@title='Passing Year']")
	public WebElement passing_year;
	
	@FindBy(xpath="//*[@title='University Name']")
	public WebElement university;
	
	@FindBy(xpath="//*[@value='Save changes']")
	public WebElement save_changes_button;
	
	@FindBy(xpath="//*[text()='Close']")
	public WebElement close_button;
	
	@FindBy(xpath="//*[@title='Next']")
	public WebElement aedpnext_button;
	
	public ItecyAddEducationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void aedpclick_add_education()
	{
		add_education.click();
	}
	public void select_degree()
	{
		select_degree.click();
		Select s=new Select(select_degree);
		s.selectByVisibleText("B.E / B.Tech");
	}
	
	public void select_specialization()
	{
		select_specialization.click();
		Select s=new Select(select_specialization);
		s.selectByVisibleText("Electronics / Telecommunications");
	}
	
	public void fill_passing_year(String x)
	{
		passing_year.sendKeys(x);
	}
	
	public void fill_university_name(String x)
	{
		university.sendKeys(x);
	}
	
	public void aedpclick_save_changes_button()
	{
		save_changes_button.click();
	}
	
	public void aedpclick_close_button()
	{
		close_button.click();
	}
	
	public void aedpclick_next()
	{
		aedpnext_button.click();
	}
	
}
