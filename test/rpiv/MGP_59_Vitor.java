/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpiv;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static rpiv.MGP_3_Vitor.driver;
import static rpiv.MGP_3_Vitor.url;
import rpivTestLink.SeleniumIntegracao;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author vitao
 */
public class MGP_59_Vitor {
    
    public static WebDriver driver;
    public static String url = "http://192.168.56.101:8080/GerenciadorPampatec/loginEmpreendedor.jsf";
   
    @Before
    public void setUp() throws TestLinkAPIException, InterruptedException{
        System.setProperty("webdriver.chrome.driver",
                "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        
        
    }
    
    @Test
    public void test01_MGP_59() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
                       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios:j_idt41\"]/div/select")).sendKeys("Sendo Avaliado");
        Thread.sleep(1500);
        String retorno = driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios_data\"]/tr[1]/td[3]")).getText();
        

        if(retorno.equals("Sendo Avaliado")){
            SeleniumIntegracao.updateResults("GP04-58", null, TestLinkAPIResults.TEST_PASSED);
        }else{
            SeleniumIntegracao.updateResults("GP04-58", null, TestLinkAPIResults.TEST_FAILED);
        }

    }
    
    @Test
    public void test02_MGP_59() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
                       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios:j_idt41\"]/div/select")).sendKeys("Submetido");
        Thread.sleep(1500);
        String retorno = driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios_data\"]/tr/td[3]")).getText();
                                                      
        if(retorno.equals("Submetido")){
            SeleniumIntegracao.updateResults("GP04-59", null, TestLinkAPIResults.TEST_PASSED);
        }else{
            SeleniumIntegracao.updateResults("GP04-59", null, TestLinkAPIResults.TEST_FAILED);
        }
    }
    
    @Test
    public void test03_MGP_59() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
                       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios:j_idt41\"]/div/select")).sendKeys("Ressubmetido");
        Thread.sleep(1500);
        String retorno = driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios_data\"]/tr/td[3]")).getText();
                                                      
        if(retorno.equals("Ressubmetido")){
            SeleniumIntegracao.updateResults("GP04-60", null, TestLinkAPIResults.TEST_PASSED);
        }else{
            SeleniumIntegracao.updateResults("GP04-60", null, TestLinkAPIResults.TEST_FAILED);
        }
    }
    
    @Test
    public void test04_MGP_59() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
                       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios:j_idt41\"]/div/select")).sendKeys("Em Pré-Avaliação");
        Thread.sleep(1500);
        String retorno = driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios_data\"]/tr[1]/td[3]")).getText();
                                                      
        if(retorno.equals("Em Pré-Avaliação")){
            SeleniumIntegracao.updateResults("GP04-61", null, TestLinkAPIResults.TEST_PASSED);
        }else{
            SeleniumIntegracao.updateResults("GP04-61", null, TestLinkAPIResults.TEST_FAILED);
        }
    }
    
    @Test
    public void test05_MGP_59() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
                       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios:j_idt41\"]/div/select")).sendKeys("Necessita Melhoria");
        Thread.sleep(1500);
        String retorno = driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios_data\"]/tr/td[3]")).getText();
                                                      
        if(retorno.equals("Necessita Melhoria")){
            SeleniumIntegracao.updateResults("GP04-62", null, TestLinkAPIResults.TEST_PASSED);
        }else{
            SeleniumIntegracao.updateResults("GP04-62", null, TestLinkAPIResults.TEST_FAILED);
        }
    }
    
    @Test
    public void test06_MGP_59() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
                       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios:j_idt41\"]/div/select")).sendKeys("Aceito para Avaliação");
        Thread.sleep(1500);
        String retorno = driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios_data\"]/tr[1]/td[3]")).getText();
                                                      
        if(retorno.equals("Aceito para Avaliação")){
            SeleniumIntegracao.updateResults("GP04-63", null, TestLinkAPIResults.TEST_PASSED);
        }else{
            SeleniumIntegracao.updateResults("GP04-63", null, TestLinkAPIResults.TEST_FAILED);
        }
    }
    
    @Test
    public void test07_MGP_59() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
                       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios:j_idt41\"]/div/select")).sendKeys("Reprovado");
        Thread.sleep(1500);
        String retorno = driver.findElement(By.xpath("//*[@id=\"locovelho:tabelaDeNegocios_data\"]/tr[1]/td[3]")).getText();
                                                      
        if(retorno.equals("Reprovado")){
            SeleniumIntegracao.updateResults("GP04-64", null, TestLinkAPIResults.TEST_PASSED);
        }else{
            SeleniumIntegracao.updateResults("GP04-64", null, TestLinkAPIResults.TEST_FAILED);
        }
    }
    
    
    /**
     * Test of closeBrowser method, of class SeleniumTeste.
     */
    @After
    public void testCloseBrowser() {
        driver.quit();
    }
}
