package br.com.automacao.pages;

import org.openqa.selenium.WebDriver;

import br.com.automacao.test.DSL;

public class HomePage {
	private DSL dsl;

	public HomePage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void selecionarCombo() {
		dsl.selecionarCombo("switch-version-select", "Bootstrap V4 Theme");
	}

	public void clicarBotaoAdd() {
		dsl.clicarBotaoLinkText("Add Record");
	}

	public void escreverNomeSearch() {
		dsl.escreveName("customerName", "Teste Sicredi");
	}

	public void clicarCheckBox() {
		dsl.clicarBotaoXpath("//input[@type='checkbox' and @class='select-all-none']");
	}

	public void clicarBotaoDeletePrimeiro() {
		dsl.clicarBotaoXpath("//span[@class='text-danger' and .='Delete']");
	}

	public void clicarBotaoDeleteSegundo() {
		dsl.clicarBotaoXpath("//button[@class='btn btn-danger delete-multiple-confirmation-button']");
	}

}