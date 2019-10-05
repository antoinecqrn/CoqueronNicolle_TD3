package testsXML;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.RevuePOJO;

import listememoire.ListeMemoireRevueDAO;
class XMLRevueTest {

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
		ListeMemoireRevueDAO.getInstance().create(r);
			
		
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
		RevuePOJO pBDD = ListeMemoireRevueDAO.getInstance().getById(id);
		
		assertNotNull(pBDD);
		
		
	}
	
	public void testAjoutExist() {
		
		int id = r.getId_revue();
		RevuePOJO pBDD = ListeMemoireRevueDAO.getInstance().getById(id);
		ListeMemoireRevueDAO.getInstance().create(pBDD);
		
		
		assertNotNull(pBDD);
		
		
	}

	
	
	public void testModifExist() {
		
		RevuePOJO p2 = new RevuePOJO(1,"BIB","Magazine", 2.5,"bleu",1);
		ListeMemoireRevueDAO.getInstance().update(p2);
		
		
		assertNotNull(p2); 
	
		
	}
	
	
	public void testSupprExist() {

		ListeMemoireRevueDAO.getInstance().delete(r);

		assertNull(r); 
		
	}

	

}
