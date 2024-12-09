package ABTesting;

import BASE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestePaginaAB extends BaseTest {

    @Test

    public void TesteAB () {

        driver.findElement(By.xpath("//a[text()='A/B Testing']")).click();

        WebElement titulo = driver.findElement(By.tagName("h3"));

        if (titulo.getText().contains("A/B Test Control")) {
            System.out.println("Versão A carregada.");
        } else if (titulo.getText().contains("A/B Test Variation 1")) {
            System.out.println("Versão B carregada.");
        } else {
            System.out.println("Versão desconhecida.");
        }

    }
}
