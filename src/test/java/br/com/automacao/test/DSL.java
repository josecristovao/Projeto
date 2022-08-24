package br.com.automacao.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	private WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}

	public void escreveId(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}

	public void escreveName(String name_campo, String texto) {
		driver.findElement(By.name(name_campo)).sendKeys(texto);
	}

	public void clicarBotaoId(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void clicarBotaoLinkText(String linktext) {
		driver.findElement(By.linkText(linktext)).click();
	}

	public void clicarBotaoXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();

	}

	public void selecionarCombo(String id, String textoVisivel) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(textoVisivel);
	}

	public void aguardaElementoTelaCarregar(int segundos, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, segundos);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

	}

	public WebElement capturaFraseIdEXpath(String id, String xpath) {
		WebElement fraseCaminho = driver.findElement(By.id(id));
		WebElement fraseRestanteDoCaminho = fraseCaminho.findElement(By.xpath(xpath));
		return fraseRestanteDoCaminho;

	}

	public WebElement capturaFraseClassNameEXpath(String className, String xpath) {
		WebElement fraseCaminho = driver.findElement(By.className(className));
		WebElement fraseRestanteDoCaminho = fraseCaminho.findElement(By.xpath(xpath));
		return fraseRestanteDoCaminho;

	}

	public void imprimirNaTelaParaConferencia(String frase) {
		System.out.println(frase);

	}

	public void esperaMilissegundos(int milissegundos) throws InterruptedException {
		Thread.sleep(milissegundos);

	}

}