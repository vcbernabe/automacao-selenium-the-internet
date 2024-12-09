package LOGIN;

import BASE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class A01_LOGIN_BASIC_AUTH extends BaseTest {

    @Test

    public void LoginBasicAuth () {

        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement messageElement = driver.findElement(By.tagName("p"));
        String textoMensagem = messageElement.getText();

        if (textoMensagem.contains("Congratulations! You must have the proper credentials.")) {
            System.out.println("Login bem-sucedido.");
        } else {
            System.out.println("Falha no login.");
        }
    }
}