
import java.util.*;

public class Iteration {

	private static LinkedList<Integer> etiquetteStack = new LinkedList<Integer>();
	private static LinkedList<Integer> etiquetteUsed = new LinkedList<Integer>();
		
	/**
	 *  Constructeur
	 */
	public Iteration() {
		
	} 

	
	/**
	 *  Lecture d'une itération
	 */
	public void iteration() {
		
	}
	
	public static String genereEtiquetteDebut() {
		int i = 0 ;
		while (etiquetteUsed.contains(i)) {
			i++ ;	
		}
		etiquetteUsed.push(i) ;
		etiquetteStack.push(i) ;
		return "FAIRE"+i ;	
	}
	
	public static String etiquetteCouranteDebut() throws ParseException {
		if (etiquetteStack.isEmpty())
			throw new ParseException("erreur etiquettes");
		return "FAIRE"+etiquetteStack.getFirst() ;
	}
	
	
	public static String genereEtiquetteFin() {
		return "FAIT"+etiquetteStack.pop();
	}
	
	public static String etiquetteCouranteFin() throws ParseException {
		if (etiquetteStack.isEmpty())
			throw new ParseException("erreur etiquettes");
		return "FAIT"+etiquetteStack.getFirst() ;
	}

}

