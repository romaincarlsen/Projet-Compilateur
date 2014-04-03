
public class IdConst extends Ident {

		// Valeur de la constante
		public Integer value;


		/**
		 *  Constructeur
		 */
		public IdConst(Integer value, Integer type) {
			this.value = value;
			this.type = type;
		}

		public boolean isVar() {
			return false ;
		}

		public boolean isConst() {
			return true ;
		}

		public Integer getValue() {
			return value ;
		}

		/**
		 *  Retourne une constante sous forme de chaine
		 */
		public String toString() {
			String means = ""; // Pour précisé la nature du booléen
			String pad = ""; // Pour aligner le mot ENTIER et BOOLEEN à la même colonne

			if(type.equals(YakaConstants.tokenImage[YakaConstants.ENTIER])) {
				pad = " ";
			}

			if(value == -1) {
				means = " (VRAI)";
			}
			else if(value == 0) {
				means = " (FAUX)";
			}

			return "CONSTANTE, "+type+pad+", valeur = "+value+means;
		}

}

