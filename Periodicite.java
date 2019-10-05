import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Periodicite {
	
public static void UpdatePeriodicite(int idperiode, String libelle) {
		
	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("UPDATE Periodicite SET libelle =? where id_periodicite =? ");			
			requete.setInt(2, idperiode);
			requete.setString(1,libelle);
			
			requete.executeUpdate();
			
		
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ResultSet res;
		
		try {
			
			res = requete.executeQuery("select id_periodicite, libelle from Periodicite");
			
	
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public static void AddPeriodicite(int idperiode, String libelle) {
	
    Connection laConnexion = Connexion.creeConnexion();
	
	PreparedStatement requete = null;
	
	;
	


	try {
		
		requete = laConnexion.prepareStatement("INSERT INTO Periodicite(id_periodicite,libelle) VALUES(?,?) ");			
		requete.setInt(1, idperiode);
		requete.setString(2,libelle);
		
		
		requete.executeUpdate();
	     

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

			
	ResultSet res;
	
	try {
		
		res = requete.executeQuery("select * from Periodicite");
		
		
		if (res != null)
			res.close();
		
		if (requete != null)
			requete.close();
		
		if (laConnexion !=null) 
			laConnexion.close();
		
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void DeletePeriodicite(int idperiode) {
	
    Connection laConnexion = Connexion.creeConnexion();
	
	PreparedStatement requete = null;
	


	try {
		
		requete = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");			
		requete.setInt(1, idperiode);
		
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	ResultSet res;
	
	try {
		
		res = requete.executeQuery("select id_periodicite, libelle from Periodicite");
		

		if (res != null)
			res.close();
		
		if (requete != null)
			requete.close();
		
		if (laConnexion !=null) 
			laConnexion.close();
		
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


}
