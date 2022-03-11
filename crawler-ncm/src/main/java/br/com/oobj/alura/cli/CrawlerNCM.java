package br.com.oobj.alura.cli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CrawlerNCM {

  public static void main(String[] args) {
    WebDriver browser = null;
    try {
      // corrija a configuração abaixo
      // System.setProperty("webdriver.chrome.driver", "../chromedriver");

      browser = new ChromeDriver();
      browser.navigate().to("https://cosmos.bluesoft.com.br/ncms/22021000");

      List<WebElement> elements = browser.findElements(By.cssSelector(".list-numbered.levels-4:nth-child(2) .item.level-1 .link"));
      elements.forEach(element -> {
        String numeroCEST = element.findElement(By.cssSelector(".number")).getText();
        String descricaoCEST = element.findElement(By.cssSelector(".full-description")).getText();
        System.out.println(numeroCEST);
        System.out.println(descricaoCEST + "\n");
      });

    } finally {
      if (browser != null) {
        browser.close();
      }
    }
  }

}
