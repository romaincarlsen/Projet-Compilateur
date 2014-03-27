
import java.util.HashMap;

public class Condition {

	/**
	 * Pour garder le compte de chaque label
	 */
	public static HashMap<String, Integer> labels = new HashMap<String, Integer>();

	/**
	 * Permet de g�n�rer un nouveau label au format :
	 * SINON1, SINON2, SINON3...
	 * FSI1, FSI2, FSI3...
	 */
	public static String getLabel(String label) {
		// On suppime les " autour du label donn� par YakaTokenManager
		label = label.replaceAll("\"$|^\"", "");

		// On r�cup�re le comptes des labels d�j� pr�sents
		Integer labelCount = (Integer) labels.get(label);

		// Si il n'existe pas on l'initialise � 1 et on l'ajoute � la liste
		if(labelCount == null) {
			labelCount = 1;
			labels.put(label, labelCount);
		}
		// Sinon on l'incr�mente et on met � jour la liste
		else {
			labelCount++;
			labels.put(label, labelCount);
		}

		// On retourne l'�tiquette g�n�r�e
		return label+labelCount;
	}

}

