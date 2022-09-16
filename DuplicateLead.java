package sep.week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		//webdrive set up
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				
				//launch browser link
				
				driver.get("http://leaftaps.com/opentaps/control/main");
				
				//maximize
				
				driver.manage().window().maximize();
				
				//user details
				
				driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				driver.findElement(By.className("decorativeSubmit")).click();
				
				//click crm/sfa
				
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				//click leads
				driver.findElement(By.linkText("Leads")).click();
				driver.findElement(By.linkText("Create Lead")).click();
				
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABC");
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Manchu");
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("P");
				driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Rao");
				driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
				driver.findElement(By.id("createLeadForm_description")).sendKeys("selenium testing");
				driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@gmz.com");
				
				//selecting by visible text
				WebElement statedrp  =driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
				Select drp1 = new Select(statedrp);
				drp1.selectByVisibleText("New York");
				driver.findElement(By.name("submitButton")).click();
				
				//selecting title
				
				String title = driver.getTitle();
				System.out.println("The tilte of the resulting page is:" +title);
				
				Thread.sleep(1000);
				
				// click duplicate button
				driver.findElement(By.linkText("Duplicate Lead")).click();
				
				//clear the company name 7 enter new company name
				driver.findElement(By.id("createLeadForm_companyName")).clear();
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("IBM");
				
				// clear firstt filed name & enter new
				driver.findElement(By.id("createLeadForm_firstNameLocal")).clear();
				driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("ravi");
				
             driver.findElement(By.name("submitButton")).click();
				
				//selecting title
				
				String title2 = driver.getTitle();
				System.out.println("The tilte of the resulting page is:" +title2);
				
				driver.close();

	}

}
