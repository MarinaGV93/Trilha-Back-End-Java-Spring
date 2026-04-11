package com.selenium.testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class GoogleSearchUITest {

    @Test
    public void testGoogleSearch() throws InterruptedException {
        //Configuração do WebDriver
        // System.setProperty("webdriver.chrome.driver", "/path/webdriver");
        // WebDriver driver = new ChromeDriver();

        //Se tem algum CAPTCHA no navegador
        ChromeOptions options = new ChromeOptions();

        // 1. Remove a flag que diz "Sou um robô"
        options.addArguments("--disable-blink-features=AutomationControlled");

        // 2. Remove o banner "O Chrome está sendo controlado por software de teste"
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        // 3. Adiciona um User-Agent real (importante para não parecer robô)
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36");

        WebDriver driver = new ChromeDriver(options);


        //Abre o navegador e navegue até a página do Google
        driver.get("https://www.google.com/");

        //Espera um pouco para garantir que a página carregue
        Thread.sleep(5000);

        //Encontra o campo de busca do Google pelo seu nome (q)
        WebElement searchBox = driver.findElement(By.name("q"));

        //Insere o texto "cachorro" na caixa de texto da busca
        searchBox.sendKeys("cachorro");

        //Pressiona Enter para realizar a busca
        searchBox.submit();

        Thread.sleep(5000);

        //Verifica se o título da página contém a palavra "cachorro"
        assertTrue(driver.getTitle().contains("cachorro"));

        //Fecha o navegador
        driver.quit();
    }
}
