package Views;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import General.Base;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class VVerificar {
	
	Base b=Base.getInstance();
 	ExtentReports extent;
    ExtentTest test;
    
	public By total=MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");
	public By check=MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.CheckBox");
	public By btn=MobileBy.id("com.androidsample.generalstore:id/btnProceed");
	public By btncarrito=MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart");
	
	public boolean ss;
	public Boolean verificarproductoadd(String vtenis) {
		try {
		test=b.createtest("Verificar productos: ");
		ExtentTest sp = test.createNode("Validando productos: ");
		ss=b.scroll2(vtenis,0);
		if(ss==true) {
			sp.pass("Se encontro el producto en el carrito: "+vtenis);
		}else {sp.fail("No se encontro el producto en carrito: "+vtenis);}
		}catch(Exception e) {System.out.println("Error en verificar producto: "+e);}
     return ss;
	}
	public boolean bo;
	public Boolean verificarpreciototal(double price) {
		try {
		b.wait(btncarrito);
		b.clic(btncarrito);
		test=b.createtest("Verificar Total: ");
        b.wait(total);
		MobileElement tot=b.findElement(total);
		String totalapp=tot.getText().replace("$","").trim();
		String totsuma=String.valueOf(price).trim();
		ExtentTest st = test.createNode("Validando Total: ");
		System.out.println("PRECIO APP:-->"+totalapp+"TOTAL suma:"+totsuma);
		if (totalapp.equals(totsuma)) {
		bo=true;
		st.pass("El total fue correcto! "+totalapp+"="+totsuma);	
		}else {st.fail("El total no es correcto! "+totalapp+"="+totsuma);bo=false;}
		}catch(Exception e) {System.out.println("Error en verificar precio: "+e);}
		return bo;
	}
	
	public void visitarpaginaweb() {
		try {
//		test=b.createtest("Visistar Sitio Web.");
		ExtentTest vp = test.createNode("Ir a Página Web: ");
		b.clic(check);
		b.clic(btn);
		vp.pass("Exitoso.");
		}catch(Exception e) {System.out.println("Error en visitarsitio: "+e);}

	}
	
	
	
	//---------------------------------------------------singleton---------------------------
			private static VVerificar v;

			private VVerificar() {

			}

			public static VVerificar getInstance() {
			    if (v == null) {
					v=new VVerificar();
				}
				return v;
			}
}
