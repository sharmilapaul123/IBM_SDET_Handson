package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.hooksclass;
import junit.framework.Assert;

import java.util.UUID;

public class stepdefinationclass {
	
	
	WebDriver driver = hooksclass.driver;
	


	@Given("User navigated to the Login page")
	public void user_navigated_to_the_Login_page() {
		
		
		driver.get("http://retailm1.upskills.in/admin/index.php?route=common/dashboard&token=fOtazgcSDn3hST8dy4F1RPyPR15xQsnO");
		driver.manage().window().maximize();
		
	    System.out.println("user is navigated to the login page");
	}

	@Given("Enter Username {string} and password {string}")
	public void enter_Username_and_password(String un, String pw) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("input-username")).sendKeys(un);;
		Thread.sleep(2000);
		driver.findElement(By.id("input-password")).sendKeys(pw);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),' Login')]")).click();
		Thread.sleep(2000);

	    
	}
	
	@Then("Error message displayed")
	public void error_message_displayed() {
	   System.out.println("error message");
	}
	@When("user is navigated successfully to the  Home page")
	public void user_navigated_to_the_Homepage_page() {
		if (driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText()=="Dashboard"){
			System.out.println("user is navigated successfully to the  Home page");
		}
	}
	@When("Created coupons")
	public void couponCreation() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='menu-marketing']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='menu-marketing']/ul/li[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-original-title='Add New']")).click();
		String uniqueString = UUID.randomUUID().toString();
		driver.findElement(By.id("input-name")).sendKeys(uniqueString);
		driver.findElement(By.id("input-code")).sendKeys("1234");
		WebElement element = driver.findElement(By.xpath("//*[@data-original-title='Save']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(5000);





	}








}
