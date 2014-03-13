
public class YVMasm implements YVM {
	
	private String result = "";
	private String bool_true = "-1";
	private String bool_false = "0";

	@Override
	public void entete() {
		result += "; entete\n";
		result += ".MODEL SMALL\n";
		result += "\t.586\n";
		result += "\n";
		result += ".CODE\n";
		result += "debut:\n";
		result += " \tSTARTUPCODE\n";
		result += "\n";
	}

	@Override
	public void queue() {
		result += "; queue\n";
		result += "\tnop\n";
		result += "\texitcode\n";
		result += "\tEND debut\n";
		result += "\n";
	}

	@Override
	public void iadd() {
		result += "; iadd\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tadd ax, bx\n";
		result += "\tpush ax\n";
		result += "\n";
	}

	@Override
	public void isub() {
		result += "; isub\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tsub ax, bx\n";
		result += "\tpush ax\n";
		result += "\n";
	}

	@Override
	public void imul() {
		result += "; imul\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\timul bx\n";
		result += "\tpush ax\n";
		result += "\n";
	}

	@Override
	public void idiv() {
		result += "; idiv\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcwd\n";
		result += "\tidiv bx\n";
		result += "\tpush ax\n";
		result += "\n";
	}

	@Override
	public void inot() {
		result += "; inot\n";
		result += "\tpop ax\n";
		result += "\tnot ax\n";
		result += "\tpush ax\n";
		/*result += "\tpop ax\n";
		result += "\tcmp ax, "+bool_true+"\n";
		result += "\tjne $+3\n";
		result += "\tpush "+bool_false+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+bool_true+"\n";*/
		result += "\n";
	}

	@Override
	public void ineg() {
		result += "; ineg\n";
		result += "\tpop ax\n";
		result += "\tneg ax\n";
		result += "\tpush ax\n";
		/*result += "\tpop bx\n";
		result += "\tpush -1\n";
		result += "\timul bx\n";
		result += "\tpush ax\n";*/
		result += "\n";
	}

	@Override
	public void ior() {
		result += "; ior\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tor ax, bx\n";
		result += "\tpush ax\n";
		/*result += "\tpop ax\n";
		result += "\tcmp ax, "+bool_true+"\n";
		result += "\tjne $+3\n";
		result += "\tpush "+bool_true+"\n";
		result += "\tjmp $+7\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, "+bool_true+"\n";
		result += "\tjne $+3\n";
		result += "\tpush "+bool_true+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+bool_false+"\n";*/
		result += "\n";
		
	}

	@Override
	public void iand() {
		result += "; iand\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tand ax, bx\n";
		result += "\tpush ax\n";
		/*result += "\tpop ax\n";
		result += "\tcmp ax, "+bool_false+"\n";
		result += "\tjne $+3\n";
		result += "\tpush "+bool_false+"\n";
		result += "\tjmp $+7\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, "+bool_false+"\n";
		result += "\tjne $+3\n";
		result += "\tpush "+bool_false+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+bool_true+"\n";*/
		result += "\n";
	}

	@Override
	public void iinf() {
		result += "; iinf\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tjge $+3";
		result += "\tpush "+bool_true+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+bool_false+"\n";
		result += "\n";
	}

	@Override
	public void isup() {
		result += "; isup\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tjle $+3";
		result += "\tpush "+bool_true+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+bool_false+"\n";
		result += "\n";
	}

	@Override
	public void iinfegal() {
		result += "; iinfegal\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tjg $+3";
		result += "\tpush "+bool_true+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+bool_false+"\n";
		result += "\n";
	}

	@Override
	public void isupegal() {
		result += "; isupegal\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tjl $+3";
		result += "\tpush "+bool_true+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+bool_false+"\n";
		result += "\n";
	}

	@Override
	public void iegal() {
		result += "; iegal\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tjne $+3";
		result += "\tpush "+bool_true+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+bool_false+"\n";
		result += "\n";
	}

	@Override
	public void idiff() {
		result += "; idiff\n";
		result += "\tpop bx\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, bx\n";
		result += "\tje $+3";
		result += "\tpush "+bool_true+"\n";
		result += "\tjmp $+2\n";
		result += "\tpush "+bool_false+"\n";
		result += "\n";
	}

	@Override
	public void iload(int offset) {
		result += "; iload "+offset+"\n";
		result += "\tpush word ptr [bp"+offset+"]\n";
		result += "\n";
	}

	@Override
	public void istore(int offset) {
		result += "; istore "+offset+"\n";
		result += "\tpop ax\n";
		result += "\tmov word ptr [bp"+offset+"], ax\n";
		result += "\n";
	}

	@Override
	public void iconst(int valeur) {
		result += "; iconst "+valeur+"\n";
		result += "\tpush "+valeur+"\n";
		result += "\n";
	}

	@Override
	public void ifeq(int label) {
		result += "; ifeq\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, 0\n";
		result += "\tje"+label+"\n";
		result += "\n";
		
	}

	@Override
	public void iffaux(int label) {
		result += "; iffaux\n";
		result += "\tpop ax\n";
		result += "\tcmp ax, "+bool_false+"\n";
		result += "\tje"+label+"\n";
		result += "\n";
	}

	@Override
	public void jump(int label) {
		result += "; jump "+label+"\n";
		result += "\tjmp "+label+"\n";
		result += "\n";
	}

	@Override
	public void ouvrePrinc(int slot) {
		result += "; ouvrePrinc "+slot+"\n";
		result += "\tmov bp, sp\n";
		result += "\tsub sp, "+slot+"\n";
		result += "\n";
	}
	
}

