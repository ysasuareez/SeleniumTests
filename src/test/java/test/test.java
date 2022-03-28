package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

class test {

ChromeDriver driver;
	
	@BeforeEach
	void declaracionDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	void ejercicio3_1() {
		try {
			driver.get("https://www.wikipedia.org/");
			Thread.sleep(1500);
			
			WebElement buscador = driver.findElement(By.id("searchInput"));
			buscador.sendKeys("Pablo Picasso\n");
			Thread.sleep(1500);
			
			WebElement imagen = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr[2]/td/a/img"));
			imagen.click();
			Thread.sleep(1500);

			assertEquals("https://es.wikipedia.org/wiki/Pablo_Picasso#/media/Archivo:Pablo_picasso_1.jpg", driver.getCurrentUrl());
			
			driver.quit();

			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void ejercicio3_2() {
		try {
			
			driver.get("https://www.wikipedia.org");
			Thread.sleep(1500);
			
			WebElement buscador = driver.findElement(By.id("searchInput"));
			buscador.sendKeys("IES Pablo Picasso\n");
			Thread.sleep(1500);
			
			WebElement textNotFind = driver.findElement(By.id("firstHeading"));
			Thread.sleep(1500);

			assertEquals("Resultados de la búsqueda", textNotFind.getText());
			
			driver.quit();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void ejercicio4_suma() {
		
		try {
			driver.get("https://testsheepnz.github.io/BasicCalculator.html");
			Thread.sleep(1500);
						
			Select select = new Select(driver.findElement(By.id("selectOperationDropdown")));			
			Thread.sleep(1500);
			
			WebElement num1 = driver.findElement(By.id("number1Field"));
			num1.sendKeys("2");			
			Thread.sleep(1500);
			
			WebElement num2 = driver.findElement(By.id("number2Field"));
			num2.sendKeys("2");		
			Thread.sleep(1500);
			
			//Como add esta seleccionado por defecto, con que clickeemos calculate sumará
			WebElement calcular = driver.findElement(By.id("calculateButton"));			
			calcular.click();			
			Thread.sleep(1500);
			
			WebElement answer = driver.findElement(By.id("numberAnswerField"));
			
			/*
			 * answer.getDomAttribute("value"); 
			 * Este metodo valdría también
			 */
			
			assertEquals("4", answer.getAttribute("value"));
			
			driver.quit();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	void ejercicio4_esta() {
		
		try {
			driver.get("https://testsheepnz.github.io/BasicCalculator.html");
			Thread.sleep(1500);
						
			Select select = new Select(driver.findElement(By.id("selectOperationDropdown")));			
			Thread.sleep(1500);
			
			WebElement num1 = driver.findElement(By.id("number1Field"));
			num1.sendKeys("3");			
			Thread.sleep(1500);
			
			WebElement num2 = driver.findElement(By.id("number2Field"));
			num2.sendKeys("2");		
			Thread.sleep(1500);
			
			/*
			 * Ahora deberemos usar alguna de las otras opciones, para ello indetificamos y
			 * desplegamos el drop down haciendole ckick
			 */
			
			WebElement DropDown = driver.findElement(By.id("selectOperationDropdown"));
			DropDown.click();
			Thread.sleep(1500);

			/*
			 * Cuando inspeccionamos este drop, para identificar las operaciones se les da un valor
			 * del 1 al 4, dependiendo de la que queramos utilizar llamamos al siguiente método:
			 */
			select.selectByIndex(1);			
			Thread.sleep(1500);
			
			WebElement calcular = driver.findElement(By.id("calculateButton"));			
			calcular.click();			
			Thread.sleep(1500);
			
			WebElement answer = driver.findElement(By.id("numberAnswerField"));
			
			assertEquals("1", answer.getAttribute("value"));
			
			driver.quit();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
