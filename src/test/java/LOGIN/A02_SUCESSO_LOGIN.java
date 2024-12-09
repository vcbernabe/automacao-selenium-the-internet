package LOGIN;

import BASE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class A02_SUCESSO_LOGIN extends BaseTest {

    @Test

    public void loginUsuario () {

        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement sucessoMensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flash success']")));

        if (sucessoMensagem.getText().contains("You logged into a secure area!")) {
            System.out.println("Texto validado com sucesso: You logged into a secure area! ");
        } else {
            System.out.println("Texto não encontrado.");
        }
    }

}

