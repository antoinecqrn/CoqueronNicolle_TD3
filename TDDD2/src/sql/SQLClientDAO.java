
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dao.ClientDAO;
import metier.ClientPOJO;

public class SQLClientDAO  implements ClientDAO {
	
	private static SQLClientDAO instance;
	
	private SQLClientDAO() {}
	

	public static ClientDAO getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new SQLClientDAO();
		}
		
		return instance;
	}


	@Override
	public ClientPOJO getById(int id) {
		// TODO Auto-generated method stub
		
		ClientPOJO cli = null;

		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Client where id_client =?");			
			requete.setInt(1, id);
			
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
			
				return cli;
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
		return cli;
		
	}



	@Override
	public boolean create(ClientPOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
	

		try {
			
			requete = laConnexion.prepareStatement("INSERT INTO Client(id_client, nom, prenom, no_rue, voie, code_postal, ville, pays) VALUES(?,?,?,?,?,?,?,?)");
			
			requete.setInt(1,objet.getId_client());
			requete.setString(2,objet.getNom());
			requete.setString(3,objet.getPrenom());
			requete.setString(4,objet.getNum_rue());
			requete.setString(5,objet.getRue());
			requete.setString(6,objet.getCp());
			requete.setString(7,objet.getCity());
			requete.setString(8,objet.getCountry());
			
			requete.executeUpdate();
			
		     
			ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Client");
			
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
	public boolean update(ClientPOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			
			requete = laConnexion.prepareStatement("UPDATE Client SET nom =? , prenom=?, no_rue=?, voie=?, code_postal=?, ville=?, pays=? WHERE id_client =?");
			
			requete.setInt(8,objet.getId_client());
			requete.setString(1,objet.getNom());
			requete.setString(2,objet.getPrenom());
			requete.setString(3,objet.getNum_rue());
			requete.setString(4,objet.getRue());
			requete.setString(5,objet.getCp());
			requete.setString(6,objet.getCity());
			requete.setString(7,objet.getCountry());
			
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
	public boolean delete(ClientPOJO objet) {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		


		try {

			requete = laConnexion.prepareStatement("delete from Client where id_client=?");
			requete.setInt(1, objet.getId_client());
			
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

