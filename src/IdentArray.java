
import java.util.HashMap;
import java.util.LinkedList;

public class IdentArray {   


		// Tableau des identfiants
		public static HashMap<String, Ident> identArray = new HashMap<String, Ident>();
		
		// Variables pour l'ajout d'un ident
		public static String lastIdent;
		public static String lastType;
		public static Object lastValue;
		public static int currentOffset = 0;

		
		/**
		 *  Constructeur d'un identifiant
		 */
		public IdentArray() {

		}
		
		
		/**
		 *  R�cup�ration d'un identifiant
		 */
		public static Ident get(String s) {
			if(has(s)) {
				return identArray.get(s);
			}
			else {
				return null;
			}
		}
		
		
		/**
		 *  V�rifie l'existence d'un identifiant
		 */
		public static boolean has(String s) {
			return identArray.containsKey(s);
		}
		
		
		/**
		 *  Ajout d'un identifiant
		 */
		public static void add(String s, Ident i) {
			identArray.put(s, i);
		}
		
		
		/**
		 *  Ajout d'un identifiant
		 */
		public static void shiftOffset() {
			currentOffset -= 2;
		}
		
		
		/**
		 *  Conversion en String du tableau d'identifiant
		 */
		public static String inString() {
			String s = "";
			
			for(String key : identArray.keySet()) {
				Ident i = identArray.get(key);
				s += key+", "+i.toString()+"\n";
			}
			
			return s;
		}
		
		
		/**
		 *  Lecture d'un identifiant
		 */
		public static Object ident() {
			return null;
		}
		
}

