
import java.util.*;

public class Expression {

	// Pile des opérateus et valeurs
	private static LinkedList<String> operatorStack = new LinkedList<String>();
	private static LinkedList<String> typeStack = new LinkedList<String>();


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


	public static String dualOperandType(String t1, String op, String t2) {
		String ent = YakaConstants.tokenImage[YakaConstants.ENTIER];
		String bool = YakaConstants.tokenImage[YakaConstants.BOOLEEN];
		String err = YakaConstants.tokenImage[YakaConstants.ERROR];

		String plus = YakaConstants.tokenImage[YakaConstants.PLUS];
		String moins = YakaConstants.tokenImage[YakaConstants.MOINS];
		String mul = YakaConstants.tokenImage[YakaConstants.MUL];
		String div = YakaConstants.tokenImage[YakaConstants.DIV];
		String inf =  YakaConstants.tokenImage[YakaConstants.INF];
		String infegal = YakaConstants.tokenImage[YakaConstants.INFEGAL];
		String sup = YakaConstants.tokenImage[YakaConstants.SUP];
		String supegal = YakaConstants.tokenImage[YakaConstants.SUPEGAL];
		String egal = YakaConstants.tokenImage[YakaConstants.EGAL];
		String diff = YakaConstants.tokenImage[YakaConstants.DIFF];
		String et = YakaConstants.tokenImage[YakaConstants.ET];
		String ou = YakaConstants.tokenImage[YakaConstants.OU];

		// + - * ou / uniquement sur une paire d'entiers
		if(op == plus || op == moins || op == mul || op == div) {
			if(t1 == ent && t2 == ent)
				return ent;
			else
				return err;
		}
		// < <= > ou > uniquement sur une paire d'entiers
		else if(op == inf || op == infegal || op == sup || op == supegal) {
			if(t1 == ent && t2 == ent)
				return bool ;
			else
				return err;
		}
		// == ou != uniquement sur une paire d'entiers ou une paire de booléens
		else if(op == egal || op == diff) {
			if( (t1 == ent && t2 == ent) || (t1 == bool && t2 == bool) )
				return bool;
			else
				return err;
		}
		// && ou || uniquement sur une paire de booléens
		else if(op == et || op == ou) {
			if(t1 == bool && t2 == bool)
				return bool;
			else
				return err;
		}

		return err;
	}


	public static String singleOperandType(String op, String t) {
		String ent = YakaConstants.tokenImage[YakaConstants.ENTIER];
		String bool = YakaConstants.tokenImage[YakaConstants.BOOLEEN];
		String err = YakaConstants.tokenImage[YakaConstants.ERROR];

		String moins = YakaConstants.tokenImage[YakaConstants.MOINS];
		String non = YakaConstants.tokenImage[YakaConstants.NON];

		// - uniquement sur un entier
		if(op == moins) {
			if(t == ent)
				return ent;
			else
				return err;
		}
		// ! uniquement sur un booléen
		else if(op == non) {
			if(t == bool)
				return bool;
			else
				return err;
		}

		return err;
	}


	public static String string() {
		String s = "" ;

		for(String i : typeStack)
			s += i + "\n" ;

		s += "\n" ;

		for(String i : operatorStack)
			s += i + "\n" ;

		return s ;
	}

}
