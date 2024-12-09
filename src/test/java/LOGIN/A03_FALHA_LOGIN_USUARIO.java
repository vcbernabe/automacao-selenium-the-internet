package LOGIN;

import BASE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class A03_FALHA_LOGIN_USUARIO extends BaseTest {

    @Test
    public void falhaLoginUsuario() {

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmit");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement erroMensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flash error']")));

        if (erroMensagem.getText().contains("Your username is invalid!")) {
                System.out.println("Texto validado com sucesso:Your username is invalid! ");
            } else {
                System.out.println("Texto não encontrado.");
            }
        }
}

