import java.util.* ;


public class IdFunction extends Ident {

		public HashMap<String, Ident> params = new HashMap<String, Ident>() ;
	
		/**
		 *  Constructeur
		 */
		public IdFunction(String type) {
			this.type = type;
		}

		public boolean isVar() {
			return false ;
		}

		public boolean isConst() {
			return false ;
		}
		
		public boolean isFunction() {
			return true ;
		}

		public Integer getValue() {
			return null ;
		}
		
		public  void setValue(int val) {
			
		}
		
		public HashMap<String, Ident> getParams() {
			return params;
		}

		public Ident getParam(String s) {
			return params.get(s) ;	
		}
		
		public void addParam(String s, Ident id) {
			params.put(s, id) ;	
		}
		
		public int nbParams() {
			return params.size() * 2 ;	
		}
		
		public void sortParams() {
			Object[] sort = params.values().toArray() ;
			int[] offset = new int[sort.length]; 
			for (int i=sort.length-1 ; i>=0 ; i--) {
				offset[-(i-(sort.length-1))] = ((Ident)sort[i]).getValue() ;
			}
			for (int i=0 ; i<sort.length ; i++)
				((Ident)sort[i]).setValue(offset[i]) ;
		}
		
		/**
		 *  Retourne une variable sous forme de chaine
		 */
		public String toString() {
			String s = "FONCTION resultat : " + type + " les paramètres :" ;
			for(String key : params.keySet()) {
				Ident i = params.get(key);
				s += "\n	" + key + ", " + i.toString() ;
			}
			return s ;
		}

}

