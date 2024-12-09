package ADICIONAR_E_REMOVER_ELEMENTOS;

import BASE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class ADICIONAR_VARIOS_ELEMENTOS extends BaseTest {

    @Test

    public void adicionarVariosElementos () {

        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addBotaoElemento = driver.findElement(By.xpath("//button[text()='Add Element']"));

            for (int i = 0; i < 5; i++) {
                addBotaoElemento .click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Delete']")));

            }

            List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));

            if (deleteButtons.size() == 5) {
                System.out.println("Botões 'Delete' foram adicionados com sucesso. Total de botões: " + deleteButtons.size());
            } else {
                System.out.println("Número de botões 'Delete' não corresponde ao esperado. Total de botões: " + deleteButtons.size());
            }
        }
}