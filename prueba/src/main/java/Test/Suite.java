package Test;

import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;

import General.Base;

public class Suite {
 	ExtentReports extent;
 	Base b=Base.getInstance();

	@BeforeSuite
	public void bf() {
		 try {
	     		extent=b.createreport();
		 }catch(Exception e){System.out.println("Error en Comprar BeforeTest: "+e);}
	}
	
	
}
