package Views;

import java.util.List;
import org.openqa.selenium.By;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import General.Base;
import General.Parameters;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Compra {

	Base b=Base.getInstance();
 	ExtentReports extent;
    ExtentTest test;
	Parameters p=Parameters.getInstance();

	public By Card=MobileBy.xpath("./hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout/android.widget.LinearLayout");
    public By ntenis=MobileBy.xpath(".//android.widget.TextView[1]");
    public By ptenis=MobileBy.xpath(".//android.widget.LinearLayout[2]/android.widget.TextView[1]");
    public By addtocart=MobileBy.xpath(".//android.widget.LinearLayout[2]/android.widget.TextView[2]");
	
    
	  public void compra(String vtenis) {
		  try {
	      test=b.createtest("Añadir Tenis a Carrito: ");
  		  ExtentTest sp2= test.createNode("Seleccionar tenis: "+vtenis);
		   if(b.scroll2(vtenis,0)) {
			   sp2.pass("Se añadio correctamente el tenis."); 
		   }else {sp2.fail("No se encontró el modelo de tenis.");}
		   List<MobileElement> element = b.findElements(Card);
		   for(MobileElement ele:element) {
			   MobileElement nombtenis=ele.findElement(ntenis);
			   if(nombtenis.getText().equals(vtenis)) {
//				   System.out.println("Nombre---> "+nombtenis.getText());
				   MobileElement pt=ele.findElement(ptenis);
//				   System.out.println("precio---> "+pt.getText());
				   String  precios=pt.getText();
				   precios=precios.replace("$", "");
				   p.maddpricetenis(precios);
				   MobileElement atc=ele.findElement(addtocart);
				   atc.click();
				   break;
			   }
		   }   
		  }catch(Exception e) {System.out.println("Error en Compra view: "+e);}
	  }
	
	
	
	
	
	
	 //---------------------------------------------------singleton---------------------------
		private static Compra v;

		private Compra() {

		}

		public static Compra getInstance() {
		    if (v == null) {
				v=new Compra();
			}
			return v;
		}
}
