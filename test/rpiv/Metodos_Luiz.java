/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpivTestLink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static rpivTestLink.SeleniumIntegracao.driver;

/**
 *
 * @author WH0AM1
 */
public class Metodos {
    
    public static WebDriver driver;
    
    public static String getCPFAleatorio() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\gui_l\\ChromeDrive\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.56.101:8080/GerenciadorPampatec/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
        driver.manage().window();

        driver.get("https://www.4devs.com.br/gerador_de_cpf");
        driver.findElement(By.xpath("//*[@id=\"pontuacao_nao\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"bt_gerar_cpf\"]")).click();
        String cpf = "";
        cpf = driver.findElement(By.xpath("//*[@id=\"texto_cpf\"]")).getAttribute("value");
        return cpf;
    }

    public static String getEmail(){
         System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\gui_l\\ChromeDrive\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com.br/");
        driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("air get email");
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a")).click();
        //driver.findElement(By.xpath("")).click();
        return driver.findElement(By.xpath("//*[@id=\"tempemail\"]")).getAttribute("value");
    }
    
    /*
     * Método para ler cadastros de um csv e retornar um vetor com todos os 
     *parametros lidos do arquivo.
     */
    public static ArrayList<String[]> leCSV(String caminho) throws Exception {

        ArrayList<String[]> lista = new ArrayList();

        FileReader arquivo = new FileReader(caminho);
        BufferedReader lerArquivo = new BufferedReader(arquivo);

        String[] dados = null;
        String linha = lerArquivo.readLine();

        while (linha != null) {
            dados = linha.split(";");
            lista.add(dados);
            linha = lerArquivo.readLine();
        }
        lerArquivo.close();

        return lista;

    }
}
