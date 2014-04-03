
import java.util.ArrayList;

public class YVMasm extends YVM {

	// Nom du fichier a creer par l'interpreteur
	private static final String asmOutputFileame = "../outputs/{{FILENAME}}.asm";

	// Liste des librairies qui seront à importer
	private ArrayList<String> libraries = new ArrayList<String>();

	// Liste des données qui seront à mettre dans le .DATA
	private ArrayList<String> data = new ArrayList<String>();



	// Création d'un nouveau fichier pour l'enregistrement de la compilation
	public YVMasm(String inputFilename) {
		super(inputFilename, asmOutputFileame);
	}



	// Fonction de sauvegarde du résulat dans le fichier de sortie
	@Override
	public void outputSave() {

		// On génère les données
		String dataStr = "";
		for(int i = 0; i < data.size(); i++) {
			dataStr += data.get(i);
		}
		if(data.size() > 0) {
			dataStr = ".DATA\n" + dataStr + "\n";
		}

		// On génère les imports de librairies
		String librariesStr = "";
		for(int i = 0; i < libraries.size(); i++) {
			librariesStr += "\textrn "+libraries.get(i)+":proc\n";
		}
		if(libraries.size() > 0) {
			librariesStr = "; imports\n" + librariesStr + "\n";
		}

		Writer.write(script, librariesStr+header+dataStr+code+footer);
		Writer.close(script);
		Writer.println("Programme de sortie : "+scriptOutputFilename+"\n");
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
		code += "\tmov word ptr [bp"+Integer.toString(id.getValue())+"], ax\n";
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
		code += "\tjne $+6\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\tjmp $+4\n";
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
		code += "\tjne $+6\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+14\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, "+Integer.toString(TRUE)+"\n";
		code += "\tjne $+6\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+4\n";
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
		code += "\tjne $+6\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\tjmp $+14\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, "+Integer.toString(FALSE)+"\n";
		code += "\tjne $+6\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\tjmp $+4\n";
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
		code += "\tjge $+6\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+4\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}

	@Override
	public void isup() {
		code += "; isup\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tjle $+6\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+4\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}

	@Override
	public void iinfegal() {
		code += "; iinfegal\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tjg $+6\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+4\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}

	@Override
	public void isupegal() {
		code += "; isupegal\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tjl $+6\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+4\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}

	@Override
	public void iegal() {
		code += "; iegal\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tjne $+6\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+4\n";
		code += "\tpush "+Integer.toString(FALSE)+"\n";
		code += "\n";
	}

	@Override
	public void idiff() {
		code += "; idiff\n";
		code += "\tpop bx\n";
		code += "\tpop ax\n";
		code += "\tcmp ax, bx\n";
		code += "\tje $+6\n";
		code += "\tpush "+Integer.toString(TRUE)+"\n";
		code += "\tjmp $+4\n";
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
		code += "\tpush word ptr "+valeur+"\n";
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
		code += "; goto "+label+"\n";
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

		// Création du nom de variable messX
		String msgName = "mess"+Integer.toString(data.size() + 1);

		// On supprime les " en début et fin de chaine pour ne conserver que le contenu de la chaine
		s = s.substring(1, s.length() - 1);

		// On ajout la déclaration au tableaux des données
		data.add("\t"+msgName+" DB \""+s+"$\"\n");

		// On ajoute la librairie si elle n'est pas encore importé
		String library = "ecrch";
		if(!libraries.contains(library)) {
			libraries.add(library);
		}

		code += "; ecrireChaine \""+s+"\""+"\n";
		code += "\tlea dx, "+msgName+"\n";
		code += "\tpush dx\n";
		code += "\tcall "+library+"\n";
		code += "\n";
	}

	public void ecrireEnt() {
		// Peut prendre un Entier ou un Booléen

		String library = "ecrent";
		if(!libraries.contains(library)) {
			libraries.add(library);
		}

		code += "\t"+"call "+library+"\n";
		code += "\n";
	}

	public void aLaLigne() {

		String library = "ligsuiv";
		if(!libraries.contains(library)) {
			libraries.add(library);
		}

		code += "; "+"aLaLigne"+"\n";
		code += "\t"+"call "+library+"\n";
		code += "\n";
	}


	// Insctructions de lecture
	public void lireEnt(Ident id) {

		String library = "lirent";
		if(!libraries.contains(library)) {
			libraries.add(library);
		}

		code += "; "+"lireEnt "+id.getValue()+"\n";
		code += "\tlea dx,[bp"+id.getValue()+"]\n";
		code += "\tpush dx\n";
		code += "\t"+"call "+library+"\n";
		code += "\n";
	}

	public void label(String label) {
		code += label + ":\n";
	}


	// Insctructions de fonctions
	public void ouvreBloc (int slot){
		code += "; ouvbloc " + slot + "\n";
		code += "\tenter " + slot + ",0\n";
	}

	public void fermeBloc (int slot){
		code += "; fermebloc " + slot + "\n";
		code += "\tleave\n"
		code += "\tret " + slot + "\n";
	}

	public void ireturn (int offset){
		code += "; ireturn " + offset + "\n";
		code += "\tpop ax\n";
		code += "\tmov [bp+" + slot + "],ax\n";
	}

	public void reserveRetour(){
		code += "; reserveRetour\n";
		code += "\tsub sp,2\n";
	}

	public void call (String name){
		code += "; call " + name + "\n";
		code += "\tcall " + name + "\n";
	}

}
