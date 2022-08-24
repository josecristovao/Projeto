package br.com.automacao.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.automacao.pages.FormularioPage;
import br.com.automacao.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FormularioTest {

	private WebDriver driver;
	private DSL dsl;
	private HomePage pageHome;
	private FormularioPage pageFormulario;

	@Before
	public void inicializa() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
		dsl = new DSL(driver);
		pageHome = new HomePage(driver);
		pageFormulario = new FormularioPage(driver);

	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void DesafioA() {
		pageHome.selecionarCombo();
		pageHome.clicarBotaoAdd();
		pageFormulario.preencherFormulario();
		WebElement caminhoTextoValidacao = dsl.capturaFraseIdEXpath("report-success",
				"//p[.='Your data has been successfully stored into the database. Edit Record or Go back to list']");
		String FraseCompletaValidacao = caminhoTextoValidacao.getText();
		dsl.imprimirNaTelaParaConferencia(FraseCompletaValidacao);
		assertEquals("Your data has been successfully stored into the database. Edit Record or Go back to list",
				FraseCompletaValidacao);
	}

	@Test
	public void DesafioB() throws InterruptedException {
		pageHome.selecionarCombo();
		pageHome.clicarBotaoAdd();
		pageFormulario.preencherFormulario();
		WebElement caminhoTextoValidacao = dsl.capturaFraseIdEXpath("report-success",
				"//p[.='Your data has been successfully stored into the database. Edit Record or Go back to list']");
		String FraseCompletaValidacao = caminhoTextoValidacao.getText();
		dsl.imprimirNaTelaParaConferencia(FraseCompletaValidacao);
		assertEquals("Your data has been successfully stored into the database. Edit Record or Go back to list",
				FraseCompletaValidacao);
		pageFormulario.voltarLista();
		dsl.esperaMilissegundos(3000);
		pageHome.escreverNomeSearch();
		pageHome.clicarCheckBox();
		dsl.esperaMilissegundos(3000);
		pageHome.clicarCheckBox();
		pageHome.clicarBotaoDeletePrimeiro();
		WebElement caminhoTextoValidacaoDois = driver
				.findElement(By.xpath("//p[contains(., 'Are you sure that you want to delete those 2 items?')]"));
		String FraseCompletaValidacaoDois = caminhoTextoValidacaoDois.getText();
		dsl.imprimirNaTelaParaConferencia(FraseCompletaValidacaoDois);
		assertEquals("Are you sure that you want to delete those 2 items?", FraseCompletaValidacaoDois);
		pageHome.clicarBotaoDeleteSegundo();
		dsl.esperaMilissegundos(3000);
		WebElement mensagemPopUp = driver.findElement(
				By.xpath("//p[contains(., 'Your data has been successfully deleted from the database.')]"));
		String mensagemPopUpVerde = mensagemPopUp.getText();
		dsl.imprimirNaTelaParaConferencia(mensagemPopUpVerde);
		assertEquals("Your data has been successfully deleted from the database.", mensagemPopUpVerde);

	}
}
