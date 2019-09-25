package listememoire;





import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.AbonnementDAO;
import metier.AbonnementPOJO;

public class ListeMemoireAbonnementDAO implements AbonnementDAO {

	private static ListeMemoireAbonnementDAO instance;

	private List<AbonnementPOJO> donnees;


	public static ListeMemoireAbonnementDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireAbonnementDAO();
		}

		return instance;
	}

	private ListeMemoireAbonnementDAO() {

		this.donnees = new ArrayList<AbonnementPOJO>();
		
		String sDate1="31/12/1998";  
	    Date date1 = null;
		try {
			date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	    
	    String sDate2="31/11/2019";  
	    Date date2 = null;
		try {
			date2 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  


		this.donnees.add(new AbonnementPOJO(1,1,date1,date2));
	}


	@Override
	public boolean create(AbonnementPOJO objet) {

		objet.setId_client(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {

			objet.setId_client(objet.getId_client()+ 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(AbonnementPOJO objet) {
		
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
	public boolean delete(AbonnementPOJO objet) {

		AbonnementPOJO supprime;
		
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
	public AbonnementPOJO getById(int id) {
		

		String sDate1="31/12/1998";  
	    Date date1 = null;
		try {
			date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	    
	    String sDate2="31/11/2019";  
	    Date date2 = null;
		try {
			date2 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new AbonnementPOJO(id,1,date1,date2));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	public ArrayList<AbonnementPOJO> findAll() {
		return (ArrayList<AbonnementPOJO>) this.donnees;
	}


}
