package Test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import General.Base;
import General.Parameters;
import Views.Navegar;

public class TNavegar {
	Base b=Base.getInstance();
	Parameters p=Parameters.getInstance();
	Navegar nv=Navegar.getInstance();
	
	@Test(priority=0)
	public void Validar_precio() {
		 try {
			 Assert.assertTrue(nv.BUSCAR("UnDosTres"));
		 }catch(Exception e){System.out.println("Error en TValidar beforeTest: "+e);}
	}
	
	@Test(priority=1)
	public void Regresar() {
		 try {
			 Assert.assertTrue(nv.back());
		 }catch(Exception e){System.out.println("Error en TValidar beforeTest: "+e);}
	}
	
	 @AfterMethod
	  public void afterMethod1(ITestResult result) {
		  try {
			b.resultest(result);
			b.extent.flush();
		  }catch(Exception e){System.out.println("Error en TValidar aftermethod: "+e);}

	  }
}
