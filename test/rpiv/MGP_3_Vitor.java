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
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static rpiv.MGP_1_Vitor.driver;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author junin
 */
public class MGP_3_Vitor {
    
    public static WebDriver driver;
    public static String url = "http://192.168.56.101:8080/GerenciadorPampatec/loginEmpreendedor.jsf";
   
    @Before
    public void setUp() throws TestLinkAPIException, InterruptedException{
        System.setProperty("webdriver.chrome.driver",
                "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        
        
    }
    
    
    @Ignore
    @Test
    public void test02_MGP_3() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("vitao375@hotmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456789");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        Thread.sleep(1500);
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"lista_planos\"]/div/div[1]/div[3]/a")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("formEquipe:botaoSalvar1")).click();
        
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"modalInfoSalvarEquipe\"]/div/div/div[3]/input")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1500);
        
        driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).clear();
        driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).sendKeys("Titulo Teste Projeto/Empresa 01");
        driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys("Segmento de clientes teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys("Proposta de valor teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys("Atividade chave teste 01");
        
        driver.findElement(By.id("tabAnaliseMercado")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys("realação com clientes teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys("Parcerias chaves teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys("Canais teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys("Recursos principais teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys("Concorrentes teste 01");
        
        driver.findElement(By.id("tabProdutoServico")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys("tecnologia e processos teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys("Potencial de inovação tecnologia teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys("Aplicações teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys("Dificuldades Esperadas teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys("Interação empresa universidade teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys("Interação empresa, comunidade, governo teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys("Infra-estrutura teste 01");
        
        driver.findElement(By.id("tabGestaoPessoas")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys("socios teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys("potencial de geração de empregos teste 01");
        
        driver.findElement(By.id("tabPlanoFinanceiro")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys("fontes de receita teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys("Estrutura de custos teste 01");
        driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys("investimento incial teste 01");
        
        driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar6")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).click();
        Thread.sleep(1500);
        
        driver.findElement(By.xpath("//*[@id=\"menuSuperior\"]/nav/div/div[2]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"menuSuperior\"]/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        
        
        SeleniumIntegracao.updateResults("GP04-34", null, TestLinkAPIResults.TEST_PASSED);
    }
    
    @Ignore
    @Test
    public void test01_MGP_3() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("vitao375@hotmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456789");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
                       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();



        
        Thread.sleep(3000);
        driver.findElement(By.id("tabAnaliseMercado")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("tabProdutoServico")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("tabGestaoPessoas")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("tabPlanoFinanceiro")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar6")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).click();
        
        
        

        SeleniumIntegracao.updateResults("GP04-32", null, TestLinkAPIResults.TEST_PASSED);
    }
    
    @Ignore
    @Test
    public void test03_MGP_3() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        Thread.sleep(1500);
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("vitao375@hotmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456789");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        Thread.sleep(1500);            
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("lista_planos:singleDT:0:visualizar")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("botao_submeter")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("form_enviar_projeto:j_idt221")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"modalInfoSubmeter\"]/div/div/div[3]/input")).click();;
        Thread.sleep(15000);
        driver.findElement(By.xpath("//*[@id=\"menuSuperior\"]/nav/div/div[2]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"menuSuperior\"]/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();
        Thread.sleep(2000);
       
        SeleniumIntegracao.updateResults("GP04-33", null, TestLinkAPIResults.TEST_PASSED);
    }
    
    @Test
    public void test04_MGP_3() throws Exception {
        driver.manage().deleteAllCookies();
        
        driver.get(url);
        
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("vitao375@hotmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456789");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
                       
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"lista_planos:singleDT:j_idt47\"]/div/select")).sendKeys("Em pré-avaliação");
       
        SeleniumIntegracao.updateResults("GP04-35", null, TestLinkAPIResults.TEST_FAILED);
    }
    
    
    
    /**
     * Test of closeBrowser method, of class SeleniumTeste.
     */
    @After
    public void testCloseBrowser() {
        driver.quit();
    }
    
}
