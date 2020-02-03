/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpiv;

import rpivTestLink.SIntegracao;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.util.ArrayList;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import rpivTestLink.TesteLeitura;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author junin
 */
public class MGP_06_IDERLI {

    public static WebDriver driver;
    public static String url = "http://192.168.56.102:8080/GerenciadorPampatec/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\junin\\OneDrive\\Documentos\\testes selenium\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
    }

    @Ignore
    @Test
    public void test06_01_02() throws Exception {

        TesteLeitura lei = new TesteLeitura();
        ArrayList<String[]> dados;

        dados = lei.ler();

        for (int j = 0; j < dados.size() - 1; j++) {
            driver.get("http://192.168.56.102:8080/GerenciadorPampatec/");

            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("juninho270199iderli@gmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
            driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();

            driver.findElement(By.id(dados.get(j)[1])).click();
            Thread.sleep(10000);
            driver.findElement(By.id("botao_revisar")).click();
            Thread.sleep(5000);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_segmento\"]")).getText(),
                    dados.get(j)[2]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_proposta\"]")).getText(),
                    dados.get(j)[3]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_atividades\"]")).getText(),
                    dados.get(j)[4]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_ralacoes\"]")).getText(),
                    dados.get(j)[5]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_parcerias\"]")).getText(),
                    dados.get(j)[6]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_canais\"]")).getText(),
                    dados.get(j)[7]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_recursos\"]")).getText(),
                    dados.get(j)[8]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_tecnologia\"]")).getText(),
                    dados.get(j)[9]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_fontesReceitas\"]")).getText(),
                    dados.get(j)[10]);

        }

        SIntegracao.updateResults(dados.get(0)[0], null, TestLinkAPIResults.TEST_PASSED);

    }

    @Ignore
    @Test
    public void test06_03() throws Exception {

        TesteLeitura lei = new TesteLeitura();
        ArrayList<String[]> dados;

        dados = lei.ler();

        for (int j = 0; j < dados.size(); j++) {
            driver.get("http://192.168.56.102:8080/GerenciadorPampatec/");

            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("juninho270199iderli@gmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
            driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();

            driver.findElement(By.id(dados.get(j)[1])).click();
            Thread.sleep(10000);
            driver.findElement(By.id("botao_revisar")).click();
            Thread.sleep(5000);
            if (driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_tecnologia\"]")).getText().equals(dados.get(j)[9])) {
                driver.findElement(By.id("botao_elaboracao_editar")).click();
                driver.findElement(By.xpath("//*[@id=\"tabProdutoServico\"]")).click();
                Thread.sleep(5000);
                driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).clear();
                driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys("mudando");
                Thread.sleep(10000);
                driver.findElement(By.id("botao_revisar")).click();
                Thread.sleep(5000);
                Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_tecnologia\"]")).getText(),
                        dados.get(j)[9]);
            }
        }

        SIntegracao.updateResults(dados.get(0)[0], null, TestLinkAPIResults.TEST_FAILED);

    }

    @Test
    public void test06_04() throws Exception {

        TesteLeitura lei = new TesteLeitura();
        ArrayList<String[]> dados;

        dados = lei.ler();

        for (int j = 0; j < dados.size(); j++) {
            driver.get("http://192.168.56.103:8080/GerenciadorPampatec/");

            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("juninho270199iderli@gmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
            driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();

            driver.findElement(By.id(dados.get(j)[1])).click();
            Thread.sleep(10000);
            driver.findElement(By.id("botao_submeter")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("form_enviar_projeto:j_idt221")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"modalInfoSubmeter\"]/div/div/div[3]/input")).click();
            Thread.sleep(5000);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_segmento\"]")).getText(),
                    dados.get(j)[2]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_proposta\"]")).getText(),
                    dados.get(j)[3]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_atividades\"]")).getText(),
                    dados.get(j)[4]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_ralacoes\"]")).getText(),
                    dados.get(j)[5]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_parcerias\"]")).getText(),
                    dados.get(j)[6]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_canais\"]")).getText(),
                    dados.get(j)[7]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_recursos\"]")).getText(),
                    dados.get(j)[8]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_tecnologia\"]")).getText(),
                    dados.get(j)[9]);
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form_revisao:revisao_fontesReceitas\"]")).getText(),
                    dados.get(j)[10]);

        }

        SIntegracao.updateResults(dados.get(0)[0], null, TestLinkAPIResults.TEST_PASSED);

    }
    @After
    public void testCloseBrowser() {
        driver.quit();
    }

}
