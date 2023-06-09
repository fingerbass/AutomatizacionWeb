package sesion04;

import com.vdurmont.emoji.EmojiParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Preg01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tasks.evalartapp.com/automatization/");

        // Credenciales de acceso
        String usr = "595524";
        String pwd = "10df2f32286b7120Mi00LTQyNTU5NQ==30e0c83e6c29f1c3";

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        username.sendKeys(usr);
        password.sendKeys(pwd);
        submitButton.click();

        String cycleNumber = null;
        do {
            // Se obtiene la iteración actual
            WebElement cycleElement = driver.findElement(By.xpath("//p[@class='text-xl text-center text-green-500']"));
            String cycleText = cycleElement.getText();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(cycleText);

            if (matcher.find()) {
                cycleNumber = matcher.group();
                System.out.println("Ciclo actual es: " + cycleNumber);
            } else {
                System.out.println("No se pudo encontrar el ciclo actual");
            }

            // Lozalizamos los elementos de cada operación
            /*
             * Escribir N veces una letra
             */
            WebElement writeElement = driver.findElement(By.xpath("//p[contains(text(),\"Escriba\")]"));
            String writeIndications = writeElement.getText();

            // Obtener el número
            int num = Integer.parseInt(writeIndications.replaceAll("\\D+", ""));
            char let = writeIndications.charAt(writeIndications.indexOf("'") + 1);

            StringBuilder typeString = new StringBuilder();
            for (int i = 0; i < num; i++) {
                typeString.append(let);
            }

            WebElement textAreaElement = driver.findElement(By.xpath("//textarea[@name=\"text\"]"));
            textAreaElement.sendKeys(typeString);

            /*
             * Operaciones matemáticas
             */
            WebElement mathOpElement = driver.findElement(By.xpath("//p[@class=\"text-center text-xl font-bold\"]"));
            String textMathOp = mathOpElement.getText().trim().replaceAll("[^0-9+*/%-]", "");
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
            int resultado = 0;

            try {
                resultado = (int) engine.eval(textMathOp);
            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }

            WebElement selElement = driver.findElement(By.xpath("//select[@name=\"select\"]"));
            Select s = new Select(selElement);
            s.selectByValue(String.valueOf(resultado));
//
//        /* Contar emoticones */
            WebElement p1 = driver.findElement(By.xpath("//p[contains(text(),\"Indique cuantos\")]"));
            WebElement p2 = driver.findElement(with(By.tagName("p")).below(p1));
            String emoji = EmojiParser.extractEmojis(p1.getText()).get(0);
            String veces = String.valueOf(p2.getText().split(emoji).length - 1);

            WebElement txtContEmojis = driver.findElement(By.xpath("//input[@name=\"number\"]"));
            txtContEmojis.sendKeys(veces);

            /* Fecha */

            // Localizar los elementos necesarios
            WebElement pFecha = driver.findElement(By.xpath("//p[contains(text(),'Indique la fecha')]"));
            WebElement inputFecha = driver.findElement(By.name("date"));

            // Obtener la fecha inicial y el número de días a sumar
            String textoParrafo = pFecha.getText();
            String fechaInicial = textoParrafo.substring(textoParrafo.indexOf(": ") + 2);
            int diasASumar = Integer.parseInt(textoParrafo.substring(textoParrafo.indexOf("corresponde ") + 14, textoParrafo.indexOf("dias") - 1));

            // Realizar la suma de días
            LocalDate fechaFinal = LocalDate.parse(fechaInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(diasASumar);

            // Ingresar la fecha final en el input
            inputFecha.sendKeys(fechaFinal.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

            WebElement sb = driver.findElement(By.xpath("//button[@type='submit']"));
            sb.click();
        } while (!cycleNumber.equals(10));
    }
}
