package metier;

import java.util.ArrayList;

public class PeriodicitePOJO{
	
	private int id_periode;
	private String libelle ;
	
	
	
	
	
	public PeriodicitePOJO(int id_periode, String libelle) {
		
		this.id_periode = id_periode;
		this.libelle = libelle;
	}
	
	public PeriodicitePOJO() {
		
	}
	
	
	public PeriodicitePOJO(ArrayList <String> array) {
		
		try {
			
			if (array.size() == 2) {
			this.id_periode = Integer.parseInt(array.get(1));
			this.libelle = array.get(2);
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public PeriodicitePOJO( String libelle) {
		
		
		this(-1, libelle);
	}
	
	public int getId_periode() {
		return id_periode;
	}
	
	public void setId_periode(int id_periode) {
		this.id_periode = id_periode;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		
		if (libelle==null || libelle.trim().length()==0) {
			
			throw new IllegalArgumentException("Libelle vide!") ;
			
		}
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Periodicite [id_periode=" + id_periode + ", libelle=" + libelle + "]";
	} 
	
	

}
