package tests;
 
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.homePage;
import pages.loginPage;

public class FirstScenario extends basicSetup{
	//This method is for signing in & sign out of the web site
	@Test
	public void init() throws Exception{ 
			loginPage login = PageFactory.initElements(driver, loginPage.class);
			login.clickOnSignIn();
			login.setEmail("jetblue@grr.la");
			login.setPassword("jetblue");
			login.clickOnLoginButton();
			
			
		}
	//This method to trigger all method for actions - adding product to the cart and check out
	@Test
	public void placeorderandcheckout() {		
			homePage order = PageFactory.initElements(driver, homePage.class);
			order.selectProdcut();
			order.addtocart();			
			order.verifyorderdetails();
			order.checkout();
	}
	
	public void logout() {
			loginPage logout = PageFactory.initElements(driver, loginPage.class);
			logout.clickOnSignOut();
	}
	
}