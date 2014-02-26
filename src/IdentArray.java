
import java.util.HashMap;
import java.util.LinkedList;

public class IdentArray {   


		// Tableau des identfiants
		public static HashMap<String, Ident> identArray;

		
		/**
		 *  Constructeur d'un identifiant
		 */
		public IdentArray() {
			identArray = new HashMap<String, Ident>();
		}
		
		
		/**
		 *  Récupération d'un identifiant
		 */
		public Ident get(String s) {
			return null;
		}
		
		
		/**
		 *  Vérifie l'existence d'un identifiant
		 */
		public boolean has(String s) {
			return false;
		}
		
		
		/**
		 *  Ajout d'un identifiant
		 */
		public static void add(String s) {
			identArray.put(s, new Ident());
		}
		
		
		/**
		 *  Lecture d'un identifiant
		 */
		public Object ident() {
			return null;
		}
		
}

