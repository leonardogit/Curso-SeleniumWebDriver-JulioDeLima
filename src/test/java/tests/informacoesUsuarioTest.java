package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class informacoesUsuarioTest {
    private WebDriver navegador; //Atributo navegador

    @Before
    public void setUp(){
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Leonardo\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);

        //Navegadando para a pagina do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit/");
    }

    @Test //TODOS OS @TEST VAO CHAMAR O @BEFORE ANTES  E DEPOIS O @AFTER DEPOIS
    public void testAdicionarUmainformacaoAdicionalDoUsuario(){

        //clicar no link que possui o texto "Sign In"
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificando o formulario login
        WebElement formularioSignInbox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o  texto de "julio000'"
        formularioSignInbox.findElement(By.name("login")).sendKeys("julio0001");

        //Digitar no campo com name "password" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInbox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no elemento com o texto SIGN IN
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Validar que dentro do elemento com class "me" está o texto "Hi,Jlio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio" , textoNoElementoMe);

    }

    @After
    public void tearDown(){
        //Fechar o navegador
        navegador.quit();//fecha todas as abas que estão abertas
        //ja o .close fecha apemas a aba que está aberta
    }
}
