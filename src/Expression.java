
import java.util.LinkedList;

public class Expression {

	// Pile des opérateus et valeurs
	private static LinkedList<String> operatorStack = new LinkedList<String>() ;
	private static LinkedList<String> typeStack = new LinkedList<String>() ;

	/**
	 *  Constructeur
	 */
	public Expression() {

	}

	/**
	 *  Calcul l'expression
	 */
	public static double evaluate() {
		return 0.0;
	}


	/**
	 *  Lecture d'une expression (valeur operateur valeur...)
	 */
	public static Object expression() {
		return null;
	}

	public static void addType(String val) {
		typeStack.push(val);
	}

	public static void addOperator(String val) {
		operatorStack.push(val) ;
	}

	public static String popType() {
		return typeStack.pop() ;
	}

	public static String popOperator() {
		return operatorStack.pop() ;
	}

	public static String binExprReturn(String t1, String t2, String op) {
		String ent = YakaConstants.tokenImage[YakaConstants.ENTIER] ;
		String bool = YakaConstants.tokenImage[YakaConstants.BOOLEEN] ;
		String err = YakaConstants.tokenImage[YakaConstants.ERROR] ;
		String plus = YakaConstants.tokenImage[YakaConstants.PLUS] ;
		String moins = YakaConstants.tokenImage[YakaConstants.MOINS] ;
		String mul = YakaConstants.tokenImage[YakaConstants.MUL] ;
		String div = YakaConstants.tokenImage[YakaConstants.DIV] ;
		String inf =  YakaConstants.tokenImage[YakaConstants.INF] ;
		String infegal = YakaConstants.tokenImage[YakaConstants.INFEGAL] ;
		String sup = YakaConstants.tokenImage[YakaConstants.SUP] ;
		String supegal = YakaConstants.tokenImage[YakaConstants.SUPEGAL] ;
		String egal = YakaConstants.tokenImage[YakaConstants.EGAL] ;
		String diff = YakaConstants.tokenImage[YakaConstants.DIFF] ;
		String et = YakaConstants.tokenImage[YakaConstants.ET] ;
		String ou = YakaConstants.tokenImage[YakaConstants.OU] ;
		if (op == plus || op == moins || op == mul || op == div) {
			if (t1==ent && t2==ent)
				return ent ;
			else
				return err ;
		}
		if (op == inf || op == infegal || op == sup || op == supegal) {
			if (t1==ent && t2==ent)
				return bool ;
			else
			return err ;
		}
		if (op == egal || op == diff) {
			if ( (t1==ent && t2==ent) || (t1==bool && t2==bool) )
				return bool ;
			else
				return err ;
		}
		if (op == et || op == ou) {
			if (t1==bool && t2==bool)
				return bool ;
			else
				return err ;
		}
		return err ;
	}

	public static String unExprReturn(String t, String op) {
		String ent = YakaConstants.tokenImage[YakaConstants.ENTIER] ;
		String bool = YakaConstants.tokenImage[YakaConstants.BOOLEEN] ;
		String err = YakaConstants.tokenImage[YakaConstants.ERROR] ;
		if (op == YakaConstants.tokenImage[YakaConstants.MOINS]) {
			if (t==ent)
				return ent ;
			else
				return err ;
		}
		if (op == YakaConstants.tokenImage[YakaConstants.NON]) {
			if (t==bool)
				return bool ;
			else
				return err ;
		}
		return err ;
	}


	public static String inString() {
		String s = "" ;

		s += "Types Stack\n";
		for(String i : typeStack)
			s += i + "\n" ;

		s += "\n" ;

		s += "Operators Stack\n";
		for(String i : operatorStack)
			s += i + "\n" ;

		return s ;
	}


}

