package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItecyAddCertificationPage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//*[@value='Add Certification']")
	public WebElement add_certification_link;
	
	@FindBy(xpath="//*[@placeholder='Certificate Name']")
	public WebElement certificate_name;
	
	@FindBy(xpath="//*[@placeholder='Validity ']")
	public WebElement validity_date;
	
	@FindBy(xpath="//*[@placeholder='Licence No']")
	public WebElement license_no;
	
	@FindBy(xpath="//*[@placeholder='Institute Name']")
	public WebElement institution_name;
	
	@FindBy(xpath="//*[@value='Save changes']")
	public WebElement acpsave_changes_button;
	
	@FindBy(xpath="//*[text()='Close']")
	public WebElement acpclose_button;
	
	@FindBy(xpath="//*[@title='Next']")
	public WebElement acpnext_button;
	
	public ItecyAddCertificationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void aexpclick_add_certification_link()
	{
		add_certification_link.click();
	}
	
	public void fill_certificate_name(String x)
	{
		certificate_name.sendKeys(x);
	}
	
	public void select_validity_date()
	{
		validity_date.click();
		//pending
	}
	
	public void fill_license_no(String x)
	{
		license_no.sendKeys(x);
	}
	
	public void fill_institution_name(String x)
	{
		institution_name.sendKeys(x);
	}
	
	public void acpclick_save_changes()
	{
		acpsave_changes_button.click();
	}
	
	public void acpclick_close()
	{
		acpclose_button.click();
	}
	
	public void acpclick_next()
	{
		acpnext_button.click();
	}
}
