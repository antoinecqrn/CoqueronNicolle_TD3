
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dao.RevueDAO;
import metier.RevuePOJO;

public class SQLRevueDAO  implements RevueDAO {
	
	private static SQLRevueDAO instance;
	
	private SQLRevueDAO() {}
	

	public static RevueDAO getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new SQLRevueDAO();
		}
		
		return instance;
	}


	@Override
	public RevuePOJO getById(int id) {
		// TODO Auto-generated method stub
		
		RevuePOJO rev = new RevuePOJO();

		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Revue where id_revue =?");			
			requete.setInt(1, id);
			
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				
				rev.setId_revue(res.getInt(1));
				rev.setTitle(res.getString(2));
				rev.setDescription(res.getString(3));
				rev.setTarifnum(res.getDouble(4));
				rev.setVisuel(res.getString(5));
				rev.setId_periode(res.getInt(6));
				
				
			
				
			}
			
	
	
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
	
			
		}
		
		catch (SQLException e )
		{
			System.out.println(e);
		}
		return rev;
		
	}



	@Override
	public boolean create(RevuePOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
	

		try {

			requete = laConnexion.prepareStatement("INSERT INTO Revue (id_revue, titre, description, tarif_numero, visuel, id_periodicite) VALUES (?,?,?,?,?,?)");
			
			requete.setInt(1,objet.getId_revue());
			requete.setString(2, objet.getTitle());
			requete.setString(3, objet.getDescription());
			requete.setDouble(4,objet.getTarifnum());
			requete.setString(5, objet.getVisuel());
			requete.setInt(6,objet.getId_periode());
			
			requete.executeUpdate();
			
			
		     
			ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Revue");
			
			if (res.rowInserted()) {
				return true;
			}
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
			
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			
		}
		
		return false;
	}


	@Override
	public boolean update(RevuePOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("UPDATE Revue SET titre=?, description=?, tarif_numero=?, visuel=?, id_periodicite=? WHERE id_revue =?");
			
			requete.setInt(6,objet.getId_revue());
			requete.setString(1, objet.getTitle());
			requete.setString(2, objet.getDescription());
			requete.setDouble(3,objet.getTarifnum());
			requete.setString(4, objet.getVisuel());
			requete.setInt(5,objet.getId_periode());
			
			requete.executeUpdate();
		
		
				
		ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Revue");
			
			if (res.rowUpdated()) {
				
				return true; 
			}
			
			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return false;
	}


	@Override
	public boolean delete(RevuePOJO objet) {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		


		try {
			
			requete = laConnexion.prepareStatement("delete from Revue where id_revue=?");
			requete.setInt(1, objet.getId_revue());
			
			requete.executeUpdate();
		

				
		ResultSet res;
		

			
			res = requete.executeQuery("select * from Revue");
			
			if (res.rowDeleted()) {
				
				return true;
			}

			if (res != null)
				res.close();
			
			if (requete != null)
				requete.close();
			
			if (laConnexion !=null) 
				laConnexion.close();
			
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return false;
	}




}
