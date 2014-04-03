import java.util.*;

public abstract class Ident {


		public final static String TRUE = "-1";
		public final static String FALSE = "0";
		protected Integer type;


		/**
		 *  Constructeur
		 */
		public Ident(Integer type) {
			this.type = type;
		}

		public Integer getType() {
			return type;
		}

		public abstract boolean isVar();

		public abstract boolean isConst();

		public abstract boolean isFunction();

		public abstract Integer getValue();

		public abstract void setValue(int val);

		public abstract HashMap<String, Ident> getParams();

		public abstract Ident getParam(String s);

		public abstract void addParam(String s, Ident id);

		public abstract int nbParams();

		public abstract void sortParams();

		/**
		 *  Retourne un identifiant sous forme de chaine
		 */
		public abstract String toString();

}

