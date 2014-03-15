
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

//quelques primitives d'écriture à l'ecran ou dans un fichier
public class Writer {


	// Quitte l'exécution et affiche une erreur
	private static void error(IOException e) {
		System.err.println(e.getMessage());
		System.err.println("Erreur fatale lors de l'écriture dans un fichier");
		System.exit(1);
	}


	// Ouverture d'un fichier
	public static OutputStream open(String nomFich) {
		//délivre un pointeur sur le fichier de nom nomFich (null si erreur)
		OutputStream f;
		try {
			f=new DataOutputStream(new FileOutputStream(nomFich));
		}
		catch (IOException e) {
			f=null;
		}
		return f;
	}


	//fermeture d'un fichier
	public static void close(OutputStream f) {
		try {
			f.close();
		}
		catch (IOException e) {
			error(e);
		}
	}


	//écriture d'un caractère
	public static void writeChar(OutputStream f,char c) {
		try {
			f.write(c);
		}
		catch(IOException e) {
			error(e);
		}
	}

	public static void writeChar(char c) {
		writeChar(System.out,c);
	}


	//écriture d'une chaîne, avec éventuel passage à la ligne
	public static void write(OutputStream f,String s) {
		try {
			for(int i=0; i<s.length(); i++)
				f.write(s.charAt(i));
		}
		catch(IOException e) {
			error(e);
		}
	}

	public static void write(String s) {
		write(System.out, s);
	}

	public static void writeln(OutputStream f,String s) {
		write(f, s+"\n");
	}

	public static void writeln(String s) {
		writeln(System.out, s);
	}

	public static void print(String s) {
		write(System.out, s);
	}

	public static void println(String s) {
		write(System.out, s+"\n");
	}

	public static void error(String s) {
		write(System.err, s);
	}

	public static void errorln(String s) {
		write(System.err, s+"\n");
	}


	//écriture d'un entier avec formatage éventuel
	public static void writeInt(OutputStream f,int x) {
		write(f,Integer.toString(x));
	}

	public static void writeInt(int x) {
		writeInt(System.out,x);
	}

	public static void writeInt(OutputStream f,int x,int longueur) {
		String s=Integer.toString(x);
		int k=longueur-s.length();

		for(int i=0;i<k;i++)
			writeChar(f,' ');

		write(f,s);
	}

	public static void writeInt(int x,int longueur) {
		writeInt(System.out,x,longueur);
	}


	//écriture d'un double avec formatage éventuel
	public static void writeDouble(OutputStream f,double d) {
		write(f,Double.toString(d));
	}

	public static void writeDouble(double d) {
		writeDouble(System.out,d);
	}

	public static void writeDouble(OutputStream f,double d,int longueur) {
		String s=Double.toString(d);
		int k=longueur-s.length();

		for(int i=0;i<k;i++)
			writeChar(f,' ');

		write(f,s);
	}

	public static void writeDouble(double d,int longueur) {
		writeDouble(System.out,d,longueur);
	}

}
