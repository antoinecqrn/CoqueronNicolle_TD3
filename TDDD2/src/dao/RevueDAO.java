package dao;
import metier.RevuePOJO;



public abstract interface RevueDAO extends DAO<RevuePOJO> {
	
	public abstract RevuePOJO getById(int id);



	
}

		