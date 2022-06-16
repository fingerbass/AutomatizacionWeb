package sesion02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://yahoo.com");

        String tituloPagina;
        tituloPagina = driver.getTitle();

        System.out.println("titulo:" + tituloPagina);

        // Ejemplo sin WebElement
        driver.findElement(By.id("ybar-sbq")).sendKeys("RECETA DE PACHAMANCA");
        driver.findElement(By.xpath("//*[@id='ybar-search']")).click();

        Thread.sleep(6000);

        // Ejemplo con WebElement
        driver.navigate().to("https://google.com");
        WebElement cajaBusqueda = driver.findElement(By.name("q"));
        WebElement botonBuscar = driver.findElement(By.name("btnK"));

        cajaBusqueda.sendKeys("Aprender de programar");
        Thread.sleep(3000);
        cajaBusqueda.clear();
        cajaBusqueda.sendKeys("Hola mundo");
        botonBuscar.click();

        Thread.sleep(3000);

        driver.quit();
    }
}