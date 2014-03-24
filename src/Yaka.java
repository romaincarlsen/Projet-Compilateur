/* Generated By:JavaCC: Do not edit this line. Yaka.java */
        public class Yaka implements YakaConstants {

                // Choix de l'interpreteur a utiliser
                public static String interpreterType = "YVMasm"; // YVM ou YVMasm

                // Nom du fichier a creer par l'interpreteur
                public static String scriptOutputName = "../outputs/{{FILENAME}}.asm";

                // Interpreteur
                public static YVM Interpreter;

                // Pour se souvenir s'il y a d�j� eu une erreur
                public static boolean err = false;


                // Main : point d'entree pour le compilateur
                public static void main(String args[]) {

                        Yaka analyzer;
                        java.io.InputStream input;

                        Writer.print("\u005cn"); // Juste pour un affichage plus claire

                        // Recuperation du texte/script a traiter
                        if(args.length==1) {
                                try {
                                        String pathToFile = args[args.length-1];
                                        String[] explodePath = pathToFile.split("/");

                                        // Le nom du fichier de sortie est le m�me avec l'extension ".asm" dans le dossier "outputs"
                                        scriptOutputName = scriptOutputName.replace("{{FILENAME}}", explodePath[explodePath.length - 1]);

                                        // On r�cup�re le contenu du fichier
                                        input = new java.io.FileInputStream(pathToFile+".yaka");
                                }
                                catch (java.io.FileNotFoundException e) {
                                        err = true;
                                        Writer.errorln("Fichier introuvable !\u005cn");
                                        return;
                                }
                        }
                        else if (args.length == 0) {
                                Writer.println("Lecture sur l'entree standard...\u005cn");

                                // Le nom du fichier de sortie est "test.asm" dans le dossier "outputs"
                                scriptOutputName = scriptOutputName.replace("{{FILENAME}}", "out");

                                // On r�cup�re le contenu de la console
                                input = System.in;
                        }
                        else {
                                Writer.errorln("Usage: java Gram [fichier]\u005cn");
                                return;
                        }

                        // Declaration de l'interpreteur
                        if(interpreterType.equals("YVM")) {
                                Interpreter = new YVM(scriptOutputName);
                        }
                        else if(interpreterType.equals("YVMasm")) {
                                Interpreter = new YVMasm(scriptOutputName);
                        }

                        // Analyse
                        try {

                                analyzer = new Yaka(input);
                                analyzer.analyse();

                                if(!err) {

                                        Writer.println("Analyse Syntaxique terminee !\u005cn");

                                        // On affiche le resultat du tableau d'ident
                                        //Writer.println(IdentArray.string());

                                        // On affiche le resultat du tableau d'expression
                                        //Writer.println(Expression.string()) ;

                                        // On cr�er le script YVM
                                        Interpreter.outputSave();

                                        Writer.println("Programme de sortie : "+scriptOutputName+"\u005cn");
                                }

                        }
                        catch(ParseException e) {
                                err = true;
                                TokenMgrError error = new TokenMgrError(
                                        "\u005cn"+e.getMessage()+"\u005cn",
                                        TokenMgrError.LEXICAL_ERROR
                                );
                                Writer.errorln(error.getMessage());
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
                Yaka.Interpreter.entete();
    bloc();
    jj_consume_token(FPROGRAMME);
                Yaka.Interpreter.queue();
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
                Yaka.Interpreter.ouvrePrinc(IdentArray.nbVar());
    suiteInstr();
  }

  static final public void declConst() throws ParseException {
    jj_consume_token(CONST);
    defConst();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 51:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      jj_consume_token(51);
      defConst();
    }
    jj_consume_token(52);
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
                IdentArray.lastType = tokenImage[ENTIER];
      break;
    case ident:
      jj_consume_token(ident);
                try {
                        IdConst id = (IdConst) IdentArray.get(YakaTokenManager.identLu);

                        if(id == null)
                                {if (true) throw new ParseException("Identifiant \u005c""+YakaTokenManager.identLu+"\u005c" non declare");}

                        IdentArray.lastValue = id.value;
                        IdentArray.lastType = id.type;
                }
                catch(ParseException e) {
                        err = true;
                        TokenMgrError error = new TokenMgrError(
                                "Erreur lexicale, ligne "+YakaTokenManager.currentLine+" :\u005cn"+e.getMessage()+"\u005cn",
                                TokenMgrError.LEXICAL_ERROR
                        );
                        Writer.errorln(error.getMessage());
                }
      break;
    case VRAI:
      jj_consume_token(VRAI);
                IdentArray.lastValue = Yaka.Interpreter.TRUE;
                IdentArray.lastType = tokenImage[BOOLEEN];
      break;
    case FAUX:
      jj_consume_token(FAUX);
                IdentArray.lastValue = Yaka.Interpreter.FALSE;
                IdentArray.lastType = tokenImage[BOOLEEN];
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
                IdentArray.add(
                        YakaTokenManager.identLu,
                        new IdVar(IdentArray.currentOffset, IdentArray.lastType)
                );
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 51:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      jj_consume_token(51);
      jj_consume_token(ident);
                        IdentArray.shiftOffset();
                        IdentArray.add(
                                YakaTokenManager.identLu,
                                new IdVar(IdentArray.currentOffset, IdentArray.lastType)
                        );
    }
    jj_consume_token(52);
  }

  static final public void type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ENTIER:
      jj_consume_token(ENTIER);
                IdentArray.lastType = tokenImage[ENTIER];
      break;
    case BOOLEEN:
      jj_consume_token(BOOLEEN);
                IdentArray.lastType = tokenImage[BOOLEEN];
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/**
 * Syntaxe des instructions
 */
  static final public void suiteInstr() throws ParseException {
    instruction();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 52:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_5;
      }
      jj_consume_token(52);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TANTQUE:
      case ECRIRE:
      case LIRE:
      case ALALIGNE:
      case ident:
        instruction();
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
    }
  }

  static final public void boucle() throws ParseException {
                                                // placer l'�tiquette de d�but
                                                Yaka.Interpreter.label(Iteration.genereEtiquetteDebut()) ;
    jj_consume_token(TANTQUE);
    expression();
    jj_consume_token(FAIRE);
                                                try {// v�rifier que type bool�en et �crire le ligne de test
                                                        String expr = Expression.popType();
                                                        if (expr != YakaConstants.tokenImage[YakaConstants.BOOLEEN])
                                                                {if (true) throw new ParseException("type expression attendue apr\u00e8s TANTQUE : BOOLEEN, type expression relev\u00e9e "+ expr);}
                                                        Yaka.Interpreter.iffaux(Iteration.etiquetteCouranteFin()) ;
                                                }
                                                catch(ParseException e) {
                                                        err = true;
                                                        TokenMgrError error = new TokenMgrError(
                                                                "Erreur d'\u00e9tiquette, ligne "+YakaTokenManager.currentLine+" :\u005cn"+e.getMessage()+"\u005cn",
                                                                TokenMgrError.LEXICAL_ERROR
                                                        );
                                                        Writer.errorln(error.getMessage());
                                                }
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TANTQUE:
      case ECRIRE:
      case LIRE:
      case ALALIGNE:
      case ident:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_6;
      }
      suiteInstr();
    }
                                                // placer le goto vers l'�tiquette de d�but	
                                                Yaka.Interpreter.jump(Iteration.etiquetteCouranteDebut()) ;
    jj_consume_token(FAIT);
                                                // placer l'�tiquette de fin
                                                Yaka.Interpreter.label(Iteration.genereEtiquetteFin()) ;
  }

  static final public void instruction() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ident:
      affectation();
      break;
    case LIRE:
      lecture();
      break;
    case ECRIRE:
    case ALALIGNE:
      ecriture();
      break;
    case TANTQUE:
      boucle();
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void affectation() throws ParseException {
    jj_consume_token(ident);
                Ident affectId = IdentArray.get(YakaTokenManager.identLu);
                try {
                        if(affectId.isConst())
                                {if (true) throw new ParseException("Affectation impossible sur une constante");}
                }
                catch(ParseException e) {
                        err = true;
                        TokenMgrError error = new TokenMgrError(
                                "Erreur d'affectation, ligne "+YakaTokenManager.currentLine+" :\u005cn"+e.getMessage()+"\u005cn",
                                TokenMgrError.LEXICAL_ERROR
                        );
                        Writer.errorln(error.getMessage());
                }
    jj_consume_token(EGAL);
    expression();
                Yaka.Interpreter.affect(affectId);
  }

  static final public void lecture() throws ParseException {
    jj_consume_token(LIRE);
    jj_consume_token(53);
    jj_consume_token(ident);
    jj_consume_token(54);
                Yaka.Interpreter.lireEnt(IdentArray.get(YakaTokenManager.identLu));
  }

  static final public void ecriture() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ECRIRE:
      jj_consume_token(ECRIRE);
      jj_consume_token(53);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MOINS:
      case NON:
      case VRAI:
      case FAUX:
      case entier:
      case ident:
      case 53:
        expression();
                        // Todo
                        Yaka.Interpreter.ecrireEnt();
        break;
      case chaine:
        jj_consume_token(chaine);
                        Yaka.Interpreter.ecrireChaine(YakaTokenManager.chaineLue);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(54);
      break;
    case ALALIGNE:
      jj_consume_token(ALALIGNE);
                Yaka.Interpreter.aLaLigne();
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/**
 * Expression
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
                        String t1 = Expression.popType();
                        String t2 = Expression.popType();
                        String op = Expression.popOperator();

                        String inf =  tokenImage[INF];
                        String infegal = tokenImage[INFEGAL];
                        String sup = tokenImage[SUP];
                        String supegal = tokenImage[SUPEGAL];
                        String egal = tokenImage[EGAL];
                        String diff = tokenImage[DIFF];

                        try {

                                String res = Expression.binExprReturn(t1,t2,op);

                                if(res == tokenImage[ERROR] && t1 != tokenImage[ERROR] && t2 != tokenImage[ERROR])
                                        {if (true) throw new ParseException("Operation de type "+t1+" "+op+" "+t2+" interdite");}

                                else {
                                        Expression.addType(res);

                                        if (op == inf)
                                                Yaka.Interpreter.iinf();

                                        else if (op == infegal)
                                                Yaka.Interpreter.iinfegal();

                                        else if (op == sup)
                                                Yaka.Interpreter.isup();

                                        else if (op == supegal)
                                                Yaka.Interpreter.isupegal();

                                        else if (op == egal)
                                                Yaka.Interpreter.iegal();

                                        else if (op == diff)
                                                Yaka.Interpreter.idiff();

                                        else
                                                {if (true) throw new ParseException("Operateur "+op+" inattendu");}
                                }
                        }
                        catch(ParseException e) {
                                err = true;
                                TokenMgrError error = new TokenMgrError(
                                        "Erreur d'expression, ligne "+YakaTokenManager.currentLine+" :\u005cn"+e.getMessage()+"\u005cn",
                                        TokenMgrError.LEXICAL_ERROR
                                );
                                Writer.errorln(error.getMessage());
                        }
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
  }

  static final public void simpleExpr() throws ParseException {
    terme();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MOINS:
      case OU:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_7;
      }
      opAdd();
      terme();
                        String t1 = Expression.popType();
                        String t2 = Expression.popType();
                        String op = Expression.popOperator();

                        String plus = tokenImage[PLUS];
                        String moins = tokenImage[MOINS];
                        String ou = tokenImage[OU];

                        try {

                                String res = Expression.binExprReturn(t1,t2,op);

                                if(res == tokenImage[ERROR]&& t1 != tokenImage[ERROR] && t2 != tokenImage[ERROR])
                                        {if (true) throw new ParseException("Operation de type "+t1+" "+op+" "+t2+" interdite");}

                                else {
                                        Expression.addType(res);

                                        if(op == plus)
                                                Yaka.Interpreter.iadd();

                                        else if (op == moins)
                                                Yaka.Interpreter.isub();

                                        else if (op == ou)
                                                Yaka.Interpreter.ior();

                                        else
                                                {if (true) throw new ParseException("Operateur "+op+" innatendu");}
                                }
                        }
                        catch(ParseException e) {
                                err = true;
                                TokenMgrError error = new TokenMgrError(
                                        "Erreur d'expression, ligne "+YakaTokenManager.currentLine+" :\u005cn"+e.getMessage()+"\u005cn",
                                        TokenMgrError.LEXICAL_ERROR
                                );
                                Writer.errorln(error.getMessage());
                        }
    }
  }

  static final public void terme() throws ParseException {
    facteur();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MUL:
      case DIV:
      case ET:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_8;
      }
      opMul();
      facteur();
                        String t1 = Expression.popType();
                        String t2 = Expression.popType();
                        String op = Expression.popOperator();

                        String mul = tokenImage[MUL];
                        String div = tokenImage[DIV];
                        String et = tokenImage[ET];

                        try {

                                String res = Expression.binExprReturn(t1,t2,op);

                                if(res == tokenImage[ERROR] && t1 != tokenImage[ERROR] && t2 != tokenImage[ERROR])
                                        {if (true) throw new ParseException("Operation de type "+t1+" "+op+" "+t2+" interdite");}

                                else {
                                        Expression.addType(res);

                                        if (op == mul)
                                                Yaka.Interpreter.imul();

                                        else if (op == div)
                                                Yaka.Interpreter.idiv();

                                        else if(op == et)
                                                Yaka.Interpreter.iand();

                                        else
                                                {if (true) throw new ParseException("Operateur "+op+" innatendu");}
                                }
                        }
                        catch(ParseException e) {
                                err = true;
                                TokenMgrError error = new TokenMgrError(
                                        "Erreur d'expression, ligne "+YakaTokenManager.currentLine+" :\u005cn"+e.getMessage()+"\u005cn",
                                        TokenMgrError.LEXICAL_ERROR
                                );
                                Writer.errorln(error.getMessage());
                        }
    }
  }

  static final public void facteur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VRAI:
    case FAUX:
    case entier:
    case ident:
    case 53:
      primaire();
      break;
    case MOINS:
    case NON:
      opNeg();
      primaire();
                String t = Expression.popType();
                String op = Expression.popOperator();

                try {

                        String res = Expression.unExprReturn(t, op);

                        if(res == tokenImage[ERROR] && t != tokenImage[ERROR])
                                        {if (true) throw new ParseException("Operation de type "+op+" "+t+" interdite");}

                        else {
                                Expression.addType(res);

                                if(op == tokenImage[MOINS])
                                        Yaka.Interpreter.ineg();

                                else if(op == tokenImage[NON])
                                        Yaka.Interpreter.inot();

                                else
                                        {if (true) throw new ParseException("Operateur "+op+" innatendu");}
                        }
                }
                catch(ParseException e) {
                        err = true;
                        TokenMgrError error = new TokenMgrError(
                                "Erreur d'expression, ligne "+YakaTokenManager.currentLine+" :\u005cn"+e.getMessage()+"\u005cn",
                                TokenMgrError.LEXICAL_ERROR
                        );
                        Writer.errorln(error.getMessage());
                }
      break;
    default:
      jj_la1[15] = jj_gen;
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
    case 53:
      jj_consume_token(53);
      expression();
      jj_consume_token(54);
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void valeur() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case entier:
      jj_consume_token(entier);
                Expression.addType(tokenImage[ENTIER]);
                Yaka.Interpreter.iconst(YakaTokenManager.entierLu);
      break;
    case ident:
      jj_consume_token(ident);
                try {
                        Ident id = IdentArray.get(YakaTokenManager.identLu);

                        if(id == null){
                                Expression.addType(YakaConstants.tokenImage[YakaConstants.ERROR]);
                                {if (true) throw new ParseException("Identifiant \u005c""+YakaTokenManager.identLu+"\u005c" non declare");}
                        }

                        Expression.addType(IdentArray.get(YakaTokenManager.identLu).type);

                        if(id.isVar())
                                Yaka.Interpreter.iload(id.getValue());

                        else if(id.isConst())
                                Yaka.Interpreter.iconst(id.getValue());
                }
                catch(ParseException e) {
                        err = true;
                        TokenMgrError error = new TokenMgrError(
                                "Erreur lexicale, ligne "+YakaTokenManager.currentLine+" :\u005cn"+e.getMessage()+"\u005cn",
                                TokenMgrError.LEXICAL_ERROR
                        );
                        Writer.errorln(error.getMessage());
                }
      break;
    case VRAI:
      jj_consume_token(VRAI);
                Expression.addType(tokenImage[BOOLEEN]);
                Yaka.Interpreter.iconst(Yaka.Interpreter.TRUE);
      break;
    case FAUX:
      jj_consume_token(FAUX);
                Expression.addType(tokenImage[BOOLEEN]);
                Yaka.Interpreter.iconst(Yaka.Interpreter.FALSE);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opRel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EGAL:
      jj_consume_token(EGAL);
                Expression.addOperator(tokenImage[EGAL]);
      break;
    case DIFF:
      jj_consume_token(DIFF);
                Expression.addOperator(tokenImage[DIFF]);
      break;
    case INF:
      jj_consume_token(INF);
                Expression.addOperator(tokenImage[INF]);
      break;
    case INFEGAL:
      jj_consume_token(INFEGAL);
                Expression.addOperator(tokenImage[INFEGAL]);
      break;
    case SUP:
      jj_consume_token(SUP);
                Expression.addOperator(tokenImage[SUP]);
      break;
    case SUPEGAL:
      jj_consume_token(SUPEGAL);
                Expression.addOperator(tokenImage[SUPEGAL]);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opAdd() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
                Expression.addOperator(tokenImage[PLUS]);
      break;
    case MOINS:
      jj_consume_token(MOINS);
                Expression.addOperator(tokenImage[MOINS]);
      break;
    case OU:
      jj_consume_token(OU);
                Expression.addOperator(tokenImage[OU]);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opMul() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MUL:
      jj_consume_token(MUL);
                Expression.addOperator(tokenImage[MUL]);
      break;
    case DIV:
      jj_consume_token(DIV);
                Expression.addOperator(tokenImage[DIV]);
      break;
    case ET:
      jj_consume_token(ET);
                Expression.addOperator(tokenImage[ET]);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void opNeg() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MOINS:
      jj_consume_token(MOINS);
                Expression.addOperator(tokenImage[MOINS]);
      break;
    case NON:
      jj_consume_token(NON);
                Expression.addOperator(tokenImage[NON]);
      break;
    default:
      jj_la1[21] = jj_gen;
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
  static final private int[] jj_la1 = new int[22];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x800000,0x0,0x80000000,0x0,0x20400000,0x0,0x0,0x0,0x0,0x80100200,0x0,0x3f000,0x80300,0x40c00,0x80100200,0x80000000,0x80000000,0x3f000,0x80300,0x40c00,0x100200,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x2,0x0,0x80000,0x30004,0x80000,0x0,0x100000,0x23801,0x23801,0x23801,0x270004,0x2800,0x0,0x0,0x0,0x230004,0x230004,0x30004,0x0,0x0,0x0,0x0,};
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
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(YakaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[55];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 22; i++) {
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
    for (int i = 0; i < 55; i++) {
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
