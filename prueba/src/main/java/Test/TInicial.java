package Test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import General.Base;
import Views.Inicial;

public class TInicial {

	Base b=Base.getInstance();
	Inicial i=Inicial.getInstance();
	
	 @Test
	  public void Iniciar(){	
		 try {
			Assert.assertFalse(i.register("Mexico","Jaime","Hombre"));
		 }catch(Exception e){System.out.println("Error en permisos test: "+e);}
	  }
	 
	  @AfterMethod
	  public void afterMethod(ITestResult result) {
			b.resultest(result);
			b.extent.flush();
	  }
}
