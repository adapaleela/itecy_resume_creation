package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItecyGeneralInformationPage 
{
	public WebDriver driver;
	
	@FindBy(name="Gender")
	public WebElement gender;
	
	@FindBy(name="MaritalStatus")
	public WebElement marital_status;
	
	@FindBy(name="NationalityId")
	public WebElement nationality;
	
	@FindBy(name="CountryId")
	public WebElement country;
	
	@FindBy(name="StateId")
	public WebElement state;
	
	@FindBy(xpath="CityId")
	public WebElement city;
	
	@FindBy(name="DateOfBirth")
	public WebElement dob;
	
	@FindBy(xpath="(//*[@class='chosen-search-input default'])[1]")
	public WebElement choose_some_languages;
	
	@FindBy(xpath="(//*[@class='chosen-search-input default'])[2]")
	public WebElement choose_location;
	
	@FindBy(xpath="//*[@placeholder='Experience']")
	public WebElement experience;
	
	@FindBy(name="ExpLevel")
	public WebElement experience_level;
	
	@FindBy(name="AuthId")
	public WebElement work_authorization;
	
	@FindBy(xpath="//*[@title='Next']")
	public WebElement gfpnext_button;
	
	public ItecyGeneralInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void select_gender()
	{
		gender.click();
		Select s=new Select(gender);
		s.selectByVisibleText("Male");
	}
	
	public void select_marital_status()
	{
		marital_status.click();
		Select s=new Select(marital_status);
		s.selectByVisibleText("Single");
	}
	
	public void select_nationality()
	{
		nationality.click();
		Select s=new Select(nationality);
		s.selectByVisibleText("Indian");
	}
	
	public void select_country()
	{
		country.click();
		Select s=new Select(country);
		s.selectByVisibleText("India");
	}
	
	public void select_state()
	{
		state.click();
		Select s=new Select(state);
		s.selectByVisibleText("Telangana");
	}
	
	public void select_city()
	{
		city.click();
		Select s=new Select(city);
		s.selectByVisibleText("Hyderabad");
	}
	
	public void select_date()
	{
		dob.click();
		//pending
	}
	
	public void select_some_languages()
	{
		choose_some_languages.click();
		//peding
	}
	
	public void select_some_location()
	{
		choose_location.click();
		//pending
	}
	
	public void fill_experience(String x)
	{
		experience.sendKeys(x);
	}
	
	public void select_experience_level()
	{
		experience_level.click();
		Select s=new Select(experience_level);
		s.selectByVisibleText("3-5 Years");
	}
	
	public void select_work_authorization()
	{
		work_authorization.click();
		Select s=new Select(work_authorization);
		s.selectByVisibleText("Citizen");
	}
	
	public void gfpclick_next()
	{
		gfpnext_button.click();
	}
	
	
}
