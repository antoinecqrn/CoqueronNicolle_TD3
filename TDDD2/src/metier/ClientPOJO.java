package metier;

import java.util.ArrayList;

public class ClientPOJO {
	
	private int id_client;
	private String nom;
	private String prenom;
	private String num_rue;
	private String rue;
	private String cp;
	private String city;
	private String country;
	
	
	
	public ClientPOJO(int id_client, String nom, String prenom, String num_rue, String rue, String cp, String city,
			String country) {
		
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.num_rue = num_rue;
		this.rue = rue;
		this.cp = cp;
		this.city = city;
		this.country = country;
	}
	
	
	public ClientPOJO() {
		
	}
	
	
	public ClientPOJO (ArrayList <String> array) {
		
		try {
			if (array.size()==8) {
				
				this.id_client = Integer.parseInt(array.get(1));
				this.nom = array.get(2);
				this.prenom = array.get(3);
				this.num_rue = array.get(4);
				this.rue = array.get(5);
				this.cp = array.get(6);
				this.city = array.get(7);
				this.country = array.get(8);
				

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



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNum_rue() {
		return num_rue;
	}



	public void setNum_rue(String num_rue) {
		this.num_rue = num_rue;
	}



	public String getRue() {
		return rue;
	}



	public void setRue(String rue) {
		this.rue = rue;
	}



	public String getCp() {
		return cp;
	}



	public void setCp(String cp) {
		this.cp = cp;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	@Override
	public String toString() {
		return "Client[id_client=" + id_client + ", nom=" + nom + ", prenom=" + prenom + ", num_rue=" + num_rue
				+ ", rue=" + rue + ", cp=" + cp + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
	

}
