package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItecyAddExperiencePage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[@value='Add Experience']")
	public WebElement add_experience_link;
	
	@FindBy(xpath="//*[@title='Select Company']")
	public WebElement select_company;
	
	@FindBy(xpath="//*[@title='Select Industry']")
	public WebElement select_industry;
	
	@FindBy(xpath="//*[@title='Select Functional Area']")
	public WebElement select_functional_area;
	
	@FindBy(xpath="//*[@title='Select Designation']")
	public WebElement select_designation;
	
	@FindBy(xpath="//*[@placeholder='Joining Date']")
	public WebElement joining_date;
	
	@FindBy(xpath="//*[@placeholder='Monthly Salary']")
	public WebElement monthly_salary;
	
	@FindBy(xpath="checkbox")
	public WebElement checkbox;
	
	@FindBy(xpath="//*[@title='Select Expected Salary']")
	public WebElement expected_salary;
	
	@FindBy(xpath="//*[@title='Select Notice Period']")
	public WebElement notice_period;
	
	@FindBy(xpath="//*[@value='Save changes']")
	public WebElement aexpsave_changes_button;
	
	@FindBy(xpath="//*[text()='Close']")
	public WebElement aexpclose_button;
	
	@FindBy(xpath="//*[@title='Next']")
	public WebElement aexpnext_button;
	
	public ItecyAddExperiencePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void aexpclick_on_experience_link()
	{
		add_experience_link.click();
	}
	
	public void select_company()
	{
		select_company.click();
		Select s=new Select(select_company);
		s.selectByVisibleText("Infosys Ltd");
	}
	
	public void select_industry()
	{
		select_industry.click();
		Select s=new Select(select_industry);
		s.selectByVisibleText("IT Computers / Software");
	}
	
	public void select_functional_area()
	{
		select_functional_area.click();
		Select s=new Select(select_functional_area);
		s.selectByVisibleText("QA");
	}
	
	public void select_designation()
	{
		select_designation.click();
		Select s=new Select(select_designation);
		s.selectByVisibleText("Quality Assurance / Control");
	}
	
	public void select_joining_date()
	{
		joining_date.click();
		//pending
	}
	
	public void click_checkbox()
	{
		checkbox.click();
	}
	
	public void select_expected_salary()
	{
		expected_salary.click();
		Select s=new Select(expected_salary);
		s.selectByVisibleText("30% Hike");
	}
	
	public void select_notice_period()
	{
		notice_period.click();
		Select s=new Select(notice_period);
		s.selectByVisibleText("7 Days");
	}
	
	public void fill_monthly_salary(String x)
	{
		monthly_salary.sendKeys(x);
	}
	
	public void aexpclick_save_changes()
	{
		aexpsave_changes_button.click();
	}
	
	public void aexpclick_close()
	{
		aexpclose_button.click();
	}
	
	public void aexpclick_next()
	{
		aexpnext_button.click();
	}
}
