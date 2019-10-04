package dao;

import metier.ClientPOJO;

public abstract interface ClientDAO extends DAO <ClientPOJO> {
	
	public abstract ClientPOJO getById(int id);


}

