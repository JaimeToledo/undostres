package Test;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import General.Base;
import General.Parameters;
import Views.VVerificar;

public class TValidar {
	VVerificar vv=VVerificar.getInstance();
	Base b=Base.getInstance();
	Parameters p=Parameters.getInstance();
    
	@Test(priority=0)
	public void Validar_precio() {
		 try {
		 double total=0;
		 for(String pr:p.preciotenis) {
//			 System.out.println("arreglo precio: "+pr);
			 total=total+(Double.parseDouble(pr));
		 }
		 Assert.assertTrue(vv.verificarpreciototal(total));
		 }catch(Exception e){System.out.println("Error en TValidar beforeTest: "+e);}
	}

	@DataProvider (name = "dptenis")
    public Iterator<Object[]> dpMethod(){
		return p.tenis.iterator();
    }
	
	@Test (dataProvider = "dptenis",priority=1)
	  public void Valida_productos(String nombretenis){	
		 try { 
		 Assert.assertTrue(vv.verificarproductoadd(nombretenis));
		 }catch(Exception e){System.out.println("Error en TValidar Test: "+e);}
	  }
	 
	  @AfterMethod
	  public void afterMethod1(ITestResult result) {
		  try {
			b.resultest(result);
		  }catch(Exception e){System.out.println("Error en TValidar aftermethod: "+e);}

	  }
	  
	  @AfterClass
	  public void ir() {
		  try {
			b.extent.flush();
		  }catch(Exception e){System.out.println("Error en TValidar afterclass: "+e);}
	  }
	  
	  
	  
}
