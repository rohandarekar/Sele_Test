package Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import com.csvreader.CsvReader;

public class login_logout {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		CsvReader v = new CsvReader("Testdata.csv");
		v.readHeaders();
		
		FileInputStream fis = new FileInputStream("object.properties");
		Properties p = new Properties();
		p.load(fis);
			
		while (v.readRecord())
		{	
			Thread.sleep(7000);
	ProfilesIni profile = new ProfilesIni();
	FirefoxProfile FP = profile.getProfile("default");
	WebDriver b = new FirefoxDriver(FP);
	b.get("http://5.79.0.37:8080/app/");
	
	Thread.sleep(7000);
		
		String col6 = v.get(("EmailAddress").trim());
		String col22 = v.get(("password").trim());
		b.findElement(By.id("email")).sendKeys("rohan");
		b.findElement(By.id(p.getProperty("bom.login.password.id"))).sendKeys(col22);
		b.findElement(By.id(p.getProperty("bom.login.button.id"))).click();
		b.close();
	
	}
}
}
