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
public class MGP_08_IDERLI {

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

    @Test
    public void test08_01() throws Exception {

        TesteLeitura lei = new TesteLeitura();
        ArrayList<String[]> dados;

        dados = lei.ler();

        for (int j = 0; j < dados.size(); j++) {
            driver.get("http://192.168.56.102:8080/GerenciadorPampatec/");
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("peu06@hotmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123");
            driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"lista_planos\"]/div/div[1]/div[3]/a")).click();
            driver.findElement(By.id("formEquipe:botaoSalvar1")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvarEquipe\"]/div/div/div[3]/input")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys(dados.get(j)[1]);
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys(dados.get(j)[2]);
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys(dados.get(j)[3]);
            driver.findElement(By.id("tabAnaliseMercado")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys(dados.get(j)[4]);
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys(dados.get(j)[5]);
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys(dados.get(j)[6]);
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys(dados.get(j)[7]);
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys(dados.get(j)[8]);
            driver.findElement(By.id("tabProdutoServico")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys(dados.get(j)[9]);
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys(dados.get(j)[10]);
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys(dados.get(j)[11]);
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys(dados.get(j)[12]);
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys(dados.get(j)[13]);
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys(dados.get(j)[14]);
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys(dados.get(j)[15]);
            driver.findElement(By.id("tabGestaoPessoas")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys(dados.get(j)[16]);
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys(dados.get(j)[17]);
            driver.findElement(By.id("tabPlanoFinanceiro")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys(dados.get(j)[18]);
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys(dados.get(j)[19]);
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys(dados.get(j)[20]);
         
            Thread.sleep(5000);
            driver.findElement(By.id("botao_submeter")).click();
            Thread.sleep(7000);
            driver.findElement(By.xpath("//*[@id=\"form_enviar_projeto:j_idt221\"]/span[2]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"modalInfoSubmeter\"]/div/div/div[3]/input")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:notificacaoSalvo"));
            Assert.assertNotEquals(driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).getText(), dados.get(j)[1]);

        }

//        SIntegracao.updateResults("GP04-54", null, TestLinkAPIResults.TEST_FAILED);
    }

    @Ignore
    @Test
    public void test08_012() throws Exception {

        TesteLeitura lei = new TesteLeitura();
        ArrayList<String[]> dados;

        dados = lei.ler();

        for (int j = 0; j < dados.size(); j++) {
            driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("juninho270199iderli@gmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
            driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"lista_planos\"]/div/div[1]/div[3]/a")).click();
            driver.findElement(By.id("formEquipe:botaoSalvar1")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvarEquipe\"]/div/div/div[3]/input")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys(dados.get(j)[1]);
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys(dados.get(j)[2]);
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys(dados.get(j)[3]);
            driver.findElement(By.id("tabAnaliseMercado")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys(dados.get(j)[4]);
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys(dados.get(j)[5]);
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys(dados.get(j)[6]);
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys(dados.get(j)[7]);
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys(dados.get(j)[8]);
            driver.findElement(By.id("tabProdutoServico")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys(dados.get(j)[9]);
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys(dados.get(j)[10]);
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys(dados.get(j)[11]);
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys(dados.get(j)[12]);
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys(dados.get(j)[13]);
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys(dados.get(j)[14]);
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys(dados.get(j)[15]);
            driver.findElement(By.id("tabGestaoPessoas")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys(dados.get(j)[16]);
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys(dados.get(j)[17]);
            driver.findElement(By.id("tabPlanoFinanceiro")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys(dados.get(j)[18]);
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys(dados.get(j)[19]);
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys(dados.get(j)[20]);
            driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar6")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("botao_submeter")).click();
            Thread.sleep(7000);
            driver.findElement(By.xpath("//*[@id=\"form_enviar_projeto:j_idt221\"]/span[2]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"modalInfoSubmeter\"]/div/div/div[3]/input")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:notificacaoSalvo"));
            Assert.assertNotEquals(driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).getText(), dados.get(j)[1]);

        }

//        SIntegracao.updateResults("GP04-54", null, TestLinkAPIResults.TEST_FAILED);
    }
    @Ignore
    @Test
    public void test08_03() throws Exception {

        TesteLeitura lei = new TesteLeitura();
        ArrayList<String[]> dados;

        dados = lei.ler();

        for (int j = 0; j < dados.size(); j++) {
            driver.get("http://192.168.56.102:8080/GerenciadorPampatec/");
            driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("juninho270199iderli@gmail.com");
            driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
            driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
            driver.findElement(By.xpath("//*[@id=\"lista_planos\"]/div/div[1]/div[3]/a")).click();
            driver.findElement(By.id("formEquipe:botaoSalvar1")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvarEquipe\"]/div/div/div[3]/input")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys(dados.get(j)[1]);
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys(dados.get(j)[2]);
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys(dados.get(j)[3]);
            driver.findElement(By.id("tabAnaliseMercado")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:relacoComClientes")).sendKeys(dados.get(j)[4]);
            driver.findElement(By.id("formulario_cadastro_projeto:parceriasChaves")).sendKeys(dados.get(j)[5]);
            driver.findElement(By.id("formulario_cadastro_projeto:canais")).sendKeys(dados.get(j)[6]);
            driver.findElement(By.id("formulario_cadastro_projeto:recursosPrincipais")).sendKeys(dados.get(j)[7]);
            driver.findElement(By.id("formulario_cadastro_projeto:concorrentes")).sendKeys(dados.get(j)[8]);
            driver.findElement(By.id("tabProdutoServico")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:tecnologiaProcessos")).sendKeys(dados.get(j)[9]);
            driver.findElement(By.id("formulario_cadastro_projeto:potencialInovacaoTecnologica")).sendKeys(dados.get(j)[10]);
            driver.findElement(By.id("formulario_cadastro_projeto:aplicacoes")).sendKeys(dados.get(j)[11]);
            driver.findElement(By.xpath("//*[@id=\"formulario_cadastro_projeto:estagioDeEvolucao\"]/option[7]")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("formulario_cadastro_projeto:dificuldadesEsperadas")).sendKeys(dados.get(j)[12]);
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaUniversidade")).sendKeys(dados.get(j)[13]);
            driver.findElement(By.id("formulario_cadastro_projeto:interacaoEmpresaComunidadeGoverno")).sendKeys(dados.get(j)[14]);
            driver.findElement(By.id("formulario_cadastro_projeto:infraestrutura")).sendKeys(dados.get(j)[15]);
            driver.findElement(By.id("tabGestaoPessoas")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:participacaoAcionaria")).sendKeys(dados.get(j)[16]);
            driver.findElement(By.id("formulario_cadastro_projeto:potencialEmprego")).sendKeys(dados.get(j)[17]);
            driver.findElement(By.id("tabPlanoFinanceiro")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:fontesDeReceita")).sendKeys(dados.get(j)[18]);
            driver.findElement(By.id("formulario_cadastro_projeto:estruturaCustos")).sendKeys(dados.get(j)[19]);
            driver.findElement(By.id("formulario_cadastro_projeto:investimentoInicial")).sendKeys(dados.get(j)[20]);
            driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar6")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"modalInfoSalvar\"]/div/div/div[3]/input")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("botao_submeter")).click();
            Thread.sleep(7000);
            driver.findElement(By.xpath("//*[@id=\"form_enviar_projeto:j_idt221\"]/span[2]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"modalInfoSubmeter\"]/div/div/div[3]/input")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:notificacaoSalvo"));

        }

        SIntegracao.updateResults(dados.get(0)[0], null, TestLinkAPIResults.TEST_FAILED);

    }

    @After
    public void testCloseBrowser() {
        driver.quit();
    }

}
