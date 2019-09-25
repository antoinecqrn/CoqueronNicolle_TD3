package metier;

public class RevuePOJO {
	
	private int id_revue;
	private String title;
	private String description;
	private double tarifnum;
	private String visuel;
	private int id_periode;
	
	
	
	public RevuePOJO(int id_revue, String title, String description, double tarifnum, String visuel, int id_periode) {
		super();
		this.id_revue = id_revue;
		this.title = title;
		this.description = description;
		this.tarifnum = tarifnum;
		this.visuel = visuel;
		this.id_periode = id_periode;
	}



	public int getId_revue() {
		return id_revue;
	}



	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getTarifnum() {
		return tarifnum;
	}



	public void setTarifnum(double tarifnum) {
		this.tarifnum = tarifnum;
	}



	public String getVisuel() {
		return visuel;
	}



	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}



	public int getId_periode() {
		return id_periode;
	}



	public void setId_periode(int id_periode) {
		this.id_periode = id_periode;
	}



	@Override
	public String toString() {
		return "Revue [id_revue=" + id_revue + ", title=" + title + ", description=" + description + ", tarifnum="
				+ tarifnum + ", visuel=" + visuel + ", id_periode=" + id_periode + "]";
	} 
	
	
	
	

}
