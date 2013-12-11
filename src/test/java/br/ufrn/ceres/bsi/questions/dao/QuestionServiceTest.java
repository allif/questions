package br.ufrn.ceres.bsi.questions.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

import br.ufrn.ceres.bsi.questions.dao.QuestionService;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Questao;
import br.ufrn.ceres.bsi.questions.model.Alternativa;

public class QuestionServiceTest {

    QuestionService service = new QuestionService(JPAUtil.EMF);
    Questao questao1;
    Questao questao2;
    Alternativa alt1;
    Alternativa alt2;
    Alternativa alt3;
    Alternativa alt4;
    Alternativa alt5;
    Alternativa alt6;

    @Before
    public void setUp() throws Exception {
        alt1 = new Alternativa("Sim");
        alt2 = new Alternativa("Não");

        questao1 = new Questao();
        questao1.setDescricao("Você gosta de Caicó?");
        questao1.addAlternativa(alt1);
        questao1.addAlternativa(alt2);

        alt3 = new Alternativa("Ótimo");
        alt4 = new Alternativa("Bom");
        alt5 = new Alternativa("Regular");
        alt6 = new Alternativa("Ruim");

        questao2 = new Questao();
        questao2.setDescricao("Qual seu nível de programador?");
        questao2.addAlternativa(alt3);
        questao2.addAlternativa(alt4);
        questao2.addAlternativa(alt5);
        questao2.addAlternativa(alt6);
    }

    @After
    public void tearDown() throws Exception {
        try {
            if (service != null && questao1.getId() != null && questao2.getId() != null) {
                service.remove(questao1.getId());
                service.remove(questao2.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        questao1 = null;
        questao2 = null;
    }

    @Test
    public void testeInserir() {
        Questao questao;
        try {
            assertEquals("1", null, questao1.getId());
            questao = service.create(questao1);
            assertNotNull("2", questao);
            assertNotNull("3", questao.getId());
            assertEquals("4", "Você gosta de Caicó?", questao.getDescricao());
        } catch (Exception e) {
            fail();
            e.printStackTrace();
        }
    }
    
    @Test
    public void testeInserirErro() {
    	Questao questao = null;
    	try {
    		assertNull("1", questao);
    		questao = service.create(questao);
    	} catch(Exception e) {
    		fail();
    		e.printStackTrace();
    	}
    }
    
    @Test
    public void testeFind() {
    	Questao questao;
    	try {
    		assertEquals("1", null, questao1.getId());
    		questao = service.create(questao1);
    		assertNotNull("2", questao);
    		assertNotNull("3", questao.getId());
    		assertNotNull("4", service.find(questao.getId()));
    	} catch(Exception e) {
    		fail();
    		e.printStackTrace();
    	}
    }
    
    @Test
    public void testeFindAll() {
    	List<Questao> questoes = new ArrayList<Questao>();
    	Questao q1;
    	Questao q2;
    	try {
    		assertEquals("1", null, questao1.getId());
    		assertEquals("2", null, questao2.getId());
    		q1 = service.create(questao1);
    		q2 = service.create(questao2);
    		assertNotNull("3", q1);
    		assertNotNull("4", q1.getId());
    		assertNotNull("5", q2);
    		assertNotNull("6", q2.getId());
    		questoes = service.findAll();
    		assertNotNull("7", questoes);
    	} catch (Exception e) {
    		fail();
    		e.printStackTrace();
    	}
    }
    
    @Test
    public void testeFindAllErro() {
    	Questao q1 = null;
    	Questao q2 = null;
    	try {
    		assertEquals("1", null, questao1.getId());
    		assertEquals("2", null, questao2.getId());
    		assertNull("3", q1);
    		assertNull("4", q2);
    		assertNotNull("6", service.findAll());
    	} catch (Exception e) {
    		fail();
    		e.printStackTrace();
    	}
    }
    
    @Test
    public void testeUpdate() {
    	Questao questao;
    	try {
    		assertEquals("1", null, questao1.getId());
    		questao = service.create(questao1);
    		assertNotNull("2", questao);
    		assertNotNull("3", questao.getId());
    		assertEquals("4", "Você gosta de Caicó?", questao.getDescricao());
    		questao.setDescricao("Você cursa BSI?");
    		service.update(questao);
    		questao = service.find(questao.getId());
    		assertEquals("4", "Você cursa BSI?", questao.getDescricao());
    	} catch(Exception e) {
    		fail();
    		e.printStackTrace();
    	}
    }
    
    @Test
    public void testeRemover() {
    	Questao questao;
    	try {
    		assertEquals("1", null, questao1.getId());
    		questao = service.create(questao2);
    		assertNotNull("2", questao);
    		assertNotNull("3", questao.getId());
    		service.remove(questao.getId());
    		assertNotNull("4", questao);
    		assertNull("5", service.find(questao.getId()));
    	} catch (Exception e) {
    		fail();
    		e.printStackTrace();
    	}
    }
    
    @Test
    public void testGetSetEMF() {
    	EntityManagerFactory emf = null;
    	try {
    		assertNull("1", emf);
    		emf = JPAUtil.EMF;
    		assertNotNull("2", emf);
    		service.setEntityManagerFactory(emf);
    		emf = null;
    		assertNull("3", emf);
    		emf = service.getEntityManagerFactory();
    		assertNotNull("4", emf);
    	} catch(Exception e) {
    		fail();
    		e.printStackTrace();
    	}
    }

}
