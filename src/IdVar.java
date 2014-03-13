
public class IdVar extends Ident {   

		// Adresse de la variable
		private int offset;


		/**
		 *  Constructeur
		 */
		public IdVar(int offset, String type) {
			this.offset = offset;
			this.type = type;
		}


		/**
		 *  Retourne une variable sous forme de chaine
		 */
		public String toString() {
			return "VARIABLE, "+type+", offset: "+offset;
		}

}

