//package sesion05.tests;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import sesion05.pages.LoginPage;
//
//import java.util.concurrent.TimeUnit;
//
//public class LoginTests {
//    WebDriver driver;
//    LoginPage loginPage;
//
//    @BeforeTest
//    public void preTest() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
//        loginPage = new LoginPage(driver);
//    }
//
//    @DataProvider(name = "datosIncorrectos")
//    public Object[][] dataLoginIncorrecto() {
//        return new Object[][]{
//                {
//                        "email_incorrecto",
//                        "password_incorrecto",
//                        "Invalid email address."
//                },
//                {
//                        "email_correcto",
//                        "password_incorrecto",
//                        "Invalid password."
//                }
//        };
//    }
//
//    @Test(testName = "Login Incorrecto: Email invalido", dataProvider = "datosIncorrectos")
//    public void testLogin(String usuario, String password, String mensajeEsperado) {
//        loginPage.iniciarSesion(usuario, password);
//        Assert.assertEquals(loginPage.getMensajeError(), mensajeEsperado);
//    }
//
//    @AfterTest()
//    public void tearDown() {
//        driver.quit();
//    }
//}