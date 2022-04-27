public class stepDefinitions {

    @Given("Login the application with {string} & {string}")
    public void userProvidedLoginWithContent(String username, String password) {
        System.setProperty("webdriver.chrome.driver", "C:\\Handson\\chromedriver.exe");
        Webdriver driver= new ChromeDriver();
        driver.get("http://retailm1.upskills.in/admin/index.php?route=common/dashboard&token=fOtazgcSDn3hST8dy4F1RPyPR15xQsnO");
        driver.manage().window().maximize();
        driver.findElement(By.id("input-username")).sendKeys(username);
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

    }
    @When("user naviagted to home page,create a coupon")
    public void createCoupon() {

       if ( driver.findElement(By.id("//h1[contains(text(),'Dashboard')]")).getText()=='Dashboard')
       {
           System.out.println("Successfully landed to homepage");
       }
        driver.findElement(By.xpath("//*[@id='menu-marketing']/a")).click();
        driver.findElement(By.xpath("//*[@id='menu-marketing']/ul/li[3]]")).click();

    }



}