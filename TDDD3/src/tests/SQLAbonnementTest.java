package tests;

import static org.junit.jupiter.api.Assertions.*;
import metier.AbonnementPOJO;

import sql.SQLAbonnementDAO;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SQLAbonnementTest {

	private AbonnementPOJO a; 
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		a = new AbonnementPOJO(1,1,java.sql.Date.valueOf("02/05/2000"), java.sql.Date.valueOf("02/06/2002"));
		SQLAbonnementDAO.getInstance().create(a);
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
		
		int id = a.getId_client();
		int id2 = a.getNum_abo();
		AbonnementPOJO pBDD = SQLAbonnementDAO.getInstance().getById(id,id2);
		
		assertNotNull(pBDD);
		
		
	}
	
	public void testAjoutExist() {
		
		int id = a.getId_client();
		int id2 = a.getNum_abo();
		
		AbonnementPOJO pBDD = SQLAbonnementDAO.getInstance().getById(id,id2);
		SQLAbonnementDAO.getInstance().create(pBDD);
		
		
		assertNotNull(pBDD);
		
		
	}

	
	
	public void testModifExist() {
		
		AbonnementPOJO p2 = new AbonnementPOJO(1,2,java.sql.Date.valueOf("02/08/2000"), java.sql.Date.valueOf("02/07/2002"));
		SQLAbonnementDAO.getInstance().update(p2);
		
		
		assertNotNull(p2); 
	
		
	}
	
	
	public void testSupprExist() {

		SQLAbonnementDAO.getInstance().delete(a);

		assertNull(a); 
		
	}


}
