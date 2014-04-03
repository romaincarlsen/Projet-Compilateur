
public abstract class Ident {


		public final static String TRUE = "-1";
		public final static String FALSE = "0";
		public Integer type;

		public Integer getType() {
			return type;
		}

		public abstract boolean isVar();

		public abstract boolean isConst();

		public abstract Integer getValue();

		/**
		 *  Retourne un identifiant sous forme de chaine
		 */
		public abstract String toString();

}

