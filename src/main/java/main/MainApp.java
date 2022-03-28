package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainApp {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		//EJERCICIO 1
		try {
			
			driver.get("https://www.wikipedia.org/");
			Thread.sleep(1500);
			
			WebElement buscador = driver.findElement(By.id("searchInput"));
			buscador.sendKeys("Java\n");	
			Thread.sleep(1500);
			System.out.println(driver.getTitle());
			Thread.sleep(1500);
			driver.quit();	
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ChromeDriver driver2 = new ChromeDriver();

		
		//EJERCICIO 2
		try {
			
			driver2.get("https://www.odoo.com/es_ES");
			Thread.sleep(1500);
			
			driver2.findElement(By.xpath("//*[@id=\"top_menu\"]/div/li/a")).click();
			Thread.sleep(1500);
			driver2.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div/div/div/form/div[3]/div[1]/a[1]")).click();
			Thread.sleep(1500);
			WebElement correo = driver2.findElement(By.id("login"));
			correo.sendKeys("a_isabel.suarez.palomo@iespablopicass.com");
			Thread.sleep(1500);
			
			WebElement nombre = driver2.findElement(By.id("name"));
			nombre.sendKeys("Ysabel Suárez Palomo");
			Thread.sleep(1500);
			
			WebElement contraseña = driver2.findElement(By.id("password"));
			contraseña.sendKeys("jaja1234\n");			Thread.sleep(1500);
			Thread.sleep(1500);
			
			driver2.quit();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
