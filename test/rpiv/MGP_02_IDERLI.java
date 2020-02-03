/*
 * Nesta classe estao os primeiros testes, realiados com o intuito
de entender o funcionamento do webdriver e realizar casos de teste simples.
 * Testes sem parametrização (tentativa de parametrizar com um for, sem realizar leitura externa;
 */
package rpiv;

import rpivTestLink.SIntegracao;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author junin
 */
public class MGP_02_IDERLI {

    public static WebDriver driver;
    public static String url = "http://192.168.56.104:8080/GerenciadorPampatec/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\junin\\OneDrive\\Documentos\\testes selenium\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
    }

    /**
     * Test of openBrowser method, of class SeleniumTeste.
     */
    @Test
    public void testCadastrar() throws Exception {
        String[] nomes = new String[10];
        String[] cpfs = new String[10];
        String[] telefones = new String[10];
        String[] experiencias = new String[10];
        String[] formacaos = new String[10];
        String[] logradouros = new String[10];
        String[] numeros = new String[10];
        String[] bairros = new String[10];
        String[] complementos = new String[10];
        String[] emails = new String[10];
        String[] senhas = new String[10];

        for (int i = 0; i < 10; i++) {
            nomes[i] = "teste" + i;
            telefones[i] = "559812345" + i;
            experiencias[i] = "experiencia" + i;
            formacaos[i] = "formacao" + i;
            logradouros[i] = "logradouro" + i;
            numeros[i] = "numero" + i;
            bairros[i] = "bairro" + i;
            complementos[i] = "complemento" + i;
            emails[i] = "email" + i + "@gmail.com";
            senhas[i] = "email" + i;
        }

        cpfs[0] = "47145884860";
        cpfs[1] = "81636846076";
        cpfs[2] = "74104101591";
        cpfs[3] = "25895705383";
        cpfs[4] = "72847378596";
        cpfs[5] = "77145167557";
        cpfs[6] = "39635035136";
        cpfs[7] = "22621377653";
        cpfs[8] = "12346278416";
        cpfs[9] = "31832199568";

        for (int j = 0; j < 10; j++) {

            driver.get("http://192.168.56.104:8080/GerenciadorPampatec/loginEmpreendedor.jsf");
            driver.findElement(By.id("formularioDeCadastro:botaoContinuaCadastro")).click();
            driver.findElement(By.id("formularioCadastro:nome")).sendKeys(nomes[j]);
            driver.findElement(By.id("formularioCadastro:cpf")).sendKeys(cpfs[j]);
            driver.findElement(By.id("formularioCadastro:telefone")).sendKeys(telefones[j]);
            driver.findElement(By.id("formularioCadastro:j_idt19")).sendKeys(experiencias[j]);
            driver.findElement(By.id("formularioCadastro:j_idt21")).sendKeys(formacaos[j]);
            driver.findElement(By.id("formularioCadastro:rua")).sendKeys(logradouros[j]);
            driver.findElement(By.id("formularioCadastro:numero")).sendKeys(numeros[j]);
            driver.findElement(By.id("formularioCadastro:bairro")).sendKeys(bairros[j]);
            driver.findElement(By.id("formularioCadastro:j_idt33")).sendKeys(complementos[j]);
            driver.findElement(By.id("formularioCadastro:email")).sendKeys(emails[j]);
            driver.findElement(By.id("formularioCadastro:senha")).sendKeys(senhas[j]);
            driver.findElement(By.id("formularioCadastro:senhaConfig")).sendKeys(senhas[j]);
            driver.findElement(By.id("formularioCadastro:botaoEnviar")).click();
        }

        //verificação de e-mail
        SIntegracao.updateResults("GP04-15", null, TestLinkAPIResults.TEST_PASSED);
    }
    @Test
    public void testEditar1() throws Exception {
        driver.get("http://192.168.56.104:8080/GerenciadorPampatec/");
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("juninho270199iderli@gmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        driver.get("http://192.168.56.102:8080/GerenciadorPampatec/view/empreendedor/editarDadosEmpreendedor.jsf");
        driver.findElement(By.id("formularioCadastro:telefone")).clear();
        driver.findElement(By.id("formularioCadastro:telefone")).sendKeys("4elefone");
        driver.findElement(By.id("formularioCadastro:senhaAtual")).sendKeys("123456");
        driver.findElement(By.id("formularioCadastro:botaoFinalizarEdicao")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.id("formularioCadastro:botaoConfirmar")).click();
//        Assert.assertEquals(driver.findElement(By.id("formularioCadastro:nome")).getText(), "Iderli Souza");
        //verificação de e-mail
        SIntegracao.updateResults("GP04-17", null, TestLinkAPIResults.TEST_FAILED);
    }
    @Test
    public void testEditar2() throws Exception {

        String[] emails = new String[5];
        String[] nomesPlanos = new String[5];
        String[] clientes = new String[5];
        String[] valores = new String[5];
        String[] atividades = new String[5];

        for (int i = 0; i < 5; i++) {
            emails[i] = "email" + i + "@gmail.com";
            nomesPlanos[i] = "Plano" + i;
            clientes[i] = "cliente" + i;
            valores[i] = "12,0" + i;
            atividades[i] = "atividade" + i;
        }

        driver.get("http://192.168.56.104:8080/GerenciadorPampatec/");

        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("juninho270199iderli@gmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        for (int j = 0; j < 5; j++) {

            driver.get("http://192.168.56.104:8080/GerenciadorPampatec/view/empreendedor/paginaBuscaPlanoDeNegocio.jsf");
            driver.findElement(By.xpath("//*[@id=\"lista_planos\"]/div/div[1]/div[3]/a/label/i")).click();

            driver.findElement(By.id("formEquipe:autocomplete_input")).sendKeys(emails[j]);
            driver.findElement(By.id("formEquipe:j_idt203")).click();

            driver.findElement(By.id("formEquipe:botaoSalvar1")).click();
            Thread.sleep(5000);
            driver.findElement(By.name("formulario_cadastro_projeto:j_idt65")).click();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).clear();
            driver.findElement(By.id("formulario_cadastro_projeto:empresaProjeto")).sendKeys(nomesPlanos[j]);
            driver.findElement(By.id("formulario_cadastro_projeto:segmentoDeClientes")).sendKeys(clientes[j]);
            driver.findElement(By.id("formulario_cadastro_projeto:propostaDeValor")).sendKeys(valores[j]);
            driver.findElement(By.id("formulario_cadastro_projeto:atividadesChave")).sendKeys(atividades[j]);
            driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar2")).click();
            Thread.sleep(5000);
            driver.findElement(By.name("formulario_cadastro_projeto:j_idt57")).click();
        }

//        Assert.assertEquals(driver.findElement(By.id("formularioCadastro:nome")).getText(), "Iderli Souza");
        //verificação de e-mail
        SIntegracao.updateResults("GP04-18", null, TestLinkAPIResults.TEST_PASSED);
    }
    @Test
    public void testEditar() throws Exception {

        driver.get("http://192.168.56.104:8080/GerenciadorPampatec/");

        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("juninho270199iderli@gmail.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        driver.get("http://192.168.56.104:8080/GerenciadorPampatec/view/empreendedor/paginaBuscaPlanoDeNegocio.jsf");
        driver.findElement(By.xpath("//*[@id=\"lista_planos\"]/div/div[1]/div[3]/a/label/i")).click();
        driver.findElement(By.id("formEquipe:botaoSalvar1")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("formulario_cadastro_projeto:j_idt65")).click();

        driver.findElement(By.id("formulario_cadastro_projeto:botaoSalvar2")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("formulario_cadastro_projeto:j_idt57")).click();

        Assert.assertEquals(driver.findElement(By.id("formularioCadastro:nome")).getText(), "Iderli Souza");
//        verificação de e-mail
        SIntegracao.updateResults("GP04-21", null, TestLinkAPIResults.TEST_FAILED);
    }

    /**
     * Test of closeBrowser method, of class SeleniumTeste.
     */
    @After
    public void testCloseBrowser() {
        driver.quit();
    }

}
