package listememoire;



import java.util.ArrayList;
import java.util.List;

import dao.ClientDAO;
import metier.ClientPOJO;

public class ListeMemoireClientDAO implements ClientDAO {

	private static ListeMemoireClientDAO instance;

	private List<ClientPOJO> donnees;


	public static ListeMemoireClientDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}

		return instance;
	}

	private ListeMemoireClientDAO() {

		this.donnees = new ArrayList<ClientPOJO>();

		this.donnees.add(new ClientPOJO(1, "bib","john","9","fraise","54678","londres", "UK"));
		this.donnees.add(new ClientPOJO(2, "bob","zaza","8","pomme","54878","paris", "FR"));
		

	}


	@Override
	public boolean create(ClientPOJO objet) {

		objet.setId_client(3);;
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_client(objet.getId_client()+ 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(ClientPOJO objet) {
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, objet);
		}
		
		return true;
	}

	@Override
	public boolean delete(ClientPOJO objet) {

		ClientPOJO supprime;
		
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return objet.equals(supprime);
	}

	@Override
	public ClientPOJO getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new ClientPOJO(id, "fufu","lolo","80","chicken","90210","LA", "USA"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	public ArrayList<ClientPOJO> findAll() {
		return (ArrayList<ClientPOJO>) this.donnees;
	}


}


