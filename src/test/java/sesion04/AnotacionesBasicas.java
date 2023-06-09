//package sesion04;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//public class AnotacionesBasicas {
//    WebDriver driver;
//
//    @BeforeClass
//    public void BeforeClass() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
//    @AfterClass
//    public void AfterClass() {
//        driver.quit();
//    }
//
//    @DataProvider(name = "registroUsuariosNewTours")
//    public Object[][] datosRegistro() {
//        return new Object[][]{
//                {
//                        "Alvaro",
//                        "Alcantara",
//                        "975646732",
//                        "alvaro@gmail.com",
//                        "Los Olivo",
//                        "Lima",
//                        "Lima",
//                        "15302"
//                },
//                {
//                        "Elias",
//                        "Valderrama",
//                        "987654321",
//                        "elias@gmail.com",
//                        "La Victoria",
//                        "Lima",
//                        "Lima",
//                        "15301"
//                }
//        };
//    }
//
//    @Test(testName = "Registro de usuarios en New Tours", dataProvider = "registroUsuariosNewTours")
//    public void miPrimerTest(String nombre, String apellido, String telefono, String email,
//                             String distrito, String departamento, String provincia, String ubigeo)
//            throws InterruptedException {
//        driver.get("https://demo.guru99.com/selenium/newtours/");
//        WebElement linkRegistroByLink = driver.findElement(By.linkText("REGISTER"));
//        linkRegistroByLink.click();
//        WebElement cajaNombre = driver.findElement(By.name("firstName"));
//        WebElement cajaApellido = driver.findElement(By.name("lastName"));
//        WebElement cajaTelefono = driver.findElement(By.name("phone"));
//        WebElement cajaCorreo = driver.findElement(By.name("userName"));
//        WebElement cajaDireccion = driver.findElement(By.name("address1"));
//        WebElement cajaProvincia = driver.findElement(By.name("city"));
//        WebElement cajaEstado = driver.findElement(By.name("state"));
//        WebElement cajaPostal = driver.findElement(By.name("postalCode"));
//        Select pais = new Select(driver.findElement(By.name("country")));
//
//        WebElement cajaUser = driver.findElement(By.name("email"));
//        WebElement cajaPassword = driver.findElement(By.name("password"));
//        WebElement cajaRePassword = driver.findElement(By.name("confirmPassword"));
//
//        cajaNombre.sendKeys(nombre);
//        cajaApellido.sendKeys(apellido);
//        cajaTelefono.sendKeys(telefono);
//        cajaCorreo.sendKeys(email);
//        //-----------------
//        cajaDireccion.sendKeys(distrito);
//        cajaProvincia.sendKeys(departamento);
//        cajaEstado.sendKeys(provincia);
//        cajaPostal.sendKeys(ubigeo);
//        pais.selectByVisibleText("PERU");
//        //-----------------
//        cajaUser.sendKeys(nombre + "-" + apellido);
//        cajaPassword.sendKeys("123456");
//        cajaRePassword.sendKeys("123456");
//
//        WebElement botonEnviar = driver.findElement(By.xpath("//input[@type='submit']"));
//        botonEnviar.click();
//
//        WebElement textoConfirmacion = driver.findElement(By.xpath("//b[contains(., ' Note: Your')]"));
//
//        String txtConfirmacion = textoConfirmacion.getText();
//
//        Assert.assertEquals(txtConfirmacion, "Note: Your user name is " + nombre + "-" + apellido + ".");
//
////        if (txtConfirmacion.equals("Note: Your user name is " + nombre + "-" + apellido + ".")) {
////            System.out.println("REGISTRO CREADO CORRECTAMENTE");
////        } else {
////            System.out.println("REGISTRO NO CREADO");
////        }
//
//        Thread.sleep(3000);
//    }
//}
