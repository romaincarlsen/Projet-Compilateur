
public class IdVar extends Ident {

		// Adresse de la variable
		private Integer offset;


		/**
		 *  Constructeur
		 */
		public IdVar(Integer offset, Integer type) {
			this.offset = offset;
			this.type = type;
		}

		public boolean isVar() {
			return true ;
		}

		public boolean isConst() {
			return false ;
		}

		public Integer getValue() {
			return offset;
		}

		/**
		 *  Retourne une variable sous forme de chaine
		 */
		public String toString() {
			String pad = ""; // Pour aligner le mot ENTIER et BOOLEEN à la même colonne

			if(type.equals(YakaConstants.tokenImage[YakaConstants.ENTIER])) {
				pad = " ";
			}

			return "VARIABLE , "+type+pad+", offset : "+offset;
		}

}

