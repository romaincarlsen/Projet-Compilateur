
import java.io.OutputStream;

public class YVM {

	protected String result;
	protected OutputStream script;
	protected String bool_true = "-1";
	protected String bool_false = "0";


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

	}

	public void queue() {

	}


	// Instructions arithmétiques
	public void iadd() {

	}

	public void isub() {

	}

	public void imul() {

	}

	public void idiv() {

	}

	public void inot() {

	}

	public void ineg() {

	}

	public void ior() {

	}

	public void iand() {

	}


	// Instructions de comparaisons
	public void iinf() {

	}

	public void isup() {

	}

	public void iinfegal() {

	}

	public void isupegal() {

	}

	public void iegal() {

	}

	public void idiff() {

	}


	// Instructions de stockage et de chargement
	public void iload(int offset) {

	}

	public void istore(int offset) {

	}

	public void iconst(int valeur) {

	}



	// Instructions de controle de flot
	public void ifeq(int label) {

	}

	public void iffaux(int label) {

	}


	public void jump(int label) {

	}


	// Instructions de pile
	public void ouvrePrinc(int slot) {

	}

}

