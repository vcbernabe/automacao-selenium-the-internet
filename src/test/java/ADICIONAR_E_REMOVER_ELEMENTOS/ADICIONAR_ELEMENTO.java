package ADICIONAR_E_REMOVER_ELEMENTOS;

import BASE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ADICIONAR_ELEMENTO extends BaseTest {

    @Test

    public void AdicionarElemento () {

        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();

        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        WebElement botaoExcluir = driver.findElement(By.xpath("//button[text()='Delete']"));

        if (botaoExcluir != null) {
            System.out.println("Botão 'Delete' foi adicionado com sucesso.");
        } else {
            System.out.println("Botão 'Delete' não foi encontrado.");
        }
    }
}