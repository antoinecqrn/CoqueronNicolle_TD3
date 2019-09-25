package factory;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.PeriodiciteDAO;
import dao.RevueDAO;
import listememoire.ListeMemoireAbonnementDAO;
import listememoire.ListeMemoireClientDAO;
import listememoire.ListeMemoirePeriodiciteDAO;
import listememoire.ListeMemoireRevueDAO;


public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		// TODO Auto-generated method stub
		return ListeMemoirePeriodiciteDAO.getInstance();
	}

	@Override
	public RevueDAO getRevueDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireRevueDAO.getInstance();
	}

	@Override
	public ClientDAO getClientDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireClientDAO.getInstance();
		
	}


	@Override
	public AbonnementDAO getAbonnementDAO() {
		// TODO Auto-generated method stub
		return ListeMemoireAbonnementDAO.getInstance();
		
	}

}
