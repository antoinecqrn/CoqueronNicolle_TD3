import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import dao.*;
import factory.*;
import metier.*;
import listememoire.*;
 


public class first {

		
public static void main(String[] args) throws ParseException {
		
		
	    System.out.println("-------------Bienvenue dans l'application CPOA TD1-------------------------");
		//start();
	    
	   
	   
//------------------------------------------------- TEST DE SQL  ---------------------------------------------------------------------------------
	    
	    
	    DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
	    
	    
//-------------------- TEST DE SQL - CLIENT-GET ---------------------------------------------------------------------------------
	    
	    ClientPOJO u = daos.getClientDAO().getById(1);
	    
	    System.out.print(u.toString());
	    
	    System.out.println("------------------------------------");
	    
//-------------------- TEST DE SQL - PERIOD - DELETE  ---------------------------------------------------------------------------------
	    
	    PeriodicitePOJO o = daos.getPeriodiciteDAO().getById(4);
	    
	    System.out.print(o.toString());
	    
	    System.out.println("------------------------------------");
	    
	    daos.getPeriodiciteDAO().delete(o);
	    
//-------------------- TEST DE SQL - ABO - ADD ET DELETE  ---------------------------------------------------------------------------------
	    
	    String sDate1="2019-09-01";  
	    
	    LocalDate d1 = LocalDate.parse(sDate1);
	    
	   
	    String sDate2="2019-11-02";  
	    LocalDate d2 = LocalDate.parse(sDate2);
	    
	    
	    AbonnementPOJO ab = new AbonnementPOJO(4,1, Date.valueOf(d1),Date.valueOf(d2));
	    daos.getAbonnementDAO().create(ab);
	    
	    System.out.print(ab.toString());
	    
	    System.out.println("------------------------------------");
	   
	    daos.getAbonnementDAO().delete(ab);
	    
	    
//-------------------- TEST DE SQL - REVUE - UPDATE ---------------------------------------------------------------------------------
	    
	    
	    
	    RevuePOJO rev2 = new RevuePOJO(1,"Le monde","journal du soir",2.5,"lemonde.jpg",1) ;
	    
	    daos.getRevueDAO().update(rev2);
	    
	    
	    System.out.print(rev2.toString());
	    
	    System.out.println("------------------------------------");
	    
//-------------------------------------------- TEST DE XML ---------------------------------------------------------------------------------
	    
	   DAOFactory daos2 = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	   System.out.println("----------------X M L --------------------");
	   
//-------------------- TEST DE XML - REVUE - ADD ---------------------------------------------------------------------------------
	    
	   RevuePOJO p = new RevuePOJO(7,"BBB","exemple",5.5,"vert",1);
	    		
	   daos2.getRevueDAO().create(p);
	    
	   System.out.print(p.toString());
	    
	    
	    
	    
	    
	    
	    
	    
	   
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
		
	}
	
	public static void start(){
		
		System.out.println("Quelle cmd voulez vous executer ? => [I]NSERT [M]ODIFY [D]ELETE ou [X] pour quitter");
		action(WaitforUserInput());
	}
	
	public static void action(String act){
	
		
		switch(act.toUpperCase()) {
			
			case "I":
				auto("insert");
				break;
			case "M":
				auto("modify");
				break;
			case "D":
				auto("delete");
				break;
			case "X":
				System.out.println("-----------------------END OF PROGRAM--------------------------------------");
				break;
			default:
				System.out.println("cette cmd n'existe pas-----------------------------------------------------");
				start();
				
				
		}
		
	}
	

	private static void auto(String x) {
		
		System.out.print("$nicolle22u - "+x+" mode - table? - ");
		String table = WaitforUserInput();
		
		if(tableverified(table) == true){
					
		request(x,table);
		
		}else {
			System.out.println("$nicolle22u - la table ["+table+"] n'existe pas.");
			auto(x);
		}
	}


	private static ArrayList<String> getfields(String table) {
	     
		 ArrayList<String> list = Table.RecupCols("nicolle22u_", table);
		return list;
	}


	private static void request(String x, String table) {
		
		switch(x) {

			case "insert":
				ExecInsert(table);
				break;
			case "delete":
				ExecDelete(table);
				break;
			case "modify":
				ExecModify(table);
				break;
		}
		
		System.out.println("Voulez vous imprimer la nouvelle table["+table+"]? [O]ui/[N]on ou [Q]uitter");
		printing(WaitforUserInput());
		
	}


	private static void ExecModify(String table) {
		
		ArrayList<String> columns = getfields(table);
		ArrayList<String> inserts = new ArrayList();
		
		for(int i=0;i < columns.size();i++) {
			
			System.out.print("$nicolle22u - [REQUETE MODIFY]["+table+"]["+columns.get(i)+"] - ");
			String neww = WaitforUserInput();
			inserts.add(neww);
				
			}
		
		if(table.equals("Periodicite")) {
			Periodicite.UpdatePeriodicite(Integer.parseInt(inserts.get(0)),inserts.get(1));
		}
		
		if(table.equals("Client")) {
				  
			Client.UpdateClient(Integer.parseInt(inserts.get(0)),inserts.get(1),inserts.get(2),inserts.get(3),inserts.get(4),inserts.get(5),inserts.get(6),inserts.get(7));
		}
		
		if(table.equals("Abonnement")) {
			  
			Abonnement.UpdateAbonnement(Integer.parseInt(inserts.get(0)),Integer.parseInt(inserts.get(1)), Date.valueOf(inserts.get(3)),Date.valueOf(inserts.get(4)));
		}
		
		if(table.equals("Revue")) {
			
			Revue.UpdateRevue(Integer.parseInt(inserts.get(0)), inserts.get(1), inserts.get(2), Double.parseDouble(inserts.get(3)), inserts.get(4), Integer.parseInt(inserts.get(5)));
			
		}
		
		
		
	}

	private static void ExecDelete(String table) {
		
		if(table.equals("Periodicite")) {
		
		Periodicite.DeletePeriodicite(Integer.parseInt(WaitforUserInput()));
		
		}
		
		if(table.equals("Client")) {
			
			Client.DeleteClient(Integer.parseInt(WaitforUserInput()));
			
			}
		
		if(table.equals("Revue")) {
			
			Revue.DeleteRevue(Integer.parseInt(WaitforUserInput()));
			
			}
		
		if(table.equals("Abonnement")) {
			
			Abonnement.DeleteAbonnement(Integer.parseInt(WaitforUserInput()));
			
			}
		
	}

	private static void ExecInsert(String table) {
		
		ArrayList<String> columns = getfields(table);
		ArrayList<String> inserts = new ArrayList();
		
		for(int i=0;i < columns.size();i++) {
			
			System.out.print("$nicolle22u - [REQUETE INSERT]["+table+"]["+columns.get(i)+"] - ");
			String neww = WaitforUserInput();
			inserts.add(neww);
				
			}
		
		if(table.equals("Periodicite")) {
			Periodicite.AddPeriodicite(Integer.parseInt(inserts.get(0)),inserts.get(1));
		}
		
		if(table.equals("Client")) {
				  
			Client.AddClient(Integer.parseInt(inserts.get(0)),inserts.get(1),inserts.get(2),inserts.get(3),inserts.get(4),inserts.get(5),inserts.get(6),inserts.get(7));
		}
		
		if(table.equals("Abonnement")) {
			  
			Abonnement.AddAbonnement(Integer.parseInt(inserts.get(0)),Integer.parseInt(inserts.get(1)), Date.valueOf(inserts.get(3)),Date.valueOf(inserts.get(4)));
		}
		
		if(table.equals("Revue")) {
			
			Revue.AddRevue(Integer.parseInt(inserts.get(0)), inserts.get(1), inserts.get(2), Double.parseDouble(inserts.get(3)), inserts.get(4), Integer.parseInt(inserts.get(5)));
			
		}
		
		
		
	}
		
	
	
	

	private static String WaitforUserInput() {
		
		Scanner scan = new Scanner(System. in);
		String print = scan.nextLine(); print.trim();
		return print;
	}

	private static void printing(String print) {
		
		if(tableverified(print) == true){
			
		}
		
	}


	private static boolean tableverified(String action) {
		
		boolean res = false;
		
		ArrayList<String> tables = Table.RecupTables();
		
		for(int i=0;i < tables.size();i++) {
			if(tables.get(i).equals(action) == true) {
				res = true;
			}
		}
		
		return res;
	}
	

	


	

}
