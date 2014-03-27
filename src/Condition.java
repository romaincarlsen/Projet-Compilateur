
import java.util.HashMap;
import java.util.ArrayList;

public class Condition {
	
	public static HashMap<String, Integer> labels = new HashMap<String, Integer>();

	/**
	 *  Constructeur
	 */
	public Condition() {
		
	}
	
	public static String getLabel(String label) {
		// On suppime les " autour du label donné par YakaTokenManager
		String label = label.replaceAll("\"$|^\"", "");
		Integer labelCount = (Integer) labels.get(label);
		
		if(labelCount == null) {
			labelCount = 1;
			labels.add(label, labelCount);
		}
		else {
			labelCount++;
			labels.put(label, labelCount);
		}
		
		return label+labelCount;
	}
	
	public static String finSi() {
		String fsi = "FSI";
		Integer fsiLabelsCount = (Integer) labels.get(fsi);
		
		if(fsiLabelsCount == null) {
			fsiLabelsCount = 1;
			labels.add(fsi, fsiLabelsCount);
		}
		else {
			fsiLabelsCount++;
			labels.put(fsi, fsiLabelsCount);
		}
		
		return fsi+fsiLabelsCount;
	}
	
}

