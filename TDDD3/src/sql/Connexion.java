package sql;
import java.sql.*;

public class Connexion {
	
	public static Connection creeConnexion() {
		
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/nicolle22u_"; 
		url += "?serverTimezone=Europe/Paris";
		String login = "nicolle22u_appli";
		String pwd = "_-_-_";
		Connection maConnexion = null;
		
		try {
		maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle) {
		System.out.println("Erreur connexion" + sqle.getMessage()); }
		
		
		return maConnexion; }

}
