package Login;

import BASE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TesteLogin extends BaseTest {

    @Test(priority =0)

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

    @Test(priority =1)
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

    @Test(priority = 2)

    public void falhaLoginSenha() {

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPd!");
        driver.findElement(By.className("radius")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement erroMensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flash error']")));

        if (erroMensagem.getText().contains("our password is invalid!")) {
            System.out.println("Texto validado com sucesso: Your password is invalid!");
        } else {
            System.out.println("Texto não encontrado.");
        }
    }

}

