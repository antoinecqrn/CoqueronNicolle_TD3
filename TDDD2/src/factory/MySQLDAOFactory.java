package factory;
import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.PeriodiciteDAO;
import dao.RevueDAO;
import sql.SQLPeriodiciteDAO;
import sql.SQLRevueDAO;
import sql.SQLAbonnementDAO;
import sql.SQLClientDAO;


public class MySQLDAOFactory extends DAOFactory {

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		
		// TODO Auto-generated method stub
	
		return SQLPeriodiciteDAO.getInstance();
		
	}

	@Override
	public RevueDAO getRevueDAO() {
		// TODO Auto-generated method stub
		
		return SQLRevueDAO.getInstance();
		
		
	}

	@Override
	public ClientDAO getClientDAO() {
		// TODO Auto-generated method stub
		return SQLClientDAO.getInstance();
	}

	@Override
	public AbonnementDAO getAbonnementDAO() {
		// TODO Auto-generated method stub
		return SQLAbonnementDAO.getInstance();
	}

}
