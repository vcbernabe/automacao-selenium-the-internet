package IMAGENS_CORROMPIDAS;

import BASE.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class VERIFICAR_IMAGENS extends BaseTest {

    @Test

    public void verificarImagens() {

        driver.findElement(By.xpath("//a[text()='Broken Images']")).click();
        List<WebElement> imagens = driver.findElements(By.tagName("img"));

        imagens.forEach(imagem -> {
            int largura = Integer.parseInt(imagem.getAttribute("naturalWidth"));
            if (!imagem.isDisplayed() || largura == 0) {
                System.out.println("Imagem quebrada ou não visível: " + imagem.getAttribute("src"));
            }
        });
        
        if (imagens.stream().allMatch(imagem -> imagem.isDisplayed() && Integer.parseInt(imagem.getAttribute("naturalWidth")) != 0)) {
            System.out.println("Todas as imagens estão visíveis e carregadas corretamente.");
        } else {
            System.out.println("Existem imagens quebradas ou não visíveis.");
        }
    }
}