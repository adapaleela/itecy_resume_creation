Feature: Itecy site testing
Scenario Outline: Itecy Login testing
Given launch site
When click on signin link
And fill username "<uid>"
And fill password "<pwd>"
And click login button
Then validate output for criteria "<uid criteria>" for "<uid>" and "<pwd criteria>" for "<pwd>"
When close site
Examples:
|          uid       |uid criteria|    pwd   |pwd criteria|
|kghonmode7@gmail.com| valid      |Kunal@0786|valid       |
|kghonnode7@gmail.cim|invalid     |Kunal@0786|valid       |
|kghonmode7@gmail.com| valid      |kunal@2354|invalid     |

@test
Scenario: Creating Resume
Given launch site
When click on signin link
And fill username "<kghonmode7@gmail.com>"
And fill password "<Kunal@0786>"
And click login button
And click on jobseeker dropdown in login page
And click on create resume
And fill the fields in creation page
|professional_title|select_industry|about_notes|
|                  |               |           |
And click on next in creation page
And fill the fields in general information page
|Select_Gender|Select_Martial_Status|Select_Nationality|Select_Country|Select_State|Select_City|Select_Date|Select_some_languages|Select_some_cities|Experience|Select_Experience_level|Select_Work_Authorization|
|             |                     |                  |              |            |           |           |                     |                  |          |                       |                         |
And click on next in general information page
And click on Add education and fill fields
|Select_Degree|Select_Specialization|Passing_Year|University_Name|
|             |                     |            |               |
And click on save changes button in add education page
And click on close button in add education page 
And click on next in add education page
And click on Add experience and fill fields
|Select_Company|Select_Industry|Select_Functional_Area|Select_Designation|Select_Date|Monthly_Salary|
|              |               |                      |                  |           |              |
And click on save changes button in add experience page
And click on close button in add experience page
And click on next in add experience page
And click on Add certification and fill fields
|Certification_name|Selection_date|License_no|Institute_name|
|                  |              |          |              |
And click on save changes button in add certification page
And click on close button in add certification page
And click on next in add certification page
And click on add skills dropdown and select required skills
And click on next in add skills page
And fill the fields of social profile
|Facebook_link|Twitter_link|Linkdin_link|G_link|Instagram_link|Dribble_link|
|             |            |            |      |              |            |
And click on next in add social profile page
And upload resume 
And click on download resume to download resume
And click on submit your details button to submitt
And click on hi message to logout
And click on logoff
And close site