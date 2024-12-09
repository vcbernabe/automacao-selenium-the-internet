package AdicionarElementos;

import BASE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class TesteAdicionarElemento extends BaseTest {

    @Test(priority = 0)
    public void AdicionarElemento() {
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        WebElement botaoExcluir = driver.findElement(By.xpath("//button[text()='Delete']"));

        if (botaoExcluir != null) {
            System.out.println("Botão 'Delete' foi adicionado com sucesso.");
        }
    }

    @Test(priority = 1)
    public void adicionarVariosElementos() {
        // Volta para a página inicial antes de começar o segundo teste
        driver.navigate().back();  // Ou recarregue a página: driver.navigate().refresh();

        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addBotaoElemento = driver.findElement(By.xpath("//button[text()='Add Element']"));

        for (int i = 0; i < 5; i++) {
            addBotaoElemento.click();
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