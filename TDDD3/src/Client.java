import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
	
	

	public static void UpdateClient(int idclient, String name, String pname, String numrue, String rue, String cp, String city, String country) {
		
	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("UPDATE Client SET nom =? , prenom=?, no_rue=?, voie=?, code_postal=?, ville=?, pays=? WHERE id_client =?");
			
			requete.setInt(8,idclient);
			requete.setString(1,name);
			requete.setString(2,pname);
			requete.setString(3,numrue);
			requete.setString(4,rue);
			requete.setString(5,cp);
			requete.setString(6,city);
			requete.setString(7,country);
			
			requete.executeUpdate();
	
			
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ResultSet res;
		
		try {
			
			res = requete.executeQuery("select id_client , nom, prenom, no_rue, voie, code_postal, ville, pays from Client");
			
			while (res.next()) {
				
				int no_client = res.getInt(1);
				String nom = res.getString(2);
				String prenom = res.getString(3);
				String num_rue = res.getString(4);
				String voie = res.getString(5);
				String code_postal = res.getString(6);
				String ville = res.getString(7);
				String pays = res.getString(8);
				
				
				System.out.println(no_client);
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(num_rue);
				System.out.println(voie);
				System.out.println(code_postal);
				System.out.println(ville);
				System.out.println(pays);
				
				
			}
			
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
	


	public static void DeleteClient(int idclient) {
		
	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("delete from Client where id_client=?");
			requete.setInt(1, idclient);
			
			requete.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		ResultSet res;
		
		try {
			
			res = requete.executeQuery("select id_client, nom, prenom, no_rue, voie, code_postal, ville, pays from Client");
			
			while (res.next()) {
				
				int no_client = res.getInt(1);
				String nom = res.getString(2);
				String prenom = res.getString(3);
				String num_rue = res.getString(4);
				String voie = res.getString(5);
				String code_postal = res.getString(6);
				String ville = res.getString(7);
				String pays = res.getString(8);
				
				
				System.out.println(no_client);
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(num_rue);
				System.out.println(voie);
				System.out.println(code_postal);
				System.out.println(ville);
				System.out.println(pays);
				
				
			}
			
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


	public static void AddClient(int id_client, String name, String pname, String numrue, String rue, String cp, String city, String country) {
		
	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			System.out.print("connexion + preppared statement");
			
			requete = laConnexion.prepareStatement("INSERT INTO Client(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays) VALUES(?,?,?,?,?,?,?,?)");
			
			requete.setInt(1,id_client);
			requete.setString(2,name);
			requete.setString(3,pname);
			requete.setString(4,numrue);
			requete.setString(5,rue);
			requete.setString(6,cp);
			requete.setString(7,city);
			requete.setString(8,country);
			
			requete.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
				
		ResultSet res;
		try {
			
			res = requete.executeQuery("SELECT id_client, nom, prenom, no_rue, voie, code_postal, ville, pays from Client");
			System.out.print("res");
			
			while (res.next()) {
				
				System.out.print("into res next");
				
				int no_client = res.getInt(1);
				String nom = res.getString(2);
				String prenom = res.getString(3);
				String num_rue = res.getString(4);
				String voie = res.getString(5);
				String code_postal = res.getString(6);
				String ville = res.getString(7);
				String pays = res.getString(8);
				
				
				System.out.println(no_client);
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(num_rue);
				System.out.println(voie);
				System.out.println(code_postal);
				System.out.println(ville);
				System.out.println(pays);
				
				
			}
			
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
