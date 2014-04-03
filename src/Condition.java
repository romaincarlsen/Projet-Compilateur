
import java.util.HashMap;

public class Condition {

	/**
	 * Pour garder le compte de chaque label
	 */
	public static HashMap<Integer, Integer> labels = new HashMap<Integer, Integer>();

	/**
	 * Permet de générer un nouveau label au format :
	 * FAIRE1, FAIRE2, FAIRE3...
	 * FAIT1, FAIT2, FAIT3...
	 */
	public static String getLabel(Integer label) {
		// On suppime les " autour du label donné par YakaConstants
		String strLabel = YakaConstants.tokenImage[label].replaceAll("\"$|^\"", "");

		// On récupère le comptes des labels déjà présents
		Integer labelCount = (Integer) labels.get(label);

		// Si il n'existe pas on l'initialise à 1 et on l'ajoute à la liste
		if(labelCount == null) {
			labelCount = 1;
			labels.put(label, labelCount);
		}
		// Sinon on l'incrémente et on met à jour la liste
		else {
			labelCount++;
			labels.put(label, labelCount);
		}

		// On retourne l'étiquette générée avec le compteut incrémenté
		return strLabel+labelCount;
	}

}

