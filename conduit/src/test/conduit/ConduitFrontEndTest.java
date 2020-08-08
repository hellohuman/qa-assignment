package test.conduit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.conduit.pageObjects.NewArticlePage;
import main.conduit.pageObjects.LoginPage;
import main.conduit.pageObjects.HomePage;
import main.conduit.pageObjects.SignupPage;
import test.conduit.setup.SetupTest;

public class ConduitFrontEndTest extends SetupTest {
	
	private String driverUrl="https://demo.realworld.io/";

	@DataProvider(name = "testData")
	public Object[][] getData() {
		return new Object[][] { 
			{ "vanity0000", "zeroloose00000@gmail.com", "testing123" },
			};
	}
	
	@DataProvider(name = "testDataForArticleCreation")
	public Object[][] getDataForArticleCreation() {
		return new Object[][] { 
			{ "zeroloose00@gmail.com", "testing123", "test article zeroloose", "this is test article", "this is my sample test article" },
			};
	}
	
	@Test(groups = { "signup", "critical" }, dataProvider = "testData")
	public void testSignup(String userName, String email, String password) throws InterruptedException {
		driver.get(driverUrl);
		//click on sign up link
		// home page
		WebElement signup = driver.findElement(By.linkText("Sign up"));

		signup.click();
		SignupPage signupPage = new SignupPage(driver);
		//signup page
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		signupPage.enterUserName(userName);
		signupPage.enterEmail(email);
		signupPage.enterPassword(password);
		signupPage.clickSubmitButton();
		Thread.sleep(2000);
		Assert.assertTrue(signupPage.isInitialized());
		Thread.sleep(4000);
		//TODO:: add logout
	}
	
	@Test(groups = { "article"}, dataProvider = "testDataForArticleCreation")
	public void testSignInAndPublishArticle(String email, String password, String articleTitle, String articleDescription, String articleBody) throws InterruptedException {
		driverUrl = "https://demo.realworld.io/#/login";
		driver.get(driverUrl);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickSubmitButton();
		Thread.sleep(4000);
		//click on new article after signing in
		HomePage homePage = new HomePage(driver);
		homePage.clickNewArticleLink();

		NewArticlePage newArticlePage = new NewArticlePage(driver);
		newArticlePage.enterArticleTitle(articleTitle);
		newArticlePage.enterArticleDescription(articleDescription);
		newArticlePage.enterArticleBody(articleBody);
		newArticlePage.publishArticle();
		newArticlePage.clickHome();
		
		//click home button and navigate to global feed
		Thread.sleep(4000);

		homePage.clickGlobalFeed();
		
		//navigate to the second article of global feed
		homePage.clickTestArticle();
		// TODO:: to navigate to created article, iterate through this list of article preview xpaths and get the value of this element and match with article title.
		///html/body/div/div/div/div[2]/div/div[1]/article-list/article-preview[1]/div/a/h1
		Thread.sleep(4000);
		
		
	}

}
