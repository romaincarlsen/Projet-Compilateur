
public class YVMasm extends YVM {

	private String data = "";
	private int dataCpt = 0;


	// Création d'un nouveau fichier pour l'enregistrement de la compilation
	public YVMasm(String filename) {
		super(filename);
	}



	// Fonction de sauvegarde du résulat dans le fichier de sortie
	@Override
	public void outputSave() {
		Writer.write(script, header+data+code+footer);
		Writer.close(script);
	}



	// Instructions début/fin
	@Override
	public void entete() {
		header += "; entete\n";
		header += ".MODEL SMALL\n";
		header += "\t.586\n";
		header += "\n";
		code += ".CODE\n";
		code += "debut:\n";
		code += " \tSTARTUPCODE\n";
		code += "\n";
	}

	@Override
	public void queue() {
		footer += "; queue\n";
		footer += "\tnop\n";
		footer += "\texitcode\n";
		footer += "\tEND debut\n";
	}



	// Instructions arithmétiques
	@Override
	public void affect(Ident id) {
		code += "; istore "+Integer.toString(id.getValue())+"\n";
		code += "\tpop ax\n";
		code += "\tmove word ptr [bp"+Integer.toString(id.getValue())+"], ax\n";
		code += "\n";
	}

	@Override
	public void iadd() {
		code += "; iadd\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tadd ax, bx\n";
		code += "\tpush ax\n";
		code += "\n";
	}

	@Override
	public void isub() {
		code += "; isub\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tsub ax, bx\n";
		code += "\tpush ax\n";
		code += "\n";
	}

	@Override
	public void imul() {
		code += "; imul\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\timul bx\n";
		code += "\tpush ax\n";
		code += "\n";
	}

	@Override
	public void idiv() {
		code += "; idiv\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcwd\n";
		code += "\tidiv bx\n";
		code += "\tpush ax\n";
		code += "\n";
	}

	@Override
	public void inot() {
		code += "; inot\n";
		code += "\tpop ax\n";
		code += "\tnot ax\n";
		code += "\tpush ax\n";
		/*code += "\tpop ax\n";
		code += "\tcmp ax, "+Integer.toString(TRUE)+"\n";
		code += "\tjne $+3\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\tjmp $+2\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";*/
		code += "\n";
	}

	@Override
	public void ineg() {
		code += "; ineg\n";
		code += "\tpop ax\n";
		code += "\tneg ax\n";
		code += "\tpush ax\n";
		/*code += "\tpop bx\n";
		code += "\tpush -1\n";
		code += "\timul bx\n";
		code += "\tpush ax\n";*/
		code += "\n";
	}

	@Override
	public void ior() {
		code += "; ior\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tor ax, bx\n";
		code += "\tpush ax\n";
		/*code += "\tpop ax\n";
		code += "\tcmp ax, "+Integer.toString(TRUE)+"\n";
		code += "\tjne $+3\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+7\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, "+Integer.toString(TRUE)+"\n";
		code += "\tjne $+3\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+2\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";*/
		code += "\n";

	}

	@Override
	public void iand() {
		code += "; iand\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tand ax, bx\n";
		code += "\tpush ax\n";
		/*code += "\tpop ax\n";
		code += "\tcmp ax, "+Integer.toString(FALSE)+"\n";
		code += "\tjne $+3\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\tjmp $+7\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, "+Integer.toString(FALSE)+"\n";
		code += "\tjne $+3\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\tjmp $+2\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";*/
		code += "\n";
	}



	// Instructions de comparaisons
	@Override
	public void iinf() {
		code += "; iinf\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tjge $+3\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+2\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}

	@Override
	public void isup() {
		code += "; isup\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tjle $+3\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+2\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}

	@Override
	public void iinfegal() {
		code += "; iinfegal\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tjg $+3\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+2\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}

	@Override
	public void isupegal() {
		code += "; isupegal\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tjl $+3\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+2\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}

	@Override
	public void iegal() {
		code += "; iegal\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tjne $+3\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+2\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}

	@Override
	public void idiff() {
		code += "; idiff\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tje $+3\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+2\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}



	// Instructions de stockage et de chargement
	@Override
	public void iload(int offset) {
		code += "; iload "+offset+"\n";
		code += "\tpush word ptr [bp"+offset+"]\n";
		code += "\n";
	}

	@Override
	public void istore(int offset) {
		code += "; istore "+offset+"\n";
		code += "\tpop ax\n";
		code += "\tmov word ptr [bp"+offset+"], ax\n";
		code += "\n";
	}

	@Override
	public void iconst(int valeur) {
		code += "; iconst "+valeur+"\n";
		code += "\tpush "+valeur+"\n";
		code += "\n";
	}



	// Instructions de controle de flot
	@Override
	public void ifeq(String label) {
		code += "; ifeq\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, 0\n";
		code += "\tje "+label+"\n";
		code += "\n";

	}

	@Override
	public void iffaux(String label) {
		code += "; iffaux\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, "+Integer.toString(FALSE)+"\n";
		code += "\tje "+label+"\n";
		code += "\n";
	}

	@Override
	public void jump(String label) {
		code += "; jump "+label+"\n";
		code += "\tjmp "+label+"\n";
		code += "\n";
	}


	// Instructions de pile
	@Override
	public void ouvrePrinc(int slot) {
		code += "; ouvrePrinc "+slot+"\n";
		code += "\tmov bp, sp\n";
		code += "\tsub sp, "+slot+"\n";
		code += "\n";
	}


	// Insctructions d'écriture
	public void ecrireChaine(String s) {
		// Todo : faire un tableau des bibliothèques à charger (ne pas ajouter si déjà existant)

		String msgName = "mess"+Integer.toString(dataCpt);
		data += msgName+" DB \""+s+"$\"";
		dataCpt++;

		code += "; ecrireChaine \""+s+"\""+"\n";
		code += "\tlea dx, "+msgName+"\n";
		code += "\tpush dx\n";
		code += "\tcall ecrch\n";
		code += "\n";
	}

	public void ecrireEnt(Ident id) {
		// Entier ou booléen
		// Todo : faire un tableau des bibliothèques à charger (ne pas ajouter si déjà existant)

		/*data += "mess"+Integer.toString(dataCpt)+" DB \""+s+"$\"";
		dataCpt++;*/

		code += "\t"+"iload "+id.getValue()+"\n";
		code += "\t"+"ecrireEnt"+"\n";
	}

	public void aLaLigne() {
		// Todo
		code += "\t"+"aLaLigne"+"\n";
	}


	// Insctructions de lecture
	public void lireEnt(Ident id) {
		// Todo
		code += "\t"+"lireEnt "+id.getValue()+"\n";
	}

}
