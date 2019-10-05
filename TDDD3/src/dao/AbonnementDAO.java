package dao;
import metier.AbonnementPOJO;


public abstract interface AbonnementDAO extends DAO<AbonnementPOJO>{
	
	public abstract AbonnementPOJO getById(int id1, int id2);
	

	}


