
import java.util.HashMap;

public class Condition {

	/**
	 * Pour garder le compte de chaque label
	 */
	public static HashMap<Integer, Integer> labels = new HashMap<Integer, Integer>();

	/**
	 * Permet de g�n�rer un nouveau label au format :
	 * FAIRE1, FAIRE2, FAIRE3...
	 * FAIT1, FAIT2, FAIT3...
	 */
	public static String getLabel(Integer label) {
		// On suppime les " autour du label donn� par YakaConstants
		String strLabel = YakaConstants.tokenImage[label].replaceAll("\"$|^\"", "");

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

		// On retourne l'�tiquette g�n�r�e avec le compteut incr�ment�
		return strLabel+labelCount;
	}

}

