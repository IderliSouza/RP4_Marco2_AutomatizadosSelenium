package rpivTestLink;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

/**
 *
 * @author WH0AM1
 */
public class MGP_73 {

    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\gui_l\\ChromeDrive\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
        driver.manage().window();
    }

   @Ignore
    @Test
    public void testeCadastroVazio() throws InterruptedException, TestLinkAPIException {
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioDeCadastro:botaoContinuaCadastro\"]/span[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:nome\"]")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:cpf\"]")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:telefone\"]")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:rua\"]")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:numero\"]")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:bairro\"]")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:email\"]")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senha\"]")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senhaConfig\"]")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:botaoEnviar\"]/span[2]")).click();
        assertEquals("Realizar Cadastro", driver.getTitle());
        SeleniumIntegracao.updateResults("GP04-47", null, TestLinkAPIResults.TEST_PASSED);
    }
    
    @Ignore
    @Test
    public void testeCadastroDadosInvalidos() throws InterruptedException, Exception {

        ArrayList<String[]> dadosInv = Metodos.leCSV("invalidos.txt");
        System.out.print(dadosInv.size());
        for (String[] strings : dadosInv) {
            driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"formularioDeCadastro:botaoContinuaCadastro\"]/span[2]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"formularioCadastro:nome\"]")).sendKeys(strings[0]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"formularioCadastro:cpf\"]")).sendKeys(strings[1]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"formularioCadastro:telefone\"]")).sendKeys(strings[2]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"formularioCadastro:rua\"]")).sendKeys(strings[3]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"formularioCadastro:numero\"]")).sendKeys(strings[4]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"formularioCadastro:bairro\"]")).sendKeys(strings[5]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"formularioCadastro:email\"]")).sendKeys(strings[6]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senha\"]")).sendKeys(strings[6]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senhaConfig\"]")).sendKeys(strings[6]);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"formularioCadastro:botaoEnviar\"]/span[2]")).click();
        }
        
        assertEquals("Realizar Cadastro", driver.getTitle());
        SeleniumIntegracao.updateResults("GP04-48", null, TestLinkAPIResults.TEST_PASSED);

    }
    
    @Test
    public void testeconfirmaEmail() throws Exception {
        String email = Metodos.getEmail();

        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        /*
        Preenche todos os campos 
         */
        String cpf = Metodos.getCPFAleatorio();

        driver.findElement(By.xpath("//*[@id=\"formularioDeCadastro:botaoContinuaCadastro\"]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:nome\"]")).sendKeys("Serjao Berranteiro");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:cpf\"]")).sendKeys(cpf);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:telefone\"]")).sendKeys("5599999999");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:rua\"]")).sendKeys("ibirapuita");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:numero\"]")).sendKeys("110");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:bairro\"]")).sendKeys("centro");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senha\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senhaConfig\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:botaoEnviar\"]/span[2]")).click();

        Thread.sleep(2000);

        /*
        Acessa o email descartavel, busca pelo título do email que o sistema manda, dá um click confirmar e por
        fim, tenta fazer login.
         */
        driver.get("https://br.getairmail.com/");
        driver.findElement(By.linkText("Gerenciador Pampatec - Confirmação de E-mail")).click();
        driver.findElement(By.cssSelector("strong")).click();
        driver.findElement(By.id("j_idt12:botaoLogin")).click();
        driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys(email);
        driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();

        Thread.sleep(2000);

        assertEquals("Página Principal - Empreendedor", driver.getTitle());
        SeleniumIntegracao.updateResults("GP04-44", null, TestLinkAPIResults.TEST_PASSED);
    }

    @Ignore
    @Test
    public void testeConfirmaEmail2() throws Exception {
        String email = Metodos.getEmail();
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");;

        driver.findElement(By.xpath("//*[@id=\"formularioDeCadastro:botaoContinuaCadastro\"]/span[2]")).click();

        /*
        Limpa todos os campos que serão preenchidos (do formulário).
         */
        driver.findElement(By.id("formularioCadastro:nome")).clear();
        driver.findElement(By.id("formularioCadastro:cpf")).clear();
        driver.findElement(By.id("formularioCadastro:telefone")).clear();
        driver.findElement(By.id("formularioCadastro:rua")).clear();
        driver.findElement(By.id("formularioCadastro:numero")).clear();
        driver.findElement(By.id("formularioCadastro:bairro")).clear();
        driver.findElement(By.id("formularioCadastro:email")).clear();
        driver.findElement(By.id("formularioCadastro:senha")).clear();
        driver.findElement(By.id("formularioCadastro:senhaConfig")).clear();

        /*
        Preenche todos os campos 
         */
        String cpf = Metodos.getCPFAleatorio();
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:nome\"]")).sendKeys("Serjao Berranteiro");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:cpf\"]")).sendKeys(cpf);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:telefone\"]")).sendKeys("5599999999");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:rua\"]")).sendKeys("ibirapuita");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:numero\"]")).sendKeys("110");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:bairro\"]")).sendKeys("centro");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senha\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senhaConfig\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:botaoEnviar\"]/span[2]")).click();
        Thread.sleep(2000);

        /*
        Acessa o email descartavel, busca pelo título do email que o sistema manda, dá um click confirmar e por
        fim, tenta fazer login.
         */
        driver.get("https://br.getairmail.com/");
        driver.findElement(By.linkText("Gerenciador Pampatec - Confirmação de E-mail")).click();
        driver.findElement(By.cssSelector("strong")).click();
        driver.findElement(By.id("j_idt12:botaoLogin")).click();
        driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys(email);
        driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        Thread.sleep(2000);
        assertEquals("Página Principal - Empreendedor", driver.getTitle());
        SeleniumIntegracao.updateResults("GP04-45", null, TestLinkAPIResults.TEST_PASSED);
    }
    
    
    @Ignore
    @Test
    public void editaEmailConfirmacao() throws InterruptedException, TestLinkAPIException{
        String email = Metodos.getEmail();
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");

        driver.findElement(By.xpath("//*[@id=\"formularioDeCadastro:botaoContinuaCadastro\"]/span[2]")).click();

        /*
        Limpa todos os campos que serão preenchidos (do formulário).
         */
        driver.findElement(By.id("formularioCadastro:nome")).clear();
        driver.findElement(By.id("formularioCadastro:cpf")).clear();
        driver.findElement(By.id("formularioCadastro:telefone")).clear();
        driver.findElement(By.id("formularioCadastro:rua")).clear();
        driver.findElement(By.id("formularioCadastro:numero")).clear();
        driver.findElement(By.id("formularioCadastro:bairro")).clear();
        driver.findElement(By.id("formularioCadastro:email")).clear();
        driver.findElement(By.id("formularioCadastro:senha")).clear();
        driver.findElement(By.id("formularioCadastro:senhaConfig")).clear();

        /*
        Preenche todos os campos 
         */
        String cpf = Metodos.getCPFAleatorio();
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:nome\"]")).sendKeys("Serjao Berranteiro");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:cpf\"]")).sendKeys(cpf);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:telefone\"]")).sendKeys("5599999999");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:rua\"]")).sendKeys("ibirapuita");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:numero\"]")).sendKeys("110");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:bairro\"]")).sendKeys("centro");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senha\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senhaConfig\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:botaoEnviar\"]/span[2]")).click();
        Thread.sleep(2000);

        /*
        Acessa o email descartavel, busca pelo título do email que o sistema manda, dá um click confirmar e por
        fim, tenta fazer login.
         */
        driver.get("https://br.getairmail.com/");
        driver.findElement(By.linkText("Gerenciador Pampatec - Confirmação de E-mail")).click();
        driver.findElement(By.cssSelector("strong")).click();
        driver.findElement(By.id("j_idt12:botaoLogin")).click();
        driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys(email);
        driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id=\"menuSuperior\"]/nav/div/div[2]/ul/li[3]/ul/li[1]/input")).click();
        String novoEmail = Metodos.getEmail();
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:email\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:email\"]")).sendKeys(novoEmail);
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:senhaAtual\"]")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:botaoFinalizarEdicao\"]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"formularioCadastro:botaoConfirmar\"]")).click();
        
        driver.get("https://br.getairmail.com/");
        Thread.sleep(10000);
        driver.get("https://br.getairmail.com/");
        driver.findElement(By.linkText("Gerenciador Pampatec - Confirmação de E-mail")).click();
        driver.findElement(By.cssSelector("strong")).click();
        driver.findElement(By.id("j_idt12:botaoLogin")).click();
        driver.findElement(By.id("formularioDeLogin:emailInput")).clear();
        driver.findElement(By.id("formularioDeLogin:emailInput")).sendKeys(email);
        driver.findElement(By.id("formularioDeLogin:senhaInput")).clear();
        driver.findElement(By.id("formularioDeLogin:senhaInput")).sendKeys("123456");
        driver.findElement(By.id("formularioDeLogin:botaoLogin")).click();
        Thread.sleep(2000);
        assertEquals("Página Principal - Empreendedor", driver.getTitle());
        
    }

    @After
    public void testCloseBrowser() {
        driver.quit();
    }
}
