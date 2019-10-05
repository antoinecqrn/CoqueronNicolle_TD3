package testsXML;

import static org.junit.jupiter.api.Assertions.*;

import listememoire.ListeMemoirePeriodiciteDAO;
import metier.PeriodicitePOJO;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class XMLPeriodTest {

	private PeriodicitePOJO p;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		

	}

	@BeforeEach
	void setUp() throws Exception {
		
		p = new PeriodicitePOJO(1,"Bimensuel");
		ListeMemoirePeriodiciteDAO.getInstance().create(p);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testSelectExist() {
		
		int id = p.getId_periode();
		PeriodicitePOJO pBDD = ListeMemoirePeriodiciteDAO.getInstance().getById(id);
		
		assertNotNull(pBDD);
		
		
	}
	
	public void testAjoutExist() {
		
		int id = p.getId_periode();
		PeriodicitePOJO pBDD = ListeMemoirePeriodiciteDAO.getInstance().getById(id);
		ListeMemoirePeriodiciteDAO.getInstance().create(pBDD);
		
		
		assertNotNull(pBDD);
		
		
	}
	

	
	public void testModifExist() {
		
		PeriodicitePOJO p2 = new PeriodicitePOJO(1,"Trimensuel");
		ListeMemoirePeriodiciteDAO.getInstance().update(p2);
		
		
		assertNotNull(p2); 
	
		
	}

	
	public void testSupprExist() {

		
		ListeMemoirePeriodiciteDAO.getInstance().delete(p);
	
		assertNull(p); 
		
	}
	}

