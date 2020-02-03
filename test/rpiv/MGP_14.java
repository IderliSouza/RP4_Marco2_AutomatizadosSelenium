/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpiv;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import rpivTestLink.SeleniumIntegracao;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static rpiv.MGP53.driver;
import static rpiv.MGP53.url;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author Arcano
 */
public class MGP_14 {

    public static WebDriver driver;
    public static String url = "http://192.168.56.101:8080/GerenciadorPampatec/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Arcano\\Documents\\NetBeansProjects\\RPIV\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window();
    }

    public void getShot() throws Exception {
        File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File("C:\\Users\\Arcano\\Documents\\NetBeansProjects\\RPIV\\Fotos\\screenshot.png"));
    }

    public void getShot2() throws Exception {
        Robot robot = new Robot();
        Rectangle ALL_SCREEN = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        BufferedImage print = robot.createScreenCapture(ALL_SCREEN);
        ImageIO.write(print, "png", new File("C:\\Users\\Arcano\\Documents\\NetBeansProjects\\RPIV\\Fotos\\screenshot1.png"));

    }

    /**
     * Test of openBrowser method, of class SeleniumTeste.
     */
    @Ignore
    @Test
    public void testeImprimirPlanoObservador() throws Exception {
        Robot r = new Robot();
        r.delay(1000);
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("guilthys@gmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("@1202matematica");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/view/empreendedor/homeEmpreendedor.jsf");
        assertEquals(driver.getTitle(), "Página Principal - Empreendedor");

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a/label/i")).click();
        driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();
        WebDriverWait espera = new WebDriverWait(driver, 10);
         espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("botao_revisar")));
        if (driver.findElement(By.id("botao_revisar")).isEnabled()) {
            SeleniumIntegracao.updateResults("GP04-27", null, TestLinkAPIResults.TEST_FAILED);
        }
        
    }
    
    /**
     * Teste do empreendedor Observador
     * @throws Exception 
     */
    @Ignore
    @Test
    public void testeRevisarPlano() throws Exception {
        Robot r = new Robot();
        r.delay(1000);
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("arcanocontahi@gmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456789");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/view/empreendedor/homeEmpreendedor.jsf");
        assertEquals(driver.getTitle(), "Página Principal - Empreendedor");

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a/label/i")).click();
        driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("botao_revisar")));
        driver.findElement(By.id("botao_revisar")).click();
        assertEquals(driver.getTitle(), "Cadastro Plano de Negócio");

        Thread.sleep(7000);
        getShot();

        SeleniumIntegracao.updateResults("GP04-30", null, TestLinkAPIResults.TEST_PASSED);
    }
    
    @Ignore
    @Test
    public void testImprimirPlanoDados() throws Exception {
        Robot r = new Robot();
        WebDriverWait espera = new WebDriverWait(driver, 10);
        r.delay(1000);
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("guilthys@gmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("@1202matematica");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        Thread.sleep(3000);
        assertEquals(driver.getTitle(), "Página Principal - Empreendedor");

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"lista_planos\"]/div/div[1]/div[3]/a/label/i")).click();
        driver.findElement(By.id("formEquipe:botaoSalvar1")).click();      
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modalInfoSalvarEquipe\"]/div/div/div[3]/input")));
        driver.findElement(By.xpath("//*[@id=\"modalInfoSalvarEquipe\"]/div/div/div[3]/input")).click();
        driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).sendKeys("X#@!");
        assertEquals(driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).getAttribute("value"), "Novo plano de negócio sem nomeX#@!");
        
        driver.findElement(By.id("botao_revisar")).click();
        assertEquals(driver.getTitle(), "Cadastro Plano de Negócio");

        Thread.sleep(7000);
        getShot();
        
    
        SeleniumIntegracao.updateResults("GP04-29", null, TestLinkAPIResults.TEST_FAILED);
        
        
    }
    
    
    
    
   
    @Test
    public void testImprimirPlanoDados2() throws Exception {
        Robot r = new Robot();
        WebDriverWait espera = new WebDriverWait(driver, 10);
        r.delay(1000);
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("guilthys@gmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("@1202matematica");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        Thread.sleep(3000);
        assertEquals(driver.getTitle(), "Página Principal - Empreendedor");

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"lista_planos\"]/div/div[1]/div[3]/a/label/i")).click();
        driver.findElement(By.id("formEquipe:botaoSalvar1")).click();      
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modalInfoSalvarEquipe\"]/div/div/div[3]/input")));
        driver.findElement(By.xpath("//*[@id=\"modalInfoSalvarEquipe\"]/div/div/div[3]/input")).click();
        assertEquals(driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).getAttribute("value"), "Novo plano de negócio sem nome");
        
        assertEquals(driver.getTitle(), "Cadastro Plano de Negócio");

        Thread.sleep(4000);
        getShot();
        
    
        SeleniumIntegracao.updateResults("GP04-28", null, TestLinkAPIResults.TEST_FAILED);
        
        
    }

    /**
     * Test of closeBrowser method, of class SeleniumTeste.
     */
    @After
    public void testCloseBrowser() throws Exception {

        driver.quit();
    }

}
