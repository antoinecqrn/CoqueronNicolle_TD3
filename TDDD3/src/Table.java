import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Table {
	
	
	public static ArrayList<String> RecupCols(String idbase, String idtable) {
	
	
    Connection laConnexion = Connexion.creeConnexion();
	PreparedStatement requete = null;
	
	ArrayList<String> columns = new ArrayList();
	
	try {
		
		requete = laConnexion.prepareStatement("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?");			
		requete.setString(1, idbase);
		requete.setString(2, idtable);
		
		
	     

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

			
	ResultSet res;
	
	try {
		
		res = requete.executeQuery();
		
		while (res.next()) {
			
			
			String lib = res.getString("COLUMN_NAME");
			columns.add(lib);
			
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
	return columns;
	}
	
	public static ArrayList<String> RecupTables(){
		
		
	    Connection laConnexion = Connexion.creeConnexion();
		PreparedStatement requete = null;
		
		ArrayList<String> tables = new ArrayList();
		
	
		try {
			
			requete = laConnexion.prepareStatement("SHOW TABLES");			
	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				
		ResultSet res;
		
		try {
			
			res = requete.executeQuery();
			
			while (res.next()) {
				
				
				String lib = res.getString("Tables_in_nicolle22u_");
				tables.add(lib);
				
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
		  return tables;
		}
}


