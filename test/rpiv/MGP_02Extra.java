/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpiv;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import rpivTestLink.SeleniumIntegracao;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static rpiv.MGP15.driver;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author junin
 */
public class MGP_02Extra {
    
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
    
    public void getShot2() throws Exception {
        Robot robot = new Robot();
        Rectangle ALL_SCREEN = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        BufferedImage print = robot.createScreenCapture(ALL_SCREEN);
        ImageIO.write(print, "png", new File("C:\\Users\\Arcano\\Documents\\NetBeansProjects\\RPIV\\Fotos\\EditarDados.png"));

    }
    
    
    
    /**
     * Test of openBrowser method, of class SeleniumTeste.
     */
    
    @Test
    public void testeLoginEmail() throws Exception {
        ArrayList<String> dados = new ArrayList<String>();
   
         try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Arcano"
                    + "\\Documents\\NetBeansProjects\\RPIV\\Arquivos"
                    + "\\Perfil.txt"));
            String linha;
            
            while (br.ready()) {
                linha = br.readLine();
                String vetorLinha[] = linha.split(";");
                for(int i =0; i< vetorLinha.length; i++){
                dados.add(vetorLinha[i]);
                    System.out.println(dados.get(i));
                }
                
                FormularioDados(dados);
                dados.clear();
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        
        
        
       
    //   SeleniumIntegracao.updateResults("GP04-2", null, TestLinkAPIResults.TEST_PASSED);
    }   
    
    public void FormularioDados(ArrayList<String> dados) throws InterruptedException, TestLinkAPIException, Exception{
        
        WebDriverWait espera = new WebDriverWait(driver, 10);
    
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("guilthys@gmail.com");
        assertEquals(driver.findElement(By.id("formularioDeLogin:emailInput")).getAttribute("value"), "guilthys@gmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("@1202matematica");
        assertEquals(driver.findElement(By.id("formularioDeLogin:senhaInput")).getAttribute("value"), "@1202matematica");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/view/empreendedor/homeEmpreendedor.jsf");
        //assertEquals(driver.getTitle(), "Página Principal - Empreendedor");
        //espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("//*[@id=\"menuSuperior\"]/nav/div/div[2]/ul/li[3]/a")));
      
        driver.findElement(By.xpath("//*[@id=\"menuSuperior\"]/nav/div/div[2]/ul/li[3]/a")).click();
        
        //espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("//*[@id=\"menuSuperior\"]/nav/div/div[2]/ul/li[3]/ul/li[1]/input")));
      
        driver.findElement(By.xpath("//*[@id=\"menuSuperior\"]/nav/div/div[2]/ul/li[3]/ul/li[1]/input")).click();
        
        //espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("formularioCadastro:nome")));
      
        
        driver.findElement(By.id("formularioCadastro:nome")).clear();
        driver.findElement(By.id("formularioCadastro:nome")).sendKeys(dados.get(0));
        
        driver.findElement(By.id("formularioCadastro:telefone")).clear();
        driver.findElement(By.id("formularioCadastro:telefone")).sendKeys(dados.get(1));
        
        driver.findElement(By.id("formularioCadastro:rua")).clear();
        driver.findElement(By.id("formularioCadastro:rua")).sendKeys(dados.get(4));
        
        driver.findElement(By.id("formularioCadastro:numero")).clear();
        driver.findElement(By.id("formularioCadastro:numero")).sendKeys(dados.get(5));
        
        driver.findElement(By.id("formularioCadastro:bairro")).clear();
        driver.findElement(By.id("formularioCadastro:bairro")).sendKeys(dados.get(6));
        
        driver.findElement(By.id("formularioCadastro:j_idt62")).clear();
        driver.findElement(By.id("formularioCadastro:j_idt62")).sendKeys(dados.get(7));
        
        driver.findElement(By.id("formularioCadastro:email")).clear();
        driver.findElement(By.id("formularioCadastro:email")).sendKeys("guilthys@gmail.com");
        
        driver.findElement(By.id("formularioCadastro:senhaAtual")).clear();
        driver.findElement(By.id("formularioCadastro:senhaAtual")).sendKeys("@1202matematica");
        
        
        driver.findElement(By.id("formularioCadastro:botaoFinalizarEdicao")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("formularioCadastro:botaoConfirmar")).click();
        
                
        
        //SeleniumIntegracao.updateResults("GP04-38", null, TestLinkAPIResults.TEST_FAILED);
   
        
    
    }
    
    

    /**
     * Test of closeBrowser method, of class SeleniumTeste.
     */
    /*
    @After
    public void testCloseBrowser() {
        driver.quit();
    }
    */
}
