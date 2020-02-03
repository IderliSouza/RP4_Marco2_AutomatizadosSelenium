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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author junin
 */
public class MGP_53 {
    
    public static WebDriver driver;
    public static String url = "http://192.168.56.101:8080/GerenciadorPampatec/";
   
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Arcano\\Documents\\NetBeansProjects\\RPIV\\chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
        driver.manage().window();
    }
    /**
     * Test of openBrowser method, of class SeleniumTeste.
     */
    @Ignore
    @Test
    public void testeLoginEmail() throws Exception {
        
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("guilthys@gmail.com");
        assertEquals(driver.findElement(By.id("formularioDeLogin:emailInput")).getAttribute("value"), "guilthys@gmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("@1202matematica");
        assertEquals(driver.findElement(By.id("formularioDeLogin:senhaInput")).getAttribute("value"), "@1202matematica");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/view/empreendedor/homeEmpreendedor.jsf");
        assertEquals(driver.getTitle(), "Página Principal - Empreendedor");
       
       SeleniumIntegracao.updateResults("GP04-2", null, TestLinkAPIResults.TEST_PASSED);
    }   
    
    /**
     * Test of openBrowser method, of class SeleniumTeste.
     */
    @Ignore
    @Test
    public void testeLoginCpf() throws Exception {
        
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("96510243725");
        assertEquals(driver.findElement(By.id("formularioDeLogin:emailInput")).getAttribute("value"), "96510243725");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("@1202matematica");
        assertEquals(driver.findElement(By.id("formularioDeLogin:senhaInput")).getAttribute("value"), "@1202matematica");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/view/empreendedor/homeEmpreendedor.jsf");
        assertEquals(driver.getTitle(), "Página Principal - Empreendedor");
       
       SeleniumIntegracao.updateResults("GP04-7", null, TestLinkAPIResults.TEST_PASSED);
    }
    
    /**
     * Test of openBrowser method, of class SeleniumTeste.
     */
    @Test
    public void testeLoginCpfInvalido() throws Exception {
        
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("96510243724");
        assertEquals(driver.findElement(By.id("formularioDeLogin:emailInput")).getAttribute("value"), "96510243724");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456789");
        assertEquals(driver.findElement(By.id("formularioDeLogin:senhaInput")).getAttribute("value"), "123456789");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
            
        assertNotEquals(driver.findElement(By.xpath("//*[@id=\"formularioDeLogin\"]/div[1]/span")).getText(),"Usúario ou Senha incoreto(s)");
       
        SeleniumIntegracao.updateResults("GP04-10", null, TestLinkAPIResults.TEST_PASSED);
    }

    
    
    
    
    

    /**
     * Test of closeBrowser method, of class SeleniumTeste.
     */
    @After
    public void testCloseBrowser() {
        driver.quit();
    }
    
}
