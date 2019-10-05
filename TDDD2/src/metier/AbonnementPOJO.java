package metier;

import java.sql.Date;

import java.util.ArrayList;
import metier.DateVerif;


public class AbonnementPOJO implements DateVerif{
	
	
	private int id_client;
	private int num_abo;
	private Date datedeb;
	private Date datefin;
	
	public AbonnementPOJO(int id_client, int num_abo, Date date, Date date2) {
		
		this.id_client = id_client;
		this.num_abo = num_abo;
		this.datedeb = date;
		this.datefin = date2;
	}
	
	public AbonnementPOJO() {
		
	}
	

	public AbonnementPOJO (ArrayList <String> array) {
		
		try {
			
			if (array.size()==4) {
				
			 this.id_client = Integer.parseInt(array.get(1));
			 this.num_abo = Integer.parseInt(array.get(2));
			 this.datedeb = java.sql.Date.valueOf(DateVerif.DateVerif(array.get(3)));
			 this.datefin = java.sql.Date.valueOf(DateVerif.DateVerif(array.get(4)));
			  
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erreur nombre d'attributs"); 
			
		}
		
		
		
		
	}


	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getNum_abo() {
		return num_abo;
	}

	public void setNum_abo(int num_abo) {
		this.num_abo = num_abo;
	}

	public Date getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	@Override
	public String toString() {
		return "Abonnement [id_client=" + id_client + ", num_abo=" + num_abo + ", datedeb=" + datedeb + ", datefin="
				+ datefin + "]";
	} 

	
	
}
