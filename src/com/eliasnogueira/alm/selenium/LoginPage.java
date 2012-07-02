package com.eliasnogueira.alm.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    /**
     * Efetua o login no Prestashop
     * 
     * @param login email valido e cadastrado
     * @param senha senha para o usuario
     * @return objeto corrente do webdriver
     */
    public WebDriver efetuaLogin(String login, String senha) {
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).sendKeys(senha);
        driver.findElement(By.id("SubmitLogin")).click();
        return driver;
    }
    
    /**
     * Verifica, atrav�s de um texto presente na p�gina se estamos na pagina correta.
     *    - Para a p�gina de login com sucesso o criterio � o texto 'ALM TDC' ser apresentado
     *    - Para a p�gina de login sem sucesso o criterio � o qualquer texto diferente de 'ALM TDC' ser apresentado
     * 
     * @param texto texto que deve ou n�o conter na pagina, de acordo com o tipo de verifica��o (assertTrue ou assertFalse)
     * @return true ou false para o texto procurado
     */
    public boolean estaNaPaginaDeLogin(String texto) {
        return driver.findElement(By.tagName("body")).getText().contains(texto);
    }
}
