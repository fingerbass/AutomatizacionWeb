package sesion05.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Elementos de la página
    @FindBy(id = "email")
    private WebElement txtUsuario;

    @FindBy(id = "passwd")
    private WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement btnEntrar;

    @FindBy(id = "email_create")
    private WebElement txtCrearEmail;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/ol/li")
    private WebElement txtMensajeError;


    public LoginPage(WebDriver drvr) {
        this.driver = drvr;
        PageFactory.initElements(driver, this);
    }

    // Métodos para acciones con los elementos
    public void setTxtUsuario(String txtUsuario) {
        this.txtUsuario.clear();
        this.txtUsuario.sendKeys(txtUsuario);
    }

    public String getTxtUsuario(){
        return txtUsuario.getText();
    }

    public void setTxtPassword(String txtPassword) {
        this.txtPassword.sendKeys(txtPassword);
    }

    public void clicBotonLogin() {
        btnEntrar.click();
    }

    public String getMensajeError(){
        return txtMensajeError.getText();
    }

    // Método de pasos o eventos
    public void iniciarSesion(String usr, String pwd) {
        setTxtUsuario(usr);
        setTxtPassword(pwd);
        clicBotonLogin();
    }

    //    http://automationpractice.com/
}
