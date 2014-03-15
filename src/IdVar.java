
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

		public boolean isVar() {
			return true ;			
		}

		public boolean isConst() {
			return false ;			
		}
		
		public Object getValue() {
			return offset ;	
		}
		
		/**
		 *  Retourne une variable sous forme de chaine
		 */
		public String toString() {
			return "VARIABLE, "+type+", offset: "+offset;
		}

}
