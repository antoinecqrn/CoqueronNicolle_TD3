package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.RevuePOJO;

import sql.SQLRevueDAO;


class SQLRevueTest {
	
	
	private RevuePOJO r ;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		r = new RevuePOJO(1,"BOB","Journal", 5.5,"vert", 1);
		SQLRevueDAO.getInstance().create(r);
			
		
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
		
		int id = r.getId_revue();
		RevuePOJO pBDD = SQLRevueDAO.getInstance().getById(id);
		
		assertNotNull(pBDD);
		
		
	}
	
	public void testAjoutExist() {
		
		int id = r.getId_revue();
		RevuePOJO pBDD = SQLRevueDAO.getInstance().getById(id);
		SQLRevueDAO.getInstance().create(pBDD);
		
		
		assertNotNull(pBDD);
		
		
	}

	
	
	public void testModifExist() {
		
		RevuePOJO p2 = new RevuePOJO(1,"BIB","Magazine", 2.5,"bleu",1);
		SQLRevueDAO.getInstance().update(p2);
		
		
		assertNotNull(p2); 
	
		
	}
	
	
	public void testSupprExist() {

		SQLRevueDAO.getInstance().delete(r);

		assertNull(r); 
		
	}

	
	

}
