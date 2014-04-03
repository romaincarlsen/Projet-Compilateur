
import java.util.*;

public class Expression {

	// Pile des opérateus ET valeurs
	private static LinkedList<Integer> operatorStack = new LinkedList<Integer>();
	private static LinkedList<Integer> typeStack = new LinkedList<Integer>();


	public static void addType(int val) {
		typeStack.push(val);
	}


	public static void addOperator(int val) {
		operatorStack.push(val) ;
	}


	public static int popType() {
		return typeStack.pop() ;
	}


	public static int popOperator() {
		return operatorStack.pop() ;
	}


	public static void dualUnstack() {
		int type1 = Expression.popType();
		int operator = Expression.popOperator();
		int type2 = Expression.popType();

		try {

			int newType = dualOperandType(type1, operator, type2);

			if(newType == YakaConstants.ERROR && type1 != YakaConstants.ERROR && type2 != YakaConstants.ERROR)
				throw new ParseException("Operation de type "+YakaConstants.tokenImage[type1]+" "+YakaConstants.tokenImage[operator]+" "+YakaConstants.tokenImage[type2]+" interdite");

			else {
				Expression.addType(newType);

				// Opérateur expression
				if (operator == YakaConstants.INF)
					Yaka.Interpreter.iinf();

				else if (operator == YakaConstants.INFEGAL)
					Yaka.Interpreter.iinfegal();

				else if (operator == YakaConstants.SUP)
					Yaka.Interpreter.isup();

				else if (operator == YakaConstants.SUPEGAL)
					Yaka.Interpreter.isupegal();

				else if (operator == YakaConstants.EGAL)
					Yaka.Interpreter.iegal();

				else if (operator == YakaConstants.DIFF)
					Yaka.Interpreter.idiff();

				// Opérateur terme
				else if(operator == YakaConstants.PLUS)
					Yaka.Interpreter.iadd();

				else if (operator == YakaConstants.MOINS)
					Yaka.Interpreter.isub();

				else if (operator == YakaConstants.OU)
					Yaka.Interpreter.ior();

				// Opérateur facteur
				else if (operator == YakaConstants.MUL)
					Yaka.Interpreter.imul();

				else if (operator == YakaConstants.DIV)
					Yaka.Interpreter.idiv();

				else if(operator == YakaConstants.ET)
					Yaka.Interpreter.iand();

				else
					throw new ParseException("Operateur "+YakaConstants.tokenImage[operator]+" inattendu");
			}
		}
		catch(ParseException e) {
			MyError.report("Erreur d'expression", e);
		}
	}


	public static void singleUnstack() {
		int type = Expression.popType();
		int operator = Expression.popOperator();

		try {

			int newType = Expression.singleOperandType(operator, type);

			if(newType == YakaConstants.ERROR && type != YakaConstants.ERROR)
					throw new ParseException("Operation de type "+YakaConstants.tokenImage[operator]+" "+YakaConstants.tokenImage[type]+" interdite");

			else {
				Expression.addType(newType);

				// Opérateur facteur
				if(operator == YakaConstants.MOINS)
					Yaka.Interpreter.ineg();

				else if(operator == YakaConstants.NON)
					Yaka.Interpreter.inot();

				else
					throw new ParseException("Operateur "+YakaConstants.tokenImage[operator]+" innatendu");
			}
		}
		catch(ParseException e) {
			MyError.report("Erreur d'expression", e);
		}
	}


	public static int dualOperandType(int t1, int op, int t2) {

		// + - * OU / uniquement sur une paire d'entiers
		if(op == YakaConstants.PLUS || op == YakaConstants.MOINS || op == YakaConstants.MUL || op == YakaConstants.DIV) {
			if(t1 == YakaConstants.ENTIER && t1 == YakaConstants.ENTIER)
				return YakaConstants.ENTIER;
			else
				return YakaConstants.ERROR;
		}
		// < <= > OU > uniquement sur une paire d'entiers
		else if(op == YakaConstants.INF || op == YakaConstants.INFEGAL || op == YakaConstants.SUP || op == YakaConstants.SUPEGAL) {
			if(t1 == YakaConstants.ENTIER && t1 == YakaConstants.ENTIER)
				return YakaConstants.BOOLEEN;
			else
				return YakaConstants.ERROR;
		}
		// == OU != uniquement sur une paire d'entiers OU une paire de booléens
		else if(op == YakaConstants.EGAL || op == YakaConstants.DIFF) {
			if( (t1 == YakaConstants.ENTIER && t1 == YakaConstants.ENTIER) || (t1 == YakaConstants.BOOLEEN && t1 == YakaConstants.BOOLEEN) )
				return YakaConstants.BOOLEEN;
			else
				return YakaConstants.ERROR;
		}
		// && OU || uniquement sur une paire de booléens
		else if(op == YakaConstants.ET || op == YakaConstants.OU) {
			if(t1 == YakaConstants.BOOLEEN && t1 == YakaConstants.BOOLEEN)
				return YakaConstants.BOOLEEN;
			else
				return YakaConstants.ERROR;
		}

		return YakaConstants.ERROR;
	}


	public static int singleOperandType(int op, int t) {

		// - uniquement sur un entier
		if(op == YakaConstants.MOINS) {
			if(t == YakaConstants.ENTIER)
				return YakaConstants.ENTIER;
			else
				return YakaConstants.ERROR;
		}
		// ! uniquement sur un booléen
		else if(op == YakaConstants.NON) {
			if(t == YakaConstants.BOOLEEN)
				return YakaConstants.BOOLEEN;
			else
				return YakaConstants.ERROR;
		}

		return YakaConstants.ERROR;
	}


	public static String string() {
		String s = "" ;

		for(Integer i : typeStack)
			s += YakaConstants.tokenImage[i] + "\n" ;

		s += "\n" ;

		for(Integer i : operatorStack)
			s += YakaConstants.tokenImage[i] + "\n" ;

		return s ;
	}

}
