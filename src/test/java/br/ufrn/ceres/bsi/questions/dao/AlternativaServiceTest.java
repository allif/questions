package br.ufrn.ceres.bsi.questions.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufrn.ceres.bsi.questions.dao.AlternativaService;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Alternativa;

public class AlternativaServiceTest {
	
	AlternativaService service = new AlternativaService(JPAUtil.EMF);
	Alternativa alt1;
	Alternativa alt2;

	@Before
	public void setUp() throws Exception {
		alt1 = new Alternativa("Sim");
        alt2 = new Alternativa("Não");
	}

	@After
	public void tearDown() throws Exception {
		try {
			if(service != null && alt1 != null && alt2 != null) {
				service.remove(alt1.getId());
				service.remove(alt2.getId());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeInserir() {
		Alternativa alt = null;
		try {
			assertNull("1", alt);
			assertNull("2", alt1.getId());
			alt = service.create(alt1);
			assertNotNull("3", alt);
			assertNotNull("4", alt.getId());
			assertEquals("5", "Sim", alt.getDescricao());
		} catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeFind() {
		Alternativa alt = null;
		try {
			assertNull("1", alt);
			assertNull("2", alt2.getId());
			alt = service.create(alt2);
			assertNotNull("3", alt);
			assertNotNull("4", alt.getId());
			assertNotNull("5", service.find(alt.getId()));
		} catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeUpdate() {
		Alternativa alt;
    	try {
    		assertEquals("1", null, alt1.getId());
    		alt = service.create(alt1);
    		assertNotNull("2", alt);
    		assertNotNull("3", alt.getId());
    		assertEquals("4", "Sim", alt.getDescricao());
    		alt.setDescricao("Talvez");
    		service.update(alt);
    		alt = service.find(alt.getId());
    		assertEquals("4", "Talvez", alt.getDescricao());
    	} catch(Exception e) {
    		fail();
    		e.printStackTrace();
    	}
	}
	
	@Test
	public void testeRemove() {
		Alternativa alt;
		try {
			assertNull("1", alt1.getId());
			alt = service.create(alt1);
			assertNotNull("2", alt);
    		assertNotNull("3", alt.getId());
    		service.remove(alt.getId());
    		assertNotNull("4", alt);
    		assertNull("5", service.find(alt.getId()));
		} catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}

}
