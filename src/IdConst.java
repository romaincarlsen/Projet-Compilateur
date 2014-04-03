import java.util.* ;

public class IdConst extends Ident {

		// Valeur de la constante
		public Integer value;


		/**
		 *  Constructeur
		 */
		public IdConst(Integer value, Integer type) {
			super(type);
			this.value = value;
		}

		public boolean isVar() {
			return false ;
		}

		public boolean isConst() {
			return true ;
		}

		public boolean isFunction() {
			return false ;
		}

		public Integer getValue() {
			return value ;
		}

		public  void setValue(int val) {
			value = val ;
		}

		public HashMap<String, Ident> getParams() {
			return null;
		}

		public Ident getParam(String s) {
			return null ;
		}

		public void addParam(String s, Ident id) {

		}

		public int nbParams() {
			return 0 ;
		}

		public void sortParams() {
			// null
		}

		/**
		 *  Retourne une constante sous forme de chaine
		 */
		public String toString() {
			String pad = ""; // Pour aligner le mot ENTIER et BOOLEEN à la même colonne
			String means = ""; // Pour précisé la nature du booléen

			if(type == YakaConstants.ENTIER) {
				pad = " ";
			}
			else if(type == YakaConstants.BOOLEEN) {
				if(value == -1) {
					means = " (VRAI)";
				}
				else if(value == 0) {
					means = " (FAUX)";
				}
			}

			return "CONSTANTE, "+type+pad+", valeur = "+value+means;
		}

}

