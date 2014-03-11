
public interface YVM {
	
	// Instructions début/fin
	public void entete();
	public void queue();
	
	// Instructions arithmétiques
	public void iadd();
	
	public void isub();
	
	public void imul();
	
	public void idiv();
	
	public void inot();
	
	public void ineg();
	
	public void ior();
	
	public void iand();
	
	
	// Instructions de comparaisons
	public void iinf();
	
	public void isup();
	
	public void iinfegal();
	
	public void isupegal();
	
	public void iegal();
	
	public void idiff();
	
	
	// Instructions de stockage et de chargement
	public void iload(int offset);
	
	public void istore(int offset);
	
	public void iconst(int valeur);
	
	
	// Instructions de controle de flot
	public void ifeq(int label);
	
	public void iffaux(int label);
	
	public void jump(int label);


	// Instructions de pile
	public void ouvrePrinc(int slot);

}

