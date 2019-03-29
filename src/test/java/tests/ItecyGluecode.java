package tests;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.ItecyAddCertificationPage;
import pages.ItecyAddEducationPage;
import pages.ItecyAddExperiencePage;
import pages.ItecyAddSkillsPage;
import pages.ItecyCreatePage;
import pages.ItecyGeneralInformationPage;
import pages.ItecyHomePage;
import pages.ItecyLoginPage;
import pages.ItecyResumeUploadPage;
import pages.ItecySocialProfilePage;

public class ItecyGluecode 
{
	public WebDriver driver;
	public WebDriverWait wait;
	public ItecyHomePage homepage;
	public ItecyLoginPage loginpage;
	public ItecyCreatePage createpage;
	public ItecyGeneralInformationPage generalinformationpage;
	public ItecyAddEducationPage addeducationpage;
	public ItecyAddExperiencePage addexperiencepage;
	public ItecyAddCertificationPage addcertificationpage;
	public ItecyAddSkillsPage addskillspage;
	public ItecySocialProfilePage socialprofilepage;
	public ItecyResumeUploadPage resumeuploadpage;
	public Scenario s;
	public Properties p;
	
	@Before
	public void method1(Scenario s)throws Exception
	{
		this.s=s;
		File f=new File("E:\\leelajava\\itecy\\src\\test\\resources\\repository\\itecy_properties.properties");
		FileReader fr=new FileReader(f);
		p=new Properties();
		p.load(fr);
	}
	
	@Given("^launch site$")
	public void launch_site() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",p.getProperty("cpath"));
		driver=new ChromeDriver();
		homepage=new ItecyHomePage(driver);
		loginpage=new ItecyLoginPage(driver);
		createpage=new ItecyCreatePage(driver);
		generalinformationpage=new ItecyGeneralInformationPage(driver);
		addeducationpage=new ItecyAddEducationPage(driver);
		addexperiencepage=new ItecyAddExperiencePage(driver);
		addcertificationpage=new ItecyAddCertificationPage(driver);
		addskillspage=new ItecyAddSkillsPage(driver);
		socialprofilepage=new ItecySocialProfilePage(driver);
		resumeuploadpage=new ItecyResumeUploadPage(driver);
		driver.get(p.getProperty("url"));
		wait=new WebDriverWait(driver,50);
		driver.manage().window().maximize();
	}
	
	@When("^click on signin link$")
	public void click_on_signin_link()
	{
		wait.until(ExpectedConditions.visibilityOf(loginpage.signin));
		loginpage.clickSignin();
	}
	
	@And("^fill username \"(.*)\"$")
	public void fill_username(String x)
	{
		wait.until(ExpectedConditions.visibilityOf(loginpage.uid));
		loginpage.fillUid(x);
	}
	
	@And("^fill password \"(.*)\"$")
	public void fill_password(String y)
	{
		wait.until(ExpectedConditions.visibilityOf(loginpage.pwd));
		loginpage.fillPwd(y);
	}
	
	@And("^click login button$")
	public void click_login_button()
	{
		wait.until(ExpectedConditions.visibilityOf(loginpage.login));
		loginpage.clickLogin();
	}
	
	@Then("^validate output for criteria \"(.*)\" for \"(.*)\" and \"(.*)\" for \"(.*)\"$")
	public void validate_output(String uc,String u,String pc,String p)throws Exception
	{
		Thread.sleep(5000);
	    try 
	    {
	    	if(uc.equals("valid") && pc.equals("valid") && homepage.messg.isDisplayed())
	    	{
	    		
	    		wait.until(ExpectedConditions.visibilityOf(homepage.messg));
	    		s.write("valid userid and password test passed");
	    		homepage.clickMessg();
	    		wait.until(ExpectedConditions.visibilityOf(homepage.logoff));
	    		homepage.clickLogoff();
	    		
	    	}
	    	else if(uc.equals("uid_blank") && pc.equals("valid") && loginpage.alertmessg.isDisplayed())
	    	{
	    		s.write("blank userid test passed");
	    	}
	    	else if(uc.equals("valid") && pc.equals("pwd_blank") && loginpage.alertmessg.isDisplayed())
	    	{
	    		s.write("blank pwd test passed");
	    	}
	    	else if(uc.equals("invalid") && pc.equals("valid") && loginpage.uidinvaliderrmessg.isDisplayed())
	    	{
	    		s.write("invalid uid test passed");
	    	}
	    	else if(uc.equals("invalid") && pc.equals("valid") && loginpage.pwdinvaliderrmessg.isDisplayed())
	    	{
	    		s.write("invalid uid test passed");
	    	}
	    	else
	    	{
	    		byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	    		s.embed(ss,"login test failed");
	    		Assert.fail();
	    	}
	    }
	    catch(Exception ex)
	    {
	    	byte[] ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    		s.embed(ss,ex.getMessage());
    		Assert.fail();
	    }
	
	}
	@And("^close site$")
	@When("^close site$")
	public void close_site()
	{
		driver.close();
	}
	
	@And("^click on jobseeker dropdown in login page$")
	public void click_on_jobseeker_dropdown()
	{
		wait.until(ExpectedConditions.visibilityOf(homepage.jobseeker_dropdown_link));
		homepage.click_jobseeker_dropdown_link();
	}
	
	@And("^click on create resume$")
	public void click_on_create_resume()
	{
		wait.until(ExpectedConditions.visibilityOf(homepage.create_resume_option));
		homepage.click_create_resume_option();
	}
	
	@And("^fill the fields in creation page$")
	public void fill_fields_in_creation_page(DataTable dt) throws Exception
	{
		//datatable

		List<Map<String,String>> data=dt.asMaps(String.class,String.class);
		wait.until(ExpectedConditions.visibilityOf(createpage.resume_title));
		 
		//fill fields
		String professional_title=data.get(0).get("professional_title");
		String about_notes=data.get(0).get("about_notes");
		
		createpage.fill_resume_title(professional_title);
		wait.until(ExpectedConditions.visibilityOf(createpage.industry_id));
		createpage.select_industry();
		wait.until(ExpectedConditions.visibilityOf(createpage.summary));
		createpage.fill_summary(about_notes);
	}
	
	@And("^click on next in creation page$")
	public void click_on_next_in_creation_page()
	{
		wait.until(ExpectedConditions.visibilityOf(createpage.cpnext_button));
		createpage.cpclick_next();
	}
	
	@And("^fill the fields in general information page$")
	public void fill_fields_in_general_information_page(DataTable dt) throws Exception
	{
		//datatable
		List<Map<String,String>> data=dt.asMaps(String.class,String.class);
		wait.until(ExpectedConditions.visibilityOf(generalinformationpage.gender));
		
		//fill fields
		String experience=data.get(0).get("Experience");
		
		generalinformationpage.select_gender();
		wait.until(ExpectedConditions.visibilityOf(generalinformationpage.marital_status));
		generalinformationpage.select_marital_status();
		wait.until(ExpectedConditions.visibilityOf(generalinformationpage.nationality));
		generalinformationpage.select_nationality();
		wait.until(ExpectedConditions.visibilityOf(generalinformationpage.country));
		generalinformationpage.select_country();
		wait.until(ExpectedConditions.visibilityOf(generalinformationpage.state));
		generalinformationpage.select_state();
		wait.until(ExpectedConditions.visibilityOf(generalinformationpage.city));
		generalinformationpage.select_city();
		//pending
		//wait.until(ExpectedConditions.visibilityOf(generalinformationpage.dob));
		//generalinformationpage.select_date();
		//wait.until(ExpectedConditions.visibilityOf(generalinformationpage.choose_some_languages));
		//wait.until(ExpectedConditions.visibilityOf(generalinformationpage.choose_location));
		wait.until(ExpectedConditions.visibilityOf(generalinformationpage.experience));
		generalinformationpage.fill_experience(experience);
		wait.until(ExpectedConditions.visibilityOf(generalinformationpage.experience_level));
		generalinformationpage.select_experience_level();
		wait.until(ExpectedConditions.visibilityOf(generalinformationpage.work_authorization));
		generalinformationpage.select_work_authorization();
		
	}
	
	@And("^click on next in general information page$")
	public void click_on_next_in_general_information_page()
	{
		wait.until(ExpectedConditions.visibilityOf(generalinformationpage.gfpnext_button));
		generalinformationpage.gfpclick_next();
	}
	
	@And("^click on Add education and fill fields$")
	public void fill_fields_in_add_education_page(DataTable dt) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(addeducationpage.add_education));
		addeducationpage.aedpclick_add_education();
		//datatable
		List<Map<String,String>> data=dt.asMaps(String.class,String.class);
		wait.until(ExpectedConditions.visibilityOf(addeducationpage.select_degree));
		
		String passing_year=data.get(0).get("Passing_Year");
		String university_name=data.get(0).get("University_Name");
		
		addeducationpage.select_degree();
		wait.until(ExpectedConditions.visibilityOf(addeducationpage.select_specialization));
		addeducationpage.select_specialization();
		wait.until(ExpectedConditions.visibilityOf(addeducationpage.passing_year));
		addeducationpage.fill_passing_year(passing_year);
		wait.until(ExpectedConditions.visibilityOf(addeducationpage.university));
		addeducationpage.fill_university_name(university_name);
	}
	
	@And("^click on save changes button in add education page$")
	public void click_on_save_changes_button_in_add_education_page()
	{
		wait.until(ExpectedConditions.visibilityOf(addeducationpage.save_changes_button));
		addeducationpage.aedpclick_save_changes_button();
	}
	
	@And("^click on close button in add education page$")
	public void click_on_close_button_in_add_education_page()
	{
		wait.until(ExpectedConditions.visibilityOf(addeducationpage.close_button));
		addeducationpage.aedpclick_close_button();
	}
	
	@And("^click on next in add education page$")
	public void click_on_next_in_add_education_page()
	{
		wait.until(ExpectedConditions.visibilityOf(addeducationpage.aedpnext_button));
		addeducationpage.aedpclick_next();
	}
	
	@And("^click on Add experience and fill fields$")
	public void fill_fields_in_add_experience_page(DataTable dt) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.add_experience_link));
		addexperiencepage.aexpclick_on_experience_link();
		//datatable
		List<Map<String,String>> data=dt.asMaps(String.class,String.class);
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.select_company));
		
		String monthly_salary=data.get(0).get("Monthly_Salary");
		
		addexperiencepage.select_company();
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.select_industry));
		addexperiencepage.select_industry();
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.select_functional_area));
		addexperiencepage.select_functional_area();
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.select_designation));
		addexperiencepage.select_designation();
		//pending
		//wait.until(ExpectedConditions.visibilityOf(addexperiencepage.joining_date));
		//addexperiencepage.select_joining_date();
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.monthly_salary));
		addexperiencepage.select_expected_salary();
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.checkbox));
		addexperiencepage.click_checkbox();
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.expected_salary));
		addexperiencepage.fill_monthly_salary(monthly_salary);
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.notice_period));
		addexperiencepage.select_notice_period();
		
	}
	
	@And("^click on save changes button in add experience page$")
	public void click_on_save_changes_button_in_add_experience_page()
	{
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.aexpsave_changes_button));
		addexperiencepage.aexpclick_save_changes();
	}
	
	@And("^click on close button in add experience page$")
	public void click_on_close_button_in_add_experience_page()
	{
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.aexpclose_button));
		addexperiencepage.aexpclick_close();
	}
	
	@And("^click on next in add experience page$")
	public void click_on_next_in_add_experience_page()
	{
		wait.until(ExpectedConditions.visibilityOf(addexperiencepage.aexpnext_button));
		addexperiencepage.aexpclick_next();
	}
	
	@And("^click on Add certification and fill fields$")
	public void fill_fields_in_add_certification_page(DataTable dt) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(addcertificationpage.add_certification_link));
		addcertificationpage.aexpclick_add_certification_link();
		//datable
		List<Map<String,String>> data=dt.asMaps(String.class,String.class);
		wait.until(ExpectedConditions.visibilityOf(addcertificationpage.certificate_name));
		
		String certification_name=data.get(0).get("Certification_name");
		String license_no=data.get(0).get("License_no");
		String institute_name=data.get(0).get("Institute_name");
		
		addcertificationpage.fill_certificate_name(certification_name);
		//pending
		//wait.until(ExpectedConditions.visibilityOf(addcertificationpage.validity_date));
		//addcertificationpage.select_validity_date();
		wait.until(ExpectedConditions.visibilityOf(addcertificationpage.license_no));
		addcertificationpage.fill_license_no(license_no);
		wait.until(ExpectedConditions.visibilityOf(addcertificationpage.institution_name));
		addcertificationpage.fill_institution_name(institute_name);
	}
	
	@And("^click on save changes button in add certification page$")
	public void click_on_save_changes_button_in_add_certification_page()
	{
		wait.until(ExpectedConditions.visibilityOf(addcertificationpage.acpsave_changes_button));
		addcertificationpage.acpclick_save_changes();
	}
	
	@And("^click on close button in add certification page$")
	public void click_on_close_button_in_add_certification_page()
	{
		wait.until(ExpectedConditions.visibilityOf(addcertificationpage.acpclose_button));
		addcertificationpage.acpclick_close();
	}
	
	@And("^click on next in add certification page$")
	public void click_on_next_in_add_certification_page()
	{
		wait.until(ExpectedConditions.visibilityOf(addcertificationpage.acpnext_button));
		addcertificationpage.acpclick_next();
	}
	
	@And("^click on add skills dropdown and select required skills$")
	public void select_required_skills_from_dropdown()
	{
		wait.until(ExpectedConditions.visibilityOf(addskillspage.add_skills_link));
		addskillspage.click_add_skills_link();
		//pending
		//dropdown
	}
	
	@And("^click on next in add skills page$")
	public void click_on_next_in_add_skills_page()
	{
		wait.until(ExpectedConditions.visibilityOf(addskillspage.aspnext_button));
		addskillspage.aspclick_next();
	}
	
	@And("^fill the fields of social profile$")
	public void fill_fields_in_social_profile_page(DataTable dt) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(socialprofilepage.facebook));
		//datatable
		List<Map<String,String>> data=dt.asMaps(String.class,String.class);
		
		String facebook_link=data.get(0).get("Facebook_link");
		String twitter_link=data.get(0).get("Twitter_link");
		String linkdin_link=data.get(0).get("Linkdin_link");
		String g_link=data.get(0).get("G_link");
		String instagram_link=data.get(0).get("Instagram_link");
		String dribble_link=data.get(0).get("Dribble_link");
		
		socialprofilepage.fill_facebook(facebook_link);
		wait.until(ExpectedConditions.visibilityOf(socialprofilepage.twitter));
		socialprofilepage.fill_twitter(twitter_link);
		wait.until(ExpectedConditions.visibilityOf(socialprofilepage.linkdin));
		socialprofilepage.fill_linkdin(linkdin_link);
		wait.until(ExpectedConditions.visibilityOf(socialprofilepage.glink));
		socialprofilepage.fill_glink(g_link);
		wait.until(ExpectedConditions.visibilityOf(socialprofilepage.instagram));
		socialprofilepage.fill_instagram(instagram_link);
		wait.until(ExpectedConditions.visibilityOf(socialprofilepage.dribble));
		socialprofilepage.fill_dribble(dribble_link);
		
	}
	
	@And("^click on next in add social profile page$")
	public void click_on_next_in_add_social_profile_page()
	{
		wait.until(ExpectedConditions.visibilityOf(socialprofilepage.sppnext_button));
		socialprofilepage.sppclick_next();
	}
	
	@And("^upload resume$")
	public void upload_resume() throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(resumeuploadpage.upload_resume));
		resumeuploadpage.click_upload_resume();
	}
	
	@And("^click on download resume to download resume$")
	public void download_resume()
	{
		wait.until(ExpectedConditions.visibilityOf(resumeuploadpage.download_resume));
		resumeuploadpage.click_download_resume();
	}
	
	@And("^click on submit your details button to submitt$")
	public void click_on_submitt()
	{
		wait.until(ExpectedConditions.visibilityOf(resumeuploadpage.submitt));
		resumeuploadpage.click_submitt();
	}
	
	@And("^click on hi message to logout$")
	public void click_on_messg()
	{
		wait.until(ExpectedConditions.visibilityOf(resumeuploadpage.profile_link));
		resumeuploadpage.click_profile_link();
	}
	
	@And("^click on logoff$")
	public void click_on_logoff()
	{
		wait.until(ExpectedConditions.visibilityOf(resumeuploadpage.logoff));
		resumeuploadpage.click_logoff();
	}
	
	
}
