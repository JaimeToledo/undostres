package Test;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import General.Base;
import General.Parameters;
import Views.Compra;

public class TCompra {
	
	Base b=Base.getInstance();
	Compra c=Compra.getInstance();
	Parameters p=Parameters.getInstance();
	
	@BeforeTest
	public void bf() {
		 try {
			 //Air Jordan 4 Retro
			 //Air Jordan 1 Mid SE
			 //Nike Blazer Mid '77
			 //Converse All Star
			 //Air Jordan 9 Retro
			 //Jordan 6 Rings
			 //Jordan Lift Off
			 //LeBron Soldier 12
			 //PG 3
			 //Nike SFB Jungle
	    p.maddtenis("Air Jordan 4 Retro");
		p.maddtenis("Converse All Star");
		 }catch(Exception e){System.out.println("Error en Comprar BeforeTest: "+e);}

	}
	
	@DataProvider (name = "dptenis")
    public Iterator<Object[]> dpMethod(){
		return p.tenis.iterator();
    }
	
	@Test (dataProvider = "dptenis")
	  public void Comprar(String nombretenis){	
		 try {
     	 c.compra(nombretenis);
		 Assert.assertTrue(b.isDisplayed(c.addtocart));
		 }catch(Exception e){System.out.println("Error en Comprar Test: "+e);}
	  }
	 
	  @AfterMethod
	  public void afterMethod(ITestResult result) {
		  try {
			b.resultest(result);
			b.extent.flush();
		  }catch(Exception e){System.out.println("Error en Comprar aftermethod: "+e);}
	  }
}
