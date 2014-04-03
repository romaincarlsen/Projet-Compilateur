
import java.util.HashMap;
import java.util.LinkedList;

public class IdentArray {


		// Tableau des identfiants
		public static HashMap<String, Ident> globaux = new HashMap<String, Ident>();
		public static HashMap<String, Ident> locaux = new HashMap<String, Ident>();

		// Variables pour l'ajout d'un ident
		public static String lastIdent;
		public static Integer lastType;
		public static Integer lastValue;
		public static int offsetVar = 0;
		public static int offsetParam = 2;

		public static String currentNameFunction = "";


		/**
		 *  Récupération d'un identifiant
		 */
		public static Ident getLocal(String s) {
			if(hasLocal(s)) {
				return locaux.get(s);
			}
			else {
				return null;
			}
		}

		/**
		 *  Récupération d'un identifiant
		 */
		public static Ident getGlobal(String s) {
			if(hasGlobal(s)) {
				return globaux.get(s);
			}
			else {
				return null;
			}
		}

		/**
		 *  Vérifie l'existence d'un identifiant
		 */
		public static boolean hasLocal(String s) {
			return locaux.containsKey(s);
		}

		/**
		 *  Vérifie l'existence d'un identifiant
		 */
		public static boolean hasGlobal(String s) {
			return globaux.containsKey(s);
		}

		/**
		 *  Ajout d'un identifiant global
		 */
		public static void addGlobal(String s, Ident i) {
			globaux.put(s, i);
		}

		/**
		 *  Ajout d'un identifiant local
		 */
		public static void addLocal(String s, Ident i) {
			locaux.put(s, i);
		}

		public static void addParam(String idFunction, String s, Ident param) {
			globaux.get(idFunction).addParam(s, param);
		}

		public static void sortParams(String idFunction) {
			globaux.get(idFunction).sortParams();
		}

		public static int nbVar() {
			return locaux.size() * 2;
		}

		/**
		 *  Ajout d'un identifiant
		 */
		public static void shiftOffsetVar() {
			offsetVar -= 2;
		}

		/**
		 *  Ajout d'un identifiant
		 */
		public static void shiftOffsetParam() {
			offsetParam += 2;
		}

		/**
		 *  init d'un identifiant
		 */
		public static void initOffsetVar() {
			offsetVar = 0;
		}

		/**
		 *  init d'un identifiant
		 */
		public static void initOffsetParam() {
			offsetParam = 2;
		}

		public static void cleanLocaux() {
			locaux.clear();
		}

		/**
		 *  Conversion en String du tableau d'identifiant
		 */
		public static String string() {
			String s = "";
			s += "Locaux :\n";
			for(String key : locaux.keySet()) {
				Ident i = locaux.get(key);
				s += key+", "+i.toString()+"\n";
			}
			s += "Globaux :\n";
			for(String key : globaux.keySet()) {
				Ident i = globaux.get(key);
				s += key+", "+i.toString()+"\n";
			}

			return s;
		}

}

