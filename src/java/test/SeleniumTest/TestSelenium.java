/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.SeleniumTest;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jvbor
 */
public class TestSelenium {

    public static void main(String[]args){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\jvbor\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
    WebDriver navegar = new ChromeDriver();
    
    navegar.navigate().to("http://localhost:8080/APS-04-Lanchonete-Online-em-Java-master/view/cadastro/cadastro.html"); 
    int cont = 0;
    Random rand = new Random();
    while (cont <10){
        navegar.manage().window().maximize();
        navegar.findElement(By.name("nome")).sendKeys("nome" + rand.nextInt(100));
        navegar.findElement(By.name("sobrenome")).sendKeys("sobrenome"+ rand.nextInt(100));
        navegar.findElement(By.name("telefone")).sendKeys("" + rand.nextInt(1000000000));
        navegar.findElement(By.name("usuario")).sendKeys("Teste" + rand.nextInt(100));
        navegar.findElement(By.name("senha")).sendKeys("Teste" + rand.nextInt(100));
        navegar.findElement(By.name("rua")).sendKeys("Teste" + rand.nextInt(100));
        navegar.findElement(By.name("numero")).sendKeys("" + rand.nextInt(100));
        navegar.findElement(By.name("bairro")).sendKeys("" + rand.nextInt(100));
        navegar.findElement(By.name("cidade")).sendKeys("" + rand.nextInt(100));
        navegar.findElement(By.name("complemento")).sendKeys("Teste");
        navegar.findElement(By.name("estado")).sendKeys("Teste");
        navegar.findElement(By.className("buttonSubmit")).click();
        
        navegar.navigate().to("http://localhost:8080/APS-04-Lanchonete-Online-em-Java-master/view/cadastro/cadastro.html"); 
        cont ++;
        
    }
       navegar.navigate().to("http://localhost:8080/APS-04-Lanchonete-Online-em-Java-master/view/login/login.html"); 
       navegar.findElement(By.id("loginInput")).sendKeys("jv");
       navegar.findElement(By.id("senhaInput")).sendKeys("teste1234");
       navegar.findElement(By.className("buttonSubmit")).click();
       navegar.navigate().to("http://localhost:8080/APS-04-Lanchonete-Online-em-Java-master/view/menu/menu.html"); 
       navegar.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       navegar.findElement(By.xpath("//*[text()='Adicionar ao Carrinho']")).click();
       navegar.switchTo( ).alert( ).accept();
       navegar.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       navegar.navigate().to("http://localhost:8080/APS-04-Lanchonete-Online-em-Java-master/view/carrinho/carrinho.html");  
       navegar.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       navegar.findElement(By.className("buttonSubmitSalvar")).click();
       navegar.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       navegar.findElement(By.className("pagCredito")).click();
       navegar.findElement(By.className("pagDinheiro")).click();
       navegar.findElement(By.className("buttonSubmit")).click();
    }
    
}