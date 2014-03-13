
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
	
	public static String inString() {
		String s = "" ;
		for(String i : typeStack)
			s += i + "\n" ;
		s += "\n" ;
		for(String i : operatorStack)
			s += i + "\n" ;
		return s ;
	}
	

}

