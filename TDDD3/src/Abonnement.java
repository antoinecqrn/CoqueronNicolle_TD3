import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Abonnement {

	
	public static void UpdateAbonnement(int idclient,int numabo, Date datedeb, Date datefin) {
		
	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("UPDATE Abonnement SET id_revue = ? , date_deb = ?, date_fin = ? WHERE id_client = ?   ");
			requete.setInt(4, idclient);
			requete.setInt(1, numabo);
			requete.setDate(2, datedeb);
			requete.setDate(3, datefin);
			
			requete.executeUpdate(); 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ResultSet res;
		
		try {
			
			res = requete.executeQuery("select id_client, id_revue, date_debut, date_fin from Abonnement");
	
			
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

	
	public static void AddAbonnement(int idclient,int numabo, Date datedeb, Date datefin) {
		
	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("INSERT INTO Abonnement(id_client, id_revue, date_debut, date_fin) VALUES (?,?,?,?) ");
			requete.setInt(1, idclient);
			requete.setInt(2, numabo);
			requete.setDate(3, datedeb);
			requete.setDate(4, datefin);
			
			requete.executeUpdate(); 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ResultSet res;
		
		try {
			
			res = requete.executeQuery("select id_client, id_revue, date_debut, date_fin from Abonnement");
	
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
	

	
	public static void DeleteAbonnement(int idclient) {
		
	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("delete from Abonnement where id_client=?");
			requete.setInt(1, idclient);
			requete.executeUpdate(); 
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ResultSet res;
		
		try {
			
			res = requete.executeQuery("select id_client, id_revue, date_debut, date_fin from Abonnement");
			
		
			
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
