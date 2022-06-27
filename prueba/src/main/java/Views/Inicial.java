package Views;

import org.openqa.selenium.By;
import com.aventstack.extentreports.ExtentTest;
import General.Base;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class Inicial {
	
	
         public By pais=By.id("com.androidsample.generalstore:id/spinnerCountry");
         public By name=By.id("com.androidsample.generalstore:id/nameField");
         public By sexom=By.id("com.androidsample.generalstore:id/radioMale");
         public By sexof=By.id("com.androidsample.generalstore:id/radioFemale");
         public By vamosacomprar=By.id("com.androidsample.generalstore:id/btnLetsShop");
         public By listapais=MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView");
         
     	Base b=Base.getInstance();
        ExtentTest test;
        
        boolean bo;
     	public Boolean register(String vpais,String vname,String vsexo) {
     		try {
    	    test=b.createtest("Pantalla Inicial: ");
     		b.wait(pais);
    		ExtentTest sp1= test.createNode("Seleccionar pais: "+vpais);
     		b.clic(pais);
     		b.wait(listapais);
     		MobileElement foundpais=b.scroll(vpais,0);
     		if(foundpais.isDisplayed()) {
     		sp1.pass("Se encontro el pais y fue seleccionado");	
     		}else {sp1.fail("No se encontro el pais ingresado"); Base.driver.close();}
    		ExtentTest sn = test.createNode("Ingreso de Nombre: "+vname);
     		if(b.isDisplayed(name)) {
         		b.write(vname,name);
         		sn.pass("Se ingreso correctamente el nombre: "+vname);
     		}else {sn.fail("No fue posible ingresar correctamente el nombre: "+vname); Base.driver.close();}
    		ExtentTest ss= test.createNode("Ingreso de Nombre: "+vsexo);
     		if(vsexo.equals("Hombre")) {
     			b.clic(sexom);
     			ss.pass("Se selecciono sexo: ");
     		}else {b.clic(sexof); ss.pass("Se selecciono sexo: "+vsexo);}
     		b.clic(vamosacomprar);
     		bo=b.isDisplayed(vamosacomprar);
     		}catch(Exception e) {System.out.println("Error en Registrar, Inicial: "+e);}
     		return bo;
     	}
         
         
         
       //---------------------------------------------------singleton---------------------------
 		private static Inicial v;

 		private Inicial() {

 		}

 		public static Inicial getInstance() {
 		    if (v == null) {
 				v=new Inicial();
 			}
 			return v;
 		}
}
