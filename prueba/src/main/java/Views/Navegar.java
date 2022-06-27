package Views;

import org.openqa.selenium.By;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import General.Base;
import io.appium.java_client.MobileBy;

public class Navegar {
	Base b=Base.getInstance();
	VVerificar vv=VVerificar.getInstance();
 	ExtentReports extent;
    ExtentTest test;
    
   public By search=MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.EditText");

   public boolean boo;
   public Boolean BUSCAR(String texto) {
	  try {
	   test=b.createtest("Buscar Sitio.");
	   vv.visitarpaginaweb();
	   ExtentTest sp = test.createNode("Buscando sitio: "+texto);
	   b.wait(search);
	   if(b.isDisplayed(search)) {
		  sp.pass("Se visita Sitio Web");
		  b.write(texto, search);
		  b.clic(search);
		  b.enter();
		  boo=true;
		  Thread.sleep(100);
	   }else {sp.fail("No se pudo visitar el Sitio Web");boo=false;}
		}catch(Exception e) {System.out.println("Error en Buscar Navegar: "+e);}
	  return boo;
   }

   public Boolean back() {
	   ExtentTest sbac= test.createNode("Se regresa a la App: ");
	   b.back();
	   if(!b.isDisplayed(search)) {
		   boo=true;
		   sbac.pass("Se logro regresar correctamente a la App Nativa");
	   }else {sbac.fail("No se puedo regresar correctamente a la App Nativa");boo=false;}
	   return boo;
  }
 //---------------------------------------------------singleton---------------------------
	private static Navegar v;

	private Navegar() {

	}

	public static Navegar getInstance() {
	    if (v == null) {
			v=new Navegar();
		}
		return v;
	}
}
