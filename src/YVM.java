
import java.io.OutputStream;

public class YVM {

	protected String header = "";
	protected String code = "";
	protected String footer = "";

	protected OutputStream script;
	public static final Integer TRUE = -1;
	public static final Integer FALSE = 0;



	// Création d'un nouveau fichier pour l'enregistrement de la compilation
	public YVM(String filename) {
		script = Writer.open(filename);
	}



	// Fonction de sauvegarde du résulat dans le fichier de sortie
	public void outputSave() {
		Writer.write(script, header+code+footer);
		Writer.close(script);
	}



	// Instructions début/fin
	public void entete() {
		header += "\t"+"entete"+"\n";
	}

	public void queue() {
		footer += "\t"+"queue"+"\n";
	}



	// Instructions arithmétiques
	public void affect(Ident id) {
		code += "\t"+"istore "+Integer.toString(id.getValue())+"\n";
	}

	public void iadd() {
		code += "\t"+"iadd"+"\n";
	}

	public void isub() {
		code += "\t"+"isub"+"\n";
	}

	public void imul() {
		code += "\t"+"imul"+"\n";
	}

	public void idiv() {
		code += "\t"+"idiv"+"\n";
	}

	public void inot() {
		code += "\t"+"inot"+"\n";
	}

	public void ineg() {
		code += "\t"+"ineg"+"\n";
	}

	public void ior() {
		code += "\t"+"ior"+"\n";
	}

	public void iand() {
		code += "\t"+"iand"+"\n";
	}



	// Instructions de comparaisons
	public void iinf() {
		code += "\t"+"iinf"+"\n";
	}

	public void isup() {
		code += "\t"+"isup"+"\n";
	}

	public void iinfegal() {
		code += "\t"+"iinfegal"+"\n";
	}

	public void isupegal() {
		code += "\t"+"isupegal"+"\n";
	}

	public void iegal() {
		code += "\t"+"iegal"+"\n";
	}

	public void idiff() {
		code += "\t"+"idiff"+"\n";
	}



	// Instructions de stockage et de chargement
	public void iload(int offset) {
		code += "\t"+"iload "+Integer.toString(offset)+"\n";
	}

	public void istore(int offset) {
		code += "\t"+"istore "+Integer.toString(offset)+"\n";
	}

	public void iconst(int value) {
		code += "\t"+"iconst "+Integer.toString(value)+"\n";
	}



	// Instructions de controle de flot
	public void ifeq(String label) {
		code += "\t"+"ifeq "+label+"\n";
	}

	public void iffaux(String label) {
		code += "\t"+"iffaux "+label+"\n";
	}


	public void jump(String label) {
		code += "\t"+"jump "+label+"\n";
	}



	// Instructions de pile
	public void ouvrePrinc(int slot) {
		code += "\t"+"ouvrePrinc "+Integer.toString(slot)+"\n";
	}



	// Insctructions d'écriture
	public void ecrireChaine(String s) {
		s = s.substring(1, s.length() - 1);
		code += "\t"+"ecrireChaine \""+s+"\""+"\n";
	}

	public void ecrireEnt() {
		// Entier ou booléen
		//code += "\t"+"iload "+id.getValue()+"\n";
		code += "\t"+"ecrireEnt"+"\n";
	}

	public void aLaLigne() {
		code += "\t"+"aLaLigne"+"\n";
	}


	// Insctructions de lecture
	public void lireEnt(Ident id) {
		code += "\t"+"lireEnt "+id.getValue()+"\n";
	}

}
