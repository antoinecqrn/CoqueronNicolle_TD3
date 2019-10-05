package testsXML;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import metier.ClientPOJO;
import listememoire.ListeMemoireClientDAO;

class XMLClientTest {
	private ClientPOJO c; 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		
		c = new ClientPOJO(1,"jean","valjean", "3", "fraises","metz","57000","France");
		ListeMemoireClientDAO.getInstance().create(c);
		
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
		
		int id = c.getId_client();
		ClientPOJO pBDD = ListeMemoireClientDAO.getInstance().getById(id);
		
		assertNotNull(pBDD);
		
		
	}
	
	public void testAjoutExist() {
		
		int id = c.getId_client();
		ClientPOJO pBDD = ListeMemoireClientDAO.getInstance().getById(id);
		ListeMemoireClientDAO.getInstance().create(pBDD);
		
		
		assertNotNull(pBDD);
		
		
	}

	
	
	public void testModifExist() {
		
		ClientPOJO p2 = new ClientPOJO(1,"baba","shoe", "8", "pomme","nancy","57000","USA");
		ListeMemoireClientDAO.getInstance().update(p2);
		
		
		assertNotNull(p2); 
	
		
	}
	
	
	public void testSupprExist() {

		ListeMemoireClientDAO.getInstance().delete(c);

		assertNull(c); 
		
	}

	

}
