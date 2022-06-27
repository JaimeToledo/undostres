package General;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;


 
public class CapturarPantalla {

    public 	MediaEntityModelProvider tomarcaptura(WebDriver driver)throws IOException, InterruptedException{
        MediaEntityModelProvider evidencia=null;
		int num=idevidencia();
		TakesScreenshot captura= (TakesScreenshot) driver;
		File srcFile=captura.getScreenshotAs(OutputType.FILE);
		File destino=new File("./Reporte/Evidencia/"+getDate()+num+".jpg");
		FileUtils.copyFile(srcFile, destino);	
		evidencia = MediaEntityBuilder.createScreenCaptureFromPath("./Evidencia/"+getDate()+num+".jpg").build();
		return evidencia;
	}
	public String getDate() {
		DateFormat d= new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date date=null;
		date=new Date();
		return d.format(date);
	}
	
	public int idevidencia() {
		Random random = new Random();
		int n=random.nextInt(10000);
		return n;
	}
}