
import java.io.OutputStream;

public class YVM {

	// Nom du fichier a creer par l'interpreteur
	protected String scriptOutputFilename = "../outputs/{{FILENAME}}.yvm";
	protected OutputStream script;

	protected String header = "";
	protected String code = "";
	protected String footer = "";

	public static final Integer TRUE = -1;
	public static final Integer FALSE = 0;


	// Création d'un nouveau fichier pour l'enregistrement de la compilation
	public YVM(String inputFilename) {
		scriptOutputFilename = scriptOutputFilename.replace("{{FILENAME}}", inputFilename);

		// Le nom du fichier de sortie est le même avec l'extension ".asm" dans le dossier "outputs"
		script = Writer.open(scriptOutputFilename);
	}

	public YVM(String inputFilename, String outputFilename) {
		scriptOutputFilename = outputFilename.replace("{{FILENAME}}", inputFilename);

		// Le nom du fichier de sortie est le même avec l'extension ".asm" dans le dossier "outputs"
		script = Writer.open(scriptOutputFilename);
	}



	// Fonction de sauvegarde du résulat dans le fichier de sortie
	public void outputSave() {
		Writer.write(script, header+code+footer);
		Writer.close(script);
		Writer.println("Programme de sortie : "+scriptOutputFilename+"\n");
	}



	// Instructions début/fin
	public void entete() {
		header += "\tentete\n";
	}

	public void queue() {
		footer += "\tqueue\n";
	}



	// Instructions arithmétiques
	public void affect(Ident id) {
		code += "\tistore "+Integer.toString(id.getValue())+"\n";
	}

	public void iadd() {
		code += "\tiadd\n";
	}

	public void isub() {
		code += "\tisub\n";
	}

	public void imul() {
		code += "\timul\n";
	}

	public void idiv() {
		code += "\tidiv\n";
	}

	public void inot() {
		code += "\tinot\n";
	}

	public void ineg() {
		code += "\tineg\n";
	}

	public void ior() {
		code += "\tior\n";
	}

	public void iand() {
		code += "\tiand\n";
	}



	// Instructions de comparaisons
	public void iinf() {
		code += "\tiinf\n";
	}

	public void isup() {
		code += "\tisup\n";
	}

	public void iinfegal() {
		code += "\tiinfegal\n";
	}

	public void isupegal() {
		code += "\tisupegal\n";
	}

	public void iegal() {
		code += "\tiegal\n";
	}

	public void idiff() {
		code += "\tidiff\n";
	}



	// Instructions de stockage et de chargement
	public void iload(int offset) {
		code += "\tiload "+Integer.toString(offset)+"\n";
	}

	public void istore(int offset) {
		code += "\tistore "+Integer.toString(offset)+"\n";
	}

	public void iconst(int value) {
		code += "\ticonst "+Integer.toString(value)+"\n";
	}



	// Instructions de controle de flot
	public void ifeq(String label) {
		code += "\tifeq "+label+"\n";
	}

	public void iffaux(String label) {
		code += "\tiffaux "+label+"\n";
	}


	public void jump(String label) {
		code += "\tgoto "+label+"\n";
	}



	// Instructions de pile
	public void ouvrePrinc(int slot) {
		code += "\touvrePrinc "+Integer.toString(slot)+"\n";
	}



	// Insctructions d'écriture
	public void ecrireChaine(String s) {
		s = s.substring(1, s.length() - 1);
		code += "\tecrireChaine \""+s+"\"\n";
	}

	public void ecrireEnt() {
		// Entier ou booléen
		//code += "\tiload "+id.getValue()+"\n";
		code += "\tecrireEnt\n";
	}

	public void aLaLigne() {
		code += "\taLaLigne\n";
	}


	// Insctructions de lecture
	public void lireEnt(Ident id) {
		code += "\tlireEnt "+id.getValue()+"\n";
	}

	public void label(String label) {
		code += label + ":\n";
	}


	// Insctructions de fonctions
	public void ouvreBloc (int slot){
		code += "\touvbloc " + slot + "\n";
	}

	public void fermeBloc (int slot){
		code += "\tfermebloc " + slot + "\n";
	}

	public void ireturn (int offset){
		code += "\tireturn " + offset + "\n";
	}

	public void reserveRetour(){
		code += "\treserveRetour\n";
	}

	public void call (String name){
		code += "\tcall " + name + "\n";
	}
	
	public void main() {
		code += "main:\n";	
	}
}
