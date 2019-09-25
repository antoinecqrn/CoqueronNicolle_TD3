package listememoire;


import java.util.ArrayList;
import java.util.List;

import dao.PeriodiciteDAO;
import metier.PeriodicitePOJO;

public class ListeMemoirePeriodiciteDAO implements PeriodiciteDAO {

	private static ListeMemoirePeriodiciteDAO instance;

	private List<PeriodicitePOJO> donnees;


	public static ListeMemoirePeriodiciteDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoirePeriodiciteDAO();
		}

		return instance;
	}

	private ListeMemoirePeriodiciteDAO() {

		this.donnees = new ArrayList<PeriodicitePOJO>();

		this.donnees.add(new PeriodicitePOJO(1, "Mensuel"));
		this.donnees.add(new PeriodicitePOJO(2, "Quotidien"));
	}


	@Override
	public boolean create(PeriodicitePOJO objet) {

		objet.setId_periode(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_periode(objet.getId_periode()+ 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(PeriodicitePOJO objet) {
		
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
	public boolean delete(PeriodicitePOJO objet) {

		PeriodicitePOJO supprime;
		
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
	public PeriodicitePOJO getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new PeriodicitePOJO(id, "test"));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	public ArrayList<PeriodicitePOJO> findAll() {
		return (ArrayList<PeriodicitePOJO>) this.donnees;
	}
}
