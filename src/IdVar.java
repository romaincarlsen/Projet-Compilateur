import java.util.* ;

public class IdVar extends Ident {

		// Adresse de la variable
		private Integer offset;


		/**
		 *  Constructeur
		 */
		public IdVar(Integer offset, String type) {
			this.offset = offset;
			this.type = type;
		}

		public boolean isVar() {
			return true ;
		}

		public boolean isConst() {
			return false ;
		}
		
		public boolean isFunction() {
			return false ;
		}
		

		public Integer getValue() {
			return offset;
		}
		
		public  void setValue(int val) {
			offset = val ;
		}
		
		public HashMap<String, Ident> getParams() {
			return null ;
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

