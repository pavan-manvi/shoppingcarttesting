package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage {

	WebDriver driver;

       public loginPage(WebDriver driver){ 
                this.driver=driver; 
       }

	//Using FindBy for locating elements
    @FindBy(how=How.CLASS_NAME, using="login") WebElement clickonSignin;
	@FindBy(how=How.NAME, using="email") WebElement emailTextBox;
	@FindBy(how=How.NAME, using="passwd") WebElement passwordTextBox;
	@FindBy(how=How.NAME, using="SubmitLogin") WebElement signin;
	@FindBy(how=How.CLASS_NAME, using="logout") WebElement signout;
	
    // Defining all the user actions (Methods) that can be performed in the login page

       
	// This method is to click Sign in
	public void clickOnSignIn(){
			clickonSignin.click();
		}
	
	// This method is to set Email in the email text box
	public void setEmail(String strEmail){
		emailTextBox.sendKeys(strEmail);
	}
	// This method is to set Password in the password text box
	public void setPassword(String strPassword){
		passwordTextBox.sendKeys(strPassword);
	}
	// This method is to click on Sign in
	public void clickOnLoginButton(){
		signin.click();
	}

	//This method is to click on Sign out
	public void clickOnSignOut() {
		signout.click();
		
		
	}	
}