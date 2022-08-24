package br.com.automacao.pages;

import org.openqa.selenium.WebDriver;

import br.com.automacao.test.DSL;

public class FormularioPage {

	private DSL dsl;

	public FormularioPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void preencherFormulario() {
		dsl.escreveId("field-customerName", "Teste Sicredi");
		dsl.escreveId("field-contactLastName", "Teste");
		dsl.escreveId("field-contactFirstName", "seu nome");
		dsl.escreveId("field-phone", "51 9999-9999");
		dsl.escreveId("field-addressLine1", "Av Assis Brasil, 3970");
		dsl.escreveId("field-addressLine2", "Torre D");
		dsl.escreveId("field-city", "Porto Alegre");
		dsl.escreveId("field-state", "RS");
		dsl.escreveId("field-postalCode", "91000-000");
		dsl.escreveId("field-country", "Brasil");
		dsl.escreveId("field-salesRepEmployeeNumber", "1234");
		dsl.escreveId("field-creditLimit", "200");
		dsl.clicarBotaoId("form-button-save");
		dsl.aguardaElementoTelaCarregar(5,
				"//p[.='Your data has been successfully stored into the database. Edit Record or Go back to list']");

	}

	public void voltarLista() {
		dsl.clicarBotaoLinkText("Go back to list");
	}

}