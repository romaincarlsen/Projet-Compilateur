
import java.io.OutputStream;

public class YVM {

	protected String result;
	protected OutputStream script;
	public static final Integer TRUE = -1;
	public static final Integer FALSE = 0;


	// Création d'un nouveau fichier pour l'enregistrement de la compilation
	public YVM(String filename) {
		script = Writer.open(filename);
		result = "";
	}


	// Fonction de sauvegarde du résulat dans le fichier de sortie
	public void outputSave() {
		Writer.write(script, result);
		Writer.close(script);
	}


	// Instructions début/fin
	public void entete() {
		result += "\t"+"entete"+"\n";
	}

	public void queue() {
		result += "\t"+"queue"+"\n";
	}


	// Instructions arithmétiques
	public void iadd() {
		result += "\t"+"iadd"+"\n";
	}

	public void isub() {
		result += "\t"+"isub"+"\n";
	}

	public void imul() {
		result += "\t"+"imul"+"\n";
	}

	public void idiv() {
		result += "\t"+"idiv"+"\n";
	}

	public void inot() {
		result += "\t"+"inot"+"\n";
	}

	public void ineg() {
		result += "\t"+"ineg"+"\n";
	}

	public void ior() {
		result += "\t"+"ior"+"\n";
	}

	public void iand() {
		result += "\t"+"iand"+"\n";
	}


	// Instructions de comparaisons
	public void iinf() {
		result += "\t"+"iinf"+"\n";
	}

	public void isup() {
		result += "\t"+"isup"+"\n";
	}

	public void iinfegal() {
		result += "\t"+"iinfegal"+"\n";
	}

	public void isupegal() {
		result += "\t"+"isupegal"+"\n";
	}

	public void iegal() {
		result += "\t"+"iegal"+"\n";
	}

	public void idiff() {
		result += "\t"+"idiff"+"\n";
	}


	// Instructions de stockage et de chargement
	public void iload(int offset) {
		result += "\t"+"iload "+Integer.toString(offset)+"\n";
	}

	public void istore(int offset) {
		result += "\t"+"istore "+Integer.toString(offset)+"\n";
	}

	public void iconst(int value) {
		result += "\t"+"iconst "+Integer.toString(value)+"\n";
	}



	// Instructions de controle de flot
	public void ifeq(String label) {
		result += "\t"+"ifeq"+"\n";
	}

	public void iffaux(String label) {
		result += "\t"+"iffaux"+"\n";
	}


	public void jump(String label) {
		result += "\t"+"jump "+label+"\n";
	}


	// Instructions de pile
	public void ouvrePrinc(int slot) {
		result += "\t"+"ouvrePrinc "+Integer.toString(slot)+"\n";
	}

}

