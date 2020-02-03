/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpiv;

import rpivTestLink.SeleniumIntegracao;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author junin
 */
public class MGP_11_Vitor {
    
    public static WebDriver driver;
    public static String url = "http://192.168.56.101:8080/GerenciadorPampatec/loginEmpreendedor.jsf";
    public LeitorTxt leitor = new LeitorTxt();
    public String[]emailValido = leitor.ler("emailsValidos.txt");
    public String[]emailInvalido = leitor.ler("emailsInvalidos.txt");
    
    @Before
    public void setUp() throws TestLinkAPIException, InterruptedException{
        System.setProperty("webdriver.chrome.driver",
                "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        
        
    }
    
    /**
     * Teste para adicionar membros ao um plano de negócio
     * MHP-11
     * @throws java.lang.Exception
     */
    @Test
    public void test01_MGP_11() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("vitao375@hotmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456789");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(By.id("botao_elaboracao_equipe")).click();
        driver.findElement(By.id("formEquipe:autocomplete_input")).sendKeys("vitao375@gmail.com");
        driver.findElement(By.id("formEquipe:j_idt203")).click();
        driver.findElement(By.id("formEquipe:botaoSalvar1")).click();
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
        driver.manage().window().fullscreen();
        //SeleniumIntegracao.updateResults("GP04-4", null, TestLinkAPIResults.TEST_PASSED);
        
        
        
        //driver.get("http://192.168.56.101:8080/GerenciadorPampatec/view/empreendedor/enviarProjeto.jsf");
        SeleniumIntegracao.updateResults("GP04-4", null, TestLinkAPIResults.TEST_PASSED);//mudar pro GP04-4 (olhar na net)
    }

     /**
     * Teste para adicionar membros ao um plano de negócio
     * MHP-11
     * @throws testlink.api.java.client.TestLinkAPIException
     * @throws java.lang.InterruptedException
     */
    @Test
    public void test02_MGP_11() throws TestLinkAPIException, InterruptedException{
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("vitao375@hotmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456789");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        WebElement a = driver.findElement(By.id("botao_elaboracao_equipe"));
        a.click();
        driver.findElement(By.id("formEquipe:autocomplete_input")).sendKeys("emailInvalidoTest");
        driver.findElement(By.id("formEquipe:j_idt203")).click();
        driver.findElement(By.id("formEquipe:botaoSalvar1")).click();
        
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
        driver.manage().window().fullscreen();
        //SeleniumIntegracao.updateResults("GP04-4", null, TestLinkAPIResults.TEST_PASSED);
        
        

        SeleniumIntegracao.updateResults("GP04-4", null, TestLinkAPIResults.TEST_PASSED);
    
    }
    
    
    /*
    Válidos
    */
    @Test
    public void test03_MGP_11() throws Exception {
        
        for (int i = 0; i < emailValido.length; i++) {

            driver.manage().deleteAllCookies();

            driver.get(url);
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("vitao375@hotmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456789");
            driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);
            driver.findElement(By.id("botao_elaboracao_equipe")).click();
            driver.findElement(By.id("formEquipe:autocomplete_input")).sendKeys(emailValido[i]);
            driver.findElement(By.id("formEquipe:j_idt203")).click();
            driver.findElement(By.id("formEquipe:botaoSalvar1")).click();

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
            driver.manage().window().fullscreen();
        //SeleniumIntegracao.updateResults("GP04-4", null, TestLinkAPIResults.TEST_PASSED);
        
        }
        
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/view/empreendedor/enviarProjeto.jsf");
        SeleniumIntegracao.updateResults("GP04-25", null, TestLinkAPIResults.TEST_PASSED);//mudar pro GP04-4 (olhar na net)
    }
    
    
    /*
    Inválidos
    */
    @Test
    public void test04_MGP_11() throws Exception {
        
        for (int i = 0; i < emailInvalido.length; i++) {

            driver.manage().deleteAllCookies();

            driver.get(url);
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("vitao375@hotmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456789");
            driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
            
            Thread.sleep(3000);
            driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);
            driver.findElement(By.id("botao_elaboracao_equipe")).click();
            driver.findElement(By.id("formEquipe:autocomplete_input")).sendKeys(emailInvalido[i]);
            driver.findElement(By.id("formEquipe:j_idt203")).click();
            driver.findElement(By.id("formEquipe:botaoSalvar1")).click();

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
            driver.manage().window().fullscreen();
        //SeleniumIntegracao.updateResults("GP04-4", null, TestLinkAPIResults.TEST_PASSED);
        
        }
        
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/view/empreendedor/enviarProjeto.jsf");
        SeleniumIntegracao.updateResults("GP04-26", null, TestLinkAPIResults.TEST_PASSED);//mudar pro GP04-4 (olhar na net)
    }
    
    /**
     * Test of closeBrowser method, of class SeleniumTeste.
     */
    @After
    public void testCloseBrowser() {
        driver.quit();
    }
    
}
