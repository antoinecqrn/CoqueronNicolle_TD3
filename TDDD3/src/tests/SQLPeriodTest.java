package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.PeriodicitePOJO;
import sql.SQLPeriodiciteDAO;

class SQLPeriodTest {
	
	
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
		SQLPeriodiciteDAO.getInstance().create(p);
		
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
		PeriodicitePOJO pBDD = SQLPeriodiciteDAO.getInstance().getById(id);
		
		assertNotNull(pBDD);
		
		
	}
	
	public void testAjoutExist() {
		
		int id = p.getId_periode();
		PeriodicitePOJO pBDD = SQLPeriodiciteDAO.getInstance().getById(id);
		SQLPeriodiciteDAO.getInstance().create(pBDD);
		
		
		assertNotNull(pBDD);
		
		
	}
	

	
	public void testModifExist() {
		
		PeriodicitePOJO p2 = new PeriodicitePOJO(1,"Trimensuel");
		SQLPeriodiciteDAO.getInstance().update(p2);
		
		
		assertNotNull(p2); 
	
		
	}

	
	public void testSupprExist() {

		
		SQLPeriodiciteDAO.getInstance().delete(p);
	
		assertNull(p); 
		
	}
	
	


}
