package sesion03;

import com.sun.xml.internal.ws.policy.sourcemodel.AssertionData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;

public class PracticaLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Ejemplo buscando por LinkText y xPath
//        driver.get("https://demo.guru99.com/selenium/newtours/index.php");
//        WebElement linkRegistroByLink = driver.findElement(By.linkText("REGISTER"));
//        linkRegistroByLink.click();
//        Thread.sleep(5000);
//        driver.navigate().back();
//        Thread.sleep(3000);
////        WebElement linkRegistroByXpath = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
//        WebElement linkRegistroByXpath = driver.findElement(By.xpath("//input[@name='userName']"));
//        // WebElement linkRegistroByXpath = driver.findElement(By.xpath("//td/input[@type='text']"));
//        linkRegistroByXpath.click();
//        Thread.sleep(5000);


//        // Ejemplo buscando por ID
//        driver.get("https://campusvirtual.umch.edu.pe:8083");
//        Thread.sleep(3000);
//        WebElement txtLogin = driver.findElement(By.id("user"));
//        txtLogin.sendKeys("PRUEBA ENVIANDO TEXTO POR ID");
//        Thread.sleep(3000);

        // Ejemplo Dropdown y Submit Button
        driver.get("https://demo.guru99.com/selenium/newtours/register.php");
        Select countries = new Select(driver.findElement(By.name("country")));
        WebElement username = driver.findElement(By.id("email"));

        // Buscar por índice
        Thread.sleep(2000);
        countries.selectByIndex(10); // Aruba
        Thread.sleep(2000);
        countries.selectByVisibleText("SPAIN");
        Thread.sleep(2000);
        countries.selectByValue("PERU");
        Thread.sleep(2000);

        username.sendKeys("evalderrama");

        WebElement botonEnviar = driver.findElement(By.xpath("//input[@type='submit']"));
        botonEnviar.click();

        WebElement textoConfirmacion = driver.findElement(By.xpath("//b[contains(., ' Note: Your')]"));

        String txtConfirmacion = textoConfirmacion.getText();

        if (txtConfirmacion.equals("Note: Your user name is evalderrama.")){
            System.out.println("REGISTRO CREADO CORRECTAMENTE");
        }else {
            System.out.println("REGISTRO NO CREADO");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
