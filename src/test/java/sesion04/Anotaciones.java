package sesion04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Anotaciones {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/selenium/newtours/");
        Thread.sleep(2000);

        WebElement linkRegistroByLink = driver.findElement(By.linkText("REGISTER"));
        linkRegistroByLink.click();
        WebElement cajaNombre = driver.findElement(By.name("firstName"));
        WebElement cajaApellido = driver.findElement(By.name("lastName"));
        WebElement cajaTelefono = driver.findElement(By.name("phone"));
        WebElement cajaCorreo = driver.findElement(By.name("userName"));
        WebElement cajaDireccion = driver.findElement(By.name("address1"));
        WebElement cajaProvincia = driver.findElement(By.name("city"));
        WebElement cajaEstado = driver.findElement(By.name("state"));
        WebElement cajaPostal = driver.findElement(By.name("postalCode"));
        Select pais = new Select(driver.findElement(By.name("country")));

        WebElement cajaUser = driver.findElement(By.name("email"));
        WebElement cajaPassword = driver.findElement(By.name("password"));
        WebElement cajaRePassword = driver.findElement(By.name("confirmPassword"));

        cajaNombre.sendKeys("Alvaro");
        cajaApellido.sendKeys("Alcantara");
        cajaTelefono.sendKeys("975646732");
        cajaCorreo.sendKeys("alvaro@gmail.com");
        //-----------------
        cajaDireccion.sendKeys("Los Olivo");
        cajaProvincia.sendKeys("Lima");
        cajaEstado.sendKeys("Lima");
        cajaPostal.sendKeys("15302");
        pais.selectByVisibleText("PERU");
        //-----------------
        cajaUser.sendKeys("Alvaro-Alcantara");
        cajaPassword.sendKeys("123456");
        cajaRePassword.sendKeys("123456");

        WebElement botonEnviar = driver.findElement(By.xpath("//input[@type='submit']"));
        botonEnviar.click();

        WebElement textoConfirmacion = driver.findElement(By.xpath("//b[contains(., ' Note: Your')]"));

        String txtConfirmacion = textoConfirmacion.getText();

        if (txtConfirmacion.equals("Note: Your user name is Alvaro-Alcantara.")){
            System.out.println("REGISTRO CREADO CORRECTAMENTE");
        }else {
            System.out.println("REGISTRO NO CREADO");
        }
        Thread.sleep(3000);
        //-----------Login--------------------
        WebElement linkHome = driver.findElement(By.linkText("Home"));
        linkHome.click();

        WebElement cajaUsuario = driver.findElement(By.name("userName"));
        WebElement cajaPassword1 = driver.findElement(By.name("password"));

        cajaUsuario.sendKeys("Alvaro-Alcantara");
        cajaPassword1.sendKeys("123456");
        Thread.sleep(3000);
        WebElement botonLogin = driver.findElement(By.name("submit"));
        botonLogin.click();

        Thread.sleep(3000);
        driver.quit();
    }
}