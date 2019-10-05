import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Revue {


	public static void UpdateRevue(int idrevue, String title, String desc, double tn, String visu, int idperiod) {
		
	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("UPDATE titre=?, description=?, tarif_numero=?, visuel=?, id_periodicite=? WHERE id_revue =?");
			
			requete.setInt(6,idrevue);
			requete.setString(1, title);
			requete.setString(2, desc);
			requete.setDouble(3,tn);
			requete.setString(4, visu);
			requete.setInt(5,idperiod);
			
			requete.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ResultSet res;
		
		try {
			
			res = requete.executeQuery("select id_revue, titre, description, tarif_numero, visuel, id_periodicite from Revue");
			
		
			
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
	

	

	public static void AddRevue(int idrevue, String title, String desc, double tn, String visu, int idperiod) {
		
	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("INSERT INTO Revue (id_revue, titre, description, tarif_numero, visuel, id_periodicite) VALUES (?,?,?,?,?,?)");
			
			requete.setInt(1,idrevue);
			requete.setString(2, title);
			requete.setString(3, desc);
			requete.setDouble(4,tn);
			requete.setString(5, visu);
			requete.setInt(6,idperiod);
			
			requete.executeUpdate();
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ResultSet res;
		
		
		  try {
		  
		 res = requete.executeQuery("select id_revue, titre, description, tarif_numero, visuel, id_periodicite from Revue"
		  );
		 /*
		 * while (res.next()) {
		 * 
		 * int no_revue = res.getInt(1); String titre = res.getString(2); String
		 * description = res.getString(3); double tarif_numero = res.getDouble(4);
		 * String visuel = res.getString(5); int id_period = res.getInt(6);
		 * 
		 * 
		 * System.out.println(no_revue); System.out.println(titre);
		 * System.out.println(description); System.out.println(tarif_numero);
		 * System.out.println(visuel); System.out.println(id_period);
		 * 
		 * 
		 * 
		 * }
		 */
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

	
	
	

	public static void DeleteRevue(int idrevue) {
		
	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("delete from Revue where id_revue=?");
			requete.setInt(1, idrevue);
			
			requete.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ResultSet res;
		
		try {
			
			res = requete.executeQuery("select id_revue, titre, description, tarif_numero, visuel, id_periodicite from Revue");
		
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
