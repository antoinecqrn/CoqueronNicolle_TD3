
package sql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dao.AbonnementDAO;
import metier.AbonnementPOJO;

public class SQLAbonnementDAO  implements AbonnementDAO {
	
	private static SQLAbonnementDAO instance;
	
	private SQLAbonnementDAO() {}
	

	public static AbonnementDAO getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new SQLAbonnementDAO();
		}
		
		return instance;
	}


	@Override
	public AbonnementPOJO getById(int id1, int id2) {
		// TODO Auto-generated method stub
		
		AbonnementPOJO abo = new AbonnementPOJO();

		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Abonnement where id_client =? and id_revue=? ");			
			requete.setInt(1, id1);
			requete.setInt(2, id2);
			
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				abo.setId_client(res.getInt(1));
				abo.setNum_abo(res.getInt(2));
				abo.setDatedeb(res.getDate(3));
				abo.setDatefin(res.getDate(4));
			
				
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
		return abo;
		
	}



	@Override
	public boolean create(AbonnementPOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
	

		try {

			requete = laConnexion.prepareStatement("INSERT INTO Abonnement(id_client, id_revue, date_debut, date_fin) VALUES (?,?,?,?) ");
			requete.setInt(1, objet.getId_client());
			requete.setInt(2, objet.getNum_abo());
			requete.setDate(3, objet.getDatedeb());
			requete.setDate(4, objet.getDatefin());
			
			requete.executeUpdate(); 
		     
			ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Abonnement");

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
	public boolean update(AbonnementPOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			
			requete = laConnexion.prepareStatement("UPDATE Abonnement SET  date_deb =?, date_fin =? WHERE id_client =? AND id_revue =?  ");
			requete.setInt(3, objet.getId_client());
			requete.setInt(4, objet.getNum_abo());
			requete.setDate(1,  objet.getDatedeb());
			requete.setDate(2,  objet.getDatefin());
			
			requete.executeUpdate(); 
		
		
				
		ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Abonnement");
			

			
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
	public boolean delete(AbonnementPOJO objet) {
		// TODO Auto-generated method stub
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		


		try {


			requete = laConnexion.prepareStatement("delete from Abonnement where id_client=? and id_revue = ");
			requete.setInt(1, objet.getId_client());
			requete.setInt(2,objet.getNum_abo());
			requete.executeUpdate(); 
				
		ResultSet res;
		

			
			res = requete.executeQuery("select * from Abonnement");
		

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

