/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpiv;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import rpivTestLink.SeleniumIntegracao;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author vitao
 */
public class MGP_27_Vitor {

    public static WebDriver driver;
    public static String url = "http://192.168.56.102:8080/GerenciadorPampatec/loginEmpreendedor.jsf";

    @Before
    public void setUp() throws TestLinkAPIException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void test01_MGP_27() throws Exception {
        driver.manage().deleteAllCookies();
        LeitorTxt leitor = new LeitorTxt();
        String[] values = leitor.ler("camposDeTexto.txt");
        try {
            for (int i = 0; i < values.length; i++) {

                driver.get(url);

                driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
                driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
                driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
                driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
                Thread.sleep(3000);
                driver.findElement(By.id("locovelho:tabelaDeNegocios:0:avaliarPlano")).click();
                Thread.sleep(1500);
                driver.findElement(By.id("tabNegocio")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioSegmento")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:segmentoDeCliente2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:segmentoDeCliente2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioSegmento")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioProposta")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:propostaDeValor2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:propostaDeValor2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioProposta")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioAtividades")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:atividadesChave2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:atividadesChave2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioAtividades")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("tabAnaliseMercado")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioRelacao")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:relacaoClientes2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:relacaoClientes2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioRelacao")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioParceria")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:parceriasChave2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:parceriasChave2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioParceria")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioCanais")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:canais2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:canais2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioCanais")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioRecursos")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:recursosPrincipais2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:recursosPrincipais2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioRecursos")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioConcorrentes")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:concorrentes2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:concorrentes2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioConcorrentes")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("tabProdutoServico")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioEstagio")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:estagioEvolucao2")).sendKeys("asd123%*/Teste01");
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioEstagio")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioTecnologia")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:tecnologiaProcessos2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:tecnologiaProcessos2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioTecnologia")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioPotencial")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:potencialInovacaoTecnologica2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:potencialInovacaoTecnologica2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioPotencial")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioAplicacao")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:aplicacoes2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:aplicacoes2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioAplicacao")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioDificuldades")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:dificuldadesEsperadas2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:dificuldadesEsperadas2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioDificuldades")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInteracaoUniversidade")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:interacaoEmpresaUniversidade2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:interacaoEmpresaUniversidade2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInteracaoUniversidade")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInteracaoComunidade")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:interacaoEmpresaComunidadeGoverno2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:interacaoEmpresaComunidadeGoverno2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInteracaoComunidade")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInfraEstrutura")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:infraestrutura2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:infraestrutura2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInfraEstrutura")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("tabGestaoPessoas")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioDescricao")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:participacaoAcionaria2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:participacaoAcionaria2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioDescricao")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioPotencialRenda")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:potencialEmprego2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:potencialEmprego2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioPotencialRenda")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("tabPlanoFinanceiro")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioFontes")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:fontesDeReceita2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:fontesDeReceita2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioFontes")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioEstruturaCustos")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:estruturaCustos2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:estruturaCustos2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioEstruturaCustos")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInvestimentoInicial")).click();
                driver.findElement(By.id("formulario_comentarpreavalizar:investimentoInicial2")).clear();
                driver.findElement(By.id("formulario_comentarpreavalizar:investimentoInicial2")).sendKeys(values[i]);
                driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInvestimentoInicial")).click();

                driver.findElement(By.id("formulario_comentarpreavalizar:botaoSalvar6")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id=\"locovelho\"]/nav/div/div[2]/ul/li[2]/a")).click();
                driver.findElement(By.xpath("//*[@id=\"locovelho\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
                Thread.sleep(5000);
            }
            SeleniumIntegracao.updateResults("GP04-77", null, TestLinkAPIResults.TEST_PASSED);
        } catch (Exception e) {
            SeleniumIntegracao.updateResults("GP04-77", null, TestLinkAPIResults.TEST_FAILED);
        }

    }

    @Test
    public void test02_MGP_27() throws Exception {
        driver.manage().deleteAllCookies();

        driver.get(url);

        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("locovelho:tabelaDeNegocios:0:avaliarPlano")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("tabPlanoFinanceiro")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioFontes")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:fontesDeReceita2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioFontes")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioEstruturaCustos")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:estruturaCustos2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioEstruturaCustos")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInvestimentoInicial")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:investimentoInicial2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInvestimentoInicial")).click();

        driver.findElement(By.linkText("Avaliar")).click();

        //driver.findElement(By.id("formulario_comentarpreavalizar:botaoSalvar6")).click();
        Thread.sleep(2000);
        boolean botao = driver.findElement(By.id("formulario_comentarpreavalizar:botaoEnviar")).isEnabled();

        if (botao) {
            SeleniumIntegracao.updateResults("GP04-79", null, TestLinkAPIResults.TEST_FAILED);
        } else {
            SeleniumIntegracao.updateResults("GP04-79", null, TestLinkAPIResults.TEST_PASSED);
        }

    }

    @Test
    public void test03_MGP_27() throws Exception {
        driver.manage().deleteAllCookies();

        driver.get(url);

        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys("gerentedefault1@ideiah.com");
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("gerente123");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt14\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("locovelho:tabelaDeNegocios:0:avaliarPlano")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("tabNegocio")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioSegmento")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:segmentoDeCliente2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioSegmento")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioProposta")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:propostaDeValor2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioProposta")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioAtividades")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:atividadesChave2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioAtividades")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("tabAnaliseMercado")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioRelacao")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:relacaoClientes2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioRelacao")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioParceria")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:parceriasChave2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioParceria")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioCanais")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:canais2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioCanais")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioRecursos")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:recursosPrincipais2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioRecursos")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioConcorrentes")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:concorrentes2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioConcorrentes")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("tabProdutoServico")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioEstagio")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:estagioEvolucao2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioEstagio")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioTecnologia")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:tecnologiaProcessos2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioTecnologia")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioPotencial")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:potencialInovacaoTecnologica2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioPotencial")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioAplicacao")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:aplicacoes2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioAplicacao")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioDificuldades")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:dificuldadesEsperadas2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioDificuldades")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInteracaoUniversidade")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:interacaoEmpresaUniversidade2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInteracaoUniversidade")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInteracaoComunidade")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:interacaoEmpresaComunidadeGoverno2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInteracaoComunidade")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInfraEstrutura")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:infraestrutura2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInfraEstrutura")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("tabGestaoPessoas")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioDescricao")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:participacaoAcionaria2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioDescricao")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioPotencialRenda")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:potencialEmprego2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioPotencialRenda")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("tabPlanoFinanceiro")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioFontes")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:fontesDeReceita2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioFontes")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioEstruturaCustos")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:estruturaCustos2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioEstruturaCustos")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInvestimentoInicial")).click();
        driver.findElement(By.id("formulario_comentarpreavalizar:investimentoInicial2")).clear();
        driver.findElement(By.id("formulario_comentarpreavalizar:adicionarComentarioInvestimentoInicial")).click();

        driver.findElement(By.linkText("Avaliar")).click();

        //driver.findElement(By.id("formulario_comentarpreavalizar:botaoSalvar6")).click();
        Thread.sleep(2000);
        boolean botao = driver.findElement(By.id("formulario_comentarpreavalizar:botaoEnviar")).isEnabled();

        if (botao) {
            SeleniumIntegracao.updateResults("GP04-78", null, TestLinkAPIResults.TEST_PASSED);
        } else {
            SeleniumIntegracao.updateResults("GP04-78", null, TestLinkAPIResults.TEST_FAILED);
        }

    }

    /**
     * Test of closeBrowser method, of class SeleniumTeste.
     */
    @After
    public void testCloseBrowser() {
        driver.findElement(By.xpath("//*[@id=\"locovelho\"]/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"locovelho\"]/nav/div/div[2]/ul/li[2]/ul/li/a")).click();
        driver.quit();
    }
}
