package General;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Base {
	
	ExtentTest test;
	public ExtentReports extent;
	Reporte rep = Reporte.getInstance();
	CapturarPantalla c=new CapturarPantalla();
    public static AndroidDriver<MobileElement> driver;


    
	public static AndroidDriver<MobileElement> generatedriver() {
		try {	
			DesiredCapabilities caps = new DesiredCapabilities();
			    caps.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
		        caps.setCapability("appPackage","com.androidsample.generalstore");
		        caps.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
		        caps.setCapability("automationName","UiAutomator2");
		        caps.setCapability("noReset", true);
		        caps.setCapability("noSign", true);
		        caps.setCapability("unicodeKeyboard", "true");                                     
		        caps.setCapability("resetKeyboard", "true");
		        caps.setCapability("autoGrantPermissions", true);
		        URL url=new URL("http://127.0.0.1:4723/wd/hub");
			    driver= new AndroidDriver<MobileElement>(url,caps);

		    }catch(Exception e) {System.out.println("ERROR en Base Método generatedriver: "+e);}
		return driver;
	}

	public MobileElement findElement(By locator) {
		return (MobileElement) driver.findElement(locator);
	}
	public List<MobileElement> findElements(By locator) {
		return  driver.findElements(locator);
	}
	public void write(String text, By locator) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	MobileElement listitem;
	public MobileElement scroll(String text, int index) {
		try {
			listitem = driver.findElement(
					MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
							+ ".instance("+index+")).scrollIntoView(new UiSelector()"
									+ ".text(\""+text+ "\").instance("+index+"))"));
			listitem.click();
		} catch (Exception e) {
			System.out.println("No se encontro en scroll: " + text);
		}
		return listitem;
	}
	MobileElement listitem2;
	public Boolean scroll2(String text, int index) {
		try {
			listitem2 = driver.findElement(
					MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
							+ ".instance("+index+")).scrollIntoView(new UiSelector()"
									+ ".text(\""+text+ "\").instance("+index+"))"));
			
		} catch (Exception e) {
			System.out.println("No se encontro en scroll: " + text);
		}
		return listitem2.isDisplayed();
	}
	
	
	public void clic(By locator) {
		driver.findElement(locator).click();
	}

	public void clear(By locator) {
		driver.findElement(locator).clear();
	}

	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void tap(By locator) {
		try {
			TouchAction<?> action = new TouchAction<>(driver);
			action.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElement(locator))))
					.perform();
			action.perform();
		} catch (Exception e) {
			System.out.println("No se pudo realizar tap en base: " + e);
		}
	}
	public void wait(By locator) {
		try {
			WebDriverWait load = new WebDriverWait(driver, 5);
			load.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("No se encontro el elemento en el tiempo de espera" + locator);
		}
	}
	
	public void enter() {
		try {
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		} catch (Exception e) {
			System.out.println("No se logró hacer enter, Base: "+e);
		}
	}
	public void back() {
		try {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		} catch (Exception e) {
			System.out.println("No se logró hacer Back, Base: "+e);
		}
	}

	// REPORTE
		public ExtentReports createreport() {
			extent = rep.addreporte();
			return extent;
		}

		public ExtentTest createtest(String Nombre) {
			try {
				test = extent.createTest(Nombre);
			} catch (Exception e) {
				System.out.println("Error al crear test: " + Nombre + " = " + e);
			}
			return test;
		}

		MediaEntityModelProvider evidencia = null;

	public void resultest(ITestResult result) {// metodo para mostrar el resultado
		try {
//			Thread.sleep(500);
			if (result.getStatus() == ITestResult.FAILURE) {
				test.log(Status.FAIL, MarkupHelper.createLabel(
						"El Resultado del Test:  " + result.getName() + " no fue exitoso!", ExtentColor.RED));
				evidencia=c.tomarcaptura(driver);
				test.fail("Evidencia: ", evidencia);
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS,
						MarkupHelper.createLabel("Caso de prueba " + result.getName() + " Exitoso", ExtentColor.GREEN));
				evidencia=c.tomarcaptura(driver);
				test.pass("Evidencia: ",evidencia);
			} else if (result.getStatus() == ITestResult.SKIP) {
				test.log(Status.SKIP, MarkupHelper.createLabel("Caso de prueba " + result.getName() + "fue saltado",
						ExtentColor.YELLOW));
				test.skip("Evidencia: ",evidencia);
			}
			test.log(Status.INFO, "A continucion se muestran los pasos para la prueba: ");
		} catch (Exception e) {
			System.out.println("Error en Base, Metodo resultest: " + e);
		}
	}
	
//---------------------------------------------------singleton---------------------------
	private static Base base;

	private Base() {
	try {
    driver=generatedriver();
	}catch(Exception e) {System.out.println("Error en Base, iniciar driver "+e);}
	}

	public static Base getInstance() {
        if (base == null) {
			base=new Base();
		}
		return base;
	}
}