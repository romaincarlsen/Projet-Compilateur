
public class IdConst extends Ident {   

		// Valeur de la constante
		public Object value;

		
		/**
		 *  Constructeur
		 */
		public IdConst(Object value, String type) {
			this.value = value;
			this.type = type;
		}

		public boolean isVar() {
			return false ;			
		}

		public boolean isConst() {
			return true ;			
		}		
		
		public Object getValue() {
			return value ;			
		}		
		
		/**
		 *  Retourne une constante sous forme de chaine
		 */
		public String toString() {
			return "CONSTANTE, "+type+", valeur="+value;
		}

}

