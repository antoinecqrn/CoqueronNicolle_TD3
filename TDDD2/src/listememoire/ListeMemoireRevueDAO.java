package listememoire;




import java.util.ArrayList;
import java.util.List;

import dao.RevueDAO;
import metier.RevuePOJO;

public class ListeMemoireRevueDAO implements RevueDAO {

	private static ListeMemoireRevueDAO instance;

	private List<RevuePOJO> donnees;


	public static ListeMemoireRevueDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}

		return instance;
	}

	private ListeMemoireRevueDAO() {

		this.donnees = new ArrayList<RevuePOJO>();

		this.donnees.add(new RevuePOJO(1, "Republicain Lorrain", "actualité", 2.50, "blanc",1));
		this.donnees.add(new RevuePOJO(2, "Auto Moto", "voiture", 3.50, "rouge",2));
	}


	@Override
	public boolean create(RevuePOJO objet) {

		objet.setId_revue(3);;
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_revue(objet.getId_revue()+ 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(RevuePOJO objet) {
		
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
	public boolean delete(RevuePOJO objet) {

		RevuePOJO supprime;
		
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
	public RevuePOJO getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new RevuePOJO(id, "test","aaa",1.1,"bb",1));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	public ArrayList<RevuePOJO> findAll() {
		return (ArrayList<RevuePOJO>) this.donnees;
	}


}


