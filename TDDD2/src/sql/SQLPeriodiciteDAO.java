package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.PeriodiciteDAO;
import metier.PeriodicitePOJO;

public class SQLPeriodiciteDAO  implements PeriodiciteDAO {
	
	private static SQLPeriodiciteDAO instance;
	
	private SQLPeriodiciteDAO() {}
	

	public static PeriodiciteDAO getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new SQLPeriodiciteDAO();
		}
		
		return instance;
	}


	@Override
	public PeriodicitePOJO getById(int id) {
		// TODO Auto-generated method stub
		
		PeriodicitePOJO period = new PeriodicitePOJO();

		
		try {
			
			Connection laConnexion = Connexion.creeConnexion();
			
			PreparedStatement requete = null;
			ResultSet res;
			
			requete = laConnexion.prepareStatement("select * from Periodicite where id_periodicite =?");			
			requete.setInt(1, id);
			
			res = requete.executeQuery();
			
			
			
			
			while (res.next()) {
				
				System.out.println("requête executée");
				
				 period.setId_periode(res.getInt(1));
				 period.setLibelle(res.getString(2));
				
				
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
		return period;
		
	}



	@Override
	public boolean create(PeriodicitePOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
	

		try {
			
			requete = laConnexion.prepareStatement("INSERT INTO Periodicite(id_periodicite,libelle) VALUES(?,?) ");			
			requete.setInt(1, objet.getId_periode());
			requete.setString(2,objet.getLibelle());
			
			
			requete.executeUpdate();
		     
			ResultSet res;
		
	
			
			res = requete.executeQuery("select * from Periodicite");
			
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
	public boolean update(PeriodicitePOJO objet) {
		// TODO Auto-generated method stub
		

	    Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		
 

		try {
			
			requete = laConnexion.prepareStatement("UPDATE Periodicite SET libelle =? where id_periodicite =? ");			
			requete.setInt(2, objet.getId_periode());
			requete.setString(1,objet.getLibelle());
			
			requete.executeUpdate();
			
		
		
				
		ResultSet res;
		
	
			
			res = requete.executeQuery("select id_periodicite, libelle from Periodicite");
			
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
	public boolean delete(PeriodicitePOJO objet) {
		// TODO Auto-generated method stub
		
		Connection laConnexion = Connexion.creeConnexion();
		
		PreparedStatement requete = null;
		


		try {
			
			requete = laConnexion.prepareStatement("delete from Periodicite where id_periodicite=?");			
			requete.setInt(1, objet.getId_periode());
			
			requete.executeUpdate();
	   			
		    ResultSet res;
		

			
			res = requete.executeQuery("select id_periodicite, libelle from Periodicite");
		
			System.out.print("row deleted");
			
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
