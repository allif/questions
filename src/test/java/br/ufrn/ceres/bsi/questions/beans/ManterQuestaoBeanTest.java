package br.ufrn.ceres.bsi.questions.beans;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufrn.ceres.bsi.questions.beans.ManterQuestaoBean;
import br.ufrn.ceres.bsi.questions.model.Alternativa;
import br.ufrn.ceres.bsi.questions.model.Questao;

public class ManterQuestaoBeanTest {
	
	private ManterQuestaoBean bean;
	private Questao questao;
	private Alternativa alternativa1;
	private Alternativa alternativa2;
	private Alternativa alternativa3;
	private Alternativa alternativa4;

	@Before
	public void setUp() throws Exception {
		bean = new ManterQuestaoBean();
		questao = new Questao();
		alternativa1 = new Alternativa();
        alternativa2 = new Alternativa();
        alternativa3 = new Alternativa();
        alternativa4 = new Alternativa();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testeGetSet() {
		try {
			assertNotNull("1", questao);
			assertNotNull("2", alternativa1);
			assertNotNull("3", alternativa2);
			assertNotNull("4", alternativa3);
			assertNotNull("5", alternativa4);
			
			bean.setQuestao(questao);
			questao = bean.getQuestao();
			
			bean.setAlternativa1(alternativa1);
			alternativa1 = bean.getAlternativa1();
			
			bean.setAlternativa2(alternativa2);
			alternativa2 = bean.getAlternativa2();
			
			bean.setAlternativa3(alternativa3);
			alternativa3 = bean.getAlternativa3();
			
			bean.setAlternativa4(alternativa4);
			alternativa4 = bean.getAlternativa4();
			
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}
	}

}
