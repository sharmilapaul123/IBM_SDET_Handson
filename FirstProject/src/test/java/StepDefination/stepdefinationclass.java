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

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class stepdefinationclass {
	
	
	WebDriver driver = hooksclass.driver;
	String uniqueString1 = UUID.randomUUID().toString();
	String uniqueString=uniqueString1+"SharmilaHandson";
	Random rnd = new Random();
	int number = rnd.nextInt(59);
	String uniqueID= String.format("%02d", number)+"01267";
	String uniqueIDUpdated= String.format("%02d", number)+"01268";


	


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
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//*[@id='menu-marketing']/ul/li[3]"));
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);*/
		element.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@data-original-title='Add New']")).click();

		driver.findElement(By.id("input-name")).sendKeys(uniqueString);
		Thread.sleep(4000);
		driver.findElement(By.id("input-code")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("input-code"))	.sendKeys(uniqueID);
		Thread.sleep(7000);
		WebElement element1 = driver.findElement(By.xpath("//button[@type='submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		element1.click();
		Thread.sleep(5000);


	}
	@Then("validate the Coupon ,Edit  the coupon")
	public void couponCreationValidation() throws InterruptedException {
		 List<WebElement> element = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr/td[@class='text-left']"));
		Iterator<WebElement> itr = element.iterator();
		while (itr.hasNext()) {

			WebElement i = itr.next();
			System.out.print(i + "Next element");
			String elementString=i.getText();


			if (elementString.contains("SharmilaHandson"))
				Thread.sleep(7000);
			driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr/td[@class='text-right'][2]")).click();

				Thread.sleep(7000);
			driver.findElement(By.id("input-code")).clear();
			driver.findElement(By.id("input-code"))	.sendKeys(uniqueIDUpdated);
			WebElement element1 = driver.findElement(By.xpath("//button[@type='submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(3000);
			element1.click();
			Thread.sleep(5000);
			break;


		}

	}
	@Then("Delete Coupon")
	public void DeleteCoupon() throws InterruptedException {
		List<WebElement> element = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr/td[@class='text-left']"));
		Iterator<WebElement> itr = element.iterator();
		while (itr.hasNext()) {

			WebElement i = itr.next();
			System.out.print(i + "Next element");
			String elementString=i.getText();


			if (elementString.contains("SharmilaHandson")){
				driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
				Thread.sleep(5000);
				driver.switchTo( ).alert( ).accept();
				Thread.sleep(5000);
				break;



			}}

	}






}
