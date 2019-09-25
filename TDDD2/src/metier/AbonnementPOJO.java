package metier;

import java.sql.Date;

public class AbonnementPOJO {
	
	
	private int id_client;
	private int num_abo;
	private Date datedeb;
	private Date datefin;
	
	public AbonnementPOJO(int id_client, int num_abo, Date datedeb, Date datefin) {
		super();
		this.id_client = id_client;
		this.num_abo = num_abo;
		this.datedeb = datedeb;
		this.datefin = datefin;
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
