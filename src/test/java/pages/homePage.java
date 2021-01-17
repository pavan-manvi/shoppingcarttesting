package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class homePage {
	
	WebDriver driver;
	WebDriverWait wait;	

    public homePage(WebDriver driver){ 
             this.driver=driver;
             wait = new WebDriverWait(driver,30);
    }
    
	//Using FindBy for locating elements
    
    @FindBy(how=How.PARTIAL_LINK_TEXT, using="T-") WebElement clickontshirtstab;
    @FindBy(how=How.CLASS_NAME, using="product_img_link") WebElement product;	
    @FindBy(how=How.CLASS_NAME, using="fancybox-iframe") WebElement frameid;
	@FindBy(how=How.NAME, using="Submit") WebElement clickonaddtocartbtn;
	@FindBy(how=How.TAG_NAME, using="h2") WebElement successmessage;
	@FindBy(how=How.ID, using="layer_cart_product_title") WebElement productname;
	@FindBy(how=How.ID, using="layer_cart_product_attributes") WebElement productattribute;
	@FindBy(how=How.ID, using="layer_cart_product_quantity") WebElement quantity;
	@FindBy(how=How.ID, using="layer_cart_product_price") WebElement totalprice;
	@FindBy(how=How.LINK_TEXT, using="Proceed to checkout") WebElement clickoncheckout;
	@FindBy(how=How.CLASS_NAME, using="button btn btn-default button-medium") WebElement processaddress;
	@FindBy(how=How.NAME, using="processCarrier") WebElement processcarrier;
	
    // Defining all the user actions (Methods) that can be performed while adding product to the cart

    
	// This method is to click on T-shirts tab and click on the product
	public void selectProdcut(){
			clickontshirtstab.click();			
			product.click();			
		}
	
	// This method is to adding product to the cart
	public void addtocart(){			
			
			driver.switchTo().frame(frameid);
			wait.until(ExpectedConditions.visibilityOf(clickonaddtocartbtn));			
			clickonaddtocartbtn.click();
			driver.switchTo().defaultContent();
			
	}
	
	// This method is to assert order details
	public void verifyorderdetails(){		
		
		String activeHandle = driver.getWindowHandle();
		driver.switchTo().window(activeHandle);	
		
		try {		
				//Assert success message of adding product to the cart
				wait.until(ExpectedConditions.visibilityOf(successmessage));
				String expectedtext = "Product successfully added to your shopping cart";
				String actualtext = successmessage.getText();
				Assert.assertEquals(actualtext,expectedtext);
				System.out.println("addted to cart success message Asserted");		
				
				//Assert product name
				wait.until(ExpectedConditions.visibilityOf(productname));
				String expectedproductname = "Faded Short Sleeve T-shirts";
				String actualproductname = productname.getText();
				Assert.assertEquals(expectedproductname,actualproductname);
				System.out.println("product name Asserted");
				
				//Assert product details				
				String expectedproductcolorandsize = "Orange, S";
				String actualproductcolorandsize = productattribute.getText();
				Assert.assertEquals(expectedproductcolorandsize,actualproductcolorandsize);
				System.out.println("color and size Asserted");		
				
				//Assert quantity				
				String expectedqty = "1";
				String actualqty = quantity.getText();
				Assert.assertEquals(expectedqty,actualqty);
				System.out.println("qty asserted");
				
				
				String caltotalprice = "$"+ Double.toString((Integer.parseInt(quantity.getText()) * 16.51)); 
				
				//Assert quantity				
				String expectedtotalprice = caltotalprice;
				String actualtotalprice = totalprice.getText();
				Assert.assertEquals(expectedtotalprice,actualtotalprice);
				System.out.println("total price Asserted");
			}
		catch(Exception e)
		{
			System.out.println("One of the assertion failed:"+e.toString());			
		}
		
		
	}	
	
	//This method is to checkout the product
		public void checkout(){			
				clickoncheckout.click();
				wait.until(ExpectedConditions.visibilityOf(clickoncheckout));
				clickoncheckout.click();				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				System.out.println("Product checkedout successfully");
				
			
		}
}
