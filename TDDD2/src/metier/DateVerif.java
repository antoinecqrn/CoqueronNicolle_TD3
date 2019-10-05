package metier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateVerif   {
	
	

	public static LocalDate DateVerif(String s){


		try {
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(s, formatage);
		return date;
		}catch(Exception e){
		System.out.print("Problème de saisie de la date veuillez réssayer la requete");
		}
		return null;


		}


}
