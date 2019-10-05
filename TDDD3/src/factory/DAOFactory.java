package factory;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.PeriodiciteDAO;
import dao.Persistance;
import dao.RevueDAO;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance cible) {
		
		
		DAOFactory daoF = null ;
		
		switch (cible) {
		
		case MYSQL:
			daoF = new MySQLDAOFactory();
			break;
			
		case LISTE_MEMOIRE:
			daoF = new ListeMemoireDAOFactory();
			break;
		default:
			break;
			
		}
		
		return daoF;
		
	}
	
	
	public abstract PeriodiciteDAO getPeriodiciteDAO();
	public abstract RevueDAO getRevueDAO();
	public abstract ClientDAO getClientDAO();
	public abstract AbonnementDAO getAbonnementDAO();
	

}
