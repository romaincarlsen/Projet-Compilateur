/* Generated By:JavaCC: Do not edit this line. Yaka.java */
public class Yaka implements YakaConstants {

        public static void main(String args[]) {
                Yaka analyseur;
                java.io.InputStream input;

                if (args.length==1) {
                        System.out.print(args[args.length-1] + ": ");
                        try {
                                input = new java.io.FileInputStream(args[args.length-1]+".yaka");
                        }
                        catch (java.io.FileNotFoundException e) {
                                System.out.println("Fichier introuvable.");
                        return;
                        }
                }
                else if (args.length==0) {
                        System.out.println("Lecture sur l'entree standard...");
                        input = System.in;
                }
                else {
                        System.out.println("Usage: java Gram [fichier]");
                        return;
                }
                try {
                        analyseur = new Yaka(input);
                        analyseur.analyse();
                        System.out.println("analyse syntaxique reussie!");
                        System.out.println(IdentArray.inString());
                        System.out.println(Expression.inString()) ;
                }
                catch (ParseException e) {
                        String msg = e.getMessage();
                        msg = msg.substring(0,msg.indexOf("\u005cn"));
                        System.out.println("Erreur de syntaxe : "+msg);
                }
        }


        /**
	 *  Lecture d'un programme
	 */
        public void prog() {

        }

/**************************************/
/********debut de la grammaire ********/
/**************************************/
  static final public void analyse() throws ParseException {
    jj_consume_token(PROGRAMME);
    jj_consume_token(ident);
    bloc();
    jj_consume_token(FPROGRAMME);
  }

  static final public void bloc() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CONST:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      declConst();
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      declVar();
    }
    suiteExpr();
  }

  static final public void declConst() throws ParseException {
    jj_consume_token(CONST);
    defConst();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 50:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      jj_consume_token(50);
      defConst();
    }
    jj_consume_token(51);
  }

  static final public void defConst() throws ParseException {
    jj_consume_token(ident);
                             IdentArray.lastIdent = YakaTokenManager.identLu;
    jj_consume_token(EGAL);
    valConst();
     IdentArray.add(IdentArray.lastIdent, new IdConst(IdentArray.lastValue, IdentArray.lastType));
  }

  static final public void valConst() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
          IdentArray.lastValue = YakaTokenManager.entierLu;
          IdentArray.lastType = YakaConstants.tokenImage[ENTIER];
      break;
    case ident:
      jj_consume_token(ident);
         IdConst i = (IdConst) IdentArray.get(YakaTokenManager.identLu);
         if(i != null) {
                 IdentArray.lastValue = i.value;
                 IdentArray.lastType = i.type;
         }
         else {
                 TokenMgrError error = new TokenMgrError("Error : "+YakaTokenManager.identLu+" ident not found", TokenMgrError.LEXICAL_ERROR);
                 System.err.println(error.getMessage());
         }
      break;
    case VRAI:
      jj_consume_token(VRAI);
         IdentArray.lastValue = YakaConstants.tokenImage[VRAI];
         IdentArray.lastType = YakaConstants.tokenImage[BOOLEEN];
      break;
    case FAUX:
      jj_consume_token(FAUX);
         IdentArray.lastValue = YakaConstants.tokenImage[FAUX];
         IdentArray.lastType = YakaConstants.tokenImage[BOOLEEN];
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void declVar() throws ParseException {
    jj_consume_token(VAR);
    type();
    jj_consume_token(ident);
          IdentArray.shiftOffset();
          IdentArray.add(YakaTokenManager.identLu, new IdVar(IdentArray.currentOffset, IdentArray.lastType));
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 50:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      jj_consume_token(50);
      jj_consume_token(ident);
                  IdentArray.shiftOffset();
                  IdentArray.add(YakaTokenManager.identLu, new IdVar(IdentArray.currentOffset, IdentArray.lastType));
    }
    jj_consume_token(51);
  }

  static final public void type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ENTIER:
      jj_consume_token(ENTIER);
               IdentArray.lastType = YakaConstants.tokenImage[ENTIER];
      break;
    case BOOLEEN:
      jj_consume_token(BOOLEEN);
                IdentArray.lastType = YakaConstants.tokenImage[BOOLEEN];
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*
 * Syntaxe des instructions.
 */
  static final public void suiteExpr() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MOINS:
    case NON:
    case VRAI:
    case FAUX:
    case entier:
    case ident:
    case 52:
      expression();
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 51:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_5;
        }
        jj_consume_token(51);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MOINS:
        case NON:
        case VRAI:
        case FAUX:
        case entier:
        case ident:
        case 52:
          expression();
          break;
        default:
          jj_la1[7] = jj_gen;
          ;
        }
      }
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
  }

/*
 * Expression .
 */
  static final public void expression() throws ParseException {
    simpleExpr();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INF:
    case SUP:
    case INFEGAL:
    case SUPEGAL:
    case EGAL:
    case DIFF:
      opRel();
      simpleExpr();
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
  }

  static final public void simpleExpr() throws ParseException {
    terme();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MOINS:
      case OU:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_6;
      }
      opAdd();
      terme();
    }
  }

  static final public void terme() throws ParseException {
    facteur();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
      case DIV:
      case ET:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_7;
      }
      opMul();
      facteur();
    }
  }

  static final public void facteur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
    case 52:
      primaire();
      break;
    case MOINS:
    case NON:
      opNeg();
      primaire();
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void primaire() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
      valeur();
      break;
    case 52:
      jj_consume_token(52);
      expression();
      jj_consume_token(53);
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void valeur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
                 Expression.addType("\u005c"ENTIER\u005c"");
      break;
    case ident:
      jj_consume_token(ident);
                 Expression.addType(IdentArray.get(YakaTokenManager.identLu).type);
      break;
    case VRAI:
      jj_consume_token(VRAI);
                 Expression.addType("\u005c"BOOLEEN\u005c"");
      break;
    case FAUX:
      jj_consume_token(FAUX);
                 Expression.addType("\u005c"BOOLEEN\u005c"");
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opRel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EGAL:
      jj_consume_token(EGAL);
                 Expression.addOperator(YakaConstants.tokenImage[EGAL]) ;
      break;
    case DIFF:
      jj_consume_token(DIFF);
                 Expression.addOperator(YakaConstants.tokenImage[DIFF]) ;
      break;
    case INF:
      jj_consume_token(INF);
                 Expression.addOperator(YakaConstants.tokenImage[INF]) ;
      break;
    case INFEGAL:
      jj_consume_token(INFEGAL);
                 Expression.addOperator(YakaConstants.tokenImage[INFEGAL]) ;
      break;
    case SUP:
      jj_consume_token(SUP);
                 Expression.addOperator(YakaConstants.tokenImage[SUP]) ;
      break;
    case SUPEGAL:
      jj_consume_token(SUPEGAL);
                 Expression.addOperator(YakaConstants.tokenImage[SUPEGAL]) ;
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opAdd() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
                 Expression.addOperator(YakaConstants.tokenImage[PLUS]) ;
      break;
    case MOINS:
      jj_consume_token(MOINS);
                 Expression.addOperator(YakaConstants.tokenImage[MOINS]) ;
      break;
    case OU:
      jj_consume_token(OU);
                 Expression.addOperator(YakaConstants.tokenImage[OU]) ;
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opMul() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MUL:
      jj_consume_token(MUL);
                 Expression.addOperator(YakaConstants.tokenImage[MUL]) ;
      break;
    case DIV:
      jj_consume_token(DIV);
                 Expression.addOperator(YakaConstants.tokenImage[DIV]) ;
      break;
    case ET:
      jj_consume_token(ET);
                 Expression.addOperator(YakaConstants.tokenImage[ET]) ;
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opNeg() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MOINS:
      jj_consume_token(MOINS);
                 Expression.addOperator(YakaConstants.tokenImage[MOINS]) ;
      break;
    case NON:
      jj_consume_token(NON);
                 Expression.addOperator(YakaConstants.tokenImage[NON]) ;
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public YakaTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[19];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x400000,0x0,0x40000000,0x0,0x10200000,0x0,0x40100200,0x40100200,0x3f000,0x80300,0x40c00,0x40100200,0x40000000,0x40000000,0x3f000,0x80300,0x40c00,0x100200,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1,0x0,0x40000,0x14002,0x40000,0x0,0x80000,0x114002,0x114002,0x0,0x0,0x0,0x114002,0x114002,0x14002,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public Yaka(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Yaka(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new YakaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Yaka(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new YakaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Yaka(YakaTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(YakaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[54];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 19; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 54; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
