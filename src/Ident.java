
public abstract class Ident {


		public final static String TRUE = "-1";
		public final static String FALSE = "0";
		// Type de l'Ident
		public String type;


		/**
		 *  Constructeur
		 */
		public Ident() {

		}

		public abstract boolean isVar() ;

		public abstract boolean isConst() ;

		public abstract Integer getValue() ;

		/**
		 *  Retourne un identifiant sous forme de chaine
		 */
		public abstract String toString();

}

